public class Android extends GNULinux {
 
    private int numCompilation;
    private boolean isRoot;
 
    public Android(String name, float version, String platform, int numCompilation) {
        super(name,version,platform,3);
        this.numCompilation = numCompilation;
        isRoot = false;
    }
 
    public void root() {
        if(isRoot) {
            System.out.println("\n\t\tEl celular ya ha sido Rooteado!");
        } else {
            isRoot = true;
            System.out.println("\n\t\tAndroid Rooteado con éxito!!!");
        }
    }
 
    public void installRom(String nameRom) {
        System.out.println("\n\t\tSe ha instalado exitosamente la ROM " + nameRom);
    }
 
    private String getRootStatus() {
        if(isRoot) return "Activado";
        return "Desactivado";
    }
 
    public String toString() {
        return super.toString() + "\n\t\tNúmero de Compilación: " + numCompilation + "\n\t\tRoot: " + getRootStatus();
    }
}
