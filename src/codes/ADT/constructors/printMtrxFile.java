package codes.ADT.constructors;

import java.io.*;
import java.io.IOException;
import java.util.Scanner;

import codes.ADT.Matrix;

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
    }
    public static void printMatrix(double[] x, String pathname) throws IOException{
        String content = "";
        for(int i = 0; i < x.length; i++){
            if(i < x.length - 1){
                content = content.concat("x"+(i+1)+" : "+Double.toString(x[i]) + "\n");
            } else {
                content = content.concat("x"+(i+1)+" : "+Double.toString(x[i]));
            }
        }
        // content = Array of string
        FileWriter writer = new FileWriter(base + pathname);
        writer.write(content);
        writer.close();
    }

    public static void printLine(String args , double data, String pathname) throws IOException{
        String content = "";
        content = content.concat(args+" : "+ data);
        // content = string
        FileWriter writer = new FileWriter(base + pathname);
        writer.write(content);
        writer.close();
    }

    public static void printFx(String pathname, double[] ans, double result, double x, String args) throws IOException{
        String content = "f(x) = ";
        for (int i = ans.length - 1; i >= 0; i--) {
            String current_power = i + "";
            if (ans[i] >= 0) {
                if (i == ans.length - 1) {
                    content = content.concat(ans[i] + "x" + current_power + "");
                } else {
                    if (i == 0) {
                        content = content.concat("+" + ans[i]);
                    } else {
                        content = content.concat("+" + ans[i] + "x" + current_power + "");
                    }
                }
            } else {
                if (i == ans.length - 1) {
                    content = content.concat(ans[i] + "x" + current_power + "");
                } else {
                    if (i == 0) {
                        content = content.concat("" + ans[i]);
                    } else {
                        content = content.concat(ans[i] + "x" + current_power + "");
                    }
                }
            }
        }
        content = content.concat("\n");
        if (args != "no_args"){
            content = content.concat(args + " : " + result);
        }

        FileWriter writer = new FileWriter(base + pathname);
        writer.write(content);
        writer.close();
    }

    public static void print(String str){
        System.out.print(str);
    }
}
