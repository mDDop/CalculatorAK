import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ConsoleCalculator {
    public static void main(String[] args) {
        System.out.println("Witaj w kalkulatorze, podaj swoje dane do logowania:");
        ConsoleCalculator personCheck = new ConsoleCalculator();
        if (personCheck.personVerificate()) {
            int counter = 0;
            do {
                counter = ConsoleCalculator.choice();
            } while (counter == 0);
        }
    }

    public static boolean personVerificate() {
        Scanner idScanner = new Scanner(System.in);
        String login = "admin";
        String password = "admin2";

        int k = 0, j = 0;
        System.out.print("Podaj login: ");
        String userTextLogin = idScanner.nextLine();
        do {
            if (userTextLogin.compareTo(login) == 0) {
//                System.out.println("Poprawny login");
                k = 1;
                System.out.print("Podaj właściwe hasło: ");
                String userTextPassword = idScanner.nextLine();
                if (userTextPassword.compareTo(password) == 0) {
//                    System.out.println("Poprawne hasło");
                    j = 1;
                }
            } else {
                System.out.print("Login niepoprawny, podaj login: ");
                userTextLogin = idScanner.nextLine();
            }
        } while (k == 0 || j == 0);
        System.out.println("Zalogowano");
        return true;
    }

    public static Double[] stringToArrayInput(String sumCalcString) {
        String[] arrayStringValues = sumCalcString.split(" ");
        Double[] arrayDoubleValues = new Double[arrayStringValues.length];
        for (int i = 0; i < arrayStringValues.length; i++) {
            arrayDoubleValues[i] = Double.parseDouble(arrayStringValues[i]);
        }
        return arrayDoubleValues;
    }

    public static void sumResult(Double[] sumLastData) {
        Double sumScore = 0d;
        for (int i = 0; i < sumLastData.length; i++) {
            sumScore = sumScore + sumLastData[i];
        }
        System.out.println("Suma podanych liczb to: " + sumScore);
    }

    public static void substractResult(Double[] sumLastData) {
        Double sumScore = 0d;
        for (int i = 0; i < sumLastData.length; i++) {
            if (i == 0) {
                sumScore = sumLastData[i];
            } else {
                sumScore = sumScore - sumLastData[i];
            }
        }
        System.out.println("Różnica podanych liczb to: " + sumScore);
    }

    public static void multiplyResult(Double[] sumLastData) {
        Double sumScore = 0d;
        for (int i = 0; i < sumLastData.length; i++) {
            if (i == 0) {
                sumScore = sumLastData[i];
            } else {
                sumScore = sumScore * sumLastData[i];
            }
        }
        System.out.println("Iloczyn podanych liczb to: " + sumScore);
    }

    public static void divideResult(Double[] sumLastData) {
        Double sumScore = 0d;
        int k = 0;
        for (int i = 0; i < sumLastData.length; i++) {
            if (i == 0) {
                sumScore = sumLastData[i];
            } else {
                if (sumLastData[i] == 0) {
                    System.out.println("Dzielnik nie może być zerem!");
                    k = 1;
                    break;
                } else {
                    sumScore = sumScore / sumLastData[i];
                }
            }

        }
        if (k == 0) {
            System.out.println("Iloraz podanych liczb to: " + sumScore);
        }
    }

    public static void decimalToBinary(int sumLastData) {
        StringBuffer binary = new StringBuffer();
        do {
            if (sumLastData % 2 == 1) {
                binary.insert(0, "1");
                sumLastData = sumLastData / 2;
            } else if (sumLastData % 2 == 0) {
                binary.insert(0, "0");
                sumLastData = sumLastData / 2;
            }
        } while (sumLastData / 1 != 0);
        System.out.println("Liczba w systemie dwójkowym to: " + binary.toString());
    }

    public static void decimalToOktal(int sumLastData) {
        StringBuffer binary = new StringBuffer();
        do {
            binary.insert(0, sumLastData % 8);
            sumLastData = sumLastData / 8;
        } while (sumLastData / 1 != 0);
        System.out.println("Liczba w systemie oktalnym to: " + binary.toString());
    }

    public static void decimalToHeksadecimal(int sumLastData) {
        StringBuffer binary = new StringBuffer();
        do {
            if (sumLastData % 16 <= 9) {
                binary.insert(0, sumLastData % 16);
            } else if (sumLastData % 16 == 10) {
                binary.insert(0, "A");
            } else if (sumLastData % 16 == 11) {
                binary.insert(0, "B");
            } else if (sumLastData % 16 == 12) {
                binary.insert(0, "C");
            } else if (sumLastData % 16 == 13) {
                binary.insert(0, "D");
            } else if (sumLastData % 16 == 14) {
                binary.insert(0, "E");
            } else if (sumLastData % 16 == 15) {
                binary.insert(0, "F");
            }
            sumLastData = sumLastData / 16;
        } while (sumLastData / 1 != 0);
        System.out.println("Liczba w systemie szesnastkowym to: " + binary.toString());
    }

    public static void qrtCalc(Double[] sumLastData) {
        if (sumLastData.length < 2) {
            System.out.println("Podałeś za mało danych");
        } else {
            double y, y1;
            y1 = sumLastData[0];
            if (sumLastData[0] >= 1) {
                y = y1;
            } else {
                y = 1;
            }
            int counterLoop = 0;
            if (sumLastData[0] < 0 && sumLastData[1] % 2 == 0) {
                System.out.println("Podałeś/aś liczbę ujemną z parzystego stopnia pierwiastka");
            } else {
                do {
                    if (counterLoop == 0) {

                    } else {
                        y = y1;
                    }
                    y1 = 1 / sumLastData[1] * ((sumLastData[1] - 1) * y + sumLastData[0] / (Math.pow(y, sumLastData[1] - 1)));
                    //  System.out.println(y + "   " + y1);
                    counterLoop++;
                } while (Math.abs(y - y1) > 0.0001);
                System.out.println("Pierwiastek " + sumLastData[1] + " stopnia z liczby " + sumLastData[0] + " wynosi: " + y1);
            }
        }
    }

    public static void averageResult(Double[] sumLastData) {
        Double sumScore = 0d;
        for (int i = 0; i < sumLastData.length; i++) {
            sumScore = sumScore + sumLastData[i];
            if (i == sumLastData.length - 1) {
                sumScore = sumScore / sumLastData.length;
            }
        }
        System.out.println("Srednia z podanych liczb to: " + sumScore);
    }

    public static void medianeResult(Double[] sumLastData) {
        Double sumScore = 0d;
        Arrays.sort(sumLastData);
        if (sumLastData.length % 2 == 1) {
            sumScore = sumLastData[sumLastData.length / 2];
        } else {
            sumScore = (sumLastData[sumLastData.length / 2 - 1] + sumLastData[sumLastData.length / 2]) / 2;
        }

        System.out.println("Mediana z podanych liczb to: " + sumScore);
    }

    public static int choice() {
        System.out.println("Wybierz opcję kalkulatora:");
        System.out.println("1 - dodawanie, 2 - odejmowanie, 3 - mnożenie, 4 - dzielenie, 5 - konwersja/binarny, 6 - konwersja/ósemkowy");
        System.out.println("7 - konwersja szesnastkowy,8 - pierwiastkowanie, 9 - potęgowanie,  10 - średnia, 11 - mediana, 20-zakończ");
        Scanner calculatorOption = new Scanner(System.in);
        Scanner dataScanner = new Scanner(System.in);
        int chosenOption = calculatorOption.nextInt();
        int counteroption = 0;
        switch (chosenOption) {
            case 1: {
                System.out.println("Podaj składniki sumy oddzielone spacjami: ");
                String inputData = dataScanner.nextLine();
                Double[] sumLastData = stringToArrayInput(inputData);
                sumResult(sumLastData);
                break;
            }
            case 2: {
                System.out.println("Podaj odjemną i odjemniki oddzielone spacjami: ");
                String inputData = dataScanner.nextLine();
                Double[] sumLastData = stringToArrayInput(inputData);
                substractResult(sumLastData);
                break;
            }
            case 3: {
                System.out.println("Podaj mnożniki oddzielone spacjami: ");
                String inputData = dataScanner.nextLine();
                Double[] sumLastData = stringToArrayInput(inputData);
                multiplyResult(sumLastData);
                break;
            }
            case 4: {
                System.out.println("Podaj dzielną i dzielniki oddzielone spacjami: ");
                String inputData = dataScanner.nextLine();
                Double[] sumLastData = stringToArrayInput(inputData);
                divideResult(sumLastData);
                break;

            }
            case 5: {
                System.out.println("Podaj liczbe całkowitą celem zamiany na liczbę w systemie binarnym: ");
                String inputData = dataScanner.nextLine();
                Double[] sumLastData = stringToArrayInput(inputData);
                int forChangeNumber;
                forChangeNumber = sumLastData[0].intValue();
                decimalToBinary(forChangeNumber);
                break;
            }
            case 6: {
                System.out.println("Podaj liczbe całkowitą celem zamiany na liczbę w systemie oktalnym: ");
                String inputData = dataScanner.nextLine();
                Double[] sumLastData = stringToArrayInput(inputData);
                int forChangeNumber;
                forChangeNumber = sumLastData[0].intValue();
                decimalToOktal(forChangeNumber);
                break;
            }
            case 7: {
                System.out.println("Podaj liczbe całkowitą celem zamiany na liczbę w systemie szesnastkowym: ");
                String inputData = dataScanner.nextLine();
                Double[] sumLastData = stringToArrayInput(inputData);
                int forChangeNumber;
                forChangeNumber = sumLastData[0].intValue();
                decimalToHeksadecimal(forChangeNumber);
                break;
            }
            case 8: {
                System.out.println("Podaj liczbę do pierwiastkowania i stopień pierwiastka oddzielone spacją: ");
                String inputData = dataScanner.nextLine();
                Double[] sumLastData = stringToArrayInput(inputData);
                qrtCalc(sumLastData);
                break;
            }
            case 9: {
                System.out.println("Podaj liczbę do potęgowania i potęgę oddzielone spacją: ");
                String inputData = dataScanner.nextLine();
                Double[] sumLastData = stringToArrayInput(inputData);
                System.out.println(sumLastData[0] + " do potęgi " + sumLastData[1] + " wynosi: " + Math.pow(sumLastData[0], sumLastData[1]));
                ;
                break;
            }
            case 10: {
                System.out.println("Podaj składniki średniej oddzielone spacjami: ");
                String inputData = dataScanner.nextLine();
                Double[] sumLastData = stringToArrayInput(inputData);
                averageResult(sumLastData);
                break;
            }
            case 11: {
                System.out.println("Podaj składniki dla obliczenia mediany oddzielone spacjami: ");
                String inputData = dataScanner.nextLine();
                Double[] sumLastData = stringToArrayInput(inputData);
                medianeResult(sumLastData);
                break;
            }
            case 20: {
                counteroption = 90;
                break;
            }
            default: {
                counteroption = 90;
                break;
            }
        }
        return counteroption;
    }
}

