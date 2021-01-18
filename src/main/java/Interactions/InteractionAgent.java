package Interactions;

import StructureOrganisation.Batch;
import StructureOrganisation.StructureOrganisationAgent;

import java.util.ArrayList;
import java.util.List;

public class InteractionAgent {

    List<Batch> batches;

    public InteractionAgent(ArrayList<Batch> _batches){
        this.batches = _batches;
    }

    public void fightForFood(){
        //for b in batches -> b.interact
        for(Batch b : batches){
            b.getFirst().objectInteraction(b.getSecond());
        }
    }


}
