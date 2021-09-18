import java.util.Scanner;

public class matrix {
    private int r;             
    private int c;             
    private int[][] Matriks;   

    public matrix() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println();
        System.out.print("Masukan baris: "); r = keyboard.nextInt();
        System.out.print("Masukan kolom: "); c = keyboard.nextInt();
        Matriks = new int[r][c];
        System.out.println("Please assign the following elements: ");
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                System.out.print("[" + i + "]" + "[" + j + "]: ");
                Matriks[i][j] = keyboard.nextInt();
            }
        }
        keyboard.close();
    }

    public void tulisMatrix() {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(String.format("%d ", Matriks[i][j]));
            }
            System.out.println();
        }
    }

    public void transformMatrix() {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                Matriks[i][j] = 1; 
            }
        }
    }
}