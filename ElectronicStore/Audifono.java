import java.util.*;
public class Audifono {
    public static int disponibles = 0;
    public static int vendidos = 0;
    public static int registros = 0;
 
    private String numInv;
    private String marca;
    private String color; 
    private float precio;
    private int peso;
    public boolean vendido;
 
    public void registrar_audifono(String marca, String color, int peso, float precio) {
        this.marca = marca;
        this.color = color;
        this.peso = peso;
        this.precio = precio;
        vendido = false;
        numInv = generar_numInv(registros + 1);
        disponibles++;
        registros++;
    }
    public static boolean vender_audifono(Audifono A[], String num, int l) {
        int i;
        boolean find = false;
        for(i=0;i<l;i++) {
            if((A[i].numInv).equals(num)) {find = true; break;}
        }
        if(!find) return false;
        else {
            A[i].vendido = true;
            vendidos++;
            disponibles--;
            return true;
        }
    }
    private String generar_numInv(int r) {
        if(r < 10) return "AUD0" + Integer.toString(r);
        else return "AUD" + Integer.toString(r);
    }
    public String toString() {
        return "\n\t\tNúmero De Inventario: " + numInv + 
                "\n\t\tMarca: " + marca + 
                "\n\t\tColor: " + color +
                "\n\t\tPeso: " + peso + " grs" +
                "\n\t\tPrecio: $ " + precio + " pesos";
    }
}
