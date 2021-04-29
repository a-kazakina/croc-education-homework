package ru.croc.homework8.jaxb;

import ru.croc.homework8.model.out.Enterprise;
import ru.croc.homework8.model.in.LeisureEnterprise;
import ru.croc.homework8.model.in.MunicipalEnterprise;

import java.util.ArrayList;
import java.util.List;

/**
 * Сервис по преобразованию классов:
 *      LeisureEnterprise -> Enterprise
 *      MunicipalEnterprise -> Enterprise
 */
public class ServiceConvertor {

    /**
     * Метод конвертирует объект класса LeisureEnterprise в объект класса Enterprise.
     * @param lEnterprise объект класса LeisureEnterprise
     * @return объект класса Enterprise
     */
    public Enterprise toEnterprise(LeisureEnterprise lEnterprise) {
        StringBuilder description = new StringBuilder("Адрес: ");
        description.append(lEnterprise.getAddress());
        description.append(", директор: ");
        description.append(lEnterprise.getDirector());
        return new Enterprise(lEnterprise.getName(), description.toString());
    }

    /**
     * Метод конвертирует объект класса MunicipalEnterprise в объект класса Enterprise.
     * @param mEnterprise объект класса MunicipalEnterprise
     * @return объект класса Enterprise
     */
    public Enterprise toEnterprise(MunicipalEnterprise mEnterprise) {
        StringBuilder description = new StringBuilder("Адрес: ");
        description.append(mEnterprise.getAddress());
        description.append(", директор: ");
        description.append(mEnterprise.getDirector());
        return new Enterprise(mEnterprise.getName(), description.toString());
    }

    /**
     * Метод конвертирует список объектов класса LeisureEnterprise в спсиок объектов класса Enterprise.
     * @param lEnterprises список объектов класса LeisureEnterprise
     * @return спиок объектов класса Enterprise
     */
    public List<Enterprise> toEnterpriseL(List<LeisureEnterprise> lEnterprises) {
        List<Enterprise> enterprises = new ArrayList<>();
        for (LeisureEnterprise lEnterprise : lEnterprises) {
            StringBuilder description = new StringBuilder("Адрес: ");
            description.append(lEnterprise.getAddress());
            description.append(", директор: ");
            description.append(lEnterprise.getDirector());
            enterprises.add(new Enterprise(lEnterprise.getName(), description.toString()));
        }
        return enterprises;
    }

    /**
     * Метод конвертирует список объектов класса MunicipalEnterprise в спсиок объектов класса Enterprise.
     * @param mEnterprises список объектов класса MunicipalEnterprise
     * @return спиок объектов класса Enterprise
     */
    public List<Enterprise> toEnterpriseM(List<MunicipalEnterprise> mEnterprises) {
        List<Enterprise> enterprises = new ArrayList<>();
        for (MunicipalEnterprise mEnterprise : mEnterprises) {
            StringBuilder description = new StringBuilder("Адрес: ");
            description.append(mEnterprise.getAddress());
            description.append(", директор: ");
            description.append(mEnterprise.getDirector());
            enterprises.add(new Enterprise(mEnterprise.getName(), description.toString()));
        }
        return enterprises;
    }
}
