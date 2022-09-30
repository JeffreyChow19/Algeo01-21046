package codes.inputs;

import java.util.Scanner;
import codes.ADT.constructors.*;
import codes.ADT.primitives.MakeSquare;
import codes.methods.Cramer;
import codes.methods.Gauss;
import codes.methods.GaussJordan;
import codes.ADT.primitives.*;
import codes.methods.InverseCofactor;
import codes.methods.submethods.SPLCheck;
import codes.methods.submethods.menuCheck;
import codes.ADT.Matrix;
import codes.ADT.Param;

public class inputSPL extends printMtrxConsole {
    public static Scanner scanner = new Scanner(System.in);

    public static void main() {
        int choice = chooseMethods();

        Matrix matrix = createMtrx.main(false);

        processMethods(choice, matrix);
    }

    public static int chooseMethods() {
        // Scanner scanner = new Scanner(System.in);

        String[] methods = {
                "Metode eliminasi Gauss",
                "Metode eliminasi Gauss-Jordan",
                "Metode matriks balikan",
                "Kaidah Cramer",
                "Return to Menu"
        };

        System.out.println("\nMethods");
        System.out.println("=======\n");

        int choice = menuCheck.main(1, 5, methods);

        return choice;
    }

    public static void processMethods(int choice, Matrix matrix) {
        switch (choice) {
            case 1:
                Matrix ansGauss = Gauss.gauss(matrix);
                printGauss(ansGauss);
                break;
            case 2:
                Matrix ansJordan = GaussJordan.jordan(matrix);
                printGauss(ansJordan);
                break;
            case 3:
                double[] ansInv = processInv(matrix);
                printCramer(ansInv);
                break;
            case 4:
                double[] ansCramer = Cramer.cramer(matrix);
                printCramer(ansCramer);
                break;
            case 5:
                break;
            default:
                break;
        }
    }

    public static void printGauss(Matrix m) {
        int status = SPLCheck.main(m);

        print("\n");
        if (status == 0) {
            /* Solusi Unik */

            println("SPL memiliki solusi unik");

            double[] unik = uniqueCase(m);
        
            // printMtrx.main(m);
            printMtrx.main(unik);
            
        } else if (status == 1) {
            /* Solusi Banyak */
            System.out.println("SPL memiliki banyak solusi");
            Param[] ans = infiniteCase(m);
            printMtrx.main(ans);


        } else {
            /* Tidak ada solusi */
            println("Tidak ada nilai x yang memenuhi persamaan SPL.");
        }
    }

    public static double[] uniqueCase(Matrix m) {

        double[] unik = new double[m.rows];

        for (int i = m.rows - 1; i >= 0; i--) {
            unik[i] = m.Mtrx[i][m.cols - 1];

            for (int j = i + 1; j <= m.cols - 2; j++) {
                unik[i] -= unik[j] * m.Mtrx[i][j];
            }

            unik[i] /= m.Mtrx[i][i];
        }
        double[] result = new double[unik.length];
        result = CheckNeg0.check(unik);
        return result;
    }

    public static Param[] infiniteCase(Matrix m) {
    
        // check which one need to use param
        boolean[] occupied = new boolean[m.cols];
        boolean[] useParam = new boolean[m.cols];

        // initialize with false
        for (int i=0; i < occupied.length; i++){
            occupied[i] = false;
            useParam[i] = false;
        }

        // checking
        for (int j=0; j < m.cols-1; j++){
            int notZero = countNotZero(m, j);
            if (notZero == 0){
                useParam[j] = true;
            } else if (occupied[notZero]){
                useParam[j] = true;
            } else {
                occupied[notZero] = true;
            }
        }

        // state variable will use
        Param[] ans = new Param[m.cols-1];

        char[] params = new char[countTrue(useParam)];

        char start = 't';

        // decide params to use
        for (int i=0; i < params.length; i++){
            params[i] = start;
            start = (char) ((int) start + 1);
        }

        int now = 0;
        int[] indexParam = new int[params.length];
        // set default for items
        for (int i = 0; i < ans.length; i++){
            double[] temp = new double[params.length];
            for (int j=0; j < params.length; j++){
                if (useParam[i] && now == j){
                    temp[j] = 1;
                    indexParam[now] = i;
                } else {
                    temp[j] = 0;
                }
            }

            if (useParam[i]){
                now++;
            }

            ans[i] = new Param(0, params, temp);
        }

        // sampai di state ini sudah diketahui mana x yang menggunakan parameter dan sudah di assign keberadaanya.
        
        for (int i = m.rows-1; i >= 0; i--){

            int j = firstNotZero(m,i);
            if (j != m.cols-1){

                if (!useParam[j]){
                    
                    ans[j].val = m.Mtrx[i][m.cols-1];

                    for (int k=j+1; k < m.cols-1; k++){

                        if (!useParam[k]){
                            ans[j].val -= (m.Mtrx[i][k] * ans[k].val);
                            for (int l = 0; l < params.length; l++){
                                ans[j].valPar[l] -= m.Mtrx[i][k] * ans[k].valPar[l];
                            }
                        } else {
                            int in = findVal(indexParam, k);
                            ans[j].valPar[in] -= m.Mtrx[i][k];
                        }

                    }

                    ans[j].val /= m.Mtrx[i][j];
                    for (int l = 0; l < params.length; l++) {
                        ans[j].valPar[l] /= m.Mtrx[i][j];
                    }

                }

            }

        }

        return ans;
    }

    public static int countNotZero(Matrix m, int cols){
        int count = 0;

        for (int i = 0; i < m.rows; i++){
            if (m.Mtrx[i][cols] != 0 && count < m.cols-1){
                count++;
            }
        }

        return count;
    }

    public static int countTrue(boolean[] ans){
        int count = 0;
        
        for (int i=0; i < ans.length; i++){
            if (ans[i]){
                count++;
            }
        }

        return count;
    }

    public static int firstNotZero (Matrix m, int rows){
        int index = 0;
        
        while (index < m.cols-1 && m.Mtrx[rows][index] == 0){
            index++;
        }

        return index;
    }

    public static int findVal (int[] indexParam, int find){
        int i = 0;
        while (i < indexParam.length && indexParam[i] != find ){
            i++;
        }
        return i;
    }

    public static void printCramer(double[] ans) {
        printMtrx.main(ans);
    }

    public static double[] processInv (Matrix m){
        Matrix squared = MakeSquare.makeSquare(m);
        Matrix inversed = InverseCofactor.inverse(squared);

        double[] ans = new double[m.rows];

        for (int i=0; i < inversed.rows; i++){
            ans[i] = 0;
            for (int j=0; j < inversed.cols; j++){
                ans[i] += (inversed.Mtrx[i][j] * m.Mtrx[j][m.cols-1]);
            }
        }

        return ans;
    }

    public static int count0(Matrix m, int cols) {
        int count = 0;
        for (int i = 0; i < m.rows; i++) {
            if (Double.isNaN(1.0 / m.Mtrx[i][cols]) || Double.isInfinite(1.0 / m.Mtrx[i][cols])) {
                count++;
            }
        }
        return count;
    }
}
