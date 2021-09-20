import java.util.Scanner;

public class splCramer{
    int row;
    int column;
    float[][] matriksA;
    float[][] matriksAug;
    float[] matriksB;

    // konstruktor
    public splCramer(boolean isKeyboard) {
        if (isKeyboard) {

            Scanner sc = new Scanner(System.in);
            System.out.println();
            System.out.print("Masukan baris: ");
            row = sc.nextInt();
            System.out.print("Masukan kolom: ");
            column = sc.nextInt();
            
            matriksA = new float[row][column];
            
            System.out.println("Masukkan koefisien matriks a!");
            for(int i = 0; i < row; i++){
                for(int j = 0; j < column; j++){
                    System.out.print("[" + i + "]" + "[" + j + "]: ");
                    matriksA[i][j] = sc.nextFloat();
                }
            }
            
            matriksB = new float[row];
            
            System.out.println("Masukkan koefisien matriks b!");
            for(int i = 0; i < row; i++){
                System.out.print("[" + i + "]" + ": ");
                matriksB[i] = sc.nextFloat();
            }

            matriksAug = new float[row][column + 1];

            for (int i = 0; i < row; i++){
                for(int j = 0; j < column; j++){
                    matriksAug[i][j] =  matriksA[i][j];
                }
                matriksAug[i][column] =  matriksB[i];
            }
            sc.close();
        } else {
        }
    }

    public void tulisMatrix(float[][] keluaran) {
        for (int i = 0; i < keluaran.length; i++) {
            for (int j = 0; j < keluaran[0].length; j++) {
                System.out.print(String.format("%.2f ", keluaran[i][j]));
            }
            System.out.println();
        }
    }

    public void replaceWithB(int k, float[][] matriksNew){
        for (int i = 0; i < row; i++){
            for(int j = 0; j < column; j++){
                matriksNew[i][j] =  matriksA[i][j];
            }
        }
        for (int i = 0; i < row; i++){
                matriksNew[i][k] = matriksB[i]; 
        }
    }

    public int Determinan(float[][] Matriks) {
        float[][] newMatriks = new float[Matriks.length][(Matriks[0].length * 2)-1];
        for (int i = 0; i < Matriks.length; i++){
            for(int j = 0; j < Matriks[0].length; j++){
                newMatriks[i][j] =  Matriks[i][j];
            }
            for(int k = Matriks[0].length; k < newMatriks[0].length; k++){
                newMatriks[i][k] =  Matriks[i][newMatriks[0].length-1-k];
            }
        }
        float det;
        for(int i = 0; i < Matriks[0].length-1; i++){
            for(int j = 0; j < Matriks[0].length; j++){
                
            }
        }
        return 1;
    }

    public void cramer() {
        int k = 0;
        float detMatA = Determinan(matriksA);
        float detMatCramer;
        float[][] matriksCramer = new float[row][column];
        System.out.println(detMatA);
        while (k < column){
            replaceWithB(k, matriksCramer);
            tulisMatrix(matriksCramer);
            k++;
        }
    }
}