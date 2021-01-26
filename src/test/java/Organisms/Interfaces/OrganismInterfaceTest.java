package Organisms.Interfaces;

import Organisms.Abstractions.Organism;
import Organisms.AggressiveOrganism;
import junit.framework.TestCase;

public class OrganismInterfaceTest extends TestCase {

    public void testEvaluateState() {
        Organism aggressiveDuplicated = new AggressiveOrganism(1.5,2.0,1.0);
        Organism aggressiveAlive = new AggressiveOrganism(1.5,1.0,1.0);
        Organism aggressiveDead = new AggressiveOrganism(1.5,0.0,1.0);

        assert(aggressiveAlive.evaluateState());
        assert(aggressiveDuplicated.evaluateState());
        assert(!aggressiveDead.evaluateState());

    }
}