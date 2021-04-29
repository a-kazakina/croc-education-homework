package ru.croc.homework8.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.croc.homework8.dbprovider.DataSourceProvider;
import ru.croc.homework8.model.in.LeisureEnterprise;
import ru.croc.homework8.model.in.MunicipalEnterprise;
import ru.croc.homework8.repository.EnterpriseRepository;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalTime;

/**
 * Проверка методов класса {@link: EnterpriseService}.
 */
public class EnterpriseServiceTest {

    @Test
    void addMunicipalRecord() throws IOException, SQLException {
        DataSourceProvider dataSourceProvider = new DataSourceProvider();
        EnterpriseRepository repository = new EnterpriseRepository(dataSourceProvider.getDataSource());
        EnterpriseService service = new EnterpriseService(repository);

        LocalTime time = LocalTime.of(10, 0, 0);
        Time timeOpen = Time.valueOf(time);
        time = LocalTime.of(20, 0, 0);
        Time timeClose = Time.valueOf(time);
        MunicipalEnterprise menterprise = new MunicipalEnterprise(1,
                "Предприятие1",
                timeOpen,
                timeClose,
                "Иванов",
                "Краснодар, Красная 1");
        service.addMunicipalRecord(menterprise);
        Assertions.assertTrue(service.findByID("municipal_enterprises", 1));
        service.clearAll("municipal_enterprises");
        service.clearAll("leisure_enterprises");
    }

    @Test
    void addLeisureRecord() throws IOException, SQLException {
        DataSourceProvider dataSourceProvider = new DataSourceProvider();
        EnterpriseRepository repository = new EnterpriseRepository(dataSourceProvider.getDataSource());
        EnterpriseService service = new EnterpriseService(repository);

        LocalTime time = LocalTime.of(10, 0, 0);
        Time timeOpen = Time.valueOf(time);
        time = LocalTime.of(20, 0, 0);
        Time timeClose = Time.valueOf(time);
        LeisureEnterprise lenterprise = new LeisureEnterprise(1,
                "Предприятие1",
                timeOpen,
                timeClose,
                "Иванов",
                "Краснодар, Красная 1");
        service.addLeisureRecord(lenterprise);
        Assertions.assertTrue(service.findByID("leisure_enterprises", 1));
        service.clearAll("municipal_enterprises");
        service.clearAll("leisure_enterprises");
    }
}
