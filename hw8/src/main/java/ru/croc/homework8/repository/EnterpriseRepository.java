package ru.croc.homework8.repository;

import org.apache.derby.jdbc.EmbeddedDataSource;
import ru.croc.homework8.model.LeisureEnterprise;
import ru.croc.homework8.model.MunicipalEnterprise;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Репозиторий для доступа к таблицам
 * с данными о предприятиях (LeisureEnterprise, MunicipalEnterprise).
 */
public class EnterpriseRepository {

    private static final String TABLE_LEISURE_ENTERPRISE = "leisure_enterprises";
    private static final String TABLE_MUNICIPAL_ENTERPRISE = "municipal_enterprises";

    /** Data source. */
    private EmbeddedDataSource dataSource;

    public EnterpriseRepository(EmbeddedDataSource dataSource) {
        this.dataSource = dataSource;
        initTable(TABLE_LEISURE_ENTERPRISE);
        initTable(TABLE_MUNICIPAL_ENTERPRISE);
    }

    /**
     * Метод инициализации БД.
     */
    private void initTable(String tableName) {
        System.out.println(String.format("Иницализация %s таблицы.", tableName));

        // пробуем подключиться к БД через data source
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {
            DatabaseMetaData databaseMetadata = connection.getMetaData();

            // ищем таблицу, которую хотим проинициализировать
            ResultSet resultSet = databaseMetadata.getTables(
                    null,
                    null,
                    tableName.toUpperCase(),
                    new String[]{"TABLE"});
            if (resultSet.next()) {
                System.out.println("Таблица уже существует.");
            } else {
                statement.executeUpdate(
                        "CREATE TABLE "
                                + tableName
                                + " ("
                                + "id INTEGER PRIMARY KEY, "
                                + "name VARCHAR(255), "
                                + "timeOpen TIME, "
                                + "timeClose TIME, "
                                + "director VARCHAR(255), "
                                + "address VARCHAR(255)"
                                + ")");
                System.out.println("Таблица проинициализирована.");
            }
        } catch (SQLException e) {
            System.out.println("Ошибка инициализации таблицы: " + e.getMessage());
        } finally {
            System.out.println("=========================");
        }
    }

    /**
     * Метод создания записи в БД о новом муниципальном предприятии.
     *
     * @param enterprise муниципальное предприятие
     */
    public void addMunicipalRecord(MunicipalEnterprise enterprise) {
        String sqlQuery = "INSERT INTO " + TABLE_MUNICIPAL_ENTERPRISE + " VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
            statement.setString(1, enterprise.getId().toString());
            statement.setString(2, enterprise.getName());
            statement.setString(3, enterprise.getTimeOpen().toString());
            statement.setString(4, enterprise.getTimeClose().toString());
            statement.setString(5, enterprise.getDirector());
            statement.setString(6, enterprise.getAddress());
            statement.execute();
        } catch (Exception e) {
            System.out.println("Ошибка выполнения запроса: " + e.getMessage());
        }
    }

    /**
     * Метод создания записи в БД о новом досуговом предприятии.
     *
     * @param enterprise муниципальное предприятие
     */
    public void addLeisureRecord(LeisureEnterprise enterprise) {
        String sqlQuery = "INSERT INTO " + TABLE_LEISURE_ENTERPRISE + " VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
            statement.setString(1, enterprise.getId().toString());
            statement.setString(2, enterprise.getName());
            statement.setString(3, enterprise.getTimeOpen().toString());
            statement.setString(4, enterprise.getTimeClose().toString());
            statement.setString(5, enterprise.getDirector());
            statement.setString(6, enterprise.getAddress());
            statement.execute();
        } catch (Exception e) {
            System.out.println("Ошибка выполнения запроса: " + e.getMessage());
        }
    }

    /**
     * Метод поиска записи в таблице по идентификатору.
     *
     * @param tableName имя таблицы
     * @param id идентификатор предприятия
     * @return true - в таблице есть запись, false - иначе
     * @throws SQLException
     */
    public boolean findByID(String tableName, Integer id) throws SQLException {
        // пробуем подключиться к БД через data source
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + tableName + " WHERE id=" + id);
            if (resultSet.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Ошибка выполнения запроса: " + e.getMessage());
        }
        return false;
    }

    /**
     * Метод поиска всех записей о муниципальных предприятиях в БД.
     *
     * @return список всех муниципальных предприятий
     */
    public List<MunicipalEnterprise> findAllMunicipalEnterprises() {
        // пробуем подключиться к БД через data source
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + TABLE_MUNICIPAL_ENTERPRISE);
            List<MunicipalEnterprise> municipalEnterprisesList = new ArrayList<>();
            while (resultSet.next()) {
                municipalEnterprisesList.add(
                        new MunicipalEnterprise(
                                resultSet.getInt("id"),
                                resultSet.getString("name"),
                                resultSet.getTime("timeOpen"),
                                resultSet.getTime("timeClose"),
                                resultSet.getString("director"),
                                resultSet.getString("address")
                        ));
            }
            return municipalEnterprisesList;
        } catch (Exception e) {
            System.out.println("Ошибка выполнения запроса: " + e.getMessage());
        }
        return new ArrayList<>();
    }

    /**
     * Метод поиска всех записей о досуговых предприятиях в БД.
     *
     * @return список всех досуговых предприятий
     */
    public List<LeisureEnterprise> findAllLeisureEnterprises() {
        // пробуем подключиться к БД через data source
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + TABLE_LEISURE_ENTERPRISE);
            List<LeisureEnterprise> leisureEnterprisesList = new ArrayList<>();
            while (resultSet.next()) {
                leisureEnterprisesList.add(
                        new LeisureEnterprise(
                                resultSet.getInt("id"),
                                resultSet.getString("name"),
                                resultSet.getTime("timeOpen"),
                                resultSet.getTime("timeClose"),
                                resultSet.getString("director"),
                                resultSet.getString("address")
                        ));
            }
            return leisureEnterprisesList;
        } catch (Exception e) {
            System.out.println("Ошибка выполнения запроса: " + e.getMessage());
        }
        return new ArrayList<>();
    }

    /**
     * Метод удаления таблицы.
     */
    public void clearAll(String tableName) {
        String sqlQuery = "DROP TABLE " + tableName;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
            statement.execute();
        } catch (Exception e) {
            System.out.println("Ошибка выполнения запроса: " + e.getMessage());
        }
    }
}
