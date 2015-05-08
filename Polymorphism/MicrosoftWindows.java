public class MicrosoftWindows extends OperatingSystem {
 
    protected String nameAntivirus;
 
    public MicrosoftWindows(String name, float version, String platform, String nameAntivirus) {
        super(name,version,platform);
        this.nameAntivirus = nameAntivirus;
    }
 
    protected void talkCortana() {
        System.out.println("\n\t\tEl SO " + name + "ha interactuado con Cortana!");
    }
 
    public void updateOS() {
        if(version == 1.0) {
            version += 1.0;
        }
        if(version == 2.0) {
            version += 1.0;
        }
        if(version == 3.0) {
            version += 1.0;
        }
        if(version == 4.0) {
            version += 1.0;
        }
    }
 
}
