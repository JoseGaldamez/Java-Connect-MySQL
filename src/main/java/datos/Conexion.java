
package datos;

/**
 * @author jose_galdamez
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;


public class Conexion {
    
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/test";
    private static final String JDBC_USER = "jose_galdamez";
    private static final String JDBC_PASSWORD = "Magodeoz1991";
    
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }
    
    
    // methods to close all the opened objects.
    public static void closeResultSet(ResultSet resultSet) throws SQLException{
        resultSet.close();
    }
    
    public static void closeStatement(PreparedStatement preparedStatement ) throws SQLException{
        preparedStatement.close();
    }
    
    public static void closeConnection(Connection connection) throws SQLException{
        connection.close();
    }
    
    
}
