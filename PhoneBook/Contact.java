import java.util.*;
public class Contact implements Comparable <Contact> {
 
    public static int num_contacts = 0;
 
    private String name;
    private String last_name;
    private short age;
    private long phone;
    private String email;
    private String address;
    private char gender;
    private String relationship;
 
    public Contact() {
        name = "";
        last_name = "";
        age = 0;
        phone = 0;
        email = "";
        address = "";
        gender = ' ';
        relationship = "";
    }
 
    public void init(String value) {
        name = value;
    }
    public void new_contact(String name, String last_name, short age, long phone, String email, String address, char gender, short relationship) {
        this.name = name;
        this.last_name = last_name;
        this.age = age;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.gender = gender;
        if(relationship == 1) this.relationship = "Amigo";
        if(relationship == 2) this.relationship = "Familiar";
        if(relationship == 3) this.relationship = "Conocido";
        num_contacts++;
    }
    public void fill(String name, String last_name, short age, long phone, String email, String address, char gender, short relationship) {
        this.name = name;
        this.last_name = last_name;
        this.age = age;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.gender = gender;
        if(relationship == 1) this.relationship = "Amigo";
        if(relationship == 2) this.relationship = "Familiar";
        if(relationship == 3) this.relationship = "Conocido";
    }
 
    public static int search_contact(Contact contacts[], Contact name) {
        int index = Arrays.binarySearch(contacts,0,num_contacts,name);
        return  index;
    }
 
    public static void drop_contact(Contact contacts[], int index) {
        contacts[index].init("ZZZZZ");
        sort_contacts(contacts);
        num_contacts--;
    }
 
    public static void update_contact(Contact contacts[], Contact c, int index) {
        contacts[index].name = c.name;
        contacts[index].last_name = c.last_name;
        contacts[index].age = c.age;
        contacts[index].phone = c.phone;
        contacts[index].email = c.email;
        contacts[index].address = c.address;
        contacts[index].gender = c.gender;
        contacts[index].relationship = c.relationship;
        sort_contacts(contacts);
    }
 
    static public void view_contacts(Contact contacts[]) {
        sort_contacts(contacts);
        for(int i=0;i<num_contacts;i++) {
            System.out.println(contacts[i]);
        }
    }
 
    private static void sort_contacts(Contact contacts[]) {
        Arrays.sort(contacts,0,num_contacts);
    }
 
    public String toString() {
        return "\n\t\t" + relationship + "\n\n" +
               "\t\tNombre: " + name + "\n" +
               "\t\tApellidos: " + last_name + "\n" +
               "\t\tEdad: " + age + "\n" +
               "\t\tGenero: " + gender + "\n" +
               "\t\tTelefono: " + phone + "\n" +
               "\t\tEmail: " + email + "\n" +
               "\t\tDireccion: " + address;
    }
 
    public int compareTo(Contact C) {
        return (this.name).compareTo(C.name);
    }   
}
