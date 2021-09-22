import java.util.Scanner;

public class inputKeyboard {
    int n;
    float[][] matriksA;
    float[][] matriksAug;
    float[] matriksB;
    public inputKeyboard(String menu){
        if (menu == "splCramer") {
            Scanner sc = new Scanner(System.in);
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
        } else if (menu == "determinan") {
            Scanner sc= new Scanner(System.in);
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
        }
    }
}
