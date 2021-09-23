import java.util.Scanner;

public class reductionPlus{
    public static void main(String[] args){   
        System.out.println("Please enter the rows in the Matriks");
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		System.out.println("Please enter the columns in the Matriks");
		int column = sc.nextInt();

		double [][] Matriks = new double [row][column];

		for (int r = 0; r < row; r++) {
			for (int c = 0; c < column; c++) {
				System.out.println(String.format("Enter Matriks[%d][%d] integer", r, c));
				Matriks[r][c] = sc.nextInt();
			}
		}    
        sc.close();

        PrintMatriks(Matriks);
        System.out.println(DeterminanReduksi(Matriks));
        PrintMatriks(Matriks);

        // Reduction(Matriks);
        // System.out.println("\n");

        // System.out.println(DeterminanReduksi(Matriks));
        
        // PrintMatriks(Matriks);
        // MakeRowOne(Matriks);
        // System.out.println("\n");

        // PrintMatriks(Matriks);
        // SecondaryReduction(Matriks);
        // System.out.println("\n");

        // PrintMatriks(Matriks);

        // System.out.println(DeterminanReduksi(Matriks));
    }

    //Merubah matrix diinput menjadi matrix yg bawahnya doang 0 0 0.
    //Contoh:   9 9 9       * * *
    //          8 8 8 ->    0 * *
    //          8 8 8       0 0 *
    public static void Reduction(double [][] Matriks){
        double  Multiplier;
        int c_alternative;
        int konts = 1;
        for (int c = 0; c < Matriks.length; c++){
            c_alternative = c;
            if (Matriks[c + konts-1][c] == 0){
                int i=0;
                while (c+i < Matriks.length){
                    if(Matriks[c+i][c] == 0){
                        i++;
                    }
                    else{
                        break;
                    }
                }
                if (c+i != Matriks.length){
                    SwapRow(Matriks,c, c+i);
                }
                else{
                    c_alternative = 100000000;
                }
            }
            if (c_alternative == 100000000){
                konts = konts -1;
            }
            for (int r = c_alternative + konts; r < Matriks.length; r++) {
                Multiplier = Matriks[r][c]/Matriks[c+konts-1][c];
                for (int y = 0; y < Matriks[0].length; y++) {
                    Matriks[r][y] = Matriks[r][y] - Multiplier * Matriks[c+konts-1][y];
                }
            }
        }
    }
    //Menukar row 
    public static void SwapRow(double [][] Matriks,int a,int b) {
        double [] temp;
        temp = Matriks[a];
        Matriks[a] = Matriks[b];
        Matriks[b] = temp;
    }

    //print matrix
    public static void PrintMatriks(double [][] Matriks) {
        for (int r = 0; r < Matriks.length; r++) {
			for (int c = 0; c < Matriks[0].length; c++) {
				System.out.print(Matriks[r][c] + "\t");
			}
			System.out.println();
        }
    }
    
    //Membagi tiap row dengan bilangan paling kira tak 0
    //Contoh:   9 18 9      1 2 1
    //          0 8 8 ->    0 1 1
    //          0 0 8       0 0 1
    public static void MakeRowOne(double [][] Matriks){
        double  divider;
        for (int r = 0; r < Matriks.length; r++) {
            int x=0;
            while (x < Matriks[0].length){
                if(Matriks[r][x] == 0){
                    x++;
                }
                else{
                    break;
                }
            }
            if (x < Matriks[0].length){
                divider = Matriks[r][x];
                for (int c = 0; c < Matriks[0].length; c++) {
                    Matriks[r][c] = Matriks[r][c]/divider;
                }
            }
        }
    }

    //Merubah matrix diinput menjadi matrix yg atasnya doang 0 0 0.
    //I.S: udah direduksi dulu SecondaryReduction(Reduction())
    //Contoh:   9 9 9      * 0 0
    //          0 9 8 ->    0 * 0
    //          0 0 8       0 0 *
    public static void SecondaryReduction(double [][] Matriks){
        double  divider;
        for (int r = 1; r < Matriks.length; r++) {
            int x=0;
            while (x < Matriks[0].length){
                if(Matriks[r][x] == 0){
                    x++;
                }
                else{
                    break;
                }
            }
            if (x < Matriks[0].length){
                for (int y = r-1; y > -1 ; y--) {
                    if (Matriks[y][x] != 0){
                        divider = Matriks[y][x] / Matriks[r][x];
                        for (int c = 0; c < Matriks[0].length; c++) {
                            Matriks[y][c] = Matriks[y][c] - divider * Matriks[r][c];
                        }
                    }
                }
            }
        }
    }

    public static void SPLGauss(double [][] Matriks){}

    public static void SPLGaussJordan(double [][] Matriks){}

    //Mereturn determinan dengan metode reduksi
    public static double  DeterminanReduksi(double [][] Matriks){
        double  Determinan = 1;
        Reduction(Matriks);
        if (Matriks.length == Matriks[0].length){
            for (int i = 0; i < Matriks.length; i++) {
                Determinan = Determinan * Matriks[i][i];
            }
        }
        return Determinan;
    }
}
