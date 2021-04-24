package ru.croc.homework8.jaxb;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.croc.homework8.model.Enterprises;
import ru.croc.homework8.model.LeisureEnterprise;
import ru.croc.homework8.model.MunicipalEnterprise;

import java.io.IOException;

/**
 * Проверка сериализации и десериализации класса {@link: LeisureEnterprise}
 */

public class JaxbConverterTest {
    @Test
    void test() throws IOException {
        JaxbConverter converter = new JaxbConverter();

        LeisureEnterprise lenterprise1 = new LeisureEnterprise("Предприятие1", "Краснодар, Красная 1");
        LeisureEnterprise lenterprise2 = new LeisureEnterprise("Предприятие2", "Краснодар, Красная 2");
        MunicipalEnterprise menterprise3 = new MunicipalEnterprise("Предприятие3", "Краснодар, Красная 3");
        MunicipalEnterprise menterprise4 = new MunicipalEnterprise("Предприятие4", "Краснодар, Красная 4");

        Enterprises enterprises = new Enterprises();
        enterprises.getLeisureEnterprises().add(lenterprise1);
        enterprises.getLeisureEnterprises().add(lenterprise2);
        enterprises.getMunicipalEnterprises().add(menterprise3);
        enterprises.getMunicipalEnterprises().add(menterprise4);

        String xmlEnterprises = converter.toXml(enterprises);
        System.out.println(converter.fromXml(xmlEnterprises, Enterprises.class));
        Assertions.assertTrue(enterprises.equals(converter.fromXml(xmlEnterprises, Enterprises.class)));
    }
}
