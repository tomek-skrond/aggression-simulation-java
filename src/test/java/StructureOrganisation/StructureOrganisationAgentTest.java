package StructureOrganisation;

import Organisms.Abstractions.Organism;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

import static Organisms.Enums.OrganismType.*;

public class StructureOrganisationAgentTest extends TestCase {

    int [] paramsList = {1,1,2,1};

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

        List<Organism> list = structOrg.generateOrganisms();


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

    public void testUpdatePairs() {


        ArrayList<OrganismPair> pairs = structOrg.updatePairs(structOrg.generateOrganisms());

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


    public void testUpdateBatches() {

        ArrayList<OrganismPair> pairs = structOrg.updatePairs(
                structOrg.generateOrganisms()
        );

        ArrayList<Batch> batches = (ArrayList<Batch>) structOrg.updateBatches(
                structOrg.updatePairs(
                        structOrg.generateOrganisms()
                )
        );

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
            assert(b.foodPacket == 2.0);
            assert(b.pair.first.getHostility() == pairs.get(i).first.getHostility());
            assert(b.pair.second.getHostility() == pairs.get(i).second.getHostility());
            i++;
        }

    }

    public void testConstructData() {
        List<Organism> list = structOrg.generateOrganisms();
        List<OrganismPair> pairs = structOrg.updatePairs(list);
        List<Batch> batches = structOrg.updateBatches(pairs);

        structOrg.constructData((ArrayList<Organism>) list);

        assert(batches.size() == structOrg.getBatches().size());
    }

    public void testInitializeData() {
        structOrg.initializeData();

    }

    public void testValidateParity() {
    }

    public void testBackupOrganismSet() {
    }

    public void testGetSlice() {
    }

    public void testGatherCycleOutput() {
    }

    public void testFlushFood() {
    }
}

