package codes.methods;
import codes.ADT.Matrix;
import codes.ADT.constructors.printMtrxConsole;
// import codes.methods.Gauss;
import codes.ADT.primitives.CheckNeg0;

public class GaussJordan {
    public static Matrix jordan (Matrix m){
        Matrix temp = Gauss.gauss(m);
        // Matrix reverse_m_rows;
        for(int i = m.rows-1; i>=0; i--){
            int above_row = i-1;
            for(int j= above_row; j>=0; j--){
                double factor=0;
                int c = i;
                boolean isEmptyRow = false;
                if(temp.Mtrx[i][c]==0){
                    boolean condition = false;
                    while (!condition){
                        if(c< m.cols-1 && temp.Mtrx[i][c]==0){
                            c++;
                        }else if(c< m.cols-1 &&temp.Mtrx[i][c]!=0){
                            factor = temp.Mtrx[j][c]/temp.Mtrx[i][c];
                            condition = true;
                        }else{
                            above_row -=1;
                            isEmptyRow = true;
                            condition= true;
                        }
                    }
                }
                else{
                    factor = temp.Mtrx[j][c]/temp.Mtrx[i][c];
                }
                if(!isEmptyRow){
                    for(int k= m.cols-1; k>=0; k--){
                        temp.Mtrx[j][k] -= (temp.Mtrx[i][k]*factor);
                        // printMtrxConsole.printMatrix(temp);
                        // System.out.println();
                    }
                }
            }
        }
        for(int i = 0; i<m.rows; i++){
            int c = i;
            double factor = 0;
            if(temp.Mtrx[i][c]!=1 && temp.Mtrx[i][c]==0){
                // double factor=0;
                if(temp.Mtrx[i][c]==0){
                    boolean condition= false;
                    while(!condition){
                        if(c< m.cols-1 && temp.Mtrx[i][c]==0){
                            c++;
                        }else if(c< m.cols-1 &&temp.Mtrx[i][c]!=0){
                            factor = temp.Mtrx[i][c];
                            condition = true;
                        }else{
                            factor= 1;
                            condition= true;
                        }
                    }
                }
            }else{
                    factor = temp.Mtrx[i][c];
                }
                for(int j =c; j<m.cols; j++){
                    temp.Mtrx[i][j] /= factor;
                    // printMtrxConsole.printMatrix(temp);
                    // System.out.println();
                }  
        }
        // for(int i =0; i<m.rows; i++){
        //     for(int j =0; j<m.cols; j++){
        //         if(temp.Mtrx[i][j]==(-0)){
        //             temp.Mtrx[i][j]= 0;
        //         }
        //     }
        // }
        Matrix gauss_j_mtrx = new Matrix(m.rows, m.cols);
        gauss_j_mtrx = CheckNeg0.check(temp);
        return gauss_j_mtrx;
    }
}
