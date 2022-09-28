package codes.ADT;

public class Matrix {
    // Konstruktor Matrix
    public double[][] Mtrx;
    public int rows = 0;
    public int cols = 0;
    public int sign = 0;
    public boolean has_inversed = true;
    public double polynom_x = 0;
    public Matrix(int rows , int cols) {
        this.Mtrx = new double[rows][cols];
        this.rows = rows;
        this.cols = cols;
        this.sign = 0;
        this.has_inversed = true;
        this.polynom_x = 0;
    }

}
