package codes.inputs;

import codes.ADT.Matrix;
import codes.ADT.constructors.*;
import java.util.Scanner;
import codes.methods.determinant;
import codes.methods.submethods.menuCheck;

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

        int choice = menuCheck.main(1, 3, methods);

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
