package codes.ADT.constructors;

import java.io.*;
import java.io.IOException;

import codes.ADT.Matrix;

public class printMtrxFile{
    public static String base = "../output/";
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
                content = content.concat("x"+(i+1)+": "+Double.toString(x[i]) + "\n");
            } else {
                content = content.concat("x"+(i+1)+": "+Double.toString(x[i]));
            }
        }
        // content = Matrix of string
        FileWriter writer = new FileWriter(base + pathname);
        writer.write(content);
        writer.close();
    }
}
