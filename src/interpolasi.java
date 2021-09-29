
public class interpolasi {
    public static double[][] eselonTereduksi(double[][] Matriks){
        reductionPlus.Reduction(Matriks);
        reductionPlus.MakeRowOne(Matriks);
        reductionPlus.SecondaryReduction(Matriks);
        return Matriks;
    }
    public static double[] interpolasiPolinom(double[][]matriks){
        //baca input x
        System.out.println();

        // mengubah input menjadi matriks persamaan linier
        double[][] matriksA = new double[matriks.length][matriks.length];
        double[][] matriksB = new double[matriks.length][1];
        double[][] matriksAug = new double[matriks.length][matriks.length + 1];
        for (int i = 0; i < matriks.length; i++){
            for(int j = 0; j < matriksA[0].length; j++){
                matriksA[i][j] = power(matriks[i][0], j);
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
        double[] hasilCramer = new double[temp.length];
        for (int i = 0; i < temp.length; i++){
            hasilCramer[i] = temp[i][temp[0].length-1];
        }


        // output persamaan interpolasi
        System.out.print("P" + (matriks.length - 1) + "(x) = ");

        boolean isAllZero = true;
        for (int i = 0; i < hasilCramer.length; i++){
            if (i == 0) {
                if (hasilCramer[i] != 0){
                    System.out.print(String.format("%.4f", hasilCramer[i]));
                    isAllZero = false;
                }
            } else if(i == 1) {
                if (!isAllZero){
                    if (hasilCramer[i] != 0){
                        if (hasilCramer[i] > 0) {
                            System.out.print(" + " + String.format("%.4f", hasilCramer[i]) + " x");
                        } else if(hasilCramer[i] < 0) {
                            System.out.print(" - " + String.format("%.4f", -hasilCramer[i]) + " x");
                        }
                        isAllZero = false;
                    } 
                } else {
                    if (hasilCramer[i] != 0){
                        System.out.print(String.format("%.4f", hasilCramer[i]) + " x");
                        isAllZero = false;
                    }
                }
            } else {
                if (!isAllZero){
                    if (hasilCramer[i] > 0) {
                        System.out.print(" + " + String.format("%.4f", hasilCramer[i]) + "x^" + i);
                    } else if(hasilCramer[i] < 0) {
                        System.out.print(" - " + String.format("%.4f", -1 * hasilCramer[i]) + "x^" + i);
                    }
                } else {
                    if (hasilCramer[i] != 0){
                        System.out.print(String.format("%.4f", hasilCramer[i]) + "x^" + i);
                        isAllZero = false;
                    }
                }
            }
        }
        System.out.println();
        return hasilCramer;
    }
        // print P(X) dengan X sesuai input dari user

    public static String[] outputInterpolasiKeyboard(double[] hasilCramer){
        System.out.println();

        // masukan jumlah x yang akan ditaksir
        int n;
        do{
            System.out.print("Masukkan jumlah x yang ingin di taksir:");
            while (!menu.scan.hasNextInt()) {
                System.out.println("Input tidak valid!");
                System.out.print("Masukkan jumlah x yang ingin di taksir:");
                menu.scan.next(); 
            }
            n = menu.scan.nextInt();
        } while (n <= 0);

        System.out.println();

        // masukan masing-masing x
        double[] x = new double[n];
        for (int i = 0; i < n; i++){
            System.out.print("Masukkan x:");
            while (!menu.scan.hasNextDouble()) {
                System.out.println("Input tidak valid!");
                System.out.print("Masukkan x: ");
                menu.scan.next(); 
            }
            x[i] = menu.scan.nextDouble();
        }
        System.out.println();

        // proses mendapatkan nilai y dari dari x yang ingin ditaksir
        double[] hasilInterpolasi = new double[n];
        for (int j = 0; j < n; j++){
            double sum = 0;
            for (int i = 0; i < hasilCramer.length; i++){
                sum = sum + hasilCramer[i] * power(x[j], i);
            }
            hasilInterpolasi[j] = sum;
        }

        for (int k = 0; k < n; k++){
            System.out.println("P" + (hasilCramer.length - 1) + "(" + x[k] + ") = " + hasilInterpolasi[k]);
        }

        String[] output = new String[n];
        for (int l = 0; l < n; l++){
            output[l] = String.format("P" + (hasilCramer.length - 1) + "(" + x[l] + ") = " + hasilInterpolasi[l]);
        }

        System.out.println();

        return output;
    }

    public static String[] outputInterpolasiFile(double[] hasilCramer, double[][] file){
        System.out.println();

        int n = file.length;
        double[] x = new double[n];
        for (int i = 0; i < n; i++){
            x[i] = file[i][0];
        }
        double[] hasilInterpolasi = new double[n];
        for (int j = 0; j < n; j++){
            double sum = 0;
            for (int i = 0; i < hasilCramer.length; i++){
                sum = sum + hasilCramer[i] * power(x[j], i);
            }
            hasilInterpolasi[j] = sum;
        }

        for (int k = 0; k < n; k++){
            System.out.println("P" + (hasilCramer.length - 1) + "(" + x[k] + ") = " + hasilInterpolasi[k]);
        }

        String[] output = new String[n];
        for (int l = 0; l < n; l++){
            output[l] = String.format("P" + (hasilCramer.length - 1) + "(" + x[l] + ") = " + hasilInterpolasi[l]);
        }

        System.out.println();

        return output;
    }

    private static double power(double x, int y) {
        double result = 1; 
        for (int i = 0; i < y; i++) 
        { result = result * x; } 
        return result; 
    }
}
