import java.util.Scanner;

class invers {

    // public static double[][] InputMatrix() {
    //     System.out.println("Please enter the rows in the Matriks");
    //     Scanner sc = new Scanner(System.in);
    //     int row = sc.nextInt();
    //     System.out.println("Please enter the columns in the Matriks");
    //     int column = sc.nextInt();

    //     double[][] Matriks = new double[row][column];

    //     for (int r = 0; r < row; r++) {
    //         for (int c = 0; c < column; c++) {
    //             System.out.println(String.format("Enter Matriks[%d][%d] integer", r, c));
    //             Matriks[r][c] = sc.nextInt();
    //         }
    //     }
    //     return Matriks;
    // }

    // public static double[] InputBaris() {
    //     System.out.println("Please enter the rows in the arrays");
    //     Scanner ar = new Scanner(System.in);
    //     int row = ar.nextInt();

    //     double[] Baris = new double[row];

    //     for (int x = 0; x < row; x++) {
    //         System.out.println(String.format("Enter Arrays[%d] integer", x));
    //         Baris[x] = ar.nextInt();
    //     }
    //     return Baris;
    // }

    public static boolean IsSquare(double[][] Matrix) {
        for (int i = 0, l = Matrix.length; i < l; i++) {
            if (Matrix[i].length != l) {
                return false;
            }
        }
        return true;
    }

    // public static void PrintMatrix(double[][] Matriks) {
    //     for (int i = 0; i < Matriks.length; i++) {
    //         for (int j = 0; j < Matriks.length; j++) {
    //             System.out.print(Matriks[i][j] + " ");
    //         }
    //         System.out.print("\n");
    //     }
    // }

    public static double Determinan(double[][] Matriks) {
        double determinan;
        double[][] potong = new double[Matriks.length - 1][Matriks[0].length - 1];
        if (Matriks.length == 1) {
            determinan = Matriks[0][0];
        } else {
            determinan = 0;
            int plusminus = 1;
            for (int i = 0; i < Matriks.length; i++) {
                potong = potongMatriks(Matriks, 0, i);
                determinan = determinan + plusminus * Matriks[0][i] * Determinan(potong);
                plusminus = -plusminus;
            }
        }
        return determinan;
    }

    public static double[][] potongMatriks(double[][] Matriks1, int a, int b) {
        int x = 0;
        double[][] Matriks2 = new double[Matriks1.length - 1][Matriks1[0].length - 1];
        for (int i = 0; i < Matriks1.length; i++) {
            if (i != a) {
                int y = 0;
                for (int j = 0; j < Matriks1.length; j++) {
                    if (j != b) {
                        Matriks2[x][y] = Matriks1[i][j];
                        y++;
                    }
                }
                x++;
            }
        }
        return Matriks2;
    }

    public static double[][] MinorMatriks(double[][] Matriks) {
        double[][] m1 = new double[Matriks.length - 1][Matriks[0].length - 1];
        double[][] Mout = new double[Matriks.length][Matriks[0].length];
        for (int i = 0; i < Matriks.length; i++) {
            for (int j = 0; j < Matriks.length; j++) {
                m1 = potongMatriks(Matriks, i, j);
                Mout[i][j] = Determinan(m1);
            }
        }
        return Mout;
    }

    public static void KofaktorMatriks(double[][] Matriks) {
        for (int i = 0; i < Matriks.length; i++) {
            for (int j = 0; j < Matriks[0].length; j++) {
                if ((i + j) % 2 == 1)
                    Matriks[i][j] = (-1 * Matriks[i][j]);
            }
        }
    }

    public static double[][] TransposeMatriks(double[][] Matriks) {
        double[][] Mout = new double[Matriks.length][Matriks[0].length];
        for (int i = 0; i < Matriks.length; i++) {
            for (int j = 0; j < Matriks.length; j++) {
                Mout[i][j] = Matriks[j][i];
            }
        }
        return Mout;
    }

