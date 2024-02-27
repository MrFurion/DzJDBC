package connection;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.sql.Connection;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;

public class DataSource {
    private static DataSource instance = new DataSource();
    private ComboPooledDataSource comboPooledDataSource;

    public static DataSource getInstance(){
        return instance;
    }

    private DataSource(){
        Properties properties = new Properties();
        try (InputStream inputStream = new FileInputStream("src/main/resources/db.properties")){
            properties.load(inputStream);
        }catch (Exception e){
            e.printStackTrace();
        }
        comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setJdbcUrl(properties.getProperty("db.url"));
        comboPooledDataSource.setUser(properties.getProperty("db.user"));
        comboPooledDataSource.setPassword(properties.getProperty("db.password"));
        comboPooledDataSource.setInitialPoolSize(10);
        comboPooledDataSource.setMinPoolSize(10);
        comboPooledDataSource.setMaxPoolSize(30);
        comboPooledDataSource.setMaxConnectionAge(1000 * 60 * 10);
    }
    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = comboPooledDataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

}
