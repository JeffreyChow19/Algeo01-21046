package codes.ADT.primitives;

import codes.ADT.Matrix;

public class SPLCheck {
    public static int main(Matrix m){
        int def = 0;

        if (isInfinite(m)){
            def = 1;
        } else if (isNone(m)){
            def = 2;
        }

        return def;
    }

    public static boolean isInfinite(Matrix m){
        boolean def = false;

        int i = 0;
        while (!def && i < m.rows){
            int j = 0;
            boolean temp = true;
            while (j < m.cols && temp){
                temp = (m.Mtrx[i][j] == 0);
                j++;
            }

            def = temp;
            i++;
        }

        if (m.rows + 1 != m.cols){
            def = true;
        }

        return def;
    } 

    public static boolean isNone(Matrix m){
        boolean def = false;

        int i = 0;
        while (!def && i < m.rows) {
            int j = 0;
            boolean temp = true;
            while (j < m.cols-1 && temp) {
                temp = (m.Mtrx[i][j] == 0);
                j++;
            }

            def = temp;
            i++;
        }

        return def;
    }
}
