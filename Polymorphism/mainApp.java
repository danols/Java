public class mainApp {
    public static void main(String[] args) {
 
        Computer computer1 = new Computer(16,"Intel Core i5 3.2 Ghz",2000,"NVIDIA GTX 980","ASUS");
        System.out.println(computer1);
        CellPhone cellPhone1 = new CellPhone(2,"Snap Dragon II 1.6 Ghz",16,"NVIDIA GTX 12","XPERIA",25687460);
        System.out.println(cellPhone1);
 
        Windows windowsxp = new Windows("Windows XP",(float)2.0,"Desktop","Norton");
        System.out.println(windowsxp);
 
        Fedora fedoraOS = new Fedora("Fedora Heisenbug",21,"Desktop");
        System.out.println(fedoraOS);
 
        Windows windows = new Windows("Windows Seven",(float)1.0,"Desktop","Avast");
        System.out.println(windows);
 
        Android androidOS = new Android("Android ICS",(float)2.3,"Movil",6732);
        System.out.println(androidOS);
 
        computer1.installOS(windowsxp);
        computer1.installOS(fedoraOS);
        computer1.installOS(windows);
        computer1.viewOS();
 
        cellPhone1.installOS(androidOS);
        cellPhone1.viewOS();
 
        fedoraOS.addUser(new Admin("dano","15040102"));
        fedoraOS.addUser(new Guest("xavier"));
        fedoraOS.addUser(new Guest("john"));
 
        fedoraOS.viewUsers();
 
        androidOS.installApp(new Application("Whats App!",(float)23.0));
        androidOS.installApp(new Application("Twitter",(float)12.5));
        androidOS.installApp(new Application("Evernote",(float)17.8));
        androidOS.installApp(new Application("Netflix",(float)28.5));
 
        androidOS.viewApps();
 
    }
}
