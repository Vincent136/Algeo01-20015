import java.lang.Math;

public class interpolasi {
    public static double[][] eselonTereduksi(double[][] Matriks){
        reductionPlus.Reduction(Matriks);
        reductionPlus.MakeRowOne(Matriks);
        reductionPlus.SecondaryReduction(Matriks);
        return Matriks;
    }
    public static void interpolasiPolinom(double[][]matriks){
        //baca input x
        System.out.println();

        // mengubah input menjadi matriks persamaan linier
        double[][] matriksA = new double[matriks.length][matriks.length];
        double[][] matriksB = new double[matriks.length][1];
        double[][] matriksAug = new double[matriks.length][matriks.length + 1];
        for (int i = 0; i < matriks.length; i++){
            for(int j = 0; j < matriksA[0].length; j++){
                matriksA[i][j] = Math.pow(matriks[i][0], j);
            }
        }

        for (int i = 0; i < matriks.length; i++){
            matriksB[i][0] = matriks[i][1];
        }

        for (int i = 0; i < matriksA.length; i++){
            for(int j = 0; j < matriksA[0].length; j++){
                matriksAug[i][j] =  matriksA[i][j];
            }
            matriksAug[i][matriksA[0].length] =  matriksB[i][0];
        }

        // proses interpolasi polinom
        double[][] temp = eselonTereduksi(matriksAug);
        double[] hasil = new double[temp.length];
        for (int i = 0; i < temp.length; i++){
            hasil[i] = temp[i][temp.length-1];
        }

        System.out.print("P" + (matriks.length - 1) + "(x) = ");

        boolean isAllZero = true;
        for (int i = 0; i < hasil.length; i++){
            if (i == 0) {
                if (hasil[i] != 0){
                    System.out.print(String.format("%.4f", hasil[i]));
                    isAllZero = false;
                }
            } else if(i == 1) {
                if (!isAllZero){
                    if (hasil[i] != 0){
                        if (hasil[i] > 0) {
                            System.out.print(" + " + String.format("%.4f", hasil[i]) + " x");
                        } else if(hasil[i] < 0) {
                            System.out.print(" - " + String.format("%.4f", -hasil[i]) + " x");
                        }
                        isAllZero = false;
                    } 
                } else {
                    if (hasil[i] != 0){
                        System.out.print(String.format("%.4f", hasil[i]) + " x");
                        isAllZero = false;
                    }
                }
            } else {
                if (!isAllZero){
                    if (hasil[i] > 0) {
                        System.out.print(" + " + String.format("%.4f", hasil[i]) + "x^" + i);
                    } else if(hasil[i] < 0) {
                        System.out.print(" - " + String.format("%.4f", -1 * hasil[i]) + "x^" + i);
                    }
                } else {
                    if (hasil[i] != 0){
                        System.out.print(String.format("%.4f", hasil[i]) + "x^" + i);
                        isAllZero = false;
                    }
                }
            }
        }
        System.out.println();

        // print P(X) dengan X sesuai input dari user

        double x;
        System.out.print("Masukan x: ");
        x = menu.scan.nextDouble();


        double sum = 0;
        for (int i = 0; i < hasil.length; i++){
            sum = sum + hasil[i] * Math.pow(x, i);
        }

        System.out.println("P" + (matriks.length - 1) + "(" + x + ") = " +String.format("%.4f", sum));

        System.out.println();
    }
}
