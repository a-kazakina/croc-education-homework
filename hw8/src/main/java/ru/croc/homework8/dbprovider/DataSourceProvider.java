package ru.croc.homework8.dbprovider;

import org.apache.derby.jdbc.EmbeddedDataSource;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Data source provider.
 */
public class DataSourceProvider {

    /** Data source. */
    private EmbeddedDataSource dataSource;

    /** Параметры конфигурации. */
    private Map<String, String> properties = new HashMap<>();

    public DataSourceProvider() throws IOException {
        // загружаем параметры конфигурации при создании нового data source
        loadProperties();
    }

    /**
     * Процедура, которая загружает данные из файла .properties.
     * @throws IOException исключение, если загрузить данные из файла не удалось
     */
    private void loadProperties() throws IOException {
        Properties properties = new Properties();
        try {
            // пытаемся получить данные из файла,
            // в который записывали данные БД
            properties.load(
                    Thread.currentThread().
                            getContextClassLoader().
                            getResourceAsStream("application.properties"));

            // добавим в переменную properties пароль и логин
            for (Map.Entry<Object, Object> entry : properties.entrySet()) {
                this.properties.put((String) entry.getKey(), (String) entry.getValue());
            }
        } catch (Exception e) {
            System.out.println("Error occurred during loading properties");
            throw e;
        }
    }

    /**
     * Функция, которая получает data source.
     * @return data source
     */
    public EmbeddedDataSource getDataSource() {
        if (dataSource == null) {
            dataSource = new EmbeddedDataSource();
            dataSource.setDatabaseName(properties.get("database.name"));
            String username = properties.get("database.username");
            String password = properties.get("database.password");
            if (username != null && !username.isEmpty()
                    && password != null && !password.isEmpty()) {
                dataSource.setUser(username);
                dataSource.setPassword(password);
            }
            dataSource.setCreateDatabase("create");
        }

        return dataSource;
    }

}
