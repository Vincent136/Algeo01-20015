import javax.swing.text.AbstractDocument.LeafElement;
public class reductionPlus{
    public static void main(String[] args) {
        double[][] Matriks = InputOutput.ReadMatrixFromFile();
        Reduction(Matriks);
        matrix.tulisMatrix(Matriks);
        System.out.println("\n");
        MakeRowOne(Matriks);
        matrix.tulisMatrix(Matriks);
        SecondaryReduction(Matriks);
        matrix.tulisMatrix(Matriks);
    }
    //Merubah matrix diinput menjadi matrix yg bawahnya doang 0 0 0.
    //Contoh:   1 2 3       1 2 3
    //          4 5 6 ->    0 -3 -6
    //          7 8 11      0 0 2
    public static void Reduction(double [][] Matriks){
        double  Multiplier;
        int c_alternative;
        int konts = 1;
        int loop;
        if(Matriks.length<Matriks[0].length){
            loop = Matriks.length;
        }
        else{
            loop = Matriks[0].length;
        }
        for (int c = 0; c < loop; c++){
            c_alternative = c;
            if (Matriks[c + konts-1][c] == 0){
                int i=0;
                while (c+i < Matriks.length){
                    if(Matriks[c+i][c] == 0){
                        i++;
                    }
                    else{
                        break;
                    }
                }
                if (c+i != Matriks.length){
                    SwapRow(Matriks,c, c+i);
                }
                else{
                    c_alternative = 100000000;
                }
            }
            if (c_alternative == 100000000){
                konts = konts -1;
            }
            for (int r = c_alternative + konts; r < Matriks.length; r++) {
                Multiplier = Matriks[r][c]/Matriks[c+konts-1][c];
                for (int y = 0; y < Matriks[0].length; y++) {
                    Matriks[r][y] = Matriks[r][y] - Multiplier * Matriks[c+konts-1][y];
                }
            }
        }
    }
   
    //Menukar row a dengan b
    public static void SwapRow(double [][] Matriks,int a,int b) {
        double [] temp;
        temp = Matriks[a];
        Matriks[a] = Matriks[b];
        Matriks[b] = temp;
    }

    //print matrix
    public static void PrintMatriks(double [][] Matriks) {
        for (int r = 0; r < Matriks.length; r++) {
			for (int c = 0; c < Matriks[0].length; c++) {
				System.out.print(Matriks[r][c] + "\t");
			}
			System.out.println();
        }
    }
    
    //Membagi tiap row dengan bilangan paling kiri tak 0
    //Contoh:   9 18 9      1 2 1
    //          0 4 8 ->    0 1 2
    //          0 0 8       0 0 1
    public static void MakeRowOne(double [][] Matriks){
        double  divider;
        for (int r = 0; r < Matriks.length; r++) {
            int x=0;
            while (x < Matriks[0].length){
                if(Math.abs(Matriks[r][x]) < 0.0000000000001){
                    Matriks[r][x] = 0;
                }
                if(Matriks[r][x] == 0){
                    x++;
                }
                else{
                    break;
                }
            }
            if (x < Matriks[0].length){
                divider = Matriks[r][x];
                for (int c = 0; c < Matriks[0].length; c++) {
                    Matriks[r][c] = Matriks[r][c]/divider;
                }
            }
        }
    }

    //Merubah matrix diinput menjadi matrix yg atasnya doang 0 0 0.
    //I.S: udah direduksi dulu SecondaryReduction(Reduction())
    //Tidak perlu tetapi sebaiknya sudah di MakeRowOne terlebuh dahulu
    //Contoh:   9 9 9 10     9 0 0 1
    //          0 9 8 8 ->   0 9 0 0
    //          0 0 8 8      0 0 8 8
    public static void SecondaryReduction(double [][] Matriks){
        double  divider;
        for (int r = 1; r < Matriks.length; r++) {
            int x=0;
            while (x < Matriks[0].length){
                if(Matriks[r][x] == 0){
                    x++;
                }
                else{
                    break;
                }
            }
            if (x < Matriks[0].length){
                for (int y = r-1; y > -1 ; y--) {
                    if (Matriks[y][x] != 0){
                        divider = Matriks[y][x] / Matriks[r][x];
                        for (int c = 0; c < Matriks[0].length; c++) {
                            Matriks[y][c] = Matriks[y][c] - divider * Matriks[r][c];
                        }
                    }
                }
            }
        }
    }

    //Ngecheck if x is zero, returns true if yes
    public static boolean IsZero(double X) {
        if(X==0){
            return true;
        }
        return false;
    }
    
