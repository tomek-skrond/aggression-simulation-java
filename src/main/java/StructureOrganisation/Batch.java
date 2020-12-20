package StructureOrganisation;

import Organisms.Abstractions.Organism;
import StructureOrganisation.Interfaces.IPairable;

public class Batch implements IPairable{
    OrganismPair pair;
    Double foodPacket;

    public Batch(OrganismPair _pair, Double _foodPacket){
        this.pair = _pair;
        this.foodPacket = _foodPacket;
    }

    @Override
    public void setFirst(Organism o){
        this.pair.setFirst(o);
    }
    @Override
    public void setSecond(Organism o){
        this.pair.setSecond(o);
    }
}
