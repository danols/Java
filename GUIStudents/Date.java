import java.util.Calendar;
import java.util.GregorianCalendar;
 
public class Date {
 
    private int day;
    private int month;
    private int year;
    public static Calendar currentDate = GregorianCalendar.getInstance();
 
    public Date() {
        this.day = this.month = this.year  =1;
    }
 
    public Date(Date date) {
        if(validateDate(date.day,date.month,date.year)) {
            this.day =  date.day;
            this.month = date.month;
            this.year = date.year;
        }
    }
 
    public Date(int day, int month, int year) {
        if(validateDate(day,month,year)) {
            this.day =  day;
            this.month = month;
            this.year = year;
        }
    }
 
    public void setDate(int day, int month, int year) {
        if(validateDate(day,month,year)) {
            this.day =  day;
            this.month = month;
            this.year = year;
        }
    }
 
    private boolean validateDate(int day, int month, int year) {
        if(month == 2 && day <= 29 && day > 0 && leapYear(year)) return true;
        if(month == 2 && day <= 28 && day > 0 && !leapYear(year)) return true;
        if((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) && day <= 31 && day > 0) return true;
        if((month == 4 || month == 6 || month == 9 || month == 11) && day <= 30 && day > 0) return true;
        else return false;
    }
 
    private static boolean leapYear(int year) {
        if((year%4) == 0 && ( (year%100) != 0 || (year%400) == 0 )) return true;
        return false;
    }
 
    public int getDay() {
        return this.day;
    }
 
    public int getMonth() {
        return this.month;
    }
 
    public int getYear() {
        return this.year;
    }
 
    public void setDay(int day) {
        this.day = day;
    }
 
    public void setMonth(int month) {
        this.month = month;
    }
 
    public void setYear(int year) {
        this.year = year;
    }
 
    public static int daysOfMonth(int month) {
        if(month == 1 || month == 3 || month == 5 || month ==7 || month == 8 || month == 10 || month == 12)
            return 31;
        if(month == 2) {
            if(leapYear(currentDate.get(Calendar.YEAR))) return 29;
            if(!leapYear(currentDate.get(Calendar.YEAR))) return 28;
        }
        return 30;
    }
 
    public String toString(boolean b) {
        if(!b) return year + " Años " + month + " Meses " + day + " Dias ";
        return day + " / " + month + " / " + year;
    }
 
}
