package bogdana.example.databaseviewer.connection;

import bogdana.example.databaseviewer.config.ConfigDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
    public Connection getConnection() throws SQLException {
        java.sql.Connection con = DriverManager.getConnection(
                ConfigDao.getProperty(ConfigDao.DB_URL),
                ConfigDao.getProperty(ConfigDao.DB_LOGIN),
                ConfigDao.getProperty(ConfigDao.DB_PASSWORD)
        );
        return con;
    }
}
