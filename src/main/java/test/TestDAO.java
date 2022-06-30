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
public class TestDAO {
    
    public static void main(String[] args) {
        PersonDAO personDao = new PersonDAO();
        
        List<Person> personas = personDao.obtenerClientes();
        for( Person persona: personas ){
            System.out.println(persona.toString());
        }
    }
    
}
