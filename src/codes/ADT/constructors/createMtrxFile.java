package codes.ADT.constructors;

import java.io.IOException;
import java.util.Scanner;
import java.io.*;

import codes.ADT.Matrix;

public class createMtrxFile {
    public static Matrix createMatrix(String pathname) throws IOException {
        // Path for input text files
        // Must be inside the `files` folder
        String base = "../test/";
        FileReader file_input = new FileReader(base + pathname);
        // Concat All text content to content String
        Scanner scan = new Scanner(file_input);
        int rows = 0, cols = 0;
        String content = "";
        while (scan.hasNextLine()) {
            content = content.concat(scan.nextLine() + "\n");
        }

        // Find the length of content, rows and cols for Matrix
        int length = 0;
        for (int number : content.toCharArray()) {
            length++;
            if (number == ' ') {
                if (rows == 0) {
                    cols++;
                }
            }
            if (number == '\n') {
                rows++;
            }
        }
        cols++;
        // Parsing content to Array of String
        boolean loop = true;
        int index = 0;
        int max = rows * cols;
        String str = "";
        char[] temp = content.toCharArray();
        String[] file_to_string = new String[max];
        int z = 0;
        while (loop) {
            if (temp[z] != ' ') {
                str = str.concat("" + temp[z]);
            } else {
                file_to_string[index] = str;
                loop = false;
            }
            z++;
        }
        str = "";
        index = 1;
        for (int k = 0; k < length; k++) {
            if (temp[k] == ' ' || temp[k] == '\n') {
                for (int j = k + 1; j < length; j++) {
                    if (temp[j] != ' ' && temp[j] != '\n') {
                        str = str.concat("" + temp[j]);
                    } else {
                        file_to_string[index] = str;
                        str = "";
                        index++;
                        break;
                    }
                }
            }
        }

        // Parsing Array of String to Matrix
        index = 0;
        double sign = -1;
        Matrix m = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (file_to_string[index].contains("-")){
                    String[] parts = file_to_string[index].split("-");
                    String num_parts = parts[1];
                    m.Mtrx[i][j] = Double.parseDouble(num_parts) * sign;
                } else {
                    m.Mtrx[i][j] = Double.parseDouble(file_to_string[index]);
                }
                index++;
            }
        }
        return m;
    }
}
