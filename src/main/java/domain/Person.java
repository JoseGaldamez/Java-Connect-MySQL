
package domain;

/**
 * @author jose_galdamez
 */

public class Person {
    
    private int id_client;
    private String name;
    private String last_name;
    private String age;
    private String email;
    private String phone;

    public Person(int id_client, String name, String last_name, String age, String email, String phone) {
        this.id_client = id_client;
        this.name = name;
        this.last_name = last_name;
        this.age = age;
        this.email = email;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Persona{" + "id_client=" + id_client + ", name=" + name + ", last_name=" + last_name + ", age=" + age + ", email=" + email + ", phone=" + phone + '}';
    }

    
    
    
    // getters and setters
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
