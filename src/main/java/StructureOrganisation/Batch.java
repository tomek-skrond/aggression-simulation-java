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

    public OrganismPair getPair() {
        return pair;
    }

    public double getFoodPacket() {
        return foodPacket;
    }

    @Override
    public void setFirst(Organism o){
        this.pair.setFirst(o);
    }
    @Override
    public void setSecond(Organism o){
        this.pair.setSecond(o);
    }
    @Override
    public Organism getFirst(){
        return this.pair.first;
    }
    @Override
    public Organism getSecond(){
        return this.pair.second;
    }
    @Override
    public String toString(){
        return "Batch (\n" + pair.first.toString() + "\n" +
                            pair.second.toString() + ",\nfood(fight): " + this.foodPacket + "\n)";
    }
}