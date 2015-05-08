public class Application {
 
    private String name;
    private float version;
 
    public Application(String name, float version) {
        this.name = name;
        this.version = version;
    }
 
    public String toString() {
        return name + " - " + version;
    }
}
