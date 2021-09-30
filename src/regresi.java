public class regresi{

    // matriks temp bakal di gaussin entar :) gua mati lampu lagiiii, entar gua lanjutin dah
    public static double[] regresiLinierBerganda(double[][] matriks) {
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
        double[][] temp2 = interpolasi.eselonTereduksi(temp);
        double[] hasil = new double[temp2.length];
        for(int i = 0; i < temp2.length; i++) {
            hasil[i] = temp2[i][temp2[0].length-1];
        }
        
        
        System.out.println();
        System.out.print("Y = ");
        for(int i = 0; i < hasil.length; i++){
            if (i == 0) {
                if (hasil[i] != 0){
                    System.out.print(String.format("%.4f ", hasil[i]));
                }
            } else {
                if (hasil[i] < 0) {
                    System.out.print(String.format("- %.4f X%d", -hasil[i], i));
                } else if (hasil[i] > 0) {
                    System.out.print(String.format("+ %.4f X%d", hasil[i], i));
                }
            }
        }
        System.out.println();

        return hasil;
    }

    public static String[] outputRegresiKeyboard(double[]hasil){
        System.out.println();

        // masukan jumlah x yang akan ditaksir
        int n;
        int m = hasil.length-1;
        do{
            System.out.print("Masukkan jumlah i yang ingin di taksir:");
            while (!menu.scan.hasNextInt()) {
                System.out.println("Input tidak valid!");
                System.out.print("Masukkan jumlah i yang ingin di taksir:");
                menu.scan.next(); 
            }
            n = menu.scan.nextInt();
        } while (n <= 0);

        System.out.println();

        // masukan masing-masing x
        double[][] x = new double[n][m];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                System.out.print("Masukkan x" + (j+1) +" : ");
                while (!menu.scan.hasNextDouble()) {
                    System.out.println("Input tidak valid!");
                    System.out.print("Masukkan x" + (j+1) +" : ");
                    menu.scan.next(); 
                }
                x[i][j] = menu.scan.nextDouble();
            }
            System.out.println();
        }

        double[] hasilRegresi = new double[n];
        for (int k = 0; k < n ; k++){
            double Y = hasil[0];
            for (int j = 1; j < hasil.length; j++) {
                Y += x[k][j-1] * hasil[j];
            }
            hasilRegresi[k] = Y;
        }

        String[] output = new String[n];
        for (int l = 0; l < n; l++){
            System.out.println("Y = " + hasilRegresi[l]);
            output[l] = String.format("Y = " + hasilRegresi[l]);
        }

        System.out.println();

        return output;
    }

    public static String[] outputRegresiFile(double[]hasil, double[][]x){
        System.out.println();

        int n = x.length;

        double[] hasilRegresi = new double[n];
        for (int k = 0; k < n ; k++){
            double Y = hasil[0];
            for (int j = 1; j < hasil.length; j++) {
                Y += x[k][j-1] * hasil[j];
            }
            hasilRegresi[k] = Y;
        }

        String[] output = new String[n];
        for (int l = 0; l < n; l++){
            System.out.println("Y = " + hasilRegresi[l]);
            output[l] = String.format("Y = " + hasilRegresi[l]);
        }

        System.out.println();
        
        return output;
    }
}