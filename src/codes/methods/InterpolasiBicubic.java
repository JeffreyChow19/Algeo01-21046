package codes.methods;
import codes.ADT.*;
// import codes.methods.*;
// import codes.ADT.constructors.printMtrx;
import codes.ADT.constructors.printMtrxConsole;

public class InterpolasiBicubic {
    public static void bikubik(Matrix matrix){
        int rows = matrix.rows*matrix.cols;
        int cols = matrix.rows*matrix.cols;
        Matrix matrix_xy = new Matrix(rows, cols);
        int r=0, c=0;
        // int k = -1;
        for(int k=0; k<matrix.rows; k++){
            for(int l= 0; l<matrix.cols; l++){
                for(int i= 0; i<=3; i++){
                    for(int j= 0; j<=3; j++){
                        int x= k-1;
                        int y = l-1;
                        matrix_xy.Mtrx[r][c] = (double)(((int)Math.pow(x, i)) * ((int)Math.pow(y, j)));
                        c++;
                    }
                }
                r++;
                c=0;
            }
        }
        // for(int i=0; i< rows; i++){
        //     for(int j= 0; j<cols; j++){
        //         System.out.printf("%.2f ", matrix_xy.Mtrx[i][j]);
        //     }
        //     System.out.println();
        // }
        // printMtrxConsole.printMatrix(matrix_xy);
        double [] matrix_y = new double[rows];
        int row_y = 0;
        for(int i=0; i< matrix.rows; i++){
            for(int j= 0; j<matrix.cols; j++){
                matrix_y [row_y] = matrix.Mtrx[i][j];
                row_y++;
            }   
        }
        // for(int i= 0; i< rows; i++){
        //     System.out.printf("%.2f\n", matrix_y);
        // }
        // Matrix invers_matrix_xy = new Matrix(rows, cols);
        // // for(int i= 0; i< rows; i++){
        // //     for(int j =0; j<cols; j++){
        // //         invers_matrix_xy.Mtrx[i][j] = (InverseCofactor.inverse(matrix_xy)).Mtrx[i][j];
        // //     }
        // // }
        // invers_matrix_xy = InverseCofactor.inverse(matrix_xy);
        // for(int i=0; i< rows; i++){
        //     for(int j= 0; j<cols; j++){
        //         System.out.printf("%.2f ", invers_matrix_xy.Mtrx[i][j]);
        //     }
        //     System.out.println();
        // }
        // for(int i= 0; i<rows; i++){
        //     System.out.printf("%d\n", matrix_y[i]);
        // }
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
        after_reduction = GaussJordan.jordan(matrix_gauss);
        printMtrxConsole.printMatrix(after_reduction);
    }
}

