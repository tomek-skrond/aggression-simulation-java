package StructureOrganisation;

import Organisms.*;
import Organisms.Abstractions.Organism;
import Organisms.Enums.OrganismType;
import StructureOrganisation.Interfaces.IRandomizable;

import java.util.ArrayList;
import java.util.List;

public class StructureOrganisationAgent implements IRandomizable {


    private List<Organism> organisms;
    private List<OrganismPair> pairs = new ArrayList<>();
    public List<Batch> batches = new ArrayList<>();

    public StructureOrganisationAgent(){
        this.organisms = new ArrayList<>();
        this.pairs = new ArrayList<>();
        this.pairs = new ArrayList<>();
    }

    public Organism makeOrganismOfType(OrganismType type){

        switch(type){
            case A:
                return new AggressiveOrganism();

            case D:
                return new DominantOrganism();

            case P:
                return new PassiveOrganism();

            case S:
                return new SubmissiveOrganism();

        }
        return new SubmissiveOrganism();
    }
    public List<Organism> generateOrganisms(int howMany, OrganismType type){
        List<Organism> l = new ArrayList<>();
        for(int i=0;i<howMany;i++){
            l.add(makeOrganismOfType(type));
        }
        return l;
    }

    public List<Organism> groupIntoPairs(){
        List<Organism> bufferArray = new ArrayList<>();

        return  bufferArray;
    }

    public List<Double> assignFoodPackets(){
        List<Double> foodList = new ArrayList<>();

        return foodList;
    }

    public List<Batch> groupIntoBatches(){
        List<Batch> batchArr = new ArrayList<>();

        return batchArr;
    }
}
