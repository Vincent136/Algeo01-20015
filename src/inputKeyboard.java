public class inputKeyboard {
    public static double[][] inputKeyboardSplSquare(){
        int n;
        double[][] matriks;
        double[][] matriksB;
        double[][] matriksAug;
        System.out.print("Masukan row & kolom: ");
        n = menu.scan.nextInt();
        if (n <= 0){
            boolean isValid = false;
            while(!isValid){
                System.out.println("Masukan tidak boleh kurang dari sama dengan 0! ulangi!");
                System.out.print("Masukan n: ");
                n = menu.scan.nextInt();
                if (n > 0) {
                    isValid = true;
                }
            }
        }
        

        matriks = new double[n][n];
        
        System.out.println("Masukkan matriks a!");
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                matriks[i][j] = menu.scan.nextDouble();
            }
        }
        
        matriksB = new double[n][1];
        
        System.out.println("Masukkan matriks b!");
        for(int i = 0; i < n; i++){
            matriksB[i][0] = menu.scan.nextDouble();
        }

        matriksAug = new double[n][n + 1];

        for (int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                matriksAug[i][j] =  matriks[i][j];
            }
            matriksAug[i][n] =  matriksB[i][0];
        }
        return matriksAug;
    }

    public static double[][] inputKeyboardSpl(){
        int n;
        int m;
        double[][] matriks;
        double[][] matriksB;
        double[][] matriksAug;
        System.out.print("Masukan row: ");
        n = menu.scan.nextInt();
        if (n <= 0){
            boolean isValid = false;
            while(!isValid){
                System.out.println("Masukan tidak boleh kurang dari sama dengan 0! ulangi!");
                System.out.print("Masukan n: ");
                n = menu.scan.nextInt();
                if (n > 0) {
                    isValid = true;
                }
            }
        }
        System.out.print("Masukan kolom: ");
        m = menu.scan.nextInt();
        if (m <= 0){
            boolean isValid = false;
            while(!isValid){
                System.out.println("Masukan tidak boleh kurang dari sama dengan 0! ulangi!");
                System.out.print("Masukan m: ");
                m = menu.scan.nextInt();
                if (m > 0) {
                    isValid = true;
                }
            }
        }
        
        matriks = new double[n][n];
        
        System.out.println("Masukkan matriks a!");
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                matriks[i][j] = menu.scan.nextDouble();
            }
        }
        
        matriksB = new double[n][1];
        
        System.out.println("Masukkan matriks b!");
        for(int i = 0; i < n; i++){
            matriksB[i][0] = menu.scan.nextDouble();
        }

        matriksAug = new double[n][n + 1];

        for (int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                matriksAug[i][j] =  matriks[i][j];
            }
            matriksAug[i][n] =  matriksB[i][0];
        }

        return matriksAug;
    }

    public static double[][] inputKeyboardDeterminan (){
        int n;
        double[][] matriks;

        System.out.print("Masukan row & kolom: ");
        n = menu.scan.nextInt();
        if (n <= 0){
            boolean isValid = false;
            while(!isValid){
                System.out.println("Masukan tidak boleh kurang dari sama dengan 0! ulangi!");
                System.out.print("Masukan n: ");
                n = menu.scan.nextInt();
                if (n > 0) {
                    isValid = true;
                }
            }
        }
        
        matriks = new double[n][n];
        
        System.out.println("Masukkan matriks a!");
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                matriks[i][j] = menu.scan.nextDouble();
            }
        }
        return matriks;
    }

    public static double[][] inputKeyboardInterpolasi (){
        int n;
        double[][] matriks;

        System.out.print("Masukan jumlah titik: ");
        n = menu.scan.nextInt();
        if (n <= 0){
            boolean isValid = false;
            while(!isValid){
                System.out.println("Masukan tidak boleh kurang dari sama dengan 0! ulangi!");
                System.out.print("Masukan n: ");
                n = menu.scan.nextInt();
                if (n > 0) {
                    isValid = true;
                }
            }
        }
        System.out.println("Masukkan semua titik!");
        matriks = new double[n][2];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < 2; j++){
                matriks[i][j] = menu.scan.nextDouble();
            }
        }
        
        return matriks;
    }


    public static double[][] inputKeyboardRegresi (){
        int n;
        int k;
        double[][] matriks;

        System.out.print("Masukan jumlah peubah : ");
        n = menu.scan.nextInt();
        
        if (n <= 0){
            boolean isValid = false;
            while(!isValid){
                System.out.println("Masukan tidak boleh kurang dari sama dengan 0! ulangi!");
                System.out.print("Masukan n: ");
                n = menu.scan.nextInt();
                if (n > 0) {
                    isValid = true;
                }
            }
        }

        System.out.print("Masukan jumlah persamaan: ");
        k = menu.scan.nextInt();
        if (k <= 0){
            boolean isValid = false;
            while(!isValid){
                System.out.println("Masukan tidak boleh kurang dari sama dengan 0! ulangi!");
                System.out.print("Masukan k: ");
                k = menu.scan.nextInt();
                if (k > 0) {
                    isValid = true;
                }
            }
        }

        System.out.println("masukan tiap baris nilai x dan y!");
        matriks = new double[k][n+1];
        for(int i = 0; i < k; i++){
            for(int j = 0; j < n+1; j++){
                matriks[i][j] = menu.scan.nextDouble();
            }
        }
        
        return matriks;
    }

    public static void outputJawabanSPL (String[] array){
        System.out.println();
        System.out.println("SPL:");
        for (int i = 0; i < array.length; i++){
            System.out.println(array[i]);
        }
        System.out.println();
    }
}
