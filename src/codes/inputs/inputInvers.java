package codes.inputs;

import codes.ADT.Matrix;
import codes.ADT.constructors.*;
import codes.methods.InverseGaussJordan;

import java.io.IOException;


public class inputInvers extends inputDeterminan{
    public static void main(String[] args) {
        int choice = chooseMethods();

        int inputType = chooseType();

        if (inputType == 1){
            Matrix matrix = inptDet();

            processMethods(choice, matrix);
        }
        else {
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
                "Metode eliminasi Gauss-Jordan",
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

    public static void processMethods(int choice, Matrix m) {
        Matrix ans;
        switch (choice) {
            case 1:
                ans = InverseGaussJordan.inverse(m);

                if (ans.has_inversed){
                    printMtrxConsole.printMatrix(ans);
                } else {
                    System.out.println("Matrix has no inverse");
                }
                break;
            case 2:
                ans = InverseGaussJordan.inverse(m);
                if (ans.has_inversed){
                    printMtrxConsole.printMatrix(ans);
                } else {
                    System.out.println("Matrix has no inverse");
                }
                break;
            case 3:
                break;
            default:
                break;
        }
         
            
    }
}
