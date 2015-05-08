import java.util.*;
public class USB {
    public static int disponibles = 0;
    public static int vendidos = 0;
    public static int registros = 0;
 
    private String numInv;
    private int capacidad;
    private String marca;
    private String dimensiones; 
    private float precio;
    private int peso;
    public boolean vendido;
 
    public void registrar_usb(String marca, int capacidad, String dimensiones, int peso, float precio) {
        this.marca = marca;
        this.capacidad = capacidad;
        this.dimensiones = dimensiones;
        this.peso = peso;
        this.precio = precio;
        vendido = false;
        numInv = generar_numInv(registros + 1);
        disponibles++;
        registros++;
    }
    public static boolean vender_usb(USB U[], String num, int l) {
        int i;
        boolean find = false;
        for(i=0;i<l;i++) {
            if((U[i].numInv).equals(num)) {find = true; break;}
        }
        if(!find) return false;
        else {
            U[i].vendido = true;
            vendidos++;
            disponibles--;
            return true;
        }
    }
    private String generar_numInv(int r) {
        if(r < 10) return "USB0" + Integer.toString(r);
        else return "USB" + Integer.toString(r);
    }
    public String toString() {
        return "\n\t\tNúmero De Inventario: " + numInv + 
                "\n\t\tMarca: " + marca + 
                "\n\t\tCapacidad: " + capacidad + " GB " +
                "\n\t\tDimensiones: " + dimensiones + " mm" +
                "\n\t\tPeso: " + peso + " grs" +
                "\n\t\tPrecio: $ " + precio + " pesos";
    }
}
