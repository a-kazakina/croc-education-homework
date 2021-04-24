package ru.croc.homework8.service;

import ru.croc.homework8.model.LeisureEnterprise;
import ru.croc.homework8.model.MunicipalEnterprise;
import ru.croc.homework8.repository.EnterpriseRepository;

import java.sql.SQLException;
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
     */
    public void addMunicipalRecord(MunicipalEnterprise enterprise) { repository.addMunicipalRecord(enterprise); }

    /**
     * Метод создания записи в БД о новом досуговом предприятии.
     *
     * @param enterprise муниципальное предприятие
     */
    public void addLeisureRecord(LeisureEnterprise enterprise) { repository.addLeisureRecord(enterprise); }

    /**
     * Метод поиска всех записей о досуговых предприятиях в БД.
     *
     * @return список всех досуговых предприятий
     */
    public List<LeisureEnterprise> findAllLeisureEnterprises() {
        return repository.findAllLeisureEnterprises();
    }

    /**
     * Метод поиска всех записей о муниципальных предприятиях в БД.
     *
     * @return список всех муниципальных предприятий
     */
    public List<MunicipalEnterprise> findAllMunicipalEnterprises() { return repository.findAllMunicipalEnterprises(); }

    /**
     * Метод поиска записи в таблице по идентификатору.
     *
     * @param tableName имя таблицы
     * @param id идентификатор предприятия
     * @return true - в таблице есть запись, false - иначе
     * @throws SQLException
     */
    public boolean findByID(String tableName, Integer id) throws SQLException { return repository.findByID(tableName, id); }

    /**
     * Метод удаления таблицы.
     */
    public void clearAll(String tableName) { repository.clearAll(tableName); }
}
