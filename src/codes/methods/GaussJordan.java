package codes.methods;
import codes.ADT.Matrix;
// import codes.methods.Gauss;

public class GaussJordan {
    public static Matrix jordan (Matrix m){
        Matrix temp = Gauss.gauss(m);
        // Matrix reverse_m_rows;
        for(int i = m.rows-1; i>=0; i--){
            for(int j= i-1; j>=0; j--){
                double factor;
                if(temp.Mtrx[i][i]==0){
                    factor = 1;
                }else{
                    factor = temp.Mtrx[j][i]/temp.Mtrx[i][i];
                }
                for(int k= m.cols-1; k>=0; k--){
                    temp.Mtrx[j][k] -= (temp.Mtrx[i][k]*factor);
                }
            }
        }
        for(int i = 0; i<m.rows; i++){
            if(temp.Mtrx[i][i]!=1){
                double factor;
                if(temp.Mtrx[i][i]==0){
                    factor = 1;
                }else{
                    factor = temp.Mtrx[i][i];
                }
                for(int j =i; j<m.cols; j++){
                    temp.Mtrx[i][j] /= factor;
                }
            }
        }
        for(int i =0; i<m.rows; i++){
            for(int j =0; j<m.cols; j++){
                if(temp.Mtrx[i][j]==(-0)){
                    temp.Mtrx[i][j]= 0;
                }
            }
        }
        return temp;
    }
}
