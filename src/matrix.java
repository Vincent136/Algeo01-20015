public class matrix {
    public static void tulisMatrix(double[][] keluaran) {
        for (int i = 0; i < keluaran.length; i++) {
            for (int j = 0; j < keluaran[0].length; j++) {
                System.out.print(String.format("%.2f ", keluaran[i][j]));
            }
            System.out.println();
        }
    }
    
    public static void copyMatrix(double[][] Matriks1, double[][] Matriks2) {
        for (int i = 0; i < Matriks1.length; i++) {
            for (int j = 0; j < Matriks1[0].length; j++) {
                Matriks1[i][j] = Matriks2[i][j];
            }
        }
    }
}