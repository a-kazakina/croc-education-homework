package ru.croc.homework8.jaxb;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.croc.homework8.model.in.LeisureEnterprise;
import ru.croc.homework8.model.in.MunicipalEnterprise;
import ru.croc.homework8.model.out.Enterprise;

import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Проверка преобразования классов.
 *      LeisureEnterprise -> Enterprise
 *      MunicipalEnterprise -> Enterprise
 */
class ServiceConvertorTest {

    @Test
    void toEnterprise() {
        LocalTime time = LocalTime.of(10, 0, 0);
        Time timeOpen = Time.valueOf(time);
        time = LocalTime.of(20, 0, 0);
        Time timeClose = Time.valueOf(time);
        MunicipalEnterprise enterpriseM = new MunicipalEnterprise(1,
                "Предприятие1",
                timeOpen,
                timeClose,
                "Иванов",
                "Краснодар, Красная 1");
        LeisureEnterprise enterpriseL = new LeisureEnterprise(1,
                "Предприятие2",
                timeOpen,
                timeClose,
                "Петров",
                "Краснодар, Красная 2");
        Enterprise enterprise1 = new Enterprise("Предприятие1",
                                                "Адрес: Краснодар, Красная 1, директор: Иванов");
        Enterprise enterprise2 = new Enterprise("Предприятие2",
                "Адрес: Краснодар, Красная 2, директор: Петров");

        ServiceConvertor convertor = new ServiceConvertor();
        Enterprise enterpriseConvertor = convertor.toEnterprise(enterpriseM);
        Assertions.assertTrue(enterprise1.equals(enterpriseConvertor));

        enterpriseConvertor = convertor.toEnterprise(enterpriseL);
        Assertions.assertTrue(enterprise2.equals(enterpriseConvertor));
    }


    @Test
    void toEnterpriseL() {
        LocalTime time = LocalTime.of(10, 0, 0);
        Time timeOpen = Time.valueOf(time);
        time = LocalTime.of(20, 0, 0);
        Time timeClose = Time.valueOf(time);
        LeisureEnterprise enterpriseL1 = new LeisureEnterprise(1,
                "Предприятие1",
                timeOpen,
                timeClose,
                "Иванов",
                "Краснодар, Красная 1");
        LeisureEnterprise enterpriseL2 = new LeisureEnterprise(1,
                "Предприятие2",
                timeOpen,
                timeClose,
                "Петров",
                "Краснодар, Красная 2");

        List<LeisureEnterprise> lEnterprises = new ArrayList<>();
        lEnterprises.add(enterpriseL1);
        lEnterprises.add(enterpriseL2);

        Enterprise enterprise1 = new Enterprise("Предприятие1",
                "Адрес: Краснодар, Красная 1, директор: Иванов");
        Enterprise enterprise2 = new Enterprise("Предприятие2",
                "Адрес: Краснодар, Красная 2, директор: Петров");

        List<Enterprise> enterprises = new ArrayList<>();
        enterprises.add(enterprise1);
        enterprises.add(enterprise2);

        ServiceConvertor convertor = new ServiceConvertor();
        convertor.toEnterpriseL(lEnterprises);

        Assertions.assertTrue(enterprises.equals(lEnterprises));
    }

    @Test
    void toEnterpriseM() {
        LocalTime time = LocalTime.of(10, 0, 0);
        Time timeOpen = Time.valueOf(time);
        time = LocalTime.of(20, 0, 0);
        Time timeClose = Time.valueOf(time);
        MunicipalEnterprise enterpriseM1 = new MunicipalEnterprise(1,
                "Предприятие1",
                timeOpen,
                timeClose,
                "Иванов",
                "Краснодар, Красная 1");
        MunicipalEnterprise enterpriseM2 = new MunicipalEnterprise(1,
                "Предприятие2",
                timeOpen,
                timeClose,
                "Петров",
                "Краснодар, Красная 2");

        List<MunicipalEnterprise> mEnterprises = new ArrayList<>();
        mEnterprises.add(enterpriseM1);
        mEnterprises.add(enterpriseM2);

        Enterprise enterprise1 = new Enterprise("Предприятие1",
                "Адрес: Краснодар, Красная 1, директор: Иванов");
        Enterprise enterprise2 = new Enterprise("Предприятие2",
                "Адрес: Краснодар, Красная 2, директор: Петров");

        List<Enterprise> enterprises = new ArrayList<>();
        enterprises.add(enterprise1);
        enterprises.add(enterprise2);

        ServiceConvertor convertor = new ServiceConvertor();
        convertor.toEnterpriseM(mEnterprises);

        Assertions.assertTrue(enterprises.equals(mEnterprises));
    }
}