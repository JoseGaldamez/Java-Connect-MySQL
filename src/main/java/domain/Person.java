
package domain;

/**
 * @author jose_galdamez
 */


// Esta clase es modelo de datos que tendrán los valores que obtenga en la base de datos.
public class Person {
    
    // las personas (clientes) que tengamos en la base de datos tendrán estos campos con estos tipos de datos
    private int id_client;
    private String name;
    private String last_name;
    private String age;
    private String email;
    private String phone;

    
    // Creamos un método constructor para poder crear instancias de la clase
    // podemos crear tantos métodos contructores como queramos.
    public Person(int id_client, String name, String last_name, String age, String email, String phone) {
        this.id_client = id_client;
        this.name = name;
        this.last_name = last_name;
        this.age = age;
        this.email = email;
        this.phone = phone;
    }

    // para el ejemplo querremos imprimir todos los campos de las instancias con un solo método
    @Override
    public String toString() {
        return "Persona{" + "id_client=" + id_client + ", name=" + name + ", last_name=" + last_name + ", age=" + age + ", email=" + email + ", phone=" + phone + '}';
    }

    
    
    
    // getters and setters para las instancias
    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    
}
