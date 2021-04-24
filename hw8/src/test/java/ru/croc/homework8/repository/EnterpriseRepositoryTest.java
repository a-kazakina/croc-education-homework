package ru.croc.homework8.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.croc.homework8.dbprovider.DataSourceProvider;
import ru.croc.homework8.model.LeisureEnterprise;
import ru.croc.homework8.model.MunicipalEnterprise;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalTime;

/**
 * Проверка методов класса {@link: EnterpriseRepository}.
 */
public class EnterpriseRepositoryTest {

    @Test
    void addMunicipalRecord() throws IOException, SQLException {
        DataSourceProvider dataSourceProvider = new DataSourceProvider();
        EnterpriseRepository repository = new EnterpriseRepository(dataSourceProvider.getDataSource());

        LocalTime time = LocalTime.of(10, 0, 0);
        Time timeOpen = Time.valueOf(time);
        time = LocalTime.of(20, 0, 0);
        Time timeClose = Time.valueOf(time);
        MunicipalEnterprise mEnterprise = new MunicipalEnterprise(1,
                "Предприятие1",
                timeOpen,
                timeClose,
                "Иванов",
                "Краснодар, Красная 1");
        repository.addMunicipalRecord(mEnterprise);
        Assertions.assertTrue(repository.findByID("municipal_enterprises", 1));
        repository.clearAll("municipal_enterprises");
        repository.clearAll("leisure_enterprises");
    }

    @Test
    void addLeisureRecord() throws IOException, SQLException {
        DataSourceProvider dataSourceProvider = new DataSourceProvider();
        EnterpriseRepository repository = new EnterpriseRepository(dataSourceProvider.getDataSource());

        LocalTime time = LocalTime.of(10, 0, 0);
        Time timeOpen = Time.valueOf(time);
        time = LocalTime.of(20, 0, 0);
        Time timeClose = Time.valueOf(time);
        LeisureEnterprise lEnterprise = new LeisureEnterprise(1,
                "Предприятие1",
                timeOpen,
                timeClose,
                "Иванов",
                "Краснодар, Красная 1");
        repository.addLeisureRecord(lEnterprise);
        Assertions.assertTrue(repository.findByID("leisure_enterprises", 1));
        repository.clearAll("municipal_enterprises");
        repository.clearAll("leisure_enterprises");
    }
}
