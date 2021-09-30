import java.io.FileWriter; 
import java.io.IOException;

public class makeHilbert {
    public static void main(String[] args) {
        double[][] Hilbert6 = new double[6][7];
        for (int i = 0; i < Hilbert6.length; i++) {
            for (int j = 0; j < Hilbert6.length; j++) {
                double x=i;
                double y=j;
                Hilbert6[i][j] = 1/(x+y+1);
            }
        }
        Hilbert6[0][6] = 1;
        for (int i = 1; i < Hilbert6.length; i++) {
            Hilbert6[i][6] = 0;
        }
        try {
            String Isifile ="";
            for (int i = 0; i < Hilbert6.length; i++) {
                for (int j = 0; j < Hilbert6[0].length; j++) {
                    Isifile += Double.toString(Hilbert6[i][j]);
                    if(j != Hilbert6[0].length){
                        Isifile+=" ";
                    }
                }
                if(i!=Hilbert6.length){
                    Isifile+="\n";
                }
            }
            FileWriter myWriter = new FileWriter("../test/soal1dHilbert1.txt");
            myWriter.write(Isifile);
            myWriter.close();
            System.out.println("File sudah ditulis");

        }catch (IOException e) {
            System.out.println("Terjadi Error");
            e.printStackTrace();
          }

        double[][] Hilbert10 = new double[10][11];
        for (int i = 0; i < Hilbert10.length; i++) {
            for (int j = 0; j < Hilbert10.length; j++) {
                double x=i;
                double y=j;
                Hilbert10[i][j] = 1/(x+y+1);
            }
        }
        Hilbert10[0][10] = 1;
        for (int i = 1; i < Hilbert10.length; i++) {
            Hilbert10[i][10] = 0;
        }
        try {
            String Isifile ="";
            for (int i = 0; i < Hilbert10.length; i++) {
                for (int j = 0; j < Hilbert10[0].length; j++) {
                    Isifile += Double.toString(Hilbert10[i][j]);
                    if(j != Hilbert10[0].length){
                        Isifile+=" ";
                    }
                }
                if(i!=Hilbert10.length){
                    Isifile+="\n";
                }
            }
            FileWriter myWriter = new FileWriter("../test/soal1dHilbert2.txt");
            myWriter.write(Isifile);
            myWriter.close();
            System.out.println("File sudah ditulis");

        }catch (IOException e) {
            System.out.println("Terjadi Error");
            e.printStackTrace();
          }
    }
}
