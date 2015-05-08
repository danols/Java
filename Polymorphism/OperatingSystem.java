import java.util.Vector;
 
public abstract class OperatingSystem {
 
    protected String name;
    protected float version;
    protected Vector<User> users = new Vector<User>();
    protected Vector<Application> apps = new Vector<Application>();
    protected String platform;
 
    public OperatingSystem(String name, float version, String platform) {
        this.name = name;
        this.version = version;
        this.platform = platform;
    }
 
    protected void installApp(Application app) {
        apps.addElement(app);
    }
 
    protected void removeApp(int index) {
        apps.removeElementAt(index - 1);
    } 
 
    protected void restoreOS() {
        apps.removeAllElements();
        users.removeAllElements();
        System.out.println("\n\t\tEl OS ha sido restaurado exitosamente!!!");
    }
 
    protected void addUser(User user) {
        users.addElement(user);
    }
 
    protected void viewUsers() {
        System.out.println("\n\t\t\tUsuarios En " + name + " ***");
        for(User u : users) {
            if(u instanceof Admin)
                System.out.println("\t\tAdministrador: " + u);
            else
                System.out.println("\t\tInvitado: " + u);
        }
    }
 
    protected void viewApps() {
        System.out.println("\n\t\t\tAplicaciones En " + name + " ***");
        for(int i=0;i<apps.size();i++) {
            System.out.print("\n\t\t(" + (i+1) + ") " + apps.elementAt(i));
        }
        System.out.println();
    }
 
    public abstract void updateOS();
 
    public String toString() {
        return "\n\t\tSO: " + name + 
               "\n\t\tVersión: " + version;
    }
 
}
