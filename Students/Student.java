import java.util.Calendar;
import java.util.GregorianCalendar;
 
public class Student {
 
    private String name;
    private String group;
    private Date dateBirth;
    private Date age;
    private Subject[] subjects;
    private int numSubjects;
    private int index;
 
    public Student(String name, String group,int numSubjects, Date dateBirth) {
        this.name = name;
        this.numSubjects = numSubjects;
        this.group = group;
        subjects = new Subject[numSubjects];
        this.dateBirth = new Date(dateBirth);
        index = 0;
    }
 
    public Date calculateAge() {
        int curretYear = (Date.currentDate).get(Calendar.YEAR);
        int currentMonth = (Date.currentDate).get(Calendar.MONTH) + 1;
        int curretDay = (Date.currentDate).get(Calendar.DATE);
        age = new Date();
        if(dateBirth.getMonth() == currentMonth && dateBirth.getDay() == curretDay) {
            age.setDay(0);
            age.setMonth(0);
            age.setYear(curretYear - dateBirth.getYear());
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
 
    public void assignSubject(Subject subject) {
        subjects[index] = new Subject(subject);
        index++;
    }
 
    public Date getDateBirth() {
        return dateBirth;
    }
 
    public String toString() {
        if(age ==  null) calculateAge();
        return "\t\tNombre: " + name + "\n\t\tGrupo: " + group + "\n\t\tFecha de Nacimiento: " + dateBirth.toString(true) + "\n\t\tEdad: " + age.toString(false);
    }
 
}
