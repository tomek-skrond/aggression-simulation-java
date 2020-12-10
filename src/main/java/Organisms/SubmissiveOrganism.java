package Organisms;

import Organisms.Abstractions.Organism;

public class SubmissiveOrganism extends Organism {
    public SubmissiveOrganism(){
        super();
        this.hostility = 0.0;
    }
    public SubmissiveOrganism(Double _reproductionRate, Double _hostility,
                              Double _foodTaken, Double _isAlive){
        super(_reproductionRate,_hostility,_foodTaken,_isAlive);
    }
    public SubmissiveOrganism(SubmissiveOrganism source){
        super(source);
        this.hostility = 0.0;
    }
    @Override
    public Organism cloneObject(){
        return new SubmissiveOrganism(this);
    }
    @Override
    public void objectInteraction(Organism o1){

    }
}
