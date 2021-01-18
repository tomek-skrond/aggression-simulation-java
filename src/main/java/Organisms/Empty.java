package Organisms;

import Organisms.Abstractions.Organism;

public class Empty extends Organism {
    public static int emptyCounter = 0;

    public Empty(){
        emptyCounter++;
    }

    @Override
    public void objectInteraction(Organism o1){

    }

    @Override
    public String toString(){
        emptyCounter++;
        return "Empty " + super.toString();
    }

    @Override
    public Organism cloneObject() {
        return null;
    }
}
