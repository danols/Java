import java.util.Random;
import java.util.*;
import java.text.DecimalFormat;
 
public class Matrix {
     
    private int rows;
    private int columns;
    private String name;
    private int[][] matrix;
 
    public Matrix(String name, int size) {
        rows = size;
        columns = size;
        this.name = name;
        matrix = new int[rows][columns];
        for(int i=0;i<rows;i++) {
            for(int j=0;j<columns;j++) {
                matrix[i][j] = 1;
            }
        }
    }
 
    public Matrix(String name, int f, int c) {
        rows = f;
        columns = c;
        this.name = name;
        matrix = new int[rows][columns];
        for(int i=0;i<rows;i++) {
            for(int j=0;j<columns;j++) {
                matrix[i][j] = 1;
            }
        }
    }
 
    public Matrix(String name, int f, int c, int d) {
        rows = f;
        columns = c;
        this.name = name;
        matrix = new int[rows][columns];
        for(int i=0;i<rows;i++) {
            for(int j=0;j<columns;j++) {
                matrix[i][j] = d;
            }
        }
    }
 
    public Matrix(String name, Matrix M) {
        rows = M.rows;
        columns = M.columns;
        this.name = name;
        matrix = new int[rows][columns];
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
        matrix = new int[rows][columns];
        if(r.length() == 5) limit = 1000;
        if(r.length() == 4) limit = 100;
        if(r.length() == 3) limit = 10;
        Random num_random = new Random();
        for(int i=0;i<rows;i++) {
            for(int j=0;j<columns;j++) {
                matrix[i][j] = num_random.nextInt(limit + 1);
            }
        }
    }
 
    public void print() {
        if((this.name) != null) System.out.println("\t Matriz: " + this.name);
        for(int i=0;i<this.rows;i++) {
            System.out.print("\t\t");
            for(int j=0;j<this.columns;j++) {
                System.out.print(this.matrix[i][j]);
                if(this.matrix[i][j] >= 0 && this.matrix[i][j] < 10) System.out.print("   ");
                if(this.matrix[i][j] >= 10 && this.matrix[i][j] < 100) System.out.print("  ");
                if(this.matrix[i][j] >= 100) System.out.print(" ");
            }
            System.out.println();
        }
    }
 
    public void set(int f, int c, int v) {
        if((f > 0 && f <= this.rows) && (c > 0 && c <= this.columns))
            this.matrix[f-1][c-1] = v;
    }
 
    public void sum(Matrix M) {
        if(this.rows == M.rows && this.columns == M.columns) {
            for(int i=0;i<this.rows;i++) {
                for(int j=0;j<this.columns;j++) {
                    this.matrix[i][j] += M.matrix[i][j];
                }
            }
        }
    }
 
    public void sum(Matrix M, Matrix N) {
        if(M.rows == N.rows && M.columns == N.columns) {
            for(int i=0;i<this.rows;i++) {
                for(int j=0;j<this.columns;j++) {
                    this.matrix[i][j] = M.matrix[i][j] + N.matrix[i][j];
                }
            }
        }
    }
 
    public Matrix sum2(Matrix M) {
        if(this.rows == M.rows && this.columns == M.columns) {
            for(int i=0;i<this.rows;i++) {
                for(int j=0;j<this.columns;j++) {
                    this.matrix[i][j] += M.matrix[i][j];
                }
            }
        }
        return this;
    }
 
    public void substraction(Matrix M) {
        if(this.rows == M.rows && this.columns == M.columns) {
            for(int i=0;i<this.rows;i++) {
                for(int j=0;j<this.columns;j++) {
                    this.matrix[i][j] -= M.matrix[i][j];
                }
            }
        }
    }
 
    public void transpose() {
        int rows = this.rows;
        this.rows = this.columns;
        this.columns = rows;
        int[][] transpose_matrix = new int[this.rows][this.columns];
        for(int i=0;i<this.columns;i++) {
            for(int j=0;j<this.rows;j++) {
                transpose_matrix[j][i] = this.matrix[i][j];
            }
        }
        this.matrix = transpose_matrix;
    }
 
    public Matrix multiplication(Matrix M) {
        Matrix R = new Matrix("Results",this.rows,M.columns,0);
        if(this.columns == M.rows) {
            for(int i=0;i<this.rows;i++) {
                for(int j=0;j<M.columns;j++) {
                    for(int k=0;k<this.columns;k++) {
                        R.matrix[i][j] += (this.matrix[i][k] * M.matrix[k][j]);
                    }
                }
            }
        }
        return R;
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
 
    public boolean equals(Object O) {
        boolean flag = true;
        if(O instanceof Matrix) {
            Matrix M = (Matrix)O;
            if(this.rows != M.rows || this.columns != M.columns) return false;
            else {
                for(int i=0;i<this.rows;i++) {
                    for(int j=0;j<this.columns;j++) {
                        if(this.matrix[i][j] != M.matrix[i][j]) {
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
 
    public void calculation() {
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println("\n\t\tPromedio: " + df.format(average(this)));
        System.out.println("\t\tMaximo: " + max(this));
        System.out.println("\t\tMinimo: " + min(this));
        mode(this);
    }
    private void mode(Matrix M) {
        int max_value = max(M);
        int index = 0;
        int[] repetitions = new int[max_value + 1];
        for(int i=0;i<M.rows;i++) {
            for(int j=0;j<M.columns;j++) {
                repetitions[M.matrix[i][j]]++;
            }
        }
        int mode = repetitions[0];
        for(int id=1;id<=max_value;id++) {
            if(repetitions[id] > mode) {
                mode = repetitions[id];
                index = id;
            }
        }
        if(mode == 1) {
            System.out.print("\n\t\tModas:"); 
            for(int i=0;i<M.rows;i++) {
                for(int j=0;j<M.columns;j++) {
                    System.out.print(" " + M.matrix[i][j]);
                }
            }
            System.out.println();
        }
        else System.out.println("\n\t\tModa: " + index);
    }
 
    private int min(Matrix M) {
        int min = M.matrix[0][0];
        for(int i=0;i<M.rows;i++) {
            for(int j=0;j<M.columns;j++) {
                if(M.matrix[i][j] <= min) min = M.matrix[i][j];
            }
        }
        return min;
    }
    private int max(Matrix M) {
        int max = M.matrix[0][0];
        for(int i=0;i<M.rows;i++) {
            for(int j=0;j<M.columns;j++) {
                if(M.matrix[i][j] >= max) max = M.matrix[i][j];
            }
        }
        return max;
    }
    private float average (Matrix M) {
        int sum = 0;
        for(int i=0;i<M.rows;i++) {
            for(int j=0;j<M.columns;j++) {
                sum += M.matrix[i][j];
            }
        }
        return (float)sum / (float)(this.rows * this.columns);
    }
     
}
