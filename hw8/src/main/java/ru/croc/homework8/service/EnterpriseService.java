package ru.croc.homework8.service;

import ru.croc.homework8.model.in.LeisureEnterprise;
import ru.croc.homework8.model.in.MunicipalEnterprise;
import ru.croc.homework8.repository.EnterpriseRepository;

import java.sql.SQLSyntaxErrorException;
import java.sql.Time;
import java.util.List;

/**
 * Прикладной сервис по работе с БД.
 */
public class EnterpriseService {

    /** Репозиторий для доступа к таблице с данными. */
    private final EnterpriseRepository repository;

    public EnterpriseService(EnterpriseRepository repository) {
        this.repository = repository;
    }

    /**
     * Метод создания записи в БД о новом муниципальном предприятии.
     *
     * @param enterprise муниципальное предприятие
     * @throws SQLSyntaxErrorException
     */
    public void addMunicipalRecord(MunicipalEnterprise enterprise) throws SQLSyntaxErrorException {
        repository.addMunicipalRecord(enterprise);
    }

    /**
     * Метод создания записи в БД о новом досуговом предприятии.
     *
     * @param enterprise муниципальное предприятие
     * @throws SQLSyntaxErrorException
     */
    public void addLeisureRecord(LeisureEnterprise enterprise) throws SQLSyntaxErrorException {
        repository.addLeisureRecord(enterprise);
    }

    /**
     * Метод поиска всех записей о работающих досуговых предприятиях в БД.
     *
     * @param timeFind время
     * @return список всех досуговых предприятий
     * @throws SQLSyntaxErrorException
     */
    public List<LeisureEnterprise> findLeisureEnterprises(Time timeFind) throws SQLSyntaxErrorException {
        return repository.findLeisureEnterprises(timeFind);
    }

    /**
     * Метод поиска записей о работающих муниципальных предприятиях в БД.
     *
     * @param timeFind время
     * @return список всех муниципальных предприятий
     * @throws SQLSyntaxErrorException
     */
    public List<MunicipalEnterprise> findMunicipalEnterprises(Time timeFind) throws SQLSyntaxErrorException {
        return repository.findMunicipalEnterprises(timeFind);
    }

    /**
     * Метод поиска записи в таблице по идентификатору.
     *
     * @param tableName имя таблицы
     * @param id идентификатор предприятия
     * @return true - в таблице есть запись, false - иначе
     * @throws SQLSyntaxErrorException
     */
    public boolean findByID(String tableName, Integer id) throws SQLSyntaxErrorException {
        return repository.findByID(tableName, id);
    }

    /**
     * Метод удаления таблицы.
     *
     * @param tableName название таблицы
     * @throws SQLSyntaxErrorException
     */
    public void clearAll(String tableName) throws SQLSyntaxErrorException {
        repository.clearAll(tableName);
    }
}
