package datos;

/**
 * @author jose_galdamez
 */

import domain.Person;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonDAO {
    
    private static final String SQL_SELECT = "SELECT * FROM clients";
    
    public List<Person> obtenerClientes(){
    
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Person persona = null;
        
       
        List<Person> personas = new ArrayList<>();
        
        
        try {
            conn = Conexion.getConnection();
            
            preparedStatement = conn.prepareStatement(SQL_SELECT);
            resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                
                persona = Person(
                                    resultSet.getInt("id_client"),
                                    resultSet.getString("name"),
                                    resultSet.getString("last_name"),
                                    resultSet.getString("age"),
                                    resultSet.getString("email"),
                                    resultSet.getString("phone"));
                
                personas.add(persona);
                
            }
            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally{
            
            try {
                Conexion.closeResultSet(resultSet);
                Conexion.closeStatement(preparedStatement);
                Conexion.closeConnection(conn);
            } catch (SQLException ex) {
                System.out.println(ex);
            }
            
            
        }
       
        return personas;
       
    } 

    private Person Person(int aInt, String string, String string0, String string1, String string2, String string3) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
