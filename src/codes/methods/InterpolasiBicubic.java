package codes.methods;

import codes.ADT.*;
import codes.ADT.constructors.*;;

public class InterpolasiBicubic {
    public static double bikubik(Matrix matrix, double indeks1, double indeks2){
        int rows = ((matrix.rows)-1)*((matrix.cols));
        int cols = rows;
        Matrix matrix_xy = new Matrix(rows, cols);
        int r=0, c=0;
        // int k = -1;
        for(int k=0; k<(matrix.rows)-1; k++){
            for(int l= 0; l<(matrix.cols); l++){
                for(int i= 0; i<=3; i++){
                    for(int j= 0; j<=3; j++){
                        int x= k-1;
                        int y = l-1;
                        matrix_xy.Mtrx[r][c] = (double)(((int)Math.pow(x, i)) * ((int)Math.pow(y, j)));
                        c++;
                    }
                }
                r++;
                c = 0;
            }
        }
        double [] matrix_y = new double[rows];
        int row_y = 0;
        for(int i=0; i< matrix.rows-1; i++){
            for(int j= 0; j<matrix.cols; j++){
                matrix_y [row_y] = matrix.Mtrx[i][j];
                row_y++;
            }   
        }
        Matrix matrix_gauss = new Matrix(rows, cols+1);
        for(int i =0; i< rows; i++){
            for(int j=0; j< cols; j++){
                matrix_gauss.Mtrx[i][j] = matrix_xy.Mtrx[i][j];
            }
        }
        for(int i=0; i<rows; i++){
            matrix_gauss.Mtrx[i][cols] = matrix_y[i];
        }
        // printMtrxConsole.printMatrix(matrix_gauss);
        Matrix after_reduction = new Matrix(rows, cols+1);
        // after_reduction = Gauss.gauss(matrix_gauss);
        after_reduction = GaussJordan.jordan(matrix_gauss);  
        // printMtrxConsole.printMatrix(after_reduction);

        int k= 0;
        Matrix matrix_a = new Matrix(matrix.rows-1, matrix.cols);
        for(int i=0; i<matrix.rows-1; i++){
            for(int j=0; j<matrix.cols; j++){
                matrix_a.Mtrx[i][j] = after_reduction.Mtrx[k][cols];
                k++;
            }
        }

        double result=0;
        for(int i=0; i<=3; i++){
            for(int j=0; j<=3; j++){
                result += (matrix_a.Mtrx[i][j]*(double)(Math.pow(indeks1, i))*(double)(Math.pow(indeks2, j)));
            }
        }
        return result;
    }
}

