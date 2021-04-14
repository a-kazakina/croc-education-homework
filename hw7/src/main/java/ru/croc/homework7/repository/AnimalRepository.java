package ru.croc.homework7.repository;

import org.apache.derby.jdbc.EmbeddedDataSource;
import ru.croc.homework7.model.Animal;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Репозиторий для доступа к таблице с данными о животных (Animal).
 */
public class AnimalRepository {

    private static final String TABLE_NAME = "animals";

    /** Data source. */
    private EmbeddedDataSource dataSource;

    public AnimalRepository(EmbeddedDataSource dataSource) {
        this.dataSource = dataSource;
        initTable();
    }

    /**
     * Метод инициализации БД.
     */
    private void initTable() {
        System.out.println(String.format("Иницализация %s таблицы.", TABLE_NAME));

        // пробуем подключиться к БД через data source
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {
            DatabaseMetaData databaseMetadata = connection.getMetaData();

            // ищем таблицу, которую хотим проинициализировать
            ResultSet resultSet = databaseMetadata.getTables(
                    null,
                    null,
                    TABLE_NAME.toUpperCase(),
                    new String[]{"TABLE"});
            if (resultSet.next()) {
                System.out.println("Таблица уже существует.");
            } else {
                statement.executeUpdate(
                        "CREATE TABLE "
                                + TABLE_NAME
                                + " ("
                                + "id INTEGER PRIMARY KEY, "
                                + "name VARCHAR(255), "
                                + "limbs INTEGER, "
                                + "dateOfBirth DATE, "
                                + "predator BOOlEAN, "
                                + "aviaryNumber INTEGER"
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
     * Метод поиска всех животных в БД.
     *
     * @return список всех животных
     */
    public List<Animal> findAll() {
        // пробуем подключиться к БД через data source
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + TABLE_NAME);
            List<Animal> animalList = new ArrayList<>();
            while (resultSet.next()) {
                animalList.add(
                        new Animal(
                                resultSet.getInt("id"),
                                resultSet.getString("name"),
                                resultSet.getInt("limbs"),
                                resultSet.getDate("dateOfBirth"),
                                resultSet.getBoolean("predator"),
                                resultSet.getInt("aviaryNumber")
                        ));
            }
            return animalList;
        } catch (Exception e) {
            System.out.println("Ошибка выполнения запроса: " + e.getMessage());
        }
        return new ArrayList<>();
    }

    /**
     * Метод создания записи в БД о новом животном.
     *
     * @param animal животное
     */
    public void addAnimal(Animal animal) {
        String sqlQuery = "INSERT INTO " + TABLE_NAME + " VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
            statement.setString(1, animal.getId().toString());
            statement.setString(2, animal.getName());
            statement.setString(3, animal.getLimbs().toString());
            statement.setString(4, animal.getDateOfBirth().toString());
            statement.setString(5, animal.getPredator().toString());
            statement.setString(6, animal.getAviaryNumber().toString());
            statement.execute();
        } catch (Exception e) {
            System.out.println("Ошибка выполнения запроса: " + e.getMessage());
        }
    }

    /**
     * Метод изменения информации о животном в БД.
     * В данном методе меняется полностью вся строка с данными.
     *
     * @param id код животного
     * @param animal новая информация о животном
     */
    public void updateAnimal(Integer id, Animal animal) {
        String sqlQuery = "UPDATE " + TABLE_NAME + " SET id= ?, " +
                                                    "name=?, " +
                                                    "limbs=?, " +
                                                    "dateOfBirth=?, " +
                                                    "predator=?, " +
                                                    "aviaryNumber=? " +
                                                    "WHERE id=" + id;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
            statement.setString(1, animal.getId().toString());
            statement.setString(2, animal.getName());
            statement.setString(3, animal.getLimbs().toString());
            statement.setString(4, animal.getDateOfBirth().toString());
            statement.setString(5, animal.getPredator().toString());
            statement.setString(6, animal.getAviaryNumber().toString());
            statement.execute();
        } catch (Exception e) {
            System.out.println("Ошибка выполнения запроса: " + e.getMessage());
        }
    }

