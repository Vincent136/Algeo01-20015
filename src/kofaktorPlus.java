public class kofaktorPlus{

    // Fungsi matriks membentuk matriks minor untuk titik (a,b) dari Matriks1 dan di simpan dalam Matriks2
    public static void potongMatriks(double[][] Matriks1, double[][] Matriks2,int a, int b){
        int x = 0;
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
    }

    // fungsi untuk mengecek matriks merupakan matriks kotak (jumlah baris = jumlah kolom)
    public static boolean IsSquare(double[][] Matrix) {
        for (int i = 0, l = Matrix.length; i < l; i++) {
            if (Matrix[i].length != l) {
                return false;
            }
        }
        return true;
    }

    // fungsi menerima Matriks berisi nilai real dan mengeluarkan determinan dari Matriks
    public static double determinankofaktor(double[][]Matriks){
        double determinan;
        if(IsSquare(Matriks)){
            double[][] potong = new double[Matriks.length-1][Matriks[0].length -1];
            if (Matriks.length == 1) {
                determinan = Matriks[0][0];
            } else {
                determinan = 0;
                int plusminus = 1;
                for(int i = 0; i < Matriks.length; i++){
                    potongMatriks(Matriks,potong, 0, i);
                    determinan = determinan + plusminus * Matriks[0][i] * determinankofaktor(potong);
                    plusminus = -plusminus;
                }
            }
            return determinan;
        } else {
            return 0.0;
        }
    }

    // fungsi memasukan matrix b dengan ukuran kolom 1 ke dalam matriksA dengan kolom k
    public static void replaceWithB(int k, double[][] matriksNew, double[][] matriksB, double[][] matriksA){
        for (int i = 0; i < matriksNew.length; i++){
            for(int j = 0; j < matriksNew.length; j++){
                matriksNew[i][j] =  matriksA[i][j];
            }
        }
        for (int i = 0; i < matriksNew.length; i++){
                matriksNew[i][k] = matriksB[i][0]; 
        }
    }

    // fungsi menerima matriks augmented dan mengeluarkan array berisi spl x ke-i dengan i adalah indeks pada array
    public static double[] cramer(double[][] matriks) {
        double[][] matriksA = new double[matriks.length][matriks[0].length - 1]; 
        double[][] matriksB = new double[matriks.length][1]; 

        // membentuk matrix koefisien dari persamaan linier 
        matrix.copyMatrix(matriksA, matriks);
        
        // membentuk matrix hasil masing-masing persamaan
        for (int x = 0; x < matriks.length; x++){
            matriksB[x][0] = matriks[x][matriks[0].length - 1];
        }

        // realisasi spl dengan menggunakan kaidah cramer
        double detMatA = determinankofaktor(matriksA);
        double[] spl = new double[matriksA.length];
        if (detMatA != 0 && IsSquare(matriksA)){
            double detMatCramer;
            double[][] matriksCramer = new double[matriksA.length][matriksA.length];
            for(int k = 0; k < matriksA.length; k++)
            {
                replaceWithB(k, matriksCramer, matriksB, matriksA);
                detMatCramer = determinankofaktor(matriksCramer);
                spl[k] = detMatCramer / detMatA;
            }
            return spl;
        } else {
            for(int k = 0; k < matriksA.length; k++)
            {
                spl[k] = -Double.MAX_VALUE;
            }
            return spl;
        } 
    }

    public static String[] cramerToString(double[] list) {
        boolean notValid = true;
        int i=0;
        while(notValid && i < list.length) {
            if(list[i] != -Double.MAX_VALUE) {
                notValid = false;
            }
            i++;
        }
        if (!notValid) {
            String[] hasil = new String[list.length];
            for (int j = 0; j < list.length; j++) {
                hasil[j] = ("X" + (j + 1) + "=" + String.format("%.4f", list[j]));
            }
            return hasil;
        } else {
            String[] hasil = new String[1];
            hasil[0] = "Solusi bisa jadi tidak ada atau memiliki solusi banyak, tidak dapat diselesaikan dengan crammer";
            return hasil;
        }
    }
}