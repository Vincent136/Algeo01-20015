import java.util.Scanner;


public class menu {
    public static final Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        boolean keluar = false;
        while (!keluar){
            int choice;

            System.out.println();
            System.out.println("Menu");
            System.out.println("1. Sistem Persamaan Linier");
            System.out.println("2. Determinan");
            System.out.println("3. Matriks balikan");
            System.out.println("4. Interpolasi Polinom");
            System.out.println("5. Regresi Linier Berganda");
            System.out.println("6. Keluar");

            System.out.print("Masukan pilihan : ");

            choice = scan.nextInt();
            if (choice == 1) {                              //SPL
                System.out.println();
                System.out.println("Menu");
                System.out.println("1. Gauss");
                System.out.println("2. Gauss Jordan");
                System.out.println("3. Matriks Balikan");
                System.out.println("4. Cramer");

                System.out.print("Masukan pilihan : ");

                choice = scan.nextInt();
                if (choice == 1) {                           //SPLGauss
                    System.out.println();
                    System.out.println("Menu");
                    System.out.println("1. Input keyboard");
                    System.out.println("2. Input file");
                    System.out.print("Masukan pilihan : ");

                    choice = scan.nextInt();  
                    System.out.println();

                    if (choice == 1) {                      //SPLGauss Keyboard
                        double[][] M = inputKeyboard.inputKeyboardSpl();
                        String[] akhir = reductionPlus.SPLGauss(M);
                        inputKeyboard.outputJawabanSPL(akhir);
                        if(InputOutput.DoYouWantToWriteToFile()){
                            InputOutput.WriteToFile(akhir);
                        }
                    } else if (choice == 2) {               //SPLGauss File
                        double[][] M = InputOutput.ReadMatrixFromFile();
                        String[] akhir = reductionPlus.SPLGauss(M);
                        inputKeyboard.outputJawabanSPL(akhir);
                        if(InputOutput.DoYouWantToWriteToFile()){
                            InputOutput.WriteToFile(akhir);
                        }
                    }
                } else if (choice == 2){                    //SPLGaussJordan
                    System.out.println();
                    System.out.println("Menu");
                    System.out.println("1. Input keyboard");
                    System.out.println("2. Input file");
                    System.out.print("Masukan pilihan : ");

                    choice = scan.nextInt();  
                    System.out.println();

                    if (choice == 1) {                      //SPLGaussJordan Keyboard
                        double[][] M = inputKeyboard.inputKeyboardSpl();
                        String[] akhir = reductionPlus.SPLGaussJordan(M);
                        inputKeyboard.outputJawabanSPL(akhir);
                        if(InputOutput.DoYouWantToWriteToFile()){
                            InputOutput.WriteToFile(akhir);
                        }
                    } else if (choice == 2) {               //SPLGaussJordan File
                        double[][] M = InputOutput.ReadMatrixFromFile();
                        String[] akhir = reductionPlus.SPLGaussJordan(M);
                        inputKeyboard.outputJawabanSPL(akhir);
                        if(InputOutput.DoYouWantToWriteToFile()){
                            InputOutput.WriteToFile(akhir);
                        }
                    }
                } else if (choice == 3) {                   //SPLMatriksBalikan
                    System.out.println();
                    System.out.println("Menu");
                    System.out.println("1. Input keyboard");
                    System.out.println("2. Input file");
                    System.out.print("Masukan pilihan : ");

                    choice = scan.nextInt();  
                    System.out.println();
                    if (choice == 1) {                      //SPLMatriksBalikan Keyboard
                        double[][] M = inputKeyboard.inputKeyboardSplSquare();
                        String[] akhir = invers.SPL(M);
                        inputKeyboard.outputJawabanSPL(akhir);
                        if(InputOutput.DoYouWantToWriteToFile()){
                            InputOutput.WriteToFile(akhir);
                        }
                    } else if (choice == 2) {               //SPLMatriksBalikan File
                        double[][] M = InputOutput.ReadMatrixFromFile();
                        String[] akhir = invers.SPL(M);
                        inputKeyboard.outputJawabanSPL(akhir);
                        if(InputOutput.DoYouWantToWriteToFile()){
                            InputOutput.WriteToFile(akhir);
                        }
                    }
                }else if (choice == 4) {                    //SPLCramer
                    System.out.println();
                    System.out.println("Menu");
                    System.out.println("1. Input keyboard");
                    System.out.println("2. Input file");
                    System.out.print("Masukan pilihan : ");

                    choice = scan.nextInt();  
                    System.out.println();

                    if (choice == 1) {                      //SPLCramer Keyboard
                        double[][] M = inputKeyboard.inputKeyboardSplSquare();
                        double[] hasil = kofaktorPlus.cramer(M);
                        String[] akhir = kofaktorPlus.cramerToString(hasil);
                        inputKeyboard.outputJawabanSPL(akhir);
                        if(InputOutput.DoYouWantToWriteToFile()){
                            InputOutput.WriteToFile(akhir);
                        }
                    } else if (choice == 2) {               //SPLCramer File
                        double[][] M = InputOutput.ReadMatrixFromFile();
                        double[] hasil = kofaktorPlus.cramer(M);
                        String[] akhir = kofaktorPlus.cramerToString(hasil);
                        inputKeyboard.outputJawabanSPL(akhir);
                        if(InputOutput.DoYouWantToWriteToFile()){
                            InputOutput.WriteToFile(akhir);
                        }
                    }
                }
            }
            else if (choice == 2) {                         //Determinan
                System.out.println();
                System.out.println("Menu");
                System.out.println("1. Reduksi");
                System.out.println("2. Kofaktor");
                System.out.print("Masukan pilihan : ");

                choice = scan.nextInt();   
                if (choice == 1) {                          //DeterminanReduksi
                    System.out.println();
                    System.out.println("Menu");
                    System.out.println("1. Input keyboard");
                    System.out.println("2. Input file");
                    System.out.print("Masukan pilihan : ");

                    choice = scan.nextInt();  
                    System.out.println();

                    if (choice == 1) {                      //DeterminanReduksi Keyboard
                        double[][] M = inputKeyboard.inputKeyboardDeterminan();
                        System.out.println("Determinan matriks = " + reductionPlus.DeterminanReduksi(M));
                    } else if (choice == 2) {               //DeterminanReduksi File
                        double[][] M = InputOutput.ReadMatrixFromFile();
                        System.out.println("Determinan matriks = " + reductionPlus.DeterminanReduksi(M));
                    }
                } else if (choice == 2) {                   //DeterminanReduksi Kofaktor
                    System.out.println();
                    System.out.println("Menu");
                    System.out.println("1. Input keyboard");
                    System.out.println("2. Input file");
                    System.out.print("Masukan pilihan : ");

                    choice = scan.nextInt();  
                    System.out.println();

                    if (choice == 1) {                      //DeterminanReduksi Kofaktor Keyboard
                        double[][] M = inputKeyboard.inputKeyboardDeterminan();
                        System.out.println("Determinan matriks = " + kofaktorPlus.determinankofaktor(M));
                    } else if (choice == 2) {               //DeterminanReduksi Kofaktor File
                        double[][] M = InputOutput.ReadMatrixFromFile();
                        System.out.println("Determinan matriks = " + kofaktorPlus.determinankofaktor(M));
                    }
                }
            } 
            else if (choice == 3) {                         //Matriks Balikan
                System.out.println();
                System.out.println("Menu");
                System.out.println("1. Adjoin");
                System.out.println("2. Reduksi");
                System.out.print("Masukan pilihan : ");

                choice = scan.nextInt();  
                if(choice == 1) {
                    System.out.println();
                    System.out.println("Menu");
                    System.out.println("1. Input keyboard");
                    System.out.println("2. Input file");
                    System.out.print("Masukan pilihan : ");

                    choice = scan.nextInt();  
                    System.out.println();
                    if (choice == 1) {                          //MatriksBalikan Keyboard
                        double[][]M = inputKeyboard.inputKeyboardDeterminan();
                        invers.InverseMatriks(M);
                        System.out.println();
                        if (M[0][0] != -Double.MAX_VALUE){
                            System.out.println("matriks balikan :");
                            matrix.tulisMatrix(M);
                        } 
                    } else if (choice == 2) {                   //MatriksBalikan File
                        double[][]M = InputOutput.ReadMatrixFromFile();
                        invers.InverseMatriks(M);
                        if (M[0][0] != -Double.MAX_VALUE){
                            System.out.println();
                            System.out.println("matriks balikan :");
                            matrix.tulisMatrix(M);
                        } else {
                            System.out.println();
                            System.out.println("tidak punya invers.");
                        }
                    }
                } else if (choice == 2) {
                    System.out.println();
                    System.out.println("Menu");
                    System.out.println("1. Input keyboard");
                    System.out.println("2. Input file");
                    System.out.print("Masukan pilihan : ");

                    choice = scan.nextInt();  
                    System.out.println();
                    if (choice == 1) {                          //MatriksBalikan Keyboard
                        double[][]M = inputKeyboard.inputKeyboardDeterminan();
                        invers.InverseMatriks(M);
                        System.out.println();
                        if (M[0][0] != -Double.MAX_VALUE){
                            System.out.println();
                            System.out.println("matriks balikan :");
                            matrix.tulisMatrix(M);
                        } 
                    } else if (choice == 2) {                   //MatriksBalikan File
                        double[][]M = InputOutput.ReadMatrixFromFile();
                        invers.reductionInverse(M);
                        System.out.println();
                        if (M[0][0] != -Double.MAX_VALUE){
                            System.out.println();
                            System.out.println("matriks balikan :");
                            matrix.tulisMatrix(M);
                        } else {
                            System.out.println();
                            System.out.println("tidak punya invers.");
                        }
                    }
                }
            }
            else if (choice == 4) {                         //Interpolasi Polinom
                System.out.println();
                System.out.println("Menu");
                System.out.println("1. Input keyboard");
                System.out.println("2. Input file");
                System.out.print("Masukan pilihan : ");

                choice = scan.nextInt();  
                System.out.println();

                if (choice == 1) {                          //Interpolasi Polinom Keyboard
                    double[][]Mi = inputKeyboard.inputKeyboardInterpolasi();
                    double[] awal = interpolasi.interpolasiPolinom(Mi);
                    String[] akhir = interpolasi.outputInterpolasiKeyboard(awal);
                    if(InputOutput.DoYouWantToWriteToFile()){
                        InputOutput.WriteToFile(akhir);
                    }
                } else if (choice == 2) {                   //Interpolasi Polinom File
                    double[][]Mi = InputOutput.ReadMatrixFromFile();
                    double[] awal = interpolasi.interpolasiPolinom(Mi);
                    System.out.println();
                    System.out.println("Masukan nama file berisi x!");
                    double[][] bacaX = InputOutput.ReadMatrixFromFile(); 
                    String[] akhir = interpolasi.outputInterpolasiFile(awal, bacaX);
                    if(InputOutput.DoYouWantToWriteToFile()){
                        InputOutput.WriteToFile(akhir);
                    }
                }
            }
            else if (choice == 5) {                         //Regresi Linear Berganda
                System.out.println();
                System.out.println("Menu");
                System.out.println("1. Input keyboard");
                System.out.println("2. Input file");
                System.out.print("Masukan pilihan : ");

                choice = scan.nextInt();
                System.out.println();

                if (choice == 1) {                          //Regresi Linear Berganda File
                    double[][]M = inputKeyboard.inputKeyboardRegresi();
                    double[]awal = regresi.regresiLinierBerganda(M);
                    String[]akhir = regresi.outputRegresiKeyboard(awal);
                    if(InputOutput.DoYouWantToWriteToFile()){
                        InputOutput.WriteToFile(akhir);
                    }
                } else if (choice == 2) {                   //Regresi Linear Berganda Keyboard
                    double[][]M = InputOutput.ReadMatrixFromFile();
                    double[]awal = regresi.regresiLinierBerganda(M);
                    System.out.println();
                    System.out.println("Masukan nama file berisi x!");
                    double[][] bacaX = InputOutput.ReadMatrixFromFile(); 
                    String[]akhir = regresi.outputRegresiFile(awal,bacaX);
                    if(InputOutput.DoYouWantToWriteToFile()){
                        InputOutput.WriteToFile(akhir);
                    }
                }
            }
            else if (choice == 6) {                         //Exit
                keluar = true;
                break;
            }
        }
        System.out.println();
        scan.close();
    }
}
