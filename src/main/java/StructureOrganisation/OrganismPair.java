package StructureOrganisation;

import Organisms.Abstractions.Organism;
import StructureOrganisation.Interfaces.IPairable;

public class OrganismPair implements IPairable {
    Organism first;
    Organism second;

    public OrganismPair(){
        this.first = null;
        this.second = null;
    }
    public OrganismPair(Organism _first, Organism _second){
        this.first = _first;
        this.second = _second;
    }

    @Override
    public void setFirst(Organism o){
        this.first = o;
    }
    @Override
    public void setSecond(Organism o){
        this.second = o;
    }
}
