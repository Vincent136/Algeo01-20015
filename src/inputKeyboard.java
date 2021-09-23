import java.util.Scanner;

public class inputKeyboard {
    public static double[][] inputKeyboardCramer(){
        Scanner sc = new Scanner(System.in);
        int n;
        double[][] matriks;
        double[][] matriksB;
        double[][] matriksAug;
        System.out.print("Masukan n: ");
        n = sc.nextInt();
        if (n <= 0){
            boolean isValid = false;
            while(!isValid){
                System.out.println("Masukan tidak boleh kurang dari sama dengan 0! ulangi!");
                System.out.print("Masukan n: ");
                n = sc.nextInt();
                if (n > 0) {
                    isValid = true;
                }
            }
        }
        

        matriks = new double[n][n];
        
        System.out.println("Masukkan matriks a!");
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                matriks[i][j] = sc.nextDouble();
            }
        }
        
        matriksB = new double[n][1];
        
        System.out.println("Masukkan matriks b!");
        for(int i = 0; i < n; i++){
            matriksB[i][0] = sc.nextDouble();
        }

        matriksAug = new double[n][n + 1];

        for (int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                matriksAug[i][j] =  matriks[i][j];
            }
            matriksAug[i][n] =  matriksB[i][0];
        }
        return matriksAug;
    }

    public static double[][] inputKeyboardSpl(){
        Scanner sc = new Scanner(System.in);
        int n;
        int m;
        double[][] matriks;
        double[][] matriksB;
        double[][] matriksAug;
        System.out.print("Masukan n: ");
        n = sc.nextInt();
        if (n <= 0){
            boolean isValid = false;
            while(!isValid){
                System.out.println("Masukan tidak boleh kurang dari sama dengan 0! ulangi!");
                System.out.print("Masukan n: ");
                n = sc.nextInt();
                if (n > 0) {
                    isValid = true;
                }
            }
        }
        System.out.print("Masukan m: ");
        m = sc.nextInt();
        if (m <= 0){
            boolean isValid = false;
            while(!isValid){
                System.out.println("Masukan tidak boleh kurang dari sama dengan 0! ulangi!");
                System.out.print("Masukan m: ");
                m = sc.nextInt();
                if (m > 0) {
                    isValid = true;
                }
            }
        }
        
        matriks = new double[n][n];
        
        System.out.println("Masukkan koefisien matriks a!");
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                System.out.print("[" + i + "]" + "[" + j + "]: ");
                matriks[i][j] = sc.nextDouble();
            }
        }
        
        matriksB = new double[n][1];
        
        System.out.println("Masukkan koefisien matriks b!");
        for(int i = 0; i < n; i++){
            System.out.print("[" + i + "]" + ": ");
            matriksB[i][0] = sc.nextDouble();
        }

        matriksAug = new double[n][n + 1];

        for (int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                matriksAug[i][j] =  matriks[i][j];
            }
            matriksAug[i][n] =  matriksB[i][0];
        }

        return matriksAug;
    }

    public static double[][] inputKeyboardDeterminan (){
        Scanner sc= new Scanner(System.in);
        int n;
        double[][] matriks;

        System.out.print("Masukan n: ");
        n = sc.nextInt();
        if (n <= 0){
            boolean isValid = false;
            while(!isValid){
                System.out.println("Masukan tidak boleh kurang dari sama dengan 0! ulangi!");
                System.out.print("Masukan n: ");
                n = sc.nextInt();
                if (n > 0) {
                    isValid = true;
                }
            }
        }
        
        matriks = new double[n][n];
        
        System.out.println("Masukkan koefisien matriks a!");
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print("[" + i + "]" + "[" + j + "]: ");
                matriks[i][j] = sc.nextDouble();
            }
        }
        return matriks;
    }

    public static double[][] inputKeyboardInterpolasi (){
        Scanner sc= new Scanner(System.in);
        int n;
        double[][] matriks;

        System.out.print("Masukan n: ");
        n = sc.nextInt();
        if (n <= 0){
            boolean isValid = false;
            while(!isValid){
                System.out.println("Masukan tidak boleh kurang dari sama dengan 0! ulangi!");
                System.out.print("Masukan n: ");
                n = sc.nextInt();
                if (n > 0) {
                    isValid = true;
                }
            }
        }

        matriks = new double[n][2];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < 2; j++){
                matriks[i][j] = sc.nextDouble();
            }
        }
        
        return matriks;
    }

    public static void inputKeyboardRegresi (){
    }
}
