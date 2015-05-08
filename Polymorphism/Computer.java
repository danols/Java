import java.util.Vector;
 
public class Computer {
 
    protected int ram;
    protected String cpu;
    protected int hardDrive;
    protected String videoGraphics;
    protected String brand;
    protected Vector<OperatingSystem> os = new Vector<OperatingSystem>();
 
    public Computer(int ram, String cpu, int hardDrive, String videoGraphics, String brand) {
        this.ram = ram;
        this.cpu = cpu;
        this.hardDrive = hardDrive;
        this.videoGraphics = videoGraphics;
        this.brand = brand; 
    }
 
    protected void installOS(OperatingSystem os) {
        (this.os).addElement(os);
    }
 
    protected void unistallOS(int index) {
        (this.os).removeElementAt(index - 1);
    }
 
    protected void viewOS() {
        System.out.println("\n\t\t\tSistemas Operativos Instalados ***");
        for(OperatingSystem o : os) {
            System.out.println(o);
        }
    }
 
    public String toString() {
        return "\n\t\tProcesador: " + cpu + 
               "\n\t\tRAM: " + ram + " GB" +
               "\n\t\tDisco Duro: " + hardDrive + " GB" +
               "\n\t\tTarjeta de Video: " + videoGraphics +
               "\n\t\tMarca: " + brand;
    }
}
