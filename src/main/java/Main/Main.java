package Main;
import Bootstrap.Simulation;

import java.util.Scanner;

public class Main {

    /**
     *
     * glowna metoda, obsluguje wybor trybow zapisu symulacji i tryb wpisywania parametrpw
     */
    public static void main(String [] args) throws Exception {

        Scanner s = new Scanner(System.in);

        System.out.print("czy chcesz ustawic parametry symulacji?(1/0) ");
        int check = s.nextInt();

        if(check == 1){
            System.out.print("podaj liczbe agresywnych osobnikow: ");
            int A = s.nextInt();

            System.out.print("podaj liczbe dominujących osobnikow: ");
            int D = s.nextInt();

            System.out.print("podaj liczbe pasywnych osobnikow: ");
            int P = s.nextInt();

            System.out.print("podaj liczbe uległych osobnikow: ");
            int S = s.nextInt();

            System.out.print("podaj liczbe cykli symulacyjnych: ");
            int C = s.nextInt();

            System.out.print("czy wybierasz skrocony typ zapisu danych do pliku?(1/0) ");
            int check2 = s.nextInt();

            if(check2 == 0){
                new Simulation(A,D,P,S,C,false);

            }else{
               new Simulation(A,D,P,S,C,true);
            }
        }
        if(check == 0){

            new Simulation(100,100,100,100,10,false);

        }else if(check != 1){

            System.out.println("blad we wprowadzaniu danych, uruchomiono symulacje z domyslnymi parametrami");
            new Simulation(100,100,100,100,10,false);
        }


    }
}