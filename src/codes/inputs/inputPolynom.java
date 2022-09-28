package codes.inputs;

import java.util.*;
import codes.methods.*;
import codes.methods.submethods.*;
import codes.ADT.*;
import codes.ADT.constructors.*;
import java.io.IOException;

public class inputPolynom extends printMtrxConsole {
    private static double result;
    public static void main(String[] args) {
        Matrix matrix;
        double[] ans;
        matrix = main(false);
        // Get ans from polynom
        ans = InterpolasiPolinom.polynom(matrix);
        if (ans[0] == 999.999){
            println("Tidak dapat membentuk persamaan interpolasi polinom karena titik yang diinput menghasilkan solusi SPL yang tak terhingga.");
        } 
        else if (ans[0] == -999.999) {
            println("Tidak dapat membentuk persamaan interpolasi polinom karena titik yang diinput menghasilkan tidak menghasilkan solusi pada SPL.");
        } 
        else {
            result = InterpolasiPolinom.polynom(ans, matrix.polynom_x);
            print("f(x) = ");
            for (int i = ans.length - 1; i >= 0; i--){
                String current_power = i+"";
                if (ans[i] >= 0){
                if (i == ans.length - 1){
                    if (i == 1){
                        current_power = "";
                    }
                    printf("%.5f"+"x"+current_power+"",ans[i]);
                } else {
                    if (i == 1){
                        printf("+%.5f"+"x", ans[i]);
                    }
                    else if (i == 0){
                        printf("+%.5f", ans[i]);
                    } else {
                    printf("+%.5f"+"x"+current_power+"", ans[i]);
                    }
                }
                } else {
                    if (i == ans.length - 1){
                        if (i == 1){
                            current_power = "";
                        }
                        printf("%.5f"+"x"+current_power+"",ans[i]);
                    } else {
                        if (i == 1){
                            printf("%.5f"+"x", ans[i]);
                        }
                        else if (i == 0){
                            printf("%.5f", ans[i]);
                        } else {
                        printf("%.5f"+"x"+current_power+"", ans[i]);
                        }
                    }
                }
            }
        }
        print("\n");
        printf("Hasil Interpolasi di x = "+matrix.polynom_x+" adalah: %.5f", result);
    }

    public static Matrix main(boolean square){
        println("Input Types:");

        String[] methods = {
            "Console",
            "File txt"
        };
        Matrix m;
        double x;
        int inputType = menuCheck.main(1, 2, methods);
        Scanner in = new Scanner(System.in);
        if (inputType == 1){
            print("Masukkan n: ");
            int n = in.nextInt();
            in.nextLine();
            m = new Matrix(n, 2);
            // Fill Matrix
            for (int k = 0; k < n; k++){
                    print("Input(x"+k+"): ");
                    m.Mtrx[k][0] = in.nextDouble();
                    in.nextLine();
                    print("Input(y"+k+"): ");
                    m.Mtrx[k][1] = in.nextDouble();
                    in.nextLine();
            }
            print("Input nilai x untuk taksiran: ");
            x = in.nextDouble();
            in.nextLine();
            m.polynom_x = x;
            return m;
        } else {
            try {
                // Get Matrix from txt
                print("File name: ");
                String pathname = in.nextLine();
                String base = "../files/";
                m = createMtrxFile.createMatrix(base + pathname);
                print("Input nilai x untuk taksiran: ");
                x = in.nextDouble();
                in.nextLine();
                m.polynom_x = x;
                return m;
            } catch (IOException ex) {
                println("File not found!");
                return null;
            }
        }
    }
    // public static String superscript(String str) {
    //     str = str.replaceAll("2", "\u00b2");
    //     str = str.replaceAll("3", "\u00b3");
    //     str = str.replaceAll("4", "\u2074");
    //     str = str.replaceAll("5", "\u2075");
    //     str = str.replaceAll("6", "\u2076");
    //     str = str.replaceAll("7", "\u2077");
    //     str = str.replaceAll("8", "\u2078");
    //     str = str.replaceAll("9", "\u2079");         
    //     return str;
    // }
    }
