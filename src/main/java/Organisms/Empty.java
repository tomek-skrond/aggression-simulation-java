package Organisms;

import Organisms.Abstractions.Organism;

/**
 * Organizm pusty - jest buforem, pomaga w organizowaniu struktur
 */

public class Empty extends Organism {
    public static int emptyCounter = 0;

    /**
     * Empty() - konstruktor domyslny
     * brak parametrow
     */
    public Empty(){
        emptyCounter++;
    }

    /**
     * Interakcja z innym danym organizmem o1
     * @param o1 - organizm z którym obiekt wchodzi w interakcje
     */
    @Override
    public void objectInteraction(Organism o1){

    }

    /**
     * toString - zwraca String opisujący instancję Organizmu
     * @return String
     */
    @Override
    public String toString(){
        emptyCounter++;
        return "Empty " + super.toString();
    }
}
