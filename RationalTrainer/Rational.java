import java.util.*;
import java.util.Random;
 
public class Rational {
 
    private int numerator;
    private int denominator;
    private float value;
    private String name;
 
    public Rational(String name, int n, int d) {
        if(n == 0 ) numerator = 1;
        else numerator = n;
        if(d == 0 ) denominator = 1;
        else denominator = d;
        this.name =  name;
        simplify(this);
    }
 
    public Rational(int n, int d) {
        if(n == 0 ) numerator = 1;
        else numerator = n;
        if(d == 0 ) denominator = 1;
        else denominator = d;
        simplify(this);
    }
 
    public Rational(Rational R) {
        name = R.name;
        numerator = R.numerator;
        denominator = R.denominator;
    }
 
    public void set(int n, int d) {
        numerator = n;
        denominator = d;
    }
 
    public void setRandom() {
        Random n = new Random();
        Random d = new Random();
        numerator = n.nextInt(100 + 1);
        denominator = d.nextInt(100 + 1);
    }
 
    public Rational multiply(Rational R1, Rational R2) {
        numerator = R1.numerator * R2.numerator;
        denominator = R1.denominator * R2.denominator;
        return simplify(this);
    }
 
    public void multiply(Rational R1) {
        numerator = this.numerator * R1.numerator;
        denominator = this.denominator * R1.denominator;
        simplify(this);
    }
 
    public Rational divide(Rational R1, Rational R2) {
        numerator = R1.numerator * R2.denominator;
        denominator = R1.denominator * R2.numerator;
        return simplify(this);
    }
 
    public void divide(Rational R1) {
        numerator = this.numerator * R1.denominator;
        denominator = this.denominator * R1.numerator;
        simplify(this);
    }
 
    public Rational add(Rational R1, Rational R2) {
        if(R1.denominator == R2.denominator) {
            this.numerator = R1.numerator + R2.numerator;
            this.denominator = R1.denominator;
        } else {
            this.numerator = (R1.numerator * R2.denominator) + (R1.denominator * R2.numerator);
            this.denominator = R1.denominator * R2.denominator;
        }
        return simplify(this);
    }
 
    public void add(Rational R1) {
        if(R1.denominator == this.denominator) {
            numerator = R1.numerator + numerator;
            denominator = R1.denominator;
        } else {
            numerator = (R1.numerator * denominator) + (R1.denominator * numerator);
            denominator = R1.denominator * denominator;
        }
        simplify(this);
    }
 
    public Rational deduct(Rational R1, Rational R2) {
        if(R1.denominator == R2.denominator) {
            numerator = R1.numerator - R2.numerator;
            denominator = R1.denominator;
        } else {
            numerator = (R1.numerator * R2.denominator) - (R1.denominator * R2.numerator);
            denominator = R1.denominator * R2.denominator;
        }
        return simplify(this);
    }
 
    public void deduct(Rational R1) {
        if(this.denominator == R1.denominator) {
            numerator = this.numerator - R1.numerator;
            denominator = R1.denominator;
        } else {
            numerator = (this.numerator * R1.denominator) - (this.denominator * R1.numerator);
            denominator = this.denominator * R1.denominator;
        }
        simplify(this);
    }
 
    private Rational simplify(Rational R) {
        int mcd = MCD(Math.abs(R.numerator),Math.abs(R.denominator));
        numerator = R.numerator / mcd;
        denominator = R.denominator / mcd;
        return(this);
    }
 
    private int MCD(int a, int b) {
        while(a != 0 && b != 0) {
            if(a > b) a = a % b;
            else b = b % a;
        } 
        if(a != 0) return a;
        return b;
    }
 
    public boolean max(Rational R) {
        if((numerator * R.denominator) > (denominator * R.numerator)) return true;
        return false;
    }
 
    public boolean min(Rational R) {
        if((numerator * R.denominator) < (denominator * R.numerator)) return true;
        return false;
    }
 
    public boolean equals(Object O) {
        if(O instanceof Rational) {
            Rational aux = (Rational)O;
            if(numerator * aux.denominator == denominator * aux.numerator) return true;
            else return false;
        }
        return false;
    }
 
    public int getNum() {
        return numerator;
    }
 
    public int getDen() {
        return denominator;
    }
 
    public String toString() {
        String n = Integer.toString(numerator);
        String d = Integer.toString(denominator);
        String r = n + " / " + d;
        int size = r.length();
        if(size == 3) return r + "      ";
        if(size == 4) return r + "     ";
        if(size == 5) return r + "    ";
        if(size == 6) return r + "   ";
        if(size == 7) return r + "  ";
        if(size == 8) return r + " ";
        else return r;
    }
 
}
