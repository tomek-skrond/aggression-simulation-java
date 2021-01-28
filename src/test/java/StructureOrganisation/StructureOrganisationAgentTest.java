package StructureOrganisation;

import Organisms.Abstractions.Organism;
import Organisms.AggressiveOrganism;
import Organisms.DominantOrganism;
import Organisms.PassiveOrganism;
import Organisms.SubmissiveOrganism;
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
        structOrg.paramsList = new int[] {1,1,1,2};
        structOrg.initializeData();

        for(Organism o : this.structOrg.getOrganisms()){
            System.out.println(o);
        }

        assert(this.structOrg.getOrganisms().size() % 2 == 0);
    }

    public void testValidateParity() {
        List<Organism> org = new ArrayList<>();
        org.add(new DominantOrganism());
        org.add(new AggressiveOrganism());
        org.add(new PassiveOrganism());

        structOrg.setOrganisms(org);

        assert !structOrg.validateParity();

        org.remove(2);

        assert structOrg.validateParity();
    }

    public void testBackupOrganismSet() {
        List<Organism> org = new ArrayList<>();
        org.add(new DominantOrganism());
        org.add(new AggressiveOrganism());
        org.add(new PassiveOrganism());

        structOrg.setOrganisms(org);

        structOrg.backupOrganismSet();

        assert structOrg.getOrganisms().size() % 2 == 0;

    }

    public void testGetSlice() {
        Organism [] arr = {new DominantOrganism(),new SubmissiveOrganism(),new AggressiveOrganism()};

        Organism [] arr2 = structOrg.getSlice(arr,0,2);


        for(Organism o : arr2){
            System.out.println(o);
        }

        assert(arr2.length == arr.length - 1);
        assert ((arr2[0] instanceof DominantOrganism) && (arr2[1] instanceof SubmissiveOrganism));

    }

    public void testGatherCycleOutput() {
        List<Batch> batches = new ArrayList<>();
        OrganismPair p = new OrganismPair(new DominantOrganism(2.0,1.0,1.0),new AggressiveOrganism(1.5,2.0,1.0));
        batches.add(
                new Batch(p,2.0)
        );
        batches.add(
                new Batch(p,2.0)
        );
        batches.add(
                new Batch(p,2.0)
        );

        structOrg.setBatches(batches);
        ArrayList<Organism> arrlist = structOrg.gatherCycleOutput();
        structOrg.setOrganisms(arrlist);

        List<Organism> output = this.structOrg.getOrganisms();
        assert(output.size() == 6);
    }

    public void testFlushFood() {
        List<Organism> org = new ArrayList<>();
        org.add(new DominantOrganism(2.0,1.0,1.0));
        org.add(new AggressiveOrganism(1.5,2.0,1.0));
        org.add(new PassiveOrganism(0.5,1.0,1.0));

        structOrg.flushFood(org);

       for(Organism o : org){
           System.out.println(o);
           assert o.getFoodTaken() == 0.0;
       }

    }
}

