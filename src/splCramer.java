import java.util.Scanner;

public class splCramer{
    int n;
    float[][] matriksA;
    float[][] matriksAug;
    float[] matriksB;

    // konstruktor
    public splCramer(boolean isKeyboard) {
        if (isKeyboard) {

            Scanner sc = new Scanner(System.in);
            System.out.println();
            System.out.print("Masukan n: ");
            n = sc.nextInt();
            
            matriksA = new float[n][n];
            
            System.out.println("Masukkan koefisien matriks a!");
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    System.out.print("[" + i + "]" + "[" + j + "]: ");
                    matriksA[i][j] = sc.nextFloat();
                }
            }
            
            matriksB = new float[n];
            
            System.out.println("Masukkan koefisien matriks b!");
            for(int i = 0; i < n; i++){
                System.out.print("[" + i + "]" + ": ");
                matriksB[i] = sc.nextFloat();
            }

            matriksAug = new float[n][n + 1];

            for (int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    matriksAug[i][j] =  matriksA[i][j];
                }
                matriksAug[i][n] =  matriksB[i];
            }
            sc.close();
        } else {
        }
    }

    public void replaceWithB(int k, float[][] matriksNew){
        for (int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                matriksNew[i][j] =  matriksA[i][j];
            }
        }
        for (int i = 0; i < n; i++){
                matriksNew[i][k] = matriksB[i]; 
        }
    }

    public void cramer() {
        int k = 0;
        float detMatA = determinanKofaktor.Determinan(matriksA);
        float detMatCramer;
        float[][] matriksCramer = new float[n][n];
        System.out.println(detMatA);
        while (k < n){
            replaceWithB(k, matriksCramer);
            matrix.tulisMatrix(matriksCramer);
            k++;
        }
    }
}