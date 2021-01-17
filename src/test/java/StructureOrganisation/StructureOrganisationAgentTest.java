package StructureOrganisation;

import Organisms.Abstractions.Organism;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

import static Organisms.Enums.OrganismType.*;

public class StructureOrganisationAgentTest extends TestCase {

    int [] paramsList = {1,1,1,1};

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



        for(Object o : structOrg.getOrganisms()){
            System.out.println(o);
        }

        assert(structOrg.getOrganisms().size() % 2 == 0);

        System.out.println("liczba par: " + pairs.size() + "\n");

        int i = 0;
        for(OrganismPair p : pairs){
            System.out.println(p);
            assert(p.first == pairs.get(i).first);
            assert(p.second == pairs.get(i).second);
            i++;
        }

    }


    public void testGroupIntoBatches() {
        ArrayList<Batch> batches = structOrg
                .generateOrganisms()
                .shuffle()
                .groupIntoPairs()
                .groupIntoBatches()
                .getBatches();

        ArrayList<OrganismPair> pairs = structOrg.getPairs();
        ArrayList<Organism> organisms = structOrg.getOrganisms();

        for(Organism o : organisms){
            System.out.println(o);
        }

        int i = 0;
        for(OrganismPair p : pairs){
            assert(p.first == pairs.get(i).first);
            assert(p.second == pairs.get(i).second);
            i++;
        }
        i=0;
        for(Batch b : batches){
            System.out.println(b);
            assert(b.pair.first == pairs.get(i).first && b.foodPacket == 2.0);
            assert(b.pair.second== pairs.get(i).second);
            i++;
        }
    }

    public void testConstructData() {

    }

    public void testInitializeData() {
        structOrg.initializeData();
        for(Batch b : structOrg.getBatches()){
            System.out.println(b);
        }
    }
}

