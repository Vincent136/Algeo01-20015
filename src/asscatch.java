import java.util.Scanner;
// import java.util.*;

public class asscatch{
    public static void main(String[] args){   
        System.out.println("Please enter the rows in the Matriks");
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		System.out.println("Please enter the columns in the Matriks");
		int column = sc.nextInt();

		int[][] Matriks = new int[row][column];

		for (int r = 0; r < row; r++) {
			for (int c = 0; c < column; c++) {
				System.out.println(String.format("Enter Matriks[%d][%d] integer", r, c));
				Matriks[r][c] = sc.nextInt();
			}
		}    
        sc.close();

        Matriks = Reduction(Matriks);

        for (int r = 0; r < Matriks.length; r++) {
			for (int c = 0; c < Matriks[0].length; c++) {
				System.out.print(Matriks[r][c] + "\t");
			}
			System.out.println();
        }
    }

    //Terjaim bekerja
    public static int Determinan(int[][] Matriks) {
        int Sum = 1;
        int TotalPos = 0;
        int TotalNeg = 0;
        int x,y;;
        for (int c = 0; c < Matriks[0].length; c++) {
            x = c;
            y = 0;
            Sum = 1;
            while( y < Matriks.length){
                if(x == Matriks[0].length){
                    x = 0;
                }
                Sum = Sum * Matriks[y][x];
                x++; 
                y++;
            }
            TotalPos = TotalPos + Sum;
        }
        for (int c = 0; c < Matriks[0].length; c++) {
            x = c;
            y = 0;
            Sum = 1;
            while( y < Matriks.length){
                if(x == -1){
                    x = Matriks[0].length-1;
                }
                Sum = Sum * Matriks[y][x];
                x--; 
                y++;
            }
            TotalNeg = TotalNeg + Sum;      
        }
        return TotalPos-TotalNeg;        
    }
    
    public static void DeterminanMatriksKofaktor(int[][] Matriks){
        for (int c = 0; c < Matriks[0].length; c++) { 
            if (c%2 == 0){
                
            }    
            else{

            }
        }
    }

    public static int[][] Reduction(int[][] Matriks){
        int Multiplier;
        int i=0;
        int c_alternative;
        for (int c = 0; c < Matriks[0].length; c++){
            c_alternative = c;
            if (Matriks[c][c] == 0){
                while (Matriks[c+i][c] == 0 && c+i < Matriks.length){
                    i++;
                }
                if (c+i != Matriks.length){
                    SwapRow(Matriks,c, c+i);
                }
                else{
                    c_alternative = 100000000;
                }
            }
            for (int r = c+1; r < Matriks.length; r++) {
                Multiplier = Matriks[r][c]/Matriks[c][c];
                for (int y = 0; y < Matriks[0].length; y++) {
                    Matriks[r][y] = Matriks[r][y] - Multiplier * Matriks[c][y];
                }
            }
            
        }


        return Matriks;
    }

    public static void SwapRow(int[][] Matriks,int a,int b) {
        int[] temp;
        temp = Matriks[a];
        Matriks[a] = Matriks[b];
        Matriks[b] = temp;
    }
}
