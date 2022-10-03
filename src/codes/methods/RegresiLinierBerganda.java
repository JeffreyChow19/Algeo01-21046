package codes.methods;

import codes.ADT.constructors.createMtrx;
import codes.ADT.constructors.printMtrx;
import codes.ADT.constructors.printMtrxConsole;
import codes.ADT.primitives.CheckNeg0;
import codes.inputs.inputSPL;

import java.util.Scanner;

import codes.ADT.Matrix;

public class RegresiLinierBerganda {
    public static void main() {
        Matrix m = createMtrx.main(false);

        Matrix ans = new Matrix(m.cols, m.cols+1);

        for(int a = 0; a < ans.rows; a++){
            for (int b = 0; b < ans.cols; b++){
                ans.Mtrx[a][b] = 0;

                for (int i = 0; i < m.rows; i++){
                    
                    if (a==0){
                        if (b==0){
                            ans.Mtrx[a][b]++;
                        } else if (b == ans.cols-1) {
                            ans.Mtrx[a][b] += m.Mtrx[i][m.cols-1];
                        } else {
                            ans.Mtrx[a][b] += m.Mtrx[i][b-1];
                        }

                    } else {

                        if (b == ans.cols - 1) {
                            ans.Mtrx[a][b] += m.Mtrx[i][a-1] * m.Mtrx[i][m.cols-1];
                        } else if (b == 0) {
                            ans.Mtrx[a][b] += m.Mtrx[i][a-1];
                        } else {
                            ans.Mtrx[a][b] += m.Mtrx[i][a-1] * m.Mtrx[i][b-1];
                        }

                    }

                }

            }
            
        }

        printMtrxConsole.printMatrix(ans);
        
        ans = Gauss.gauss(ans);
        double[] result = inputSPL.uniqueCase(ans);
        result = CheckNeg0.check(result);
        String args = "no_args";
        printMtrx.mainV2(result, 0.0, 0.0, args);

        Scanner scanner = new Scanner(System.in);
        double fx = result[0];
        System.out.println();
        for (int i=1; i < result.length; i++){
            System.out.printf("Masukkan X%d : ", i);
            fx += (scanner.nextDouble() * result[i]);
            scanner.nextLine();
        }
        
        System.out.printf("Taksiran/Estimasi nilai : %.4f\n", fx);
        
    }
}
