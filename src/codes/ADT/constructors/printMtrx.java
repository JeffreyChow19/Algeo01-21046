package codes.ADT.constructors;

import java.util.Scanner;
import java.io.IOException;
import codes.ADT.*;
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
            print("\nOutput file name: ");
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

    public static void main(String args, double ans) {
        println("Output Types:");

        String[] methods = {
                "Console",
                "File txt"
        };

        int inputType = menuCheck.main(1, 2, methods);

        if (inputType == 1) {
            printMtrxConsole.printLine(args, ans);
        } else {
            print("\nOutput file name: ");
            String pathname = scanner.nextLine();
            try {
                printMtrxFile.printLine(args, ans, pathname);
            } catch (IOException ex) {
                println("No such files.");
            }
        }
    }

    public static void main(Param[] ans) {
        println("Output Types:");

        String[] methods = {
                "Console",
                "File txt"
        };

        int inputType = menuCheck.main(1, 2, methods);

        if (inputType == 1) {
            printMtrxConsole.printParam(ans);
        } else {
            print("\nOutput file name: ");
            String pathname = scanner.nextLine();
            try {
                printMtrxFile.printParam(ans, pathname);
            } catch (IOException ex) {
                println("No such files.");
            }
        }
    }

    public static void main(double[] ans, double result, double x, String args) {
        println("\nOutput Types:");

        String[] methods = {
                "Console",
                "File txt"
        };

        int inputType = menuCheck.main(1, 2, methods);

        if (inputType == 1) {
            printMtrxConsole.printFx(ans, result, x, args);
        } else {
            print("\nOutput file name: ");
            String pathname = scanner.nextLine();
            try {
                printMtrxFile.printFx(pathname, ans, result, x, args);
            } catch (IOException ex) {
                println("No such files.");
            }
        }
    }

    public static void mainV2(double[] ans, double result, double x, String args) {
        println("\nOutput Types:");

        String[] methods = {
                "Console",
                "File txt"
        };

        int inputType = menuCheck.main(1, 2, methods);

        if (inputType == 1) {
            printMtrxConsole.printFxV2(ans, result, x, args);
        } else {
            print("\nOutput file name: ");
            String pathname = scanner.nextLine();
            try {
                printMtrxFile.printFxV2(pathname, ans, result, x, args);
            } catch (IOException ex) {
                println("No such files.");
            }
        }
    }
}
