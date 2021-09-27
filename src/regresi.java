public class regresi{

    // matriks temp bakal di gaussin entar :) gua mati lampu lagiiii, entar gua lanjutin dah
    public static void regresiLinierBerganda(double[][] matriks) {
        double[][] temp = new double[matriks[0].length][matriks[0].length + 1];
        temp[0][0] = matriks.length;
        for (int i = 1; i < temp.length; i++ ){
            for(int j = 1; j < temp[0].length; j++){
                double sum = 0;
                for(int k = 0; k < matriks.length; k++){
                    sum += matriks[k][i-1] * matriks[k][j-1];
                }
                temp[i][j] = sum;
            }
        }
        for (int i = 1; i < temp[0].length; i++){
            double sum = 0;
                for(int k = 0; k < matriks.length; k++){
                    sum += matriks[k][i-1];
                }
            temp[0][i] = sum;
        }
        for (int i = 1; i < temp.length; i++){
            double sum = 0;
                for(int k = 0; k < matriks.length; k++){
                    sum += matriks[k][i-1];
                }
            temp[i][0] = sum;
        }
        double[] hasil = kofaktorPlus.cramer(temp);
        String[] output = kofaktorPlus.cramerToString(hasil);
        inputKeyboard.outputJawabanSPL(output);
    }
}