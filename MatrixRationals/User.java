import java.util.Scanner;
public class User {
    public static void main(String[] args) {
        Rational r1 = new Rational(2,3);
        Rational r2 = new Rational(1,1);
        Rational r = new Rational(1,1);
        Matrix m1 = new Matrix("M1",3,4);
        m1.print();
        Matrix mn = new Matrix("MN",3,4);
        mn.print();
        Matrix m2 = new Matrix("M2",3,4,r1);
        m2.print();
        Matrix m3 = new Matrix("M3",3,3,"R10");
        m3.print();
        m1.set(1,1,r1);
        m1.print();
        m2.print();
        m1.sum(m2);
        m1.print();
        m1.substraction(m2);
        m1.print();
        Matrix m4 = new Matrix("M4",3,3,"R10");
        m4.print();
        Matrix result = new Matrix("Result",3,3);
        result = m3.multiplication(m4);
        result.print();
        m3.transpose();
        m3.print();
        m3.spiral();
        m3.calculation();
    }
}