    //Ngecheck if x bagian dari array, returns true if yes
    public static boolean IsPartofArray(int x,int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if( x == arr[i]){
                return true;
            }
        }
        return false;
    }
    
    //Return the index where x is first found, if not found return -999
    public static int LocatedAtIndex(int x,int[] arr){
        for (int i = 0; i < arr.length; i++) {
            if(x == arr[i]){
                return i;
            }
        }
        return -999;
    }
    
    //Menggunakan Reduction, MakeRowOne untuk mengoutput hasil SPL 
    //dengan metode Eliminasi GaussJordan.
    //Input diasumsikan benar: MatriksAugmented dengan isi double.
    //Return string dengan isi jawaban
    //Note: If you are trying to understand the code, May God Help You, because i sure cant
    public static String[] SPLGauss(double [][] Matriks){
        Reduction(Matriks);
        MakeRowOne(Matriks);

        int non_zero_rows=0;    //Banyak row yang tidak kosong (nol)
        for (int r = 0; r < Matriks.length; r++) {
            int x=0;
            while (x < Matriks[0].length){
                if(Matriks[r][x] == 0){
                    x++;
                }
                else{
                    non_zero_rows+=1;
                    break;
                }
            }
        }

        boolean Validity = false;                               //Mengecheck kalau matrix augmented valid atau tidak 
        for (int j = 0; j < Matriks[0].length-1; j++) {
            if (Matriks[non_zero_rows-1][j] != 0){
                Validity = true;
            }
        }
        if (!Validity){                                         //Jika tidak valid mereturn string tidak ada solusi.
            String[] Hasil = new String[1];
            Hasil[0] = "Tidak ada solusi.";
            return Hasil;
        }
        if(non_zero_rows == Matriks[0].length-1){               //Jika kasus ideal, solusi unik.
            double[] Solusi = new double[Matriks.length];
            for (int i = Matriks.length-1; i >-1; i--) {
                Solusi[i] = Matriks[i][Matriks[0].length-1];
                for (int j = i+1; j <  Matriks[0].length-1; j++) {
                    Solusi[i] -= Matriks[i][j]*Solusi[j];
                }
            }

            String[] Hasil = new String[Matriks[0].length-1];
            for (int i = 0; i < Matriks[0].length-1; i++) {
                Hasil[i] = (String.format("x%d = %,.2f", i + 1, Solusi[i]));
            }
            return Hasil;
        }
        else{
            int[] lokasi_satu= new int[non_zero_rows];          //Lokasi indeks-indeks dari 1 primary, ordered
            for (int r = 0; r < non_zero_rows; r++) {
                int x=0;
                while (x < Matriks[0].length){
                    if(Matriks[r][x] == 0){
                        x++;
                    }
                    else{
                        lokasi_satu[r] = x;
                        break;
                    }
                }
            }
            char[] para = new char[Matriks[0].length-1];
            char isipara = 'a';
            for (int i = 0; i < para.length; i++) {
                para[i] = isipara;
                isipara++;
            }
            String[] Hasil = new String[Matriks[0].length-1];
            double[] adscounter = new double[Matriks[0].length-1];


            for (int c = 0; c < Matriks[0].length-1; c++) {    
                if (!IsPartofArray(c, lokasi_satu)){
                    Hasil[c] = (String.format("x%d = %c",c+1,para[c]));      
                }
                else{
                    Hasil[c]="";
                }
               
            }
            for (int r = lokasi_satu.length-1; r >-1; r--) {
                double temp;
                temp = Matriks[r][Matriks[0].length-1];
                int currentcol = lokasi_satu[r];

                for (int ccc = currentcol+1; ccc < Matriks[0].length-1; ccc++) {
                    adscounter[ccc] = Matriks[r][ccc];
                }
                for (int c = currentcol+1; c < Matriks[0].length-1; c++) {
                    if (IsPartofArray(c, lokasi_satu)){
                        if(!IsZero(Matriks[r][c])){
                            double multiplier = Matriks[r][c];
                            int reductorrow = LocatedAtIndex(c, lokasi_satu);
                            temp -= multiplier*Matriks[reductorrow][Matriks[0].length-1];
                            for (int cc = c+1; cc < Matriks[0].length-1; cc++) {
                            adscounter[cc] -= multiplier*Matriks[reductorrow][cc]; 
                            }
                        }
                    }
                    else{
                        if (adscounter[c] > 0){
                            Hasil[currentcol] += String.format(" -%,.2f%c",adscounter[c],para[c]);     //Contoh: " -3x3"
                        }
                        else if (adscounter[c] < 0) {
                            Hasil[currentcol] += String.format(" +%,.2f%c",-adscounter[c],para[c]);    //Contoh: " +3x3"
                        }
                    }
                }
                String temp2 = Hasil[currentcol];
                Hasil[currentcol] = (String.format("x%d = ",currentcol+1));
                Hasil[currentcol] += Double.toString(temp);
                Hasil[currentcol] += temp2;
            }
            return Hasil;
            }
        }
    
    //Menggunakan Reduction, MakeRowOne ,dan Secondary Reduction untuk mengoutput hasil SPL 
    //dengan metode Eliminasi GaussJordan.
    //Input diasumsikan benar: MatriksAugmented dengan isi double.
    //Return string dengan isi jawaban
    public static String[] SPLGaussJordan(double [][] Matriks){
        Reduction(Matriks);
        MakeRowOne(Matriks);
        SecondaryReduction(Matriks);
        
        int non_zero_rows=0;    //Banyak row yang tidak kosong (nol)
        for (int r = 0; r < Matriks.length; r++) {
            int x=0;
            while (x < Matriks[0].length){
                if(Matriks[r][x] == 0){
                    x++;
                }
                else{
                    non_zero_rows+=1;
                    break;
                }
            }
        }

        boolean Validity = false;                               //Mengecheck kalau matrix augmented valid atau tidak 
        for (int j = 0; j < Matriks[0].length-1; j++) {
            if (Matriks[non_zero_rows-1][j] != 0){
                Validity = true;
            }
        }
        if (!Validity){                                         //Jika tidak valid mereturn string tidak ada solusi.
            String[] Hasil = new String[1];
            Hasil[0] = "Tidak ada solusi.";
            return Hasil;
        }

        if(non_zero_rows == Matriks[0].length-1){              //Jika kasus ideal, solusi unik.
            String[] Hasil = new String[Matriks[0].length-1];
            for (int i = 0; i < Matriks[0].length-1; i++) {
                Hasil[i] = (String.format("x%d = %,.2f", i + 1, Matriks[i][Matriks[0].length-1]));
            }
            return Hasil;
        }
        else{                                                   //Jika kasus tidak ideal, solusi parametrik.
            char[] para = new char[Matriks[0].length-1];
            char isipara = 'a';
            for (int i = 0; i < para.length; i++) {
                para[i] = isipara;
                isipara++;
            }
            int[] lokasi_satu= new int[non_zero_rows];          //Lokasi indeks-indeks dari 1 primary
            for (int r = 0; r < non_zero_rows; r++) {
                int x=0;
                while (x < Matriks[0].length){
                    if(Matriks[r][x] == 0){
                        x++;
                    }
                    else{
                        lokasi_satu[r] = x;
                        break;
                    }
                }
            }

            String[] Hasil = new String[Matriks[0].length-1];    
            int currentrow = 0;        
            for (int i = 0; i < Matriks[0].length-1; i++) {             //Goes from index 0 till the last index(not counting augemnted)               
                if(IsPartofArray(i, lokasi_satu)){                       //if i = primary 1 index location
                    Hasil[i] =(String.format("x%d = %,.2f",i+1,Matriks[currentrow][Matriks[0].length-1])); //Contoh: "x1 = 4"
                    for (int j = i+1; j < Matriks[0].length-1; j++) {
                        if (Matriks[currentrow][j] > 0){
                            Hasil[i] += String.format(" -%,.2f%c",Matriks[currentrow][j],para[j]);     //Contoh: " -3x3"
                        }
                        else if (Matriks[currentrow][j] < 0) {
                            Hasil[i] += String.format(" +%,.2f%c",-Matriks[currentrow][j],para[j]);    //Contoh: " +3x3"
                        }
                    }
                    currentrow++;
                }
                else{                                                   //if not
                    Hasil[i] = (String.format("x%d = %c",i+1,para[i]));    //Contoh: "x7 = x7"
                }
            }    
            return Hasil;
        }
    }

    //Mereturn determinan dengan metode reduksi
    //Input diasumsikan benar: Matriks double berbentuk square 
    public static double DeterminanReduksi(double [][] Matriks){
        double  Determinan = 1;
        Reduction(Matriks);
        if (Matriks.length == Matriks[0].length){
            for (int i = 0; i < Matriks.length; i++) {
                Determinan = Determinan * Matriks[i][i];
            }
        }
        return Determinan;
    }
}
