import java.util.*;
public class Laptop {
    public static int disponibles = 0;
    public static int vendidos = 0;
    public static int registros = 0;
 
    private String numInv;
    private int capacidad_dd; 
    private int ram; 
    private String marca;
    private String procesador; 
    private String os; 
    private String dimensiones; 
    private float velocidad; 
    private float precio;
    private int peso;
    public boolean vendido;
 
    public void registrar_laptop(String marca, int capacidad_dd, int ram, String procesador, String dimensiones, String os, int peso, float velocidad, float precio) {
        this.marca = marca;
        this.ram = ram;
        this.procesador = procesador;
        this.capacidad_dd = capacidad_dd;
        this.os = os;
        this.dimensiones = dimensiones;
        this.peso = peso;
        this.velocidad = velocidad;
        this.precio = precio;
        vendido = false;
        numInv = generar_numInv(registros + 1);
        disponibles++;
        registros++;
    }
    public static boolean vender_laptop(Laptop L[], String num, int l) {
        int i;
        boolean find = false;
        for(i=0;i<l;i++) {
            if((L[i].numInv).equals(num)) {find = true; break;}
        }
        if(!find) return false;
        else {
            L[i].vendido = true;
            vendidos++;
            disponibles--;
            return true;
        }
    }
    private String generar_numInv(int r) {
        if(r < 10) return "LTP0" + Integer.toString(r);
        else return "LTP" + Integer.toString(r);
    }
    public String toString() {
        return "\n\t\tNúmero De Inventario: " + numInv + 
                "\n\t\tMarca: " + marca + 
                "\n\t\tProcesador: " + procesador + 
                "\n\t\tDisco Duro: " + capacidad_dd + " GB " +
                "\n\t\tRAM: " + ram + " GB " +
                "\n\t\tVelocidad: " + velocidad + " GHz " +
                "\n\t\tDimensiones: " + dimensiones + " cm" +
                "\n\t\tSistema Operativo: " + os +
                "\n\t\tPeso: " + peso + " grs" +
                "\n\t\tPrecio: $ " + precio + " pesos";
    }
}
