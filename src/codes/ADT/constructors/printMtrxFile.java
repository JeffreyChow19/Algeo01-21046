package codes.ADT.constructors;

import java.io.*;
import java.io.IOException;
import java.util.Scanner;

import codes.ADT.*;

public class printMtrxFile{
    private static String base = "../test/output/";
    public static Scanner in = new Scanner(System.in);
    public static void printMatrix(Matrix m, String pathname) throws IOException{
        String content = "";
        for(int i = 0; i < m.rows; i++){
            for(int j = 0; j < m.cols; j++){
                if(j < m.cols - 1){
                    content = content.concat(Double.toString(m.Mtrx[i][j]) + " ");
                } else {
                    content = content.concat(Double.toString(m.Mtrx[i][j]) + "\n");
                }
            }
        }
        // content = Matrix of string
        FileWriter writer = new FileWriter(base + pathname);
        writer.write(content);
        writer.close();
        print("Successfully added "+ pathname +"to test/output folder.");
    }
    public static void printMatrix(double[] x, String pathname) throws IOException{
        String content = "";
        for(int i = 0; i < x.length; i++){
            if(i < x.length - 1){
                content = content.concat("X"+(i+1)+" : "+Double.toString(x[i]) + "\n");
            } else {
                content = content.concat("X"+(i+1)+" : "+Double.toString(x[i]));
            }
        }
        // content = Array of string
        FileWriter writer = new FileWriter(base + pathname);
        writer.write(content);
        writer.close();
        print("Successfully added "+ pathname +"to test/output folder.");
    }

    public static void printLine(String args , double data, String pathname) throws IOException{
        String content = "";
        content = content.concat(args+" : "+ data);
        // content = string
        FileWriter writer = new FileWriter(base + pathname);
        writer.write(content);
        writer.close();
        print("Successfully added "+ pathname +"to test/output folder.");
    }

    public static void printFx(String pathname, double[] ans, double result, double x, String args) throws IOException{
        String content = "f(x) = ";
        for (int i = ans.length - 1; i >= 0; i--) {
            String current_power = i + "";
            if (ans[i] >= 0) {
                if (i == ans.length - 1) {
                    content = content.concat(ans[i] + "X" + current_power + "");
                } else {
                    if (i == 0) {
                        content = content.concat("+" + ans[i]);
                    } else {
                        content = content.concat("+" + ans[i] + "X" + current_power + "");
                    }
                }
            } else {
                if (i == ans.length - 1) {
                    content = content.concat(ans[i] + "X" + current_power + "");
                } else {
                    if (i == 0) {
                        content = content.concat("" + ans[i]);
                    } else {
                        content = content.concat(ans[i] + "X" + current_power + "");
                    }
                }
            }
        }
        content = content.concat("\n");
        if (args != "no_args"){
            content = content.concat(args + " = " + result);
        }

        FileWriter writer = new FileWriter(base + pathname);
        writer.write(content);
        writer.close();
        print("Successfully added "+ pathname +"to test/output folder.");
    }

    public static void printParam(Param[] args, String pathname) throws IOException {
        String content = "";
        for (int i = 0; i < args.length; i++) {
            boolean before = false;

            content = content.concat("X"+(i + 1)+" = ");

            if (args[i].val != 0){
                content = content.concat("" + args[i].val);
                before = true;
            }

            for (int j = 0; j < args[i].params.length; j++){
                if (args[i].valPar[j] != 0 ) {
                    if (before && args[i].valPar[j]>=0){
                        content = content.concat(" + ");
                    } else {
                        content = content.concat(" ");
                    }

                    if (args[i].valPar[j] != 1){
                        content = content.concat(""+args[i].valPar[j]+""+args[i].params[j]); 
                    } else {
                        content = content.concat("" + args[i].params[j]);
                    }

                    before = true;
                }

                if (j == args[i].params.length - 1) {
                    content = content.concat("\n");
                }
            }
        }
        FileWriter writer = new FileWriter(base + pathname);
        writer.write(content);
        writer.close();   
        print("Successfully added "+ pathname +"to test/output folder.");
    }

    public static void print(String str){
        System.out.print(str);
    }
}
