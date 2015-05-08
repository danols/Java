import java.util.Scanner;
import java.text.DecimalFormat;
public class UseMatrix {
    static Scanner input = new Scanner(System.in);
    public static void main(String [] args) {
        //Construct 1
        Matrix M1 = new Matrix("M1",3);
        M1.print();
        //Construct 2
        Matrix M2 = new Matrix("M2",3); 
        M2.print();
        //Construct 3
        Matrix M3 = new Matrix("M3",3,2,"R10");
        M3.print();
        //Construct 4
        Matrix M4 = new Matrix("M4",3,2,"R100");
        M4.print();
        //Construct 5
        Matrix M5 = new Matrix("M5",M1);
        M5.print();
        //Set   
        M3.set(1,1,12);
        M3.print();
        //Sum 1
        M3.sum(M3,M4);
        M3.print();
        //Sum 2
        M1.sum(M2);
        M1.print();
        //Sum 3
        M2.sum(M3.sum2(M4));
        M3.print();
        M2.print();
        //Substraction
        M2.substraction(M1);
        M2.print();
        //Construct 6
        Matrix M6 = new Matrix("M6",4,3,"R1000");
        M6.print();
        //Construct 7
        Matrix M7 = new Matrix("M7",3,4,"R100");
        M7.print();
        //R
        Matrix R = new Matrix("R",4);
        R = M6.multiplication(M7);
        R.print();
        //transpose
        M3.transpose();
        M3.print();
        //calculation
        M4.print();
        M4.calculation();
        //Spiral
        M4.spiral();
        //Equals
        if(M2.equals(M3)) System.out.println("\n\t\tLas Matrices Son Iguales\n");
        else System.out.println("\n\t\tLas Matrices NO Son Iguales\n");
    }
}
