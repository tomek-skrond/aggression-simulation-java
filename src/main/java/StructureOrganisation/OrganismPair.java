package StructureOrganisation;

import Organisms.Abstractions.Organism;
import Organisms.SubmissiveOrganism;
import StructureOrganisation.Interfaces.IPairable;

public class OrganismPair implements IPairable {
    Organism first;
    Organism second;

    public OrganismPair(){
        this.first = new SubmissiveOrganism();
        this.second = new SubmissiveOrganism();
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

    @Override
    public String toString(){

        return "Pair(\n" + first.toString() + "\n" +
                second.toString() + "\n)" + "\n";
    }
}
