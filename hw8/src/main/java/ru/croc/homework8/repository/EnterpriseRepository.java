package ru.croc.homework8.repository;

import org.apache.derby.jdbc.EmbeddedDataSource;
import ru.croc.homework8.model.in.LeisureEnterprise;
import ru.croc.homework8.model.in.MunicipalEnterprise;

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

    private static final  String ID = "id";
    private static final String NAME = "name";
    private static final String TIMEOPEN = "timeOpen";
    private static final String TIMECLOSE = "timeClose";
    private static final String DIRECTOR = "director";
    private static final String ADDRESS = "address";


    /** Data source. */
    private EmbeddedDataSource dataSource;

    public EnterpriseRepository(EmbeddedDataSource dataSource) throws SQLException {
        this.dataSource = dataSource;
        initTable(TABLE_LEISURE_ENTERPRISE);
        initTable(TABLE_MUNICIPAL_ENTERPRISE);
    }

    /**
     * Метод инициализации таблицы.
     *
     * @param tableName название таблицы
     * @throws SQLException
     */
    private void initTable(String tableName) throws SQLException {
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
                                    + ID + " INTEGER PRIMARY KEY, "
                                    + NAME + " VARCHAR(255), "
                                    + TIMEOPEN + " TIME, "
                                    + TIMECLOSE + " TIME, "
                                    + DIRECTOR + " VARCHAR(255), "
                                    + ADDRESS + " VARCHAR(255)"
                                    + ")");
                    System.out.println("Таблица проинициализирована.");
                    resultSet.close();
                }
        } finally {
                System.out.println("=========================");
        }
    }

    /**
     * Метод создания записи в БД о новом муниципальном предприятии.
     *
     * @param enterprise муниципальное предприятие
     * @throws SQLSyntaxErrorException
     */
    public void addMunicipalRecord(MunicipalEnterprise enterprise) throws SQLSyntaxErrorException {
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
                throw new SQLSyntaxErrorException("Ошибка выполнения запроса: " + e.getMessage());
        }
    }

    /**
     * Метод создания записи в БД о новом досуговом предприятии.
     *
     * @param enterprise муниципальное предприятие
     * @throws SQLSyntaxErrorException
     */
    public void addLeisureRecord(LeisureEnterprise enterprise) throws SQLSyntaxErrorException {
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
                throw new SQLSyntaxErrorException("Ошибка выполнения запроса: " + e.getMessage());
        }
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
        // пробуем подключиться к БД через data source
        try (Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery("SELECT * FROM " + tableName +
                                                                    " WHERE " + ID + "=" + id);
                if (resultSet.next()) {
                    resultSet.close();
                    return true;
                }
                resultSet.close();
        } catch (Exception e) {
                throw new SQLSyntaxErrorException("Ошибка выполнения запроса: " + e.getMessage());
        }
        return false;
    }

    /**
     * Метод поиска записей о работающих муниципальных предприятиях в БД.
     *
     * @param timeFind время
     * @return список всех муниципальных предприятий
     * @throws SQLSyntaxErrorException
     */
    public List<MunicipalEnterprise> findMunicipalEnterprises(Time timeFind) throws SQLSyntaxErrorException {
        String strTime = "'" + timeFind + "'";
        // пробуем подключиться к БД через data source
        try (Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery("SELECT * FROM " + TABLE_MUNICIPAL_ENTERPRISE +
                                                                " WHERE " + TIMEOPEN + " <= " + strTime +
                                                                " AND " + TIMECLOSE + " >= " + strTime );
                List<MunicipalEnterprise> municipalEnterprisesList = new ArrayList<>();
                while (resultSet.next()) {
                    municipalEnterprisesList.add(
                            new MunicipalEnterprise(
                                    resultSet.getInt(ID),
                                    resultSet.getString(NAME),
                                    resultSet.getTime(TIMEOPEN),
                                    resultSet.getTime(TIMECLOSE),
                                    resultSet.getString(DIRECTOR),
                                    resultSet.getString(ADDRESS)
                            ));
                }
                resultSet.close();
                return municipalEnterprisesList;
        } catch (Exception e) {
                throw new SQLSyntaxErrorException("Ошибка выполнения запроса: " + e.getMessage());
        }
    }

    /**
     * Метод поиска всех записей о работающих досуговых предприятиях в БД.
     *
     * @param timeFind время
     * @return список всех досуговых предприятий
     * @throws SQLSyntaxErrorException
     */
    public List<LeisureEnterprise> findLeisureEnterprises(Time timeFind) throws SQLSyntaxErrorException {
        String strTime = "'" + timeFind + "'";
        // пробуем подключиться к БД через data source
        try (Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + TABLE_LEISURE_ENTERPRISE +
                                                            " WHERE " + TIMEOPEN + " <= " + strTime +
                                                            " AND " + TIMECLOSE + " >= " + strTime );
                List<LeisureEnterprise> leisureEnterprisesList = new ArrayList<>();
                while (resultSet.next()) {
                    leisureEnterprisesList.add(
                            new LeisureEnterprise(
                                    resultSet.getInt(ID),
                                    resultSet.getString(NAME),
                                    resultSet.getTime(TIMEOPEN),
                                    resultSet.getTime(TIMECLOSE),
                                    resultSet.getString(DIRECTOR),
                                    resultSet.getString(ADDRESS)
                            ));
                }
                resultSet.close();
                return leisureEnterprisesList;
        } catch (Exception e) {
                throw new SQLSyntaxErrorException("Ошибка выполнения запроса: " + e.getMessage());
        }
    }

    /**
     * Метод удаления таблицы.
     *
     * @param tableName название таблицы
     * @throws SQLSyntaxErrorException
     */
    public void clearAll(String tableName) throws SQLSyntaxErrorException {
        String sqlQuery = "DROP TABLE " + tableName;
        try (Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
                statement.execute();
        } catch (Exception e) {
                throw new SQLSyntaxErrorException("Ошибка выполнения запроса: " + e.getMessage());
        }
    }
}
