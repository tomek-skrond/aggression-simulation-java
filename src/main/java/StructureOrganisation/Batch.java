package StructureOrganisation;

import Organisms.Abstractions.Organism;
import StructureOrganisation.Interfaces.IPairable;

public class Batch implements IPairable{

    OrganismPair pair;
    Double foodPacket;

    /**
     * konstruktor Batch
     * @param _pair para organizmow
     * @param _foodPacket pakiet zywnosci przydzielony dla Batcha
     */
    public Batch(OrganismPair _pair, Double _foodPacket){
        this.pair = _pair;
        this.foodPacket = _foodPacket;
    }

    /**
     * setter pierwszego elementu pary
     * @param o Organizm
     */
    @Override
    public void setFirst(Organism o){
        this.pair.setFirst(o);
    }
    /**
     * setter pierwszego elementu pary
     * @param o Organizm
     */
    @Override
    public void setSecond(Organism o){
        this.pair.setSecond(o);
    }
    /**
     * getter pierwszego elementu pary
     * @return Organism
     */
    @Override
    public Organism getFirst(){
        return this.pair.first;
    }
    /**
     * getter elementu elementu pary
     * @return Organism
     */
    @Override
    public Organism getSecond(){
        return this.pair.second;
    }

    /**
     * toString
     * zwraca opis klasy
     * @return String
     */
    @Override
    public String toString(){
        return "Batch (\n" + pair.first.toString() + "\n" +
                            pair.second.toString() + ",\nfood(fight): " + this.foodPacket + "\n)";
    }
}