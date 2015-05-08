import java.util.Scanner;
public class Directory {
    static Scanner input = new Scanner(System.in);
    public static void main (String[] args) {
        int in, idx;
        Contact[] Agenda = new Contact[15];
        do {
            String name = "", last_name = "", email = "", address = "";
            short age = 0, relationship = 0;
            long phone = 0;
            char gender = ' ';
            Contact contact = new Contact();
            System.out.println("\n\t\t\tAgenda de Contactos\n");
            System.out.println("\t\t1) Nuevo Contato");
            System.out.println("\t\t2) Buscar Contato");
            System.out.println("\t\t3) Modificar Contato");
            System.out.println("\t\t4) Eliminar Contato");
            System.out.println("\t\t5) Mostrar Contatos");
            System.out.println("\t\t6) Salir");
            System.out.print("\n\t\t\t-> ");
            in = input.nextInt();
            switch(in) {
                    case 1:
                        System.out.print("\n\t\tIndica El Nombre(s): ");
                        input.nextLine();
                        name = input.nextLine();
                        System.out.print("\n\t\tIndica Los Apellidos: ");
                        last_name = input.nextLine();
                        System.out.print("\n\t\tIndica La Edad: ");
                        age = input.nextShort();
                        System.out.print("\n\t\tIndica El Genero M/F: ");
                        gender = input.next().charAt(0);
                        System.out.println("\n\t\t1) Amigo");
                        System.out.println("\t\t2) Familiar");
                        System.out.println("\t\t3) Conocido");
                        System.out.print("\n\t\tIndica El Parentesco: ");
                        relationship = input.nextShort();
                        System.out.print("\n\t\tIndica El Numero De Telefono: ");
                        phone = input.nextLong();
                        System.out.print("\n\t\tIndica La Direccion De Correo: ");
                        email = input.next();
                        System.out.print("\n\t\tIndica La Direccion: ");
                        input.nextLine();
                        address = input.nextLine();
                        Agenda[Contact.num_contacts] = new Contact();
                        contact.new_contact(name,last_name,age,phone,email,address,gender,relationship);
                        Agenda[Contact.num_contacts - 1] = contact;
                    break;
                    case 2:
                        System.out.print("\n\t\tIndica El Nombre(s): ");
                        input.nextLine();
                        name = input.nextLine();
                        contact.init(name);
                        idx = Contact.search_contact(Agenda,contact);
                        if(idx < 0) System.out.println("\n\t\tContacto NO Encontrado");
                        else {
                            System.out.println(Agenda[idx]);
                        }
                    break;
                    case 3:
                        System.out.print("\n\t\tIndica El Nombre(s) Del Contacto A Modificar: ");
                        input.nextLine();
                        name = input.nextLine();
                        contact.init(name);
                        idx = Contact.search_contact(Agenda,contact);
                        if(idx < 0) System.out.println("\n\t\tContacto NO Encontrado");
                        else {
                            System.out.print("\n\t\tIndica El Nombre(s): ");
                            name = input.nextLine();
                            System.out.print("\n\t\tIndica Los Apellidos: ");
                            last_name = input.nextLine();
                            System.out.print("\n\t\tIndica La Edad: ");
                            age = input.nextShort();
                            System.out.print("\n\t\tIndica El Genero M/F: ");
                            gender = input.next().charAt(0);
                            System.out.println("\n\t\t1) Amigo");
                            System.out.println("\t\t2) Familiar");
                            System.out.println("\t\t3) Conocido");
                            System.out.print("\n\t\tIndica El Parentesco: ");
                            relationship = input.nextShort();
                            System.out.print("\n\t\tIndica El Numero De Telefono: ");
                            phone = input.nextLong();
                            System.out.print("\n\t\tIndica La Direccion De Correo: ");
                            email = input.next();
                            System.out.print("\n\t\tIndica La Direccion: ");
                            input.nextLine();
                            address = input.nextLine();
                            contact.fill(name,last_name,age,phone,email,address,gender,relationship);
                            Contact.update_contact(Agenda,contact,idx);
                        }
                    break;
                    case 4:
                        System.out.print("\n\t\tIndica El Nombre(s) Del Contacto A Eliminar: ");
                        input.nextLine();
                        name = input.nextLine();
                        contact.init(name);
                        idx = Contact.search_contact(Agenda,contact);
                        if(idx < 0) System.out.println("\n\t\tContacto NO Encontrado");
                        else {
                            Contact.drop_contact(Agenda,idx);
                            System.out.print("\n\t\tContacto Eliminado Exitosamente\n");
                        }
                    break;
                    case 5:
                        Contact.view_contacts(Agenda);
                    break;
                    case 6:
                        System.exit(0); 
                    break;
                    default:
                        System.out.println("\n\t\tOpcion NO Valida\n");
                    break;
            }
            System.out.print("\n\t\t\tDeseas Realizar Otra Operacion ? 1:Si 2:No --> ");
            in = input.nextInt();
        } while(in == 1);
    }
}
