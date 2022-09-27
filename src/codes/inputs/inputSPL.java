package codes.inputs;

import java.io.IOException;
import java.util.Scanner;
import codes.ADT.constructors.*;
import codes.ADT.primitives.MakeSquare;
import codes.methods.Cramer;
import codes.methods.Gauss;
import codes.methods.GaussJordan;
import codes.methods.InverseCofactor;
import codes.methods.InverseGaussJordan;
import codes.methods.submethods.SPLCheck;
import codes.ADT.Matrix;

public class inputSPL {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice = chooseMethods();

        int inputType = chooseType();

        if (inputType == 1) {

            Matrix matrix = createMtrxConsole.createMatrix();

            processMethods(choice, matrix);

        } else {
            try {
                // base is default path
                // Need to create input for filename
                String base = "../files/test1.txt";
                Matrix matrix = createMtrxFile.createMatrix(base);
                processMethods(choice, matrix);
            } catch (IOException ex) {
                System.out.println("Filename not found!");
            }
        }

        // scanner.close();
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

        for (int i = 1; i <= methods.length; i++) {
            System.out.printf("[%d] %s\n", i, methods[i - 1]);
        }

        int choice = -9999;

        while (choice < 1 || choice > 7) {
            if (choice != -9999) {
                System.out.println("Input not valid, try again.");
            }
            System.out.printf("\nMethods : ");
            choice = scanner.nextInt();
            scanner.nextLine();
        }

        return choice;
    }

    public static int chooseType() {
        // Scanner scanner = new Scanner(System.in);

        System.out.println("Input Types:");
        System.out.println("[1] Console");
        System.out.println("[2] File txt");

        int inputType = -9999;
        while (inputType < 1 || inputType > 2) {
            if (inputType != -9999) {
                System.out.println("Input not valid, try again.");
            }

            System.out.printf("\nInput type : ");
            inputType = scanner.nextInt();
            scanner.nextLine();
        }

        return inputType;
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

        System.out.println();
        if (status == 0) {
            /* Solusi Unik */

            System.out.println("SPL memiliki solusi unik");

            double[] unik = uniqueCase(m);
            try {
                // Need to create input filename for pathname
                printMtrxFile.printMatrix(unik, "output_1.txt");
            } catch (IOException ex) {
                System.out.println("Error: "+ex);
            }

            for (int i = 0; i < unik.length; i++) {
                System.out.printf("x%d = %.2f\n", i + 1, unik[i]);
            }

        } else if (status == 1) {
            /* Solusi Banyak */
            System.out.println("SPL memiliki banyak solusi");
            double[] banyak = infiniteCase(m);

            for (int i = 0; i < banyak.length; i++) {
                System.out.printf("x%d = %.2f\n", i + 1, banyak[i]);
            }

        } else {
            /* Tidak ada solusi */
            System.out.println("Tidak ada nilai x yang memenuhi persamaan SPL.");
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

    public static double[] infiniteCase(Matrix m) {
        double[] unik = new double[m.rows];

        for (int i = m.rows - 1; i >= 0; i--) {
            unik[i] = m.Mtrx[i][m.cols - 1];

            for (int j = i + 1; j <= m.cols - 2; j++) {
                unik[i] -= unik[j] * m.Mtrx[i][j];
            }
            // Error here (Need handling for m.Mtrx[i][i])
            unik[i] /= m.Mtrx[i][i];
        }

        return unik;
    }

    public static void printCramer(double[] ans) {
        System.out.println("\nx value :");
        for (int i = 0; i < ans.length; i++) {
            System.out.printf("x%d  = %.2f\n", i + 1, ans[i]);
        }
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



}
