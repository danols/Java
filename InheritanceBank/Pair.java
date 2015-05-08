public class Pair {
 
    private int id;
    private double value;
 
    public Pair(int id, double value) {
        this.id = id;
        this.value = value;
    }
     
    public String toString() {
        if(id == 1) return "\n\t\t\tSe hizo un depósito de " + Double.toString(value);
        return "\n\t\t\tSe hizo un retiro de " + Double.toString(value);
    }
}
