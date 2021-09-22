import java.util.Scanner;

public class splCramer{
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
        double detMatA = determinanKofaktor.determinankofaktor(matriksA);
        double detMatCramer;
        double[][] matriksCramer = new double[matriksA.length][matriksA.length];
        double[] spl = new double[matriksA.length];
        while (k < matriksA.length){
            replaceWithB(k, matriksCramer, matriksB, matriksA);
            detMatCramer = determinanKofaktor.determinankofaktor(matriksCramer);
            spl[k] = detMatCramer / detMatA;
            k++;
        }
        for (int i = 0; i < matriksA.length; i++) {
            System.out.println("X" + (i + 1) + "=" + spl[i]);
        }
    }
}