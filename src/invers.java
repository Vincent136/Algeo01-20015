import java.util.Scanner;

class invers {

    public static double[][] InputMatrix() {
        System.out.println("Please enter the rows in the Matriks");
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        System.out.println("Please enter the columns in the Matriks");
        int column = sc.nextInt();

        double[][] Matriks = new double[row][column];

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                System.out.println(String.format("Enter Matriks[%d][%d] integer", r, c));
                Matriks[r][c] = sc.nextInt();
            }
        }
        sc.close();
        return Matriks;
    }

    public static void PrintMatrix(double[][] Matriks) {
        for (int i = 0; i < Matriks.length; i++) {
            for (int j = 0; j < Matriks.length; j++) {
                System.out.print(Matriks[i][j] + " ");
            }
            System.out.print("\n");
        }
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
        double det;
        det = Determinan(Matriks);
        double[][] temp1 = new double[Matriks.length][Matriks[0].length];
        double[][] temp2 = new double[Matriks.length][Matriks[0].length];
        if (det == 0)
            System.out.println("Tidak ada invers");
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
            PrintMatrix(Matriks);
        }
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

    public static void SPL(double[][] Matriks) {

    }

    public static void main(String[] args) {
        double[][] m1;
        m1 = InputMatrix();
        // x = Determinan(m1);
        // System.out.println(x);
        // // PrintMatrix(m1);
        // m2 = MinorMatriks(m1);
        // KofaktorMatriks(m2);
        // // PrintMatrix(m2);
        // m3 = TransposeMatriks(m2);
        // PrintMatrix(m3);
        InverseMatriks(m1);
    }
}