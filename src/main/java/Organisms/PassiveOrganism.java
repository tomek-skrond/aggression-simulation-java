package Organisms;

import Organisms.Abstractions.Organism;

public class PassiveOrganism extends Organism {
    public PassiveOrganism(){
        super();
        this.hostility = 0.5;
    }
    public PassiveOrganism(PassiveOrganism source){
        super(source);
        this.hostility = 0.5;
    }

    @Override
    public Organism cloneObject(){
        return new PassiveOrganism(this);
    }
    @Override
    public void objectInteraction(Organism o1){
        
    }
}
