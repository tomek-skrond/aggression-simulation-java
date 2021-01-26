package Organisms;

import Organisms.Abstractions.Organism;
import junit.framework.TestCase;

public class PassiveOrganismTest extends TestCase {

    public void testObjectInteraction() {
        Organism passive = new PassiveOrganism();

        Organism[] organismList = {
                new AggressiveOrganism(), new DominantOrganism(),new PassiveOrganism(), new SubmissiveOrganism()
        };

        for(Organism o : organismList){
            passive.objectInteraction(o);
        }

        assert(organismList[0].getFoodTaken() == 1.5);
        assert(organismList[1].getFoodTaken() == 1.5);
        assert(organismList[2].getFoodTaken() == 1.0);
        assert(organismList[3].getFoodTaken() == 0.5);
    }
}