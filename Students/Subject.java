1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
18
19
20
21
22
23
24
25
26
27
28
29
30
31
32
33
34
35
36
37
38
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
        return "\n\t\tMateria: " + name + "\n\t\tNivel: " + Integer.toString(level) + "\n\t\tCalificación: " + String.valueOf(qualification);
    }
}
