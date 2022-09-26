package codes.inputs;

import codes.ADT.Matrix;
import codes.ADT.constructors.*;
import java.io.IOException;
import java.util.Scanner;
import codes.ADT.primitives.*;

public class inputDeterminan {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int choice = chooseMethods();

        int inputType = chooseType();

        if (inputType == 1) {

            Matrix matrix = inptDet();

            processMethods(choice, matrix);

        } else {
            try {
                String base = "../files/test1.txt";
                Matrix matrix = createMtrxFile.createMatrix(base);
                processMethods(choice, matrix);
            } catch (IOException ex) {
                System.out.println("Filename not found!");
            }
        }

    }
    
    public static int chooseMethods() {
        // Scanner scanner = new Scanner(System.in);

        String[] methods = {
                "Metode eliminasi Gauss",
                "Metode Cofactor",
                "Return to Menu"
        };

        System.out.println("\nMethods");
        System.out.println("=======\n");

        for (int i = 1; i <= methods.length; i++) {
            System.out.printf("[%d] %s\n", i, methods[i - 1]);
        }

        int choice = -9999;

        while (choice < 1 || choice > 3) {
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

    public static Matrix inptDet (){
        int n = -1;
        while (n < 1){
            System.out.println("Input N: ");
            n = scanner.nextInt();
            scanner.nextLine();
        }

        Matrix m = createMtrxConsole.initMatrix(n, n);

        return m;
    }

    public static void processMethods(int choice, Matrix m){
        double ans;
        switch (choice) {
            case 1:
                ans = determinant.detGauss(m,true);
                System.out.printf("Determinan : %.2f\n", ans);
                break;
            case 2:
                ans = determinant.detCofactor(m, m.rows, true);
                System.out.printf("Determinan : %.2f\n", ans);
                break;
            case 3:
                break;
            default:
                break;
        }
    }

}
