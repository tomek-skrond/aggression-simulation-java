package StructureOrganisation;

import Organisms.*;
import Organisms.Abstractions.Organism;
import Organisms.Enums.OrganismType;
import StructureOrganisation.Interfaces.IRandomizer;

import java.util.ArrayList;
import java.util.List;

public class StructureOrganisationAgent implements IRandomizer {


    private List<Organism> organisms;
    private List<OrganismPair> pairs;
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

    private boolean validateParity(){
        return this.organisms.size() % 2 == 0;
    }

    private void backupOrganismSet(){
        if(!validateParity()){

            this.organisms.remove(
                    generateRandomIntInRange(0,this.organisms.size())
            );
        }
    }

    public List<OrganismPair> groupIntoPairs() {

        backupOrganismSet();

        List<Organism> orgArray = this.organisms;
        List<OrganismPair> pairBuffer = new ArrayList<>();

        for (int i = 0; i < orgArray.size(); i++) {
            pairBuffer.add(
                    new OrganismPair(
                            orgArray.get(i), orgArray.get(i + 1)
                    )
            );
        }
        return pairBuffer;
    }

    public List<Batch> groupIntoBatches(){
        List<Batch> batchArr = new ArrayList<>();
        for (var p : pairs) {
            batchArr.add(
                    new Batch(p, 2.0)
            );
        }
        return batchArr;
    }
}
