package codes.methods;
import codes.ADT.*;
<<<<<<< HEAD
import codes.ADT.constructors.printMtrxConsole;

=======
// import codes.methods.*;
>>>>>>> c189a07979dcf5970d4e428acd602c7dc42690e7

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
                //         System.out.printf("%.3f ", matrix_xy.Mtrx[i][j]);
        //     }
        //     System.out.println();
        // }
        double [] matrix_y = new double[rows];
        int row_y = 0;
        for(int i=0; i< matrix.rows; i++){
            for(int j= 0; j<matrix.cols; j++){
                matrix_y [row_y] = matrix.Mtrx[i][j];
                row_y++;
            }   
        }   
        Matrix invers_matrix_xy = new Matrix(rows, cols);
<<<<<<< HEAD
        Matrix temp = new Matrix(rows, cols);
        temp = InverseCofactor.inverse(matrix_xy);
        for(int i= 0; i< rows; i++){
            for(int j =0; j<cols; j++){
                invers_matrix_xy.Mtrx[i][j] = temp.Mtrx[i][j];
=======
        // for(int i= 0; i< rows; i++){
        //     for(int j =0; j<cols; j++){
        //         invers_matrix_xy.Mtrx[i][j] = (InverseCofactor.inverse(matrix_xy)).Mtrx[i][j];
        //     }
        // }
        invers_matrix_xy = InverseCofactor.inverse(matrix_xy);
        for(int i=0; i< rows; i++){
            for(int j= 0; j<cols; j++){
                System.out.printf("%.2f ", invers_matrix_xy.Mtrx[i][j]);
>>>>>>> c189a07979dcf5970d4e428acd602c7dc42690e7
            }
        }
<<<<<<< HEAD
        printMtrxConsole.printMatrix(invers_matrix_xy);
                // invers_matrix_xy = InverseCofactor.inverse(matrix_xy);
                // for(int i=0; i< rows; i++){
                    //     for(int j= 0; j<cols; j++){
                        //         System.out.printf("%.3f ", invers_matrix_xy.Mtrx[i][j]);
                        //     }
                        //     System.out.println();
                        // }
                        // for(int i= 0; i<rows; i++){
                            //     System.out.printf("%d\n", matrix_y[i]);
                            // }
                        }
                    }
                    
                    
=======
        // for(int i= 0; i<rows; i++){
        //     System.out.printf("%d\n", matrix_y[i]);
        // }
    }
}

>>>>>>> c189a07979dcf5970d4e428acd602c7dc42690e7
