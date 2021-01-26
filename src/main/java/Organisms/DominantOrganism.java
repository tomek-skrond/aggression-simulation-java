package Organisms;

import Organisms.Abstractions.Organism;

/**
 * Organizm dominujący współczynnik agresji = 2
 */
public class DominantOrganism extends Organism {
    //public static int dominantCounter = 0;

    /**
     * Konstruktor domyslny
     */
    public DominantOrganism(){
        super();
        this.hostility = 2.0;
    }

    /**
     * Konstruktor
     * @param _hostility stopień agresji danego organizmu
     * @param _foodTaken ilość jedzenia zebrana podczas walki
     * @param _isAlive zmienna pokazująca czy organizm jest w stanie przeżyć do następnego cyklu
     */
    public DominantOrganism(double _hostility,
                            double _foodTaken, double _isAlive){

        super(_hostility,_foodTaken,_isAlive);
        this.hostility = 2.0;
    }

    /**
     * Funkcja interakcji okreslajaca interakcje z innym organizmem(o1)
     * @param o1
     */
    @Override
    public void objectInteraction(Organism o1){
        if(o1.getHostility() == 2.0){
            this.setFoodTaken(0.0);
            o1.setFoodTaken(0.0);
        }
        if(o1.getHostility() == 1.5){
            this.setFoodTaken(1.0);
            o1.setFoodTaken(1.0);
        }
        if(o1.getHostility() == 1.0){
            this.setFoodTaken(2.0);
            o1.setFoodTaken(0.0);
        }
        if(o1.getHostility() == 0.5){
            this.setFoodTaken(2.0);
            o1.setFoodTaken(0.0);
        }
    }

    @Override
    public String toString(){
        return "Dominant " + super.toString();
    }
}
