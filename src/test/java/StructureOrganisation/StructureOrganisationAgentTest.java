package StructureOrganisation;

import Organisms.Abstractions.Organism;
import Organisms.AggressiveOrganism;
import Organisms.Enums.OrganismType;
import StructureOrganisation.Interfaces.IRandomizer;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

import static Organisms.Enums.OrganismType.*;

public class StructureOrganisationAgentTest extends TestCase {

    int [] paramsList = {2,2,2,2};

    StructureOrganisationAgent structOrg = new StructureOrganisationAgent(paramsList);

    public void testMakeOrganismsOfType() {
        List<Organism> list = structOrg.makeOrganismsOfType(A,4);

        for(Organism o : list){
            System.out.println(o);
        }

        assert(list.size() == 4);
        for (int i = 0; i < list.size(); i++) {
            assert(list.get(i).getHostility() == 1.5);
        }


    }

    public void testGenerateOrganisms() {
        int [] paramsCheck = {0,0,0,0};
        ArrayList<Organism> list = structOrg
                .generateOrganisms()
                .shuffle()
                .getOrganisms();

        //list = structOrg.getOrganisms();


        for(Organism o : list){
            System.out.println(o);
            if(o.getHostility() == 1.5){
                paramsCheck[0]++;
            }
            if(o.getHostility() == 2.0){
                paramsCheck[1]++;
            }
            if(o.getHostility() == 1.0){
                paramsCheck[2]++;
            }
            if(o.getHostility() == 0.5){
                paramsCheck[3]++;
            }
        }

        for (int i = 0; i < paramsCheck.length; i++) {
            assert(paramsList[i] == paramsCheck[i]);
        }
    }

    public void testGroupIntoPairs() {

        ArrayList<OrganismPair> pairs = structOrg
                                        .generateOrganisms()
                                        .shuffle()
                                        .groupIntoPairs()
                                        .getPairs();

        System.out.println(pairs.size());

        for(Object o : structOrg.getOrganisms()){
            System.out.println(o);
        }

        assert(structOrg.getOrganisms().size() % 2 == 0);

        for(OrganismPair p : pairs){
            System.out.println(p);
        }


    }

    /*
    public void testGroupIntoBatches() {
        ArrayList<Batch> batches = structOrg
                                   .groupIntoBatches()
                                   .getBatches();
        for(Batch b : batches){
            System.out.println(b.toString());
        }
    }
*/
}

