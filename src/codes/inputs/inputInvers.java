package codes.inputs;

import codes.ADT.Matrix;
import codes.ADT.constructors.*;
import codes.methods.InverseCofactor;
import codes.methods.InverseGaussJordan;
import codes.methods.submethods.menuCheck;
import codes.mainProgram;

public class inputInvers extends inputDeterminan{
    public static void main() {
        int choice = chooseMethods();

        Matrix matrix = createMtrx.main(true);

        processMethods(choice, matrix);
    }

    public static int chooseMethods() {

        String[] methods = {
                "Metode eliminasi Gauss-Jordan",
                "Metode Cofactor",
        };

        System.out.println("\nMethods");
        System.out.println("=======\n");

        int choice = menuCheck.main(1, 2, methods);

        return choice;
    }

    public static void processMethods(int choice, Matrix m) {
        Matrix ans;
        switch (choice) {
            case 1:
                ans = InverseGaussJordan.inverse(m);

                if (ans.has_inversed){
                    printMtrx.main(ans);
                } else {
                    System.out.println("Matrix has no inverse");
                }
                break;
            case 2:
                ans = InverseCofactor.inverse(m);
                if (ans.has_inversed){
                    printMtrx.main(ans);
                } else {
                    System.out.println("Matrix has no inverse");
                }
                break;
            default:
                break;
        }      
    }
}
