package codes.ADT.constructors;

import java.util.Scanner;
import java.io.IOException;
import codes.ADT.Matrix;
import codes.methods.submethods.menuCheck;

public class printMtrx extends printMtrxConsole {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(Matrix matrix) {
        println("Output Types:");

        String[] methods = {
                "Console",
                "File txt"
        };

        int inputType = menuCheck.main(1, 2, methods);

        if (inputType == 1){
            printMtrxConsole.printMatrix(matrix);
        } else {
            println("Output file name: ");
            String pathname = scanner.nextLine();
            try {
                printMtrxFile.printMatrix(matrix, pathname);
            } catch (IOException ex) {
                println("No such files.");
            }
        }
    }

    public static void main(double[] ans) {
        println("Output Types:");

        String[] methods = {
                "Console",
                "File txt"
        };

        int inputType = menuCheck.main(1, 2, methods);

        if (inputType == 1) {
            printMtrxConsole.printMatrix(ans);
        } else {
            print("\nOutput file name: ");
            String pathname = scanner.nextLine();
            try {
                printMtrxFile.printMatrix(ans, pathname);
            } catch (IOException ex) {
                println("No such files.");
            }
        }
    }
}
