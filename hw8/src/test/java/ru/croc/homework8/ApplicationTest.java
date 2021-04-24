package ru.croc.homework8;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.croc.homework8.dbprovider.DataSourceProvider;
import ru.croc.homework8.jaxb.JaxbConverter;
import ru.croc.homework8.model.Enterprises;
import ru.croc.homework8.model.LeisureEnterprise;
import ru.croc.homework8.model.MunicipalEnterprise;
import ru.croc.homework8.repository.EnterpriseRepository;
import ru.croc.homework8.service.EnterpriseService;

import java.io.IOException;
import java.sql.Time;
import java.time.LocalTime;

public class ApplicationTest {

    @Test
    public void test() throws IOException {

        //создадим две таблицы и добавим несколько записей в них
        DataSourceProvider dataSourceProvider = new DataSourceProvider();
        EnterpriseRepository repository = new EnterpriseRepository(dataSourceProvider.getDataSource());
        EnterpriseService service = new EnterpriseService(repository);

        LocalTime time = LocalTime.of(10, 0, 0);
        Time timeOpen = Time.valueOf(time);
        time = LocalTime.of(20, 0, 0);
        Time timeClose = Time.valueOf(time);
        MunicipalEnterprise enterprise1 = new MunicipalEnterprise(1,
                "Предприятие1",
                timeOpen,
                timeClose,
                "Иванов",
                "Краснодар, Красная 1");

        time = LocalTime.of(6, 0, 0);
        timeOpen = Time.valueOf(time);
        time = LocalTime.of(15, 0, 0);
        timeClose = Time.valueOf(time);
        MunicipalEnterprise enterprise2 = new MunicipalEnterprise(2,
                "Предприятие2",
                timeOpen,
                timeClose,
                "Петров",
                "Краснодар, Красная 2");

        time = LocalTime.of(7, 0, 0);
        timeOpen = Time.valueOf(time);
        time = LocalTime.of(18, 0, 0);
        timeClose = Time.valueOf(time);
        LeisureEnterprise enterprise3 = new LeisureEnterprise(3,
                "Предприятие3",
                timeOpen,
                timeClose,
                "Сидоров",
                "Краснодар, Красная 3");

        time = LocalTime.of(9, 0, 0);
        timeOpen = Time.valueOf(time);
        time = LocalTime.of(16, 0, 0);
        timeClose = Time.valueOf(time);
        LeisureEnterprise enterprise4 = new LeisureEnterprise(4,
                "Предприятие4",
                timeOpen,
                timeClose,
                "Лошев",
                "Краснодар, Красная 4");

        service.addMunicipalRecord(enterprise1);
        service.addMunicipalRecord(enterprise2);
        service.addLeisureRecord(enterprise3);
        service.addLeisureRecord(enterprise4);

        // момент времени, на который будем искать работающие предприятия
        time = LocalTime.of(17, 30, 0);
        Time timeFind = Time.valueOf(time);

        Enterprises enterprises = new Enterprises();
        for (LeisureEnterprise enterprise : service.findAllLeisureEnterprises()) {
            if (timeFind.after(enterprise.getTimeOpen()) && timeFind.before(enterprise.getTimeClose())) {
                enterprises.getLeisureEnterprises().add(enterprise);
            }
        }

        for (MunicipalEnterprise enterprise : service.findAllMunicipalEnterprises()) {
            if (timeFind.after(enterprise.getTimeOpen()) && timeFind.before(enterprise.getTimeClose())) {
                enterprises.getMunicipalEnterprises().add(enterprise);
            }
        }

        // в оба списка попадут только по одному предприятию: Предприятие1 и Предприятие3
        Assertions.assertEquals(1, enterprises.getLeisureEnterprises().size());
        Assertions.assertEquals(1, enterprises.getMunicipalEnterprises().size());

        JaxbConverter converter = new JaxbConverter();
        System.out.println(converter.toXml(enterprises));

        service.clearAll("municipal_enterprises");
        service.clearAll("leisure_enterprises");
    }
}
