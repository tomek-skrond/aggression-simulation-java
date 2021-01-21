package Organisms;

import Organisms.Abstractions.Organism;

import java.util.ArrayList;
import java.util.List;

/**
 * Organizm uległy - współczynnik agresji = 0.5
 */
public class SubmissiveOrganism extends Organism {

    public static int deadCounter = 0;//rejestruje liczbę martwych organizmów
    public static int submissiveCounter = 0;

    /**
     * Konstruktor domyslny klasy SubmissiveOrganism
     */
    public SubmissiveOrganism(){
        super();
        this.hostility = 0.5;
        submissiveCounter++;
    }

    /**
     * Konstruktor
     * @param _hostility stopień agresji danego organizmu
     * @param _foodTaken ilość jedzenia zebrana podczas walki
     * @param _isAlive zmienna pokazująca czy organizm jest w stanie przeżyć do następnego cyklu
     */
    public SubmissiveOrganism(double _hostility,
                              double _foodTaken, double _isAlive){
        super(_hostility,_foodTaken,_isAlive);
        this.hostility = 0.5;
        submissiveCounter++;
    }

    /**
     * Funkcja określająca interakcję organizmu z innym organizmem(o1)
     * Kiedy zmienna submissiveCounter wchodzi w dany zakres, organizmy duplikują się
     * @param o1 organizm z którym obiekt wchodzi w interakcje
     */
    @Override
    public void objectInteraction(Organism o1){

        if(submissiveCounter < organismCounter/10){
            this.setFoodTaken(2.0);
        }else{
            if(o1.getHostility() == 2.0){
                this.setFoodTaken(1.0);
                o1.setFoodTaken(1.5);
            }
            if(o1.getHostility() == 1.5){
                this.setFoodTaken(1.0);
                o1.setFoodTaken(1.0);
            }
            if(o1.getHostility() == 1.0){
                this.setFoodTaken(1.0);
                o1.setFoodTaken(1.0);
            }
            if(o1.getHostility() == 0.5){
                this.setFoodTaken(1.0);
                o1.setFoodTaken(1.0);
            }
        }
    }

    /**
     * Sprawdza stan obiektu pod wzgledem posiadanego jedzenia
     * @return boolean
     */
    @Override
    public boolean evaluateState(){
        if(this.getFoodTaken() >= 1.0){
            this.setIsAlive(1.0);
            return true;
        }
        else{
            setIsAlive(0.0);
            deadCounter++;
            return false;
        }
    }
    /**
     * toString - zwraca String opisujący obiekt
     * @return String
     */
    @Override
    public String toString(){
        return "Submissive " + super.toString();
    }

}
