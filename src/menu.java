import java.util.Scanner;

public class menu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean keluar = false;
        while (!keluar){
            int choice;
            System.out.println("Menu");
            System.out.println("1. Sistem Persamaan Linier");
            System.out.println("2. Determinan");
            System.out.println("3. Matriks balikan");
            System.out.println("4. Interpolasi Polinom");
            System.out.println("5. Regresi linier berganda");
            System.out.println("6. Keluar");

            System.out.print("Masukan pilihan : ");

            choice = sc.nextInt();
            if (choice == 1) {
                System.out.println();
                System.out.println("Menu");
                System.out.println("1. Gauss");
                System.out.println("2. Gauss Jordan");
                System.out.println("3. Matriks Balikan");
                System.out.println("4. Cramer");

                System.out.print("Masukan pilihan : ");

                choice = sc.nextInt();
                if (choice == 4) {
                    double[][] M = inputKeyboard.inputKeyboardCramer();
                    double[] hasil = kofaktorPlus.cramer(M);
                    for (int i = 0; i < hasil.length; i++) {
                        System.out.println("X" + (i + 1) + "=" + hasil[i]);
                    }
                }
            }
            else if (choice == 2) {
                System.out.println();
                System.out.println("Menu");
                System.out.println("1. Reduksi");
                System.out.println("2. Kofaktor");
                choice = sc.nextInt();
                if (choice == 2) {
                    double[][] M = inputKeyboard.inputKeyboardDeterminan();
                    matrix.tulisMatrix(M);
                }
            } 
            else if (choice == 3) {
            }
            else if (choice == 4) {
                double[][]Mi = inputKeyboard.inputKeyboardInterpolasi();
                interpolasi.interpolasiPolinom(Mi);
            }
            else if (choice == 5) {
            }
            else if (choice == 6) {
                keluar = true;
                break;
            }
        }
        System.out.println();
        sc.close();
    }
}
