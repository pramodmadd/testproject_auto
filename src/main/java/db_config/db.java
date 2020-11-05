/*
    db configurations
 */


package db_config;

import Logs_config.Log;

import java.sql.*;
import java.util.Properties;

public class db {

    private static Properties properties;
    private String workingDir = System.getProperty("user.dir");
    private final String propertyFilePath = workingDir + "AutoTest\\src\\main\\resources\\db.properties";

    public static Connection con = null;
    public static Statement stmt = null;
    public static PreparedStatement pstmt = null;
    public static ResultSet result = null;

    public static void db_config() {

        try {
            /*
            Database configuration for SQL Server
             */

            // Load Microsoft SQL Server JDBC driver

            Class.forName(properties.getProperty("development.sqlserver.test.driver"));

            // Get Connection to SQL Server DB
            con = DriverManager.getConnection(properties.getProperty("development.sqlserver.connection.url"));

            Log.info("Connected to SQL Server database successfully");

            stmt = con.createStatement();

        } catch (ClassNotFoundException classException) {
            classException.printStackTrace();
            Log.error("Class not found Exception caught." + ", Class Name: " + db.class.getName());

        } catch (SQLException sqlException){
            sqlException.printStackTrace();
            Log.error("SQL Exception caught." + ", Class Name: " + db.class.getName());
        }
    }
}
