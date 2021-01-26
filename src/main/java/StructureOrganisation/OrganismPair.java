package StructureOrganisation;

import Organisms.Abstractions.Organism;
import Organisms.Empty;
import Organisms.SubmissiveOrganism;
import StructureOrganisation.Interfaces.IPairable;

/**
 * klasa par organizmow
 */
public class OrganismPair implements IPairable {
    Organism first;
    Organism second;

    /**
     * Konstruktor domyslny
     */
    public OrganismPair(){
        this.first = new Empty();
        this.second = new Empty();
    }

    /**
     * Konstruktor
     * @param _first pierwszy Organizm w parze
     * @param _second drugi organizm w parze
     */
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
    public Organism getFirst(){
        return this.first;
    }
    @Override
    public Organism getSecond(){
        return this.second;
    }

    /**
     * toString
     * @return String
     */
    @Override
    public String toString(){

        return "Pair(\n" + first.toString() + "\n" +
                second.toString() + "\n)" + "\n";
    }
}
