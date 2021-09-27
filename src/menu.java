import java.util.Scanner;


public class menu {
    public static final Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        boolean keluar = false;
        while (!keluar){
            int choice;
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
                        if(InputOutput.DoYouWantToWriteToFile()){
                            InputOutput.WriteToFile(akhir);
                        }
                    } else if (choice == 2) {               //SPLGauss File
                        double[][] M = InputOutput.ReadMatrixFromFile();
                        String[] akhir = reductionPlus.SPLGauss(M);
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
                        if(InputOutput.DoYouWantToWriteToFile()){
                            InputOutput.WriteToFile(akhir);
                        }
                    } else if (choice == 2) {               //SPLGaussJordan File
                        double[][] M = InputOutput.ReadMatrixFromFile();
                        String[] akhir = reductionPlus.SPLGaussJordan(M);
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
                        
                    } else if (choice == 2) {               //SPLMatriksBalikan File
                        
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
                        
                        if(InputOutput.DoYouWantToWriteToFile()){
                            InputOutput.WriteToFile(akhir);
                        }
                    } else if (choice == 2) {               //SPLCramer File
                        double[][] M = InputOutput.ReadMatrixFromFile();
                        double[] hasil = kofaktorPlus.cramer(M);
                        String[] akhir = kofaktorPlus.cramerToString(hasil);
                        
                        if(InputOutput.DoYouWantToWriteToFile()){
                            InputOutput.WriteToFile(akhir);
                        }
                    }
                }
            }
            else if (choice == 2) {                         //Determinan
                System.out.println("Menu");
                System.out.println("1. Reduksi");
                System.out.println("2. Kofaktor");
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
                        System.out.println("Determinan matriks = %.3f" + reductionPlus.DeterminanReduksi(M));
                    } else if (choice == 2) {               //DeterminanReduksi File
                        double[][] M = InputOutput.ReadMatrixFromFile();
                        System.out.println("Determinan matriks = %.3f" + reductionPlus.DeterminanReduksi(M));
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
                System.out.println("1. Input keyboard");
                System.out.println("2. Input file");
                System.out.print("Masukan pilihan : ");

                choice = scan.nextInt();  
                System.out.println();
                if (choice == 1) {                          //MatriksBalikan Keyboard
                    
                } else if (choice == 2) {                   //MatriksBalikan File
                    
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
                    String[] akhir = interpolasi.interpolasiPolinom(Mi);
                    if(InputOutput.DoYouWantToWriteToFile()){
                        InputOutput.WriteToFile(akhir);
                    }
                } else if (choice == 2) {                   //Interpolasi Polinom File
                    double[][]Mi = InputOutput.ReadMatrixFromFile();
                    String[] akhir = interpolasi.interpolasiPolinom(Mi);
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
                    regresi.regresiLinierBerganda(M);
                } else if (choice == 2) {                   //Regresi Linear Berganda Keyboard
                    
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
