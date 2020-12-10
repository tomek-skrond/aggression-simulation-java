package Organisms;

import Organisms.Abstractions.Organism;

public class DominantOrganism extends Organism {
    public DominantOrganism(){
        super();
        this.hostility = 1.5;
    }
    public DominantOrganism(DominantOrganism source){
        super(source);
        this.hostility = 1.5;
    }

    @Override
    public Organism cloneObject(){
        return new DominantOrganism(this);
    }
    @Override
    public void objectInteraction(Organism o1){

    }
}
