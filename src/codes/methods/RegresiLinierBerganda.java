package codes.methods;

import codes.ADT.constructors.createMtrx;
import codes.ADT.constructors.printMtrx;
import codes.ADT.primitives.CheckNeg0;
import codes.inputs.inputSPL;
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

                        if (b == ans.cols - 1) {
                            ans.Mtrx[a][b] += m.Mtrx[i][0];
                        } else if (b == 0) {
                            ans.Mtrx[a][b]++;
                        } else {
                            ans.Mtrx[a][b] += m.Mtrx[i][b];
                        }

                    } else {

                        if (b==ans.cols-1){
                            ans.Mtrx[a][b] += m.Mtrx[i][a] * m.Mtrx[i][0];
                        } else if (b==0){
                            ans.Mtrx[a][b] += m.Mtrx[i][a];
                        } else {
                            ans.Mtrx[a][b] += m.Mtrx[i][a] * m.Mtrx[i][b];
                        }

                    }

                }

                System.out.println(ans.Mtrx[a][b]);
            }
            System.out.println();
        }
        
        ans = Gauss.gauss(ans);
        double[] result = inputSPL.uniqueCase(ans);
        result = CheckNeg0.check(result);
        String args = "no_args";
        printMtrx.main(result, 0.0, 0.0, args);

        
        

        // System.out.printf("f(x) =");
        // for (int i=0; i < result.length; i++){
        //     System.out.printf(" %f b%d ", result[i], i);
        //     if (i != result.length-1){
        //         System.out.printf("+");
        //     } else {
        //         System.out.println();
        //     }
        
    }
}
