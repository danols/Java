public class Fedora extends GNULinux {
 
    public Fedora(String name, float version, String platform) {
        super(name,version,platform,3);
    }
 
    public void program(String language) {
        System.out.println("\n\t\tSe está programando en el sistema " + name + " utilizando el lenguaje " + language);
    }
}
