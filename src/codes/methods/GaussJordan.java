package codes.methods;

import codes.ADT.Matrix;
import codes.ADT.constructors.printMtrxConsole;

public class GaussJordan {
    public static Matrix jordan (Matrix m){
        Matrix temp = Gauss.gauss(m);
        // Matrix reverse_m_rows;
        for(int i = m.rows-1; i>=0; i--){
            int above_row = i-1;
            for(int j= above_row; j>=0; j--){
                double factor=0;
                int c = 0;
                boolean isEmptyRow = false;
                if(temp.Mtrx[i][c]==0){
                    boolean condition = false;
                    while (!condition){
                        if(c< m.cols-1 && Double.isInfinite(1/temp.Mtrx[i][c])){
                            c++;
                        }else if(c< m.cols-1 && !Double.isInfinite(1/temp.Mtrx[i][c])){
                            factor = temp.Mtrx[j][c]/temp.Mtrx[i][c];
                            condition = true;
                            System.out.printf("%d\n", c);
                            System.out.printf("%.2f\n", temp.Mtrx[j][c]);
                            System.out.printf("%.2f\n", temp.Mtrx[i][c]);
                            System.out.printf("%.2f\n", factor);
                        }else{
                            above_row -=1;
                            isEmptyRow = true;
                            condition= true;
                        }
                    }
                }
                else{
                    factor = temp.Mtrx[j][c]/temp.Mtrx[i][c];
                    System.out.printf("%d\n", c);
                    System.out.printf("%.2f\n", temp.Mtrx[j][c]);
                    System.out.printf("%.2f\n", temp.Mtrx[i][c]);
                    System.out.printf("%.2f\n", factor);
                }
                if(!isEmptyRow){
                    for(int k= m.cols-1; k>=0; k--){
                        temp.Mtrx[j][k] -= (temp.Mtrx[i][k]*factor);
                    }
                }
                printMtrxConsole.printMatrix(temp);
                System.out.println();
            }
        }
        return temp;    
    }
}
