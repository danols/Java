public class Windows extends MicrosoftWindows {
 
    public Windows(String name, float version, String platform, String nameAntivirus) {
        super(name,version,platform,nameAntivirus);
    }
 
    public void playGame(String nameGame) {
        System.out.println("\n\t\tSe está jugando " + nameGame + " desde el sistema " + name);
    }
 
}
