package ru.croc.homework8;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.croc.homework8.dbprovider.DataSourceProvider;
import ru.croc.homework8.jaxb.JaxbConverter;
import ru.croc.homework8.jaxb.ServiceConvertor;
import ru.croc.homework8.model.out.Enterprises;
import ru.croc.homework8.model.in.LeisureEnterprise;
import ru.croc.homework8.model.in.MunicipalEnterprise;
import ru.croc.homework8.repository.EnterpriseRepository;
import ru.croc.homework8.service.EnterpriseService;

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalTime;

/**
 * Демонстрационный сценарий проекта.
 */
public class ApplicationTest {

    @Test
    public void test() throws IOException, SQLException {

        //создадим две таблицы и добавим несколько записей в них
        DataSourceProvider dataSourceProvider = new DataSourceProvider();
        EnterpriseRepository repository = new EnterpriseRepository(dataSourceProvider.getDataSource());
        EnterpriseService service = new EnterpriseService(repository);

        LocalTime time = LocalTime.of(10, 0, 0);
        Time timeOpen = Time.valueOf(time);
        time = LocalTime.of(20, 0, 0);
        Time timeClose = Time.valueOf(time);
        LeisureEnterprise enterprise1 = new LeisureEnterprise(1,
                "Предприятие1",
                timeOpen,
                timeClose,
                "Иванов",
                "Краснодар, Красная 1");

        time = LocalTime.of(6, 0, 0);
        timeOpen = Time.valueOf(time);
        time = LocalTime.of(15, 0, 0);
        timeClose = Time.valueOf(time);
        LeisureEnterprise enterprise2 = new LeisureEnterprise(2,
                "Предприятие2",
                timeOpen,
                timeClose,
                "Петров",
                "Краснодар, Красная 2");

        time = LocalTime.of(7, 0, 0);
        timeOpen = Time.valueOf(time);
        time = LocalTime.of(18, 0, 0);
        timeClose = Time.valueOf(time);
        MunicipalEnterprise enterprise3 = new MunicipalEnterprise(3,
                "Предприятие3",
                timeOpen,
                timeClose,
                "Сидоров",
                "Краснодар, Красная 3");

        time = LocalTime.of(9, 0, 0);
        timeOpen = Time.valueOf(time);
        time = LocalTime.of(16, 0, 0);
        timeClose = Time.valueOf(time);
        MunicipalEnterprise enterprise4 = new MunicipalEnterprise(4,
                "Предприятие4",
                timeOpen,
                timeClose,
                "Лошев",
                "Краснодар, Красная 4");

        service.addLeisureRecord(enterprise1);
        service.addLeisureRecord(enterprise2);
        service.addMunicipalRecord(enterprise3);
        service.addMunicipalRecord(enterprise4);

        // момент времени, на который будем искать работающие предприятия
        time = LocalTime.of(17, 30, 0);
        Time timeFind = Time.valueOf(time);
        ServiceConvertor convertor = new ServiceConvertor();
        Enterprises enterprises = new Enterprises(
                convertor.toEnterpriseL(service.findLeisureEnterprises(timeFind)),
                convertor.toEnterpriseM(service.findMunicipalEnterprises(timeFind)));

        // в оба списка попадут только по одному предприятию: Предприятие1 и Предприятие3
        Assertions.assertEquals(1, enterprises.getlEnterprises().size());
        Assertions.assertEquals(1, enterprises.getmEnterprises().size());

        JaxbConverter converter = new JaxbConverter();
        try (FileWriter writer = new FileWriter("src/main/resources/output.xml", false)) {
            writer.write(converter.toXml(enterprises));
            writer.close();
            writer.flush();
        }
        catch(IOException ex) {
            System.out.println(ex.getMessage());
        }

        Path path = FileSystems.getDefault().getPath("src/main/resources", "output.xml");
        String output = Files.readString(path).replaceAll("\r", "").replaceAll(" ", "");
        path = FileSystems.getDefault().getPath("src/main/resources", "expected.xml");
        String expected = Files.readString(path).replaceAll("\r", "").replaceAll(" ", "");

        Assertions.assertEquals(expected, output);

        service.clearAll("municipal_enterprises");
        service.clearAll("leisure_enterprises");
    }
}
