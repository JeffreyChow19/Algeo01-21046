package codes.inputs;

import java.util.Scanner;

import codes.mainProgram;
import codes.ADT.Matrix;
import codes.ADT.constructors.*;
import codes.methods.determinant;
import codes.methods.submethods.menuCheck;

public class inputDeterminan extends printMtrxConsole {
    public static Scanner scanner = new Scanner(System.in);
    public static void main() {
        int choice = chooseMethods();

        Matrix matrix = createMtrx.main(true);

        processMethods(choice, matrix);
    }
    
    public static int chooseMethods() {

        String[] methods = {
                "Metode eliminasi Gauss",
                "Metode Cofactor",
        };

        println("\nMethods");
        println("=======\n");

        int choice = menuCheck.main(1, 2, methods);

        return choice;
    }

    public static void processMethods(int choice, Matrix m){
        double ans;
        String args = "Determinan";
        switch (choice) {
            case 1:
                ans = determinant.detGauss(m,true);
                printMtrx.main(args, ans);
                break;
            case 2:
                ans = determinant.detCofactor(m, m.rows, true);
                printMtrx.main(args, ans);
                break;
            default:
                break;
        }
    }

}
