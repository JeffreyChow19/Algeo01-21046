package codes.inputs;

import codes.ADT.Matrix;
import codes.ADT.constructors.*;
import java.util.Scanner;
import codes.methods.determinant;

public class inputDeterminan {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int choice = chooseMethods();

        Matrix matrix = createMtrx.main(true);

        processMethods(choice, matrix);
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
