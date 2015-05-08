public class Subject {
 
    private String name;
    private double qualification;
    private int level;
 
    public Subject() {
        this.name = null;
        this.qualification = 0;
        this.level =  0;
    }
 
    public Subject(Subject subject) {
        this.name = subject.name;
        this.qualification = subject.qualification;
        this.level =  subject.level;
    }
 
    public Subject(String name, double qualification, int level) {
        this.name =  name;
        this.qualification =  qualification;
        this.level = level;
    }
 
    public void qualify(double qualification) {
        if(qualification >= 0 && qualification <= 10) {
            this.qualification = qualification;
        }
    }
 
    public void setLevel(int level) {
        this.level = level;
    }
 
    public String toString() {
        return "\n Materia: " + name + " " + 
        "\n Nivel: " + Integer.toString(level) + " " + 
        "\n Calificación: " + String.valueOf(qualification) + " " +
        "\n ********************" ;
    }
}
