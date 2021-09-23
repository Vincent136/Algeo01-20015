public class kofaktorPlus{
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

    public static double determinankofaktor(double[][]Matriks){
        double determinan;
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
    }

    public static void replaceWithB(int k, double[][] matriksNew, double[] matriksB, double[][] matriksA){
        for (int i = 0; i < matriksNew.length; i++){
            for(int j = 0; j < matriksNew.length; j++){
                matriksNew[i][j] =  matriksA[i][j];
            }
        }
        for (int i = 0; i < matriksNew.length; i++){
                matriksNew[i][k] = matriksB[i]; 
        }
    }

    public static void cramer(double[] matriksB, double[][] matriksA) {
        int k = 0;
        double detMatA = determinankofaktor(matriksA);
        double detMatCramer;
        double[][] matriksCramer = new double[matriksA.length][matriksA.length];
        double[] spl = new double[matriksA.length];
        while (k < matriksA.length){
            replaceWithB(k, matriksCramer, matriksB, matriksA);
            detMatCramer = determinankofaktor(matriksCramer);
            spl[k] = detMatCramer / detMatA;
            k++;
        }
        
        for (int i = 0; i < matriksA.length; i++) {
            System.out.println("X" + (i + 1) + "=" + spl[i]);
        }
    }
}