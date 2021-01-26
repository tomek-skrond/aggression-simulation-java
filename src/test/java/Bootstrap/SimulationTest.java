package Bootstrap;

import Interactions.InteractionAgent;
import Organisms.Abstractions.Organism;
import Organisms.AggressiveOrganism;
import Organisms.DominantOrganism;
import StructureOrganisation.Batch;
import StructureOrganisation.OrganismPair;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SimulationTest extends TestCase {


    public SimulationTest() throws Exception {
    }

    public void testSimulationMainLoop() throws Exception {

        Simulation s = new Simulation();

        int[] params = s.structOrg.getParamsList();

        s.simulationMainLoop();
        for(int p : params){
            System.out.println(p);
        }

        assert(s.structOrg != null);
        assert(s.interactions != null);
        assert(!s.simulationNote.equals(""));

    }

    public void testSetupInteractions() throws Exception {
        Simulation s = new Simulation();

        InteractionAgent interactions = s.interactions;

        s.setupInteractions();

        assert(s.interactions != null);
    }

    public void testUpdateSimulationNote() throws Exception {
        Simulation s = new Simulation();
        String testString = "{}{}";

        s.simulationNote = testString;

        s.simulationMainLoop();

        assert(!s.simulationNote.contains(testString));
    }

    public void testExecuteDuplication() {
        List<Organism> orgs = Arrays.asList(new AggressiveOrganism(1.5, 2.0, 1.0),
                new DominantOrganism(2.0,2.0,1.0));
    }
}