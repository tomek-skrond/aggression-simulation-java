package Organisms;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
//import org.junit.jupiter.api.Test;

public class AggressiveOrganismTest extends TestCase {
    AggressiveOrganism testAggressiveDefaultConstructor = new AggressiveOrganism();
    AggressiveOrganism testAggressive = new AggressiveOrganism(0,2,0,1);


    public AggressiveOrganismTest(){
        this.testToString();
        this.testParameters();
    }

    @Test
    public void testToString(){
        String checkString = this.testAggressive.toString();

        assertEquals(
                "repr_rate: " + testAggressive.getReproductionRate() + "\n" +
                        "hostility: " + testAggressive.getHostility() + "\n" +
                        "food_taken: " + testAggressive.getFoodTaken() + "\n" +
                        "is_alive: " + testAggressive.getIsAlive() , checkString
        );
    }
    @Test
    public void testParameters(){
        assertTrue(testAggressive.getReproductionRate() == 0.0);
        assertTrue(testAggressive.getHostility() == 2.0);
        assertTrue(testAggressive.getFoodTaken() == 0.0);
        assertTrue(testAggressive.getIsAlive() == 1.0);
    }
}