import java.util.Scanner;
public class Tienda {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        int in,articulo;
        USB[] usb = new USB[1000];
        Laptop[] laptop = new Laptop[1000];
        Audifono[] audifono = new Audifono[1000];
        int num_usb=0,num_lap=0,num_adf=0;
        System.out.println("\n\t\t\t** Tienda De Artículos Electrónicos **");
        do {
            System.out.println("\n\t\t1) Registrar Nuevo Artículo \n\t\t2) Vender Artículo \n\t\t3) Artículos Vendidos \n\t\t4) Artículos Disponibles");
            System.out.print("\n\t\tIndica Una Operación: ");
            in = input.nextInt();
            switch(in) {
                case 1:
                    System.out.println("\n\t\t1) USB \n\t\t2) Laptop \n\t\t3) Audífono \n");
                    System.out.print("\n\t\tElige El Artículo: ");
                    articulo = input.nextInt();
                    switch(articulo) {
                        case 1:
                            USB nuevo_usb = new USB();
                            String marca,dimensiones;
                            int capacidad,peso;
                            float precio;
                            System.out.print("\n\t\tIndica La Marca: ");
                            marca = input.next();
                            System.out.print("\n\t\tIndica La Capacidad (GB): ");
                            capacidad = input.nextInt();
                            System.out.print("\n\t\tIndica El Peso (grs): ");
                            peso = input.nextInt();
                            System.out.print("\n\t\tIndica Las Dimensiones AnchoxLargo (mm): ");
                            input.nextLine();
                            dimensiones = input.nextLine();
                            System.out.print("\n\t\tIndica El Precio ($): ");
                            precio = input.nextFloat();
                            usb[num_usb] = new USB();
                            nuevo_usb.registrar_usb(marca,capacidad,dimensiones,peso,precio);
                            usb[num_usb] = nuevo_usb;
                            num_usb++;
                        break;
                        case 2:
                            Laptop nueva_laptop = new Laptop();
                            String os,procesador;
                            int capacidad_dd,ram;
                            float velocidad;
                            System.out.print("\n\t\tIndica La Marca: ");
                            marca = input.next();
                            System.out.print("\n\t\tIndica El Procesador: ");
                            input.nextLine();
                            procesador = input.nextLine();
                            System.out.print("\n\t\tIndica La Capacidad De Disco Duro (GB): ");
                            capacidad_dd = input.nextInt();
                            System.out.print("\n\t\tIndica La Capacidad De Memoria RAM (GB): ");
                            ram = input.nextInt();
                            System.out.print("\n\t\tIndica La Velocidad Del Procesador (GHz): ");
                            velocidad = input.nextFloat();
                            System.out.print("\n\t\tIndica El OS: ");
                            input.nextLine();
                            os = input.nextLine();
                            System.out.print("\n\t\tIndica El Peso (grs): ");
                            peso = input.nextInt();
                            System.out.print("\n\t\tIndica Las Dimensiones AnchoxLargo (cm): ");
                            input.nextLine();
                            dimensiones = input.nextLine();
                            System.out.print("\n\t\tIndica El Precio ($): ");
                            precio = input.nextFloat();
                            laptop[num_lap] = new Laptop();
                            nueva_laptop.registrar_laptop(marca,capacidad_dd,ram,procesador,dimensiones,os,peso,velocidad,precio);
                            laptop[num_lap] = nueva_laptop;
                            num_lap++;
                        break;
                        case 3:
                            Audifono nuevo_audifono = new Audifono(); 
                            String color;
                            System.out.print("\n\t\tIndica La Marca: ");
                            marca = input.next();
                            System.out.print("\n\t\tIndica El Color: ");
                            input.nextLine();
                            color = input.nextLine();
                            System.out.print("\n\t\tIndica El Peso (grs): ");
                            peso = input.nextInt();
                            System.out.print("\n\t\tIndica El Precio ($): ");
                            precio = input.nextFloat();
                            audifono[num_adf] = new Audifono();
                            nuevo_audifono.registrar_audifono(marca,color,peso,precio);
                            audifono[num_adf] = nuevo_audifono;
                            num_adf++;
                        break;
                        default:
                            System.out.println("\n\t\tOpción NO Válida **");
                        break;
                    }
                break;
                case 2:
                    boolean f;
                    do {
                        if(USB.disponibles == 0 && Laptop.disponibles == 0 && Audifono.disponibles == 0) System.out.println("\n\t\tArtículos Agotados **\n");
                        else {
                            String num_articulo;
                            System.out.println("\n\t\t1) Vender USB \n\t\t2) Vender Laptop \n\t\t3) Vender Audífono");
                            System.out.print("\n\t\tElige El Artículo: ");
                            articulo = input.nextInt();
                            switch(articulo) {
                                case 1:
                                    if(USB.disponibles > 0) {
                                        System.out.print("\n\t\tIndica El Número Del Artículo: ");
                                        num_articulo = input.next();
                                        f = USB.vender_usb(usb,num_articulo,num_usb);
                                        if(!f) System.out.println("\n\t\tArtículo NO Encontrado: ");
                                        else System.out.println("\n\t\tVenta Exitosa: ");
                                    } else System.out.println("\n\t\tUSB's Agotadas**");
                                break;
                                case 2:
                                    if(Laptop.disponibles > 0) {
                                        System.out.print("\n\t\tIndica El Número Del Artículo: ");
                                        num_articulo = input.next();
                                        f = Laptop.vender_laptop(laptop,num_articulo,num_lap);
                                        if(!f) System.out.println("\n\t\tArtículo NO Encontrado: ");
                                        else System.out.println("\n\t\tVenta Exitosa: ");
                                    } else System.out.println("\n\t\tLaptops Agotadas**");
                                break;
                                case 3:
                                    if(Audifono.disponibles > 0) {
                                        System.out.print("\n\t\tIndica El Número Del Artículo: ");
                                        num_articulo = input.next();
                                        f = Audifono.vender_audifono(audifono,num_articulo,num_adf);
                                        if(!f) System.out.println("\n\t\tArtículo NO Encontrado: ");
                                        else System.out.println("\n\t\tVenta Exitosa: ");
                                    } else System.out.println("\n\t\tAudífonos Agotados**");
                                break;
                                default:
                                    System.out.println("\n\t\tOpción NO Válida **");
                                break;
                            }
                        }
                        System.out.println("\n\t\tDesea Realizar Otra Venta ? 1:SI 2:NO");
                        System.out.print("\n\t\t\t-> ");
                        in = input.nextInt();
                    }while(in == 1);
                break;
                case 3:
                    if(USB.vendidos == 0) System.out.println("\n\t\t\t NO Hay USB's Vendidos");
                    else {
                        System.out.println("\n\t\t\t USB's Vendidos");
                        for(int i=0;i<num_usb;i++) {
                            if(usb[i].vendido) System.out.println("\t" + usb[i]);
                        }
                        System.out.println("\n\t\t\t\t Total De USB's Vendidos: " + USB.vendidos);
                    }
                    if(Laptop.vendidos == 0) System.out.println("\n\t\t\t NO Hay Laptops Vendidas");
                    else {
                        System.out.println("\n\t\t\t Laptops Vendidas");
                        for(int i=0;i<num_lap;i++) {
                            if(laptop[i].vendido) System.out.println("\t" + laptop[i]);
                        }
                        System.out.println("\n\t\t\t\t Total De Laptops Vendidas: " + Laptop.vendidos);
                    }
                    if(Audifono.vendidos == 0) System.out.println("\n\t\t\t NO Hay Audífonos Vendidos");
                    else {
                        System.out.println("\n\t\t\t Audífonos Vendidos");
                        for(int i=0;i<num_adf;i++) {
                            if(audifono[i].vendido) System.out.println("\t" + audifono[i]);
                        }
                        System.out.println("\n\t\t\t\t Total De Audífonos Vendidos: " + Audifono.vendidos);
                    }
                break;
                case 4:
                    if(USB.disponibles == 0) System.out.println("\n\t\t\t USB's Agotadas");
                    else {
                        System.out.println("\n\t\t\t USB's Disponibles");
                        for(int i=0;i<num_usb;i++) {
                            if(!(usb[i].vendido)) System.out.println("\t" + usb[i]);
                        }
                        System.out.println("\n\t\t\t\t Total De USB's Disponibles: " + USB.disponibles);
                    }
                    if(Laptop.disponibles == 0) System.out.println("\n\t\t\t Laptops Agotadas");
                    else {
                        System.out.println("\n\t\t\t Laptops Disponibles");
                        for(int i=0;i<num_lap;i++) {
                            if(!(laptop[i].vendido)) System.out.println("\t" + laptop[i]);
                        }
                        System.out.println("\n\t\t\t\t Total De Laptops Disponibles: " + Laptop.disponibles);
                    }
                    if(Audifono.disponibles == 0) System.out.println("\n\t\t\t Audífonos Agotados");
                    else {
                        System.out.println("\n\t\t\t Audífonos Disponibles");
                        for(int i=0;i<num_adf;i++) {
                            if(!(audifono[i].vendido)) System.out.println("\t" + audifono[i]);
                        }
                        System.out.println("\n\t\t\t\t Total De Audífonos Disponibles: " + Audifono.disponibles);
                    }
                break;
                default:
                    System.out.println("\n\t\tOpción NO Válida **");
                break;
            }
            System.out.println("\n\t\tDeseas Realizar Otra Operación ? 1:SI 2:NO");
            System.out.print("\n\t\t\t-> ");
            in = input.nextInt();
        } while(in == 1);
    } 
}
