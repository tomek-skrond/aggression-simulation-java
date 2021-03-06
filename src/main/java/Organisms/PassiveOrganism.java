package Organisms;

import Organisms.Abstractions.Organism;

/**
 * Organizm pasywny - współczynnik agresji = 1
 */
public class PassiveOrganism extends Organism {

    public static int passiveCounter = 0;

    public PassiveOrganism(){
        super();
        this.hostility = 1.0;
        passiveCounter++;
    }

    /**
     * Konstruktor
     * @param _hostility stopień agresji danego organizmu
     * @param _foodTaken ilość jedzenia zebrana podczas walki
     * @param _isAlive zmienna pokazująca czy organizm jest w stanie przeżyć do następnego cyklu
     */
    public PassiveOrganism(double _hostility,
                           double _foodTaken, double _isAlive){
        super();
        this.hostility = 1.0;
        passiveCounter++;
    }

    /**
     * Funkcja interakcji okreslajaca interakcje z innym organizmem(o1)
     * @param o1
     */
    @Override
    public void objectInteraction(Organism o1){
        if(o1.getHostility() == 2.0){
            this.setFoodTaken(0.5);
            o1.setFoodTaken(1.5);
        }
        if(o1.getHostility() == 1.5){
            this.setFoodTaken(0.5);
            o1.setFoodTaken(1.5);
        }
        if(o1.getHostility() == 1.0){
            this.setFoodTaken(1.0);
            o1.setFoodTaken(1.0);
        }
        if(o1.getHostility() == 0.5){
            this.setFoodTaken(1.5);
            o1.setFoodTaken(0.5);
        }
    }

    /**
     * toString - zwraca String opisujący instancję Organizmu
     * @return String
     */
    @Override
    public String toString(){
        return "Passive " + super.toString();
    }
}
