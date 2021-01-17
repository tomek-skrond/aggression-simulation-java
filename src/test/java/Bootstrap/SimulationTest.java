package Bootstrap;

import Organisms.DominantOrganism;
import StructureOrganisation.Batch;
import StructureOrganisation.OrganismPair;
import junit.framework.TestCase;

import java.util.ArrayList;

public class SimulationTest extends TestCase {


    Simulation sDef = new Simulation();
    Simulation s = new Simulation(1,1,1,1,2);




    public void testSimulationMainLoop() {

        int[] params = s.structOrg.getParamsList();

        for(int p : params){
            System.out.println(p);
        }

        s.simulationMainLoop();


        System.out.println(s.structOrg.batches.size());

    }
}