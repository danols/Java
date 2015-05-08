import java.util.Calendar;
import java.util.GregorianCalendar;
 
public class Student implements Comparable <Student> {
 
    private String name;
    private String group;
    private Date dateBirth;
    private Date age;
    private Subject[] subjects;
    private int numSubjects;
    private int index;
    private long id;
 
    public Student(long id) { this.id = id; }
 
    public Student(String name,long id, String group,int numSubjects, Date dateBirth) {
        this.name = name;
        this.numSubjects = numSubjects;
        this.group = group;
        this.id = id;
        subjects = new Subject[numSubjects];
        this.dateBirth = new Date(dateBirth);
        index = 0;
    }
 
    public Student(Student student) {
        this.name = student.name;
        this.numSubjects = student.numSubjects;
        this.group = student.group;
        this.id = student.id;
        this.dateBirth = new Date(student.dateBirth);
    }
 
    public void set(String name,long id, String group,int numSubjects, Date dateBirth) {
        this.name = name;
        this.numSubjects = numSubjects;
        this.group = group;
        this.id = id;
        subjects = new Subject[numSubjects];
        this.dateBirth = new Date(dateBirth);
        index = 0;
    }
 
    public Date calculateAge() {
        int curretYear = (Date.currentDate).get(Calendar.YEAR);
        int currentMonth = (Date.currentDate).get(Calendar.MONTH) + 1;
        int curretDay = (Date.currentDate).get(Calendar.DATE);
        age = new Date();
        if(dateBirth.getMonth() == currentMonth) {
            if(dateBirth.getDay() == curretDay) {
                age.setDay(0);
                age.setMonth(0);
                age.setYear(curretYear - dateBirth.getYear());
            }
            if(dateBirth.getDay() < curretDay) {
                age.setDay(curretDay - dateBirth.getDay());
                age.setMonth(0);
                age.setYear((curretYear - dateBirth.getYear()));
            }
            if(dateBirth.getDay() > curretDay) {
                int aux = 0;
                if(dateBirth.getMonth() == 1) aux = 12;
                else aux = (dateBirth.getMonth() - 1);
                age.setDay((Date.daysOfMonth(aux) - dateBirth.getDay() + curretDay));
                age.setMonth(12 - (dateBirth.getMonth() - currentMonth));
                if(dateBirth.getMonth() == currentMonth) age.setMonth(age.getMonth() - 1);
                age.setYear((curretYear - dateBirth.getYear() - 1));
            }
        }
        if(dateBirth.getMonth() > currentMonth) {
            age.setYear(curretYear - dateBirth.getYear() - 1);
            age.setMonth(12 - (dateBirth.getMonth() - currentMonth));
            if(dateBirth.getDay() > curretDay)  {
                age.setMonth((age.getMonth() - 1));
                int numMonth = ((dateBirth.getMonth() + age.getMonth()) % 12);
                age.setDay( (Date.daysOfMonth(numMonth) - dateBirth.getDay() + curretDay) );
            }
            if(dateBirth.getDay() < curretDay) age.setDay((curretDay - dateBirth.getDay()));
            if(dateBirth.getDay() == curretDay) age.setDay(0);
        }
        if(dateBirth.getMonth() < currentMonth) {
            age.setYear(curretYear - dateBirth.getYear());
            age.setMonth((currentMonth - dateBirth.getMonth()));
            if(dateBirth.getDay() == curretDay) age.setDay(0);
            if(dateBirth.getDay() < curretDay) age.setDay((curretDay - dateBirth.getDay()));
            if(dateBirth.getDay() > curretDay) {
                age.setMonth(0);
                age.setDay((Date.daysOfMonth(dateBirth.getMonth()) - dateBirth.getDay() + curretDay));
            }
        }
        return age;
    } 
 
    public void listSubjects() {
        for(int i=0;i<index;i++) {
            System.out.println(subjects[i]);
        }
    }
 
    public String getSubjects() {
        String subjectsInfo = "\n";
        for(int i=0;i<index;i++) {
            subjectsInfo += (subjects[i].toString());
        }
        return subjectsInfo;
    }
 
    public void assignSubject(Subject subject) {
        subjects[index] = new Subject(subject);
        index++;
    }
 
    public void assignSubject(String name, double qualification, int level) {
        subjects[index] = new Subject(name,qualification,level);
        index++;
    }
 
    public Date getDateBirth() {
        return dateBirth;
    }
 
    public int getNumSubjects() { return numSubjects; }
 
    //public int compareTo(Student S) { return (this.name).compareTo(S.name); }
 
    public int compareTo(Student S) {
        if(this.id > S.id) return 1;
        if(this.id < S.id) return -1;
        return 0;
    }
    public String toString() {
        if(age ==  null) calculateAge();
        return " Nombre: " + name + " " + 
        "\n Matricula: " + Long.toString(id) + " " +
        "\n Grupo: " + group + " " +
        "\n Fecha de Nacimiento: " + dateBirth.toString(true) + " " +
        "\n Edad: " + age.toString(false) + " ";
    }
     
}
