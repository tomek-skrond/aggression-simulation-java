package Organisms;

import Organisms.Abstractions.Organism;
import junit.framework.TestCase;

public class DominantOrganismTest extends TestCase {

    public void testObjectInteraction() {
        Organism dominant = new DominantOrganism();

        Organism[] organismList = {
                new AggressiveOrganism(), new DominantOrganism(),new PassiveOrganism(), new SubmissiveOrganism()
        };

        for(Organism o : organismList){
            dominant.objectInteraction(o);
        }

        assert(organismList[0].getFoodTaken() == 1.0);
        assert(organismList[1].getFoodTaken() == 0.0);
        assert(organismList[2].getFoodTaken() == 0.0);
        assert(organismList[3].getFoodTaken() == 0.0);
    }

}