    /**
     * Метод изменения информации о животном в БД.
     * В данном методе меняется код животного.
     *
     * @param beforeId старый код животного
     * @param afterId новый код животного
     */
    public void updateAnimalId(Integer beforeId, Integer afterId) {
        String sqlQuery = "UPDATE " + TABLE_NAME + " SET id=? " +
                "WHERE id=" + beforeId;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
            statement.setString(1, afterId.toString());
            statement.execute();
        } catch (Exception e) {
            System.out.println("Ошибка выполнения запроса: " + e.getMessage());
        }
    }

    /**
     * Метод изменения информации о животном в БД.
     * В данном методе меняется имя животного.
     *
     * @param id код животного
     * @param newName новое имя животного
     */
    public void updateAnimalName(Integer id, String newName) {
        String sqlQuery = "UPDATE " + TABLE_NAME + " SET name=? " +
                "WHERE id=" + id;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
            statement.setString(1, newName);
            statement.execute();
        } catch (Exception e) {
            System.out.println("Ошибка выполнения запроса: " + e.getMessage());
        }
    }

    /**
     * Метод изменения информации о животном в БД.
     * В данном методе меняется количество конечностей животного.
     *
     * @param id код животного
     * @param newLimbs новок количество конечностей
     */
    public void updateAnimalLimbs(Integer id, Integer newLimbs) {
        String sqlQuery = "UPDATE " + TABLE_NAME + " SET limbs=? " +
                "WHERE id=" + id;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
            statement.setString(1, newLimbs.toString());
            statement.execute();
        } catch (Exception e) {
            System.out.println("Ошибка выполнения запроса: " + e.getMessage());
        }
    }

    /**
     * Метод изменения информации о животном в БД.
     * В данном методе меняется дата рождения животного.
     *
     * @param id код животного
     * @param newDate новая дата рождения
     */
    public void updateAnimalDateOfBirth(Integer id, Date newDate) {
        String sqlQuery = "UPDATE " + TABLE_NAME + " SET dateOfBirth=? " +
                "WHERE id=" + id;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
            statement.setString(1, newDate.toString());
            statement.execute();
        } catch (Exception e) {
            System.out.println("Ошибка выполнения запроса: " + e.getMessage());
        }
    }

    /**
     * Метод изменения информации о животном в БД.
     * В данном методе меняется о том, является ли животное хищником.
     *
     * @param id код животного
     * @param newPredator хищник/нет
     */
    public void updateAnimalPredator(Integer id, Boolean newPredator) {
        String sqlQuery = "UPDATE " + TABLE_NAME + " SET predator=? " +
                "WHERE id=" + id;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
            statement.setString(1, newPredator.toString());
            statement.execute();
        } catch (Exception e) {
            System.out.println("Ошибка выполнения запроса: " + e.getMessage());
        }
    }

    /**
     * Метод изменения информации о животном в БД.
     * В данном методе меняется номер вольера животного.
     *
     * @param id код животного
     * @param newAviaryNumber новый номер вольера
     */
    public void updateAnimalAviaryNumber(Integer id, Integer newAviaryNumber) {
        String sqlQuery = "UPDATE " + TABLE_NAME + " SET aviaryNumber=? " +
                "WHERE id=" + id;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
            statement.setString(1, newAviaryNumber.toString());
            statement.execute();
        } catch (Exception e) {
            System.out.println("Ошибка выполнения запроса: " + e.getMessage());
        }
    }

    /**
     * Метод удаления животного из таблицы БД.
     *
     * @param id код животного
     */
    public void deleteAnimal(Integer id) {
        String sqlQuery = "DELETE FROM " + TABLE_NAME + "  WHERE id=" + id;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
            statement.execute();
        } catch (Exception e) {
            System.out.println("Ошибка выполнения запроса: " + e.getMessage());
        }
    }

    /**
     * Метод удаления таблицы.
     */
    public void deleteTable() {
        String sqlQuery = "DROP TABLE " + TABLE_NAME;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
            statement.execute();
        } catch (Exception e) {
            System.out.println("Ошибка выполнения запроса: " + e.getMessage());
        }
    }
}
