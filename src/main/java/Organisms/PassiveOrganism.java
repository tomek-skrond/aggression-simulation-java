package Organisms;

import Organisms.Abstractions.Organism;

/**
 *  * Organizm pasywny - współczynnik agresji = 1
 */
public class PassiveOrganism extends Organism {
    public PassiveOrganism(){
        super();
        this.hostility = 0.5;
    }



    public Organism getObj(){
        return new PassiveOrganism();
    }

    /**
     * Konstruktor dla Prototypów
     * @param source
     */
    public PassiveOrganism(PassiveOrganism source){
        super(source);
        this.hostility = 0.5;
    }

    /**
     * Funkcja klonująca(prototypy)
     * @return PassiveOrganism
     */
    @Override
    public Organism cloneObject(){
        return new PassiveOrganism(this);
    }

    /**
     * Funkcja interakcji
     * @param o1
     */
    @Override
    public void objectInteraction(Organism o1){

    }
}
