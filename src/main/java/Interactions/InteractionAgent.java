package Interactions;

import StructureOrganisation.Batch;
import StructureOrganisation.StructureOrganisationAgent;

import java.util.ArrayList;
import java.util.List;

public class InteractionAgent {
    StructureOrganisationAgent structureAgent;
    List<Batch> batches;

    public InteractionAgent(ArrayList<Batch> _batches,StructureOrganisationAgent _structureAgent){
        this.structureAgent = _structureAgent;
        this.batches = _batches;
    }

    void InteractionLoop(){

    }
}
