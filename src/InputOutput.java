import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter; 
import java.io.IOException;
import java.util.Scanner;


public class InputOutput {
    private static final Scanner scan = new Scanner(System.in);
    
    //Membaca matrixaugmented dari file dengan nama berdasarkan input
    //Input diasumsikan benar
    //Asumsi file ada isinya dan dalam bentuk matriks double:
    //Ex:   0 0 0.1
    //      0.3 2 4
    //      8 4 5
    // Returnnya matrix double
    // Kalau gagal, return matrix size 1x1 isinya -999
    public static double[][] ReadMatrixFromFile() {
        System.out.print("Masukan nama file: ");        //Nama File
        String File = scan.next();

        try { 
            Scanner  PanjangFile = new Scanner(new File("../test/"+File));
            String[] PanjangBaris = PanjangFile.nextLine().split(" ");

            int count =1;
            while (PanjangFile.hasNextLine()) {
                count++;
                PanjangFile.nextLine();
              }
            PanjangFile.close();

            int row = count;
            int column = PanjangBaris.length;
            double[][] Matriks = new double[row][column];

            Scanner IsiFile = new Scanner(new File("../test/"+File));
    
            for (int r = 0; r < row; r++) {
                for (int c = 0; c < column; c++) {
                    Matriks[r][c] = IsiFile.nextDouble();
                }
            }
            return Matriks;

        } catch (FileNotFoundException e) {
            System.out.print("File Tidak Ditemukan/Terjadi Error");
            double[][] MatriksInvalid = new double[0][0];
            MatriksInvalid[0][0] = -999;
            return MatriksInvalid;
        }
    }

    // Menanya kalau mau write to file, kalo yes return true, kalo no return false
    public static boolean DoYouWantToWriteToFile(){
        System.out.print("Apakah ingin di save di file?");  
        System.out.println("1.Yes");
        System.out.println("2.No");  
        int Option = scan.nextInt();
        
        while(Option != 1 && Option != 2 ){
            System.out.print("Input Salah!"); 
            System.out.println("Apakah ingin di save di file?");    
            System.out.println("1.Yes");
            System.out.println("2.No");
            Option = scan.nextInt();
        }
        if(Option == 1 ){
            return true;
        }
        else{
            return false;
        }
    }

    //Menulis (rewrite/create) MatriksofDouble ke file kosong dengan nama berdasarkan input
    //Input diasumsikan benar
    public static void WriteMatrixToFile(double[][] Matriks){
        try {
            System.out.print("Masukan nama file: ");    //Nama File
            String File = scan.next();
            
            String Isifile ="";
            for (int i = 0; i < Matriks.length; i++) {
                for (int j = 0; j < Matriks[0].length; j++) {
                    Isifile += Double.toString(Matriks[i][j]);
                    if(j != Matriks[0].length){
                        Isifile+=" ";
                    }
                }
                if(i!=Matriks.length){
                    Isifile+="\n";
                }
            }
            FileWriter myWriter = new FileWriter("../test/"+File);
            myWriter.write(Isifile);
            myWriter.close();
            System.out.println("File sudah ditulis");

        }catch (IOException e) {
            System.out.println("Terjadi Error");
            e.printStackTrace();
          }
    }

    //Menulis (rewrite/create) ArrayofString ke file kosong dengan nama berdasarkan input
    //Input diasumsikan benar
    public static void WriteToFile(String[] ArrayIsiFile){
        try {
            System.out.print("Masukan nama file: ");    //Nama File
            String File = scan.next();
            
            String Isifile ="";
            for (int i = 0; i < ArrayIsiFile.length; i++) {
                Isifile += ArrayIsiFile[i];
                if (i != ArrayIsiFile.length){
                    Isifile +="\n";
                }
            }

            FileWriter myWriter = new FileWriter("../test/"+File);
            myWriter.write(Isifile);
            myWriter.close();

            System.out.println("File sudah ditulis");

        }catch (IOException e) {
            System.out.println("Terjadi Error");
            e.printStackTrace();
          }
    }
}