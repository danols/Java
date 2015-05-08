import java.util.Random;
 
public class Matrix {
 
    private int rows;
    private int columns;
    private String name;
    private Rational[][] matrix;
     
    public Matrix(String name, int size) {
        rows = size;
        columns = size;
        this.name = name;
        matrix = new Rational[rows][columns];
        for(int i=0;i<rows;i++) {
            for(int j=0;j<columns;j++) {
                matrix[i][j] = new Rational(1,1);
            }
        }
    }
 
    public Matrix(String name, int f, int c) {
        rows = f;
        columns = c;
        this.name = name;
        matrix = new Rational[rows][columns];
        for(int i=0;i<rows;i++) {
            for(int j=0;j<columns;j++) {
                matrix[i][j] = new Rational(1,1);
            }
        }
    }
 
    public Matrix(String name, int f, int c, Rational r) {
        Rational v =  new Rational(r);
        rows = f;
        columns = c;
        this.name = name;
        matrix = new Rational[rows][columns];
        for(int i=0;i<rows;i++) {
            for(int j=0;j<columns;j++) {
                matrix[i][j] = v;
            }
        }
    }
 
    public Matrix(String name, Matrix M) {
        rows = M.rows;
        columns = M.columns;
        this.name = name;
        matrix = new Rational[rows][columns];
        for(int i=0;i<rows;i++) {
            for(int j=0;j<columns;j++) {
                matrix[i][j] = M.matrix[i][j];
            }
        }
    }
 
    public Matrix(String name, int f, int c, String r) {
        int limit = 0; 
        rows = f;
        columns = c;
        this.name = name;
        matrix = new Rational[rows][columns];
        r.replace(" ","");
        if(r.length() == 5) limit = 1000;
        if(r.length() == 4) limit = 100;
        if(r.length() == 3) limit = 10;
        Random num_random = new Random();
        for(int i=0;i<rows;i++) {
            for(int j=0;j<columns;j++) {
                matrix[i][j] = new Rational(num_random.nextInt(limit + 1),num_random.nextInt(limit + 1)); 
            }
        }
    }
 
    public void set(int f, int c, Rational r) {
        if((f > 0 && f <= this.rows) && (c > 0 && c <= this.columns))
            this.matrix[f-1][c-1] = r;
    }
 
    public void sum(Matrix M) {
        if(this.rows == M.rows && this.columns == M.columns) {
            for(int i=0;i<this.rows;i++) {
                for(int j=0;j<this.columns;j++) {
                    (this.matrix[i][j]).add(M.matrix[i][j]);
                }
            }
        }
    }
 
    public void substraction(Matrix M) {
        if(this.rows == M.rows && this.columns == M.columns) {
            for(int i=0;i<this.rows;i++) {
                for(int j=0;j<this.columns;j++) {
                    (this.matrix[i][j]).deduct(M.matrix[i][j]);
                }
            }
        }
    }
 
    public Matrix multiplication(Matrix M) {
        Matrix R = new Matrix("Results",this.rows,M.columns);
        Rational one =  new Rational(1,1);
        Rational result_multiply =  new Rational(1,1);
        if(this.columns == M.rows) {
            for(int i=0;i<this.rows;i++) {
                for(int j=0;j<M.columns;j++) {
                    (R.matrix[i][j]).deduct(one);
                    for(int k=0;k<this.columns;k++) {
                        result_multiply = result_multiply.multiply(this.matrix[i][k],M.matrix[k][j]);
                        (R.matrix[i][j]).add(result_multiply);
                    }
                }
            }
        }
        return R;
    }
 
    public void transpose() {
        int rows = this.rows;
        this.rows = this.columns;
        this.columns = rows;
        Rational[][] transpose_matrix = new Rational[this.rows][this.columns];
        for(int i=0;i<this.columns;i++) {
            for(int j=0;j<this.rows;j++) {
                transpose_matrix[j][i] = this.matrix[i][j];
            }
        }
        this.matrix = transpose_matrix;
    }
 
    public void spiral() {
        int top = 0;
        int down = this.rows - 1;
        int left = 0;
        int right = this.columns - 1;
        System.out.println("\n\t\tEspiral");
        while(true) {
            for(int j=left;j<=right;j++) { if(j==0) System.out.print("\t\t" + this.matrix[top][j] + " "); else System.out.print(this.matrix[top][j] + " ");}
            top++;
            if(top > down || left > right) break;
            for(int i=top;i<=down;i++) System.out.print(this.matrix[i][right] + " ");
            right--;
            if(top > down || left > right) break;
            for(int j=right;j>=left;j--) System.out.print(this.matrix[down][j] + " ");
            down--;
            if(top > down || left > right) break;
            for(int i=down;i>=top;i--) System.out.print(this.matrix[i][left] + " ");
            left++;
            if(top > down || left > right) break;
        }
        System.out.println("\n");
    }
 
    public void calculation() {
        System.out.println("\n\t\tPromedio: " + (average(this)));
        System.out.println("\t\tMaximo: " + max(this));
        System.out.println("\t\tMinimo: " + min(this));
        //mode(this);
    }
 
    private Rational min(Matrix M) {
        Rational min = M.matrix[0][0];
        for(int i=0;i<M.rows;i++) {
            for(int j=0;j<M.columns;j++) {
                if((M.matrix[i][j]).min(min)) min = M.matrix[i][j];
            }
        }
        return min;
    }
 
    private Rational max(Matrix M) {
        Rational max = M.matrix[0][0];
        for(int i=0;i<M.rows;i++) {
            for(int j=0;j<M.columns;j++) {
                if((M.matrix[i][j]).max(max)) max = M.matrix[i][j];
            }
        }
        return max;
    }
 
    private Rational average (Matrix M) {
        Rational sum  = new Rational(1,1);
        Rational one = new Rational(1,1);
        for(int i=0;i<M.rows;i++) {
            for(int j=0;j<M.columns;j++) {
                sum.add(M.matrix[i][j]);
            }
        }
        sum.deduct(one);
        Rational t = new Rational(this.rows * this.columns,1);
        sum.divide(t);
        return sum;
    }
 
    private void mode(Matrix M) {
         
    }
 
    public boolean equals(Object O) {
        boolean flag = true;
        if(O instanceof Matrix) {
            Matrix M = (Matrix)O;
            if(this.rows != M.rows || this.columns != M.columns) return false;
            else {
                for(int i=0;i<this.rows;i++) {
                    for(int j=0;j<this.columns;j++) {
                        if(!((this.matrix[i][j] ).equals(M.matrix[i][j]))) {
                            flag = false;
                            break;
                        }
                    }
                }
                return flag;
            }
        }
        return false;
    }
 
    public void print() {
        if((this.name) != null) System.out.println("\t Matriz: " + this.name);
        for(int i=0;i<this.rows;i++) {
            System.out.print("\t\t");
            for(int j=0;j<this.columns;j++) {
                System.out.print(this.matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
 
}
