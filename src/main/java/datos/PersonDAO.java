package datos;

/**
 * @author jose_galdamez
 */


// importaciones necearias, recuerda revisarlas, no siempre se hacen de forma correcta
import domain.Person;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersonDAO {
    
    // esta será la consulta SQL que haremos a la base de datos.
    private static final String SQL_SELECT = "SELECT * FROM clients";
    
    
    // este método revolvera una lista de clientes
    public List<Person> obtenerClientes(){
        
        
        // Creamos los objetos fuera del Try - Catch ya que en el método finnaly 
        // vamos a cerrar la conexión que genera
        // así que los creamos en un scope superior
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Person persona = null;
        
       
        // esta de personas que devolveremos 
        // que por el momento está vacia
        List<Person> personas = new ArrayList<>();
        
        // Al ser una consulta externa al programa debemos ponerlo en un try-catch
        // si la base dedatos no está corriendo esto nos causara errores,
        // por eso Java exige que se haga dentro de un manejador de errores.
        try {
            
            // aquí llamamamos al metodo getConnection de la clase Connexion que está en el paquete datos
            conn = Conexion.getConnection();
            
            // prepareando la información
            preparedStatement = conn.prepareStatement(SQL_SELECT);
            // objeto con el resultado de la consulta
            resultSet = preparedStatement.executeQuery();
            
            // recorremos las respuestas
            // el ciclo hará tantas iteracones como elementos tenga nuestra tabla
            while (resultSet.next()) {
                
                // creamos un elemento de la clase Person que está en el paquete domain
                persona = new Person(
                                    resultSet.getInt("id_client"),
                                    resultSet.getString("name"),
                                    resultSet.getString("last_name"),
                                    resultSet.getString("age"),
                                    resultSet.getString("email"),
                                    resultSet.getString("phone"));
                
                // el objeto creado lo agregamos a la lista de personas                
                personas.add(persona);
                
                //Si hay más elementos el ciclo se repite y se crea otra persona y se agrega a la lista
            }
            
        } catch (SQLException ex) {
            // Si existe algún error lo mostramos por consola
            System.out.println(ex);
        } finally{
            
            // cerramos los objetos que abrieron una conexión.
            // deben estar en un try-catch ya que le metodo se ejecuta siempre
            // y si da un error arriba no habrá una conexión que cerrar y dará un error aquí
            try {
                Conexion.closeResultSet(resultSet);
                Conexion.closeStatement(preparedStatement);
                Conexion.closeConnection(conn);
            } catch (SQLException ex) {
                System.out.println(ex);
            }
            
            
        }
       
        // regresamos la lista de personas a cualquier objeto que llamé este método obtenerClientes()
        return personas;
       
    } 
    
    public int insertarCliente(Person persona){
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        
        String SQL_INSERT = "INSERT INTO clients (name, last_name, age, email, phone) ";
        SQL_INSERT += "VALUES (?, ?, ?, ?, ?)";
    
        try {
            conn = Conexion.getConnection();
            preparedStatement = conn.prepareStatement(SQL_INSERT);
            preparedStatement.setString(1, persona.getName());
            preparedStatement.setString(2, persona.getLast_name());
            preparedStatement.setString(3, persona.getAge());
            preparedStatement.setString(4, persona.getEmail());
            preparedStatement.setString(5, persona.getPhone());
            
            
            preparedStatement.executeUpdate();
            
            return 1;
            
        } catch (SQLException ex) {
            System.out.println(ex);
            return 0;
            
        } finally{
            try {
                
                Conexion.closeStatement(preparedStatement);
                Conexion.closeConnection(conn);
                
            } catch (SQLException ex) {
                System.out.println(ex);
            }
            
        }
        
    }


    
}
