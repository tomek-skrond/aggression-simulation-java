package Organisms;

import Organisms.Abstractions.Organism;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class AggressiveOrganismTest extends TestCase {

    public void testObjectInteraction() {

        Organism aggressive = new AggressiveOrganism();

        Organism[] organismList = {
            new AggressiveOrganism(), new DominantOrganism(),new PassiveOrganism(), new SubmissiveOrganism()
        };

        for(Organism o : organismList){
            aggressive.objectInteraction(o);
        }

        assert(organismList[0].getFoodTaken() == 1.0);
        assert(organismList[1].getFoodTaken() == 0.0);
        assert(organismList[2].getFoodTaken() == 0.0);
        assert(organismList[3].getFoodTaken() == 0.0);
    }

}