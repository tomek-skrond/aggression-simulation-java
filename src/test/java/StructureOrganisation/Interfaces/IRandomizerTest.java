package StructureOrganisation.Interfaces;

import junit.framework.TestCase;

public class IRandomizerTest extends TestCase {

    IRandomizer randomizer = new IRandomizer() {

    };

    public void testGenerateRandomNumberInRange() {
        int x = randomizer.generateRandomNumberInRange(1,30);
        assert x < 30 && x > 1;
    }

    public void testGenerateRandomIntArray() {
        int[] arr = randomizer.generateRandomIntArray(15,1,20);

        assert(arr != null);
        assert(arr.length == 15);
    }
}