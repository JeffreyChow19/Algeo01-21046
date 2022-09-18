package codes.ADT;

public class Matrix {
    // Konstruktor Matrix
    public double[][] Mtrx;
    public int rows = 0;
    public int cols = 0;
    public Matrix(int rows , int cols) {
        this.Mtrx = new double[rows][cols];
        this.rows = rows;
        this.cols = cols;
    }
}
