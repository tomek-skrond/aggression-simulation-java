package Organisms;

import Organisms.Abstractions.Organism;

/**
 * Organizm dominujący współczynnik agresji = 2
 */
public class DominantOrganism extends Organism {
    public DominantOrganism(){
        super();
        this.hostility = 2.0;
    }

    /**
     * Konstruktor dla prototypów
     * @param source
     */
    public DominantOrganism(DominantOrganism source){
        super(source);
        this.hostility = 2.0;
    }

    /**
     * Funkcja klonująca(prototypy)
     * @return DominantOrganism
     */
    @Override
    public Organism cloneObject(){
        return new DominantOrganism(this);
    }



    public Organism getObj(){
        return new DominantOrganism();
    }

    /**
     * Funkcja interakcji
     * @param o1
     */
    @Override
    public void objectInteraction(Organism o1){

    }
}
