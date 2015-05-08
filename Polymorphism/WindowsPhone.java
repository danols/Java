public class WindowsPhone extends MicrosoftWindows {
 
    public WindowsPhone(String name, float version, String platform, String nameAntivirus) {
        super(name,version,platform,nameAntivirus);
    }
 
    public void call(long number) { 
        System.out.println("\n\t\tEl celular con sistema " + name + "ha llamado al número " + number);
    }
 
    public void takePhoto() {
        System.out.println("Se ha tomado una foto desde el celular con sistema " + name);
    }
}
