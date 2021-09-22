public class determinanKofaktor {
    public static void potongMatriks(float[][] Matriks1, float[][] Matriks2,int a, int b){
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

    public static float determinankofaktor(float[][]Matriks){
        float determinan;
        float[][] potong = new float[Matriks.length-1][Matriks[0].length -1];
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
}
