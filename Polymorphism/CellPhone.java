public class CellPhone extends Computer {
 
    private long phoneNumber;
 
    public CellPhone(int ram, String cpu, int hardDrive, String videoGraphics, String brand, long phoneNumber) {
        super(ram,cpu,hardDrive,videoGraphics,brand);
        this.phoneNumber = phoneNumber;
    }
    public String toStrng() {
        return super.toString() + "\n\t\tNúmero: " + phoneNumber;
    }
 
}
