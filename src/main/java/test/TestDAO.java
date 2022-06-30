/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import datos.PersonDAO;
import domain.Person;
import java.util.List;

/**
 *
 * @author jose_galdamez
 */

// Esta clase va a iniciar el programa
public class TestDAO {
    
    // aquí comienza la ejecución
    public static void main(String[] args) {
        
        // Creamos una instancia de nuestro controlador, 
        // la clase PersonDAO contiene el método obtenerClientes()
        // el método obtenerClientes() llama internamente la clase Conexión y crea la conexión con la base de datos
        PersonDAO personDao = new PersonDAO();
        
        // una vez obtenidos los datos los guardamos en una variable llamada "personas"
        // la lista contiene objetos de tipo Person que está en el paquete domain
        List<Person> personas = personDao.obtenerClientes();
        for( Person persona: personas ){
            // por cada elemento de la lista se imprime el método toString()
            // nos regresa la información de cada uno de los registros de la tabla
            // obviamente si no hay registros no hay impresiones
            System.out.println(persona.toString());
        }
    }
    
}
