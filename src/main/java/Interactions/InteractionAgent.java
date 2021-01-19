package Interactions;

import Organisms.Abstractions.Organism;
import StructureOrganisation.Batch;
import StructureOrganisation.StructureOrganisationAgent;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class InteractionAgent {

    List<Batch> batches;
    List<Organism> organisms;

    public void setOrganisms(List<Organism> organisms) {
        this.organisms = organisms;
    }

    public InteractionAgent(StructureOrganisationAgent structOrg){
        this.batches = structOrg.getBatches();
        this.organisms = structOrg.getOrganisms();
    }

    public void fightForFood(){
        //for b in batches -> b.interact
        for(Batch b : batches){
            b.getFirst().objectInteraction(b.getSecond());
        }
    }

    public List<Batch> getBatches() {
        return batches;
    }

    public void setBatches(List<Batch> batches) {
        this.batches = batches;
    }

    public List<Organism> duplication(){
        List<Organism> bufList = this.organisms;
        List<Organism> toClone = new ArrayList<>();


        for (Organism o : this.organisms) {
            if(o.getFoodTaken() == 2.0){
                toClone.add(o);
            }
        }

        for(Organism o : toClone){
            bufList.add(o);
        }
        setOrganisms(bufList);
        return bufList;
    }

}