    public static void InverseMatriks(double[][] Matriks) {
        if (Matriks.length != 1) {
            if (IsSquare(Matriks)) {
                double det;
                det = Determinan(Matriks);
                double[][] temp1 = new double[Matriks.length][Matriks[0].length];
                double[][] temp2 = new double[Matriks.length][Matriks[0].length];
                if (det == 0){
                    System.out.println("Tidak ada invers");
                    for(int k = 0; k < Matriks.length; k++)
                    {
                        for (int l = 0; l < Matriks[0].length; l++){
                            Matriks[k][l] = -Double.MAX_VALUE;
                        }
                    }
                }
                else {
                    temp1 = MinorMatriks(Matriks);
                    KofaktorMatriks(temp1);
                    temp1 = TransposeMatriks(temp1);
                    for (int i = 0; i < Matriks.length; i++) {
                        for (int j = 0; j < Matriks.length; j++) {
                            temp2[i][j] = (1 / Determinan(Matriks)) * temp1[i][j];
                        }
                    }
                    for (int i = 0; i < Matriks.length; i++) {
                        for (int j = 0; j < Matriks.length; j++) {
                            Matriks[i][j] = temp2[i][j];
                        }
                    }
                }
            } else {
                System.out.println("Matrix tidak persegi");
                for(int k = 0; k < Matriks.length; k++)
                {
                    for (int l = 0; l < Matriks[0].length; l++){
                        Matriks[k][l] = -Double.MAX_VALUE;
                    }
                }
            }
        } 
    }

    public static String[] SPL(double[][] Matriks) {
        double[][] matriksA = new double[Matriks.length][Matriks[0].length - 1]; 
        double[] Baris = new double[Matriks.length]; 

        // membentuk matrix koefisien dari persamaan linier 
        matrix.copyMatrix(matriksA, Matriks);
        
        // membentuk matrix hasil masing-masing persamaan
        for (int x = 0; x < Matriks.length; x++){
            Baris[x] = Matriks[x][Matriks[0].length - 1];
        }

        InverseMatriks(matriksA);

        if (matriksA[0][0] != -Double.MAX_VALUE){
            double[] Hasil = new double[matriksA.length];
            String[] akhir = new String[matriksA.length];
            for (int i = 0; i < matriksA.length; i++) {
                double total = 0;
                for (int j = 0; j < matriksA.length; j++) {
                    total += matriksA[i][j] * Baris[j];
                }
                Hasil[i] = total;
            }
            for (int i = 0; i < Hasil.length; i++) {
                akhir[i] = (String.format("x%d = %,.2f", i + 1, Hasil[i]));
            }
            return akhir;
        } else {
            String[] akhir = new String[1];
            akhir[0] = "Solusi bisa jadi tidak ada atau memiliki solusi banyak, tidak dapat diselesaikan dengan matriks balikan";

            return akhir;
        }
    }

    // public static void main(String[] args) {
    //     double[][] m1;
    //     double[] baris;
    //     String[] l2;
    //     m1 = InputMatrix();
    //     InverseMatriks(m1);
    //     baris = InputBaris();
    //     l2 = SPL(m1, baris);
    //     for (int i = 0; i < l2.length; i++) {
    //         System.out.println(String.format("%s", l2[i]));
    //     }
    // }

    public static void reductionInverse(double[][] Matriks) {
        if (Matriks.length != 1) {
            double[][] temp = new double[Matriks.length][2 * Matriks[0].length];
            for(int i = 0; i < Matriks.length; i++) {
                for(int j = 0; j < Matriks.length; j++){
                    temp[i][j] = Matriks[i][j];
                }
            }
            for(int j = 0; j < Matriks.length; j++){
                temp[j][Matriks.length + j] = 1.0;
            }
            reductionPlus.Reduction(temp);
            reductionPlus.MakeRowOne(temp);
            reductionPlus.SecondaryReduction(temp);
            
            boolean exists = true;
            int m = 0;
            while (exists && m < temp.length){
                if(temp[m][m] != 1){
                    for(int k = 0; k < Matriks.length; k++)
                    {
                        for (int l = 0; l < Matriks[0].length; l++){
                            Matriks[k][l] = -Double.MAX_VALUE;
                        }
                    }
                    exists =false;
                }
                m++;
            }
            if (exists){
                for(int i = 0; i < Matriks.length; i++){
                    for(int j = 0; j < Matriks.length; j++){
                        Matriks[i][j] = temp[i][Matriks.length+j];
                    }
                }
            }
        }
    }
}