/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import datos.PersonDAO;
import domain.Person;
import java.util.List;
import java.util.Scanner;

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
        Scanner scanner = new Scanner(System.in);
        int optionSelected = 1;
        
        
        while (optionSelected != 0) { 
            System.out.println("\n\n_____________________________________");
            System.out.println("\nSeleccione una acción a realizar\n");
            System.out.println("1. Listar clientes");
            System.out.println("2. Ingresar nuevo cliente.");
            System.out.println("3. Actualizar un cliente existente.");
            System.out.println("4. Borrar un cliente.");
            System.out.println("0. Salir del sistema.");
            
            System.out.print("Su selección: ");
            optionSelected = scanner.nextInt();
            
            switch (optionSelected) {
                case 1:
                    selectClients(personDao);
                    break;
                case 2:
                    insertClient(personDao, scanner);
                    break;
                    
                case 3:
                    updateClient(personDao, scanner);
                    break;
                    
                case 4:
                    deleteClient(personDao, scanner);
                    break;
                    
                case 0:
                    System.out.println("[!] Saliendo del sistema...");
                    break;
                    
                default:
                    System.out.println("\n[!] Ingrese una opción del menu válida...\n\n");
            }
            
        }
        
        
    }
    
    public static void selectClients(PersonDAO personDAO){
        
        // una vez obtenidos los datos los guardamos en una variable llamada "personas"
        // la lista contiene objetos de tipo Person que está en el paquete domain
        List<Person> personas = personDAO.obtenerClientes();
        for( Person persona: personas ){
            // por cada elemento de la lista se imprime el método toString()
            // nos regresa la información de cada uno de los registros de la tabla
            // obviamente si no hay registros no hay impresiones
            System.out.println(persona.toString());
        }
        
    }
    
    public static void deleteClient( PersonDAO personDAO, Scanner scanner ){
        
        System.out.println("Seleccione un registro para actualizar");
        System.out.println("________________________________________");
        selectClients(personDAO);
        
        System.out.print("Id del cliente seleccionado: ");
        int clientSelected = scanner.nextInt();
    
        System.out.print("\n\n¿Está seguro de querer eliminar el usuario?\n1. Si\n2. No\n\nSu respuesta: ");
        int borrar = scanner.nextInt();
        if (borrar == 1) {
            
        if(personDAO.borrarCliente(clientSelected) == 1){
        
            System.out.println("Registro borrar exitosamente.");
            
        } else {
            System.out.println("Algo salio mal.");
        }
        } else {
            System.out.println("\nSaliendo...\nVolviendo al menú...");
        }
        
    }
    
    
    public static void updateClient( PersonDAO personDAO, Scanner scanner ){
        
        System.out.println("Seleccione un registro para actualizar");
        System.out.println("________________________________________");
        selectClients(personDAO);
        
        System.out.print("Id del cliente seleccionado: ");
        int clientSelected = scanner.nextInt();
    
        
        System.out.print("Ingrese el nombre: ");
        scanner.nextLine();
        String name = scanner.nextLine();
        
        System.out.print("Ingrese el apellido: ");
        String lastname = scanner.nextLine();
        
        System.out.print("Ingrese el age: ");
        String age = scanner.nextLine();
        
        System.out.print("Ingrese el email: ");
        String email = scanner.nextLine();
        
        System.out.print("Ingrese el phone: ");
        String phone = scanner.nextLine();
        
        Person persona = new Person(clientSelected, name, lastname, age, email, phone);
        
        if(personDAO.actualizarCliente(persona) == 1){
        
            System.out.println("Registro se actualizó exitosamente.");
            
        } else {
            System.out.println("Algo salio mal.");
        }
    }
    
    
    
    public static void insertClient( PersonDAO personDAO, Scanner scanner ){
    
        
        System.out.print("Ingrese el nombre: ");
        scanner.nextLine();
        String name = scanner.nextLine();
        
        System.out.print("Ingrese el apellido: ");
        String lastname = scanner.nextLine();
        
        System.out.print("Ingrese el age: ");
        String age = scanner.nextLine();
        
        System.out.print("Ingrese el email: ");
        String email = scanner.nextLine();
        
        System.out.print("Ingrese el phone: ");
        String phone = scanner.nextLine();
        
        Person persona = new Person(0, name, lastname, age, email, phone);
        
        if(personDAO.insertarCliente(persona) == 1){
        
            System.out.println("Registro ingresado exitosamente.");
            
        } else {
            System.out.println("Algo salio mal.");
        }
    }
    
    
    
    
}
