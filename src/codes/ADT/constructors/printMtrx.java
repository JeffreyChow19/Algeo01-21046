package codes.ADT.constructors;

import java.util.Scanner;
import java.io.IOException;
import codes.ADT.Matrix;
import codes.methods.submethods.menuCheck;

public class printMtrx {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(Matrix matrix) {
        System.out.println("Output Types:");

        String[] methods = {
                "Console",
                "File txt"
        };

        int inputType = menuCheck.main(1, 2, methods);

        if (inputType == 1){
            printMtrxConsole.printMatrix(matrix);
        } else {
            System.out.println("Output file name: ");
            String pathname = scanner.nextLine();
            try {
                printMtrxFile.printMatrix(matrix, pathname);
            } catch (IOException ex) {
                System.out.println("No such files.");
            }
        }
    }
}
