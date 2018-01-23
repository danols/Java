public class app {
    public static void main(String[] args) {
 
        Student student1 = new Student("Daniel López","1CM11",4,new Date(2,6,1995)); 
 
        student1.assignSubject(new Subject("Física",9,1));
        student1.assignSubject(new Subject("Cálculo",7,1));
        student1.assignSubject(new Subject("POO",10,2));
        student1.assignSubject(new Subject("Microcontroladores",8,4));
 
        System.out.println(student1);
        student1.listSubjects();
    }
}
//hello two
