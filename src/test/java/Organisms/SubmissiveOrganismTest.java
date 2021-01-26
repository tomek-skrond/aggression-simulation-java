package Organisms;

import Organisms.Abstractions.Organism;
import junit.framework.TestCase;

public class SubmissiveOrganismTest extends TestCase {

    public void testObjectInteraction() {
        Organism submissive = new SubmissiveOrganism();

        Organism[] organismList = {
                new AggressiveOrganism(), new DominantOrganism(),new PassiveOrganism(), new SubmissiveOrganism()
        };

        for(Organism o : organismList){
            submissive.objectInteraction(o);
        }

        SubmissiveOrganism.submissiveCounter = 100;
        Organism.organismCounter = 1;

        assert(organismList[0].getFoodTaken() == 1.0);
        assert(organismList[1].getFoodTaken() == 1.5);
        assert(organismList[2].getFoodTaken() == 1.0);
        assert(organismList[3].getFoodTaken() == 1.0);

        SubmissiveOrganism.submissiveCounter = 1;
        Organism.organismCounter = 100;

        Organism aggr = new AggressiveOrganism();
        submissive.objectInteraction(aggr);

        assert(submissive.getFoodTaken() == 2.0);
        assert(aggr.getFoodTaken() == 0.0);
    }

    public void testEvaluateState() {
        Organism s = new SubmissiveOrganism();

        s.setFoodTaken(1.0);
        assert(s.evaluateState());
        assert(s.getIsAlive() == 1.0);

        s.setFoodTaken(2.0);
        assert(s.evaluateState());
        assert(s.getIsAlive() == 1.0);

        s.setFoodTaken(0.0);
        assert(!s.evaluateState());
        assert(s.getIsAlive() == 0.0);

    }
}