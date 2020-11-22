package Organisms;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//import org.junit.jupiter.api.Test;

public class AggressiveOrganismTest extends TestCase {
    AggressiveOrganism testAggressiveDefault = new AggressiveOrganism();
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

    @Test
    public void testDefaultParameters(){
        assertTrue(testAggressiveDefault.getReproductionRate() == 0.0);
        assertTrue(testAggressiveDefault.getHostility() == 2.0);
        assertTrue(testAggressiveDefault.getFoodTaken() == 0.0);
        assertTrue(testAggressiveDefault.getIsAlive() == 1.0);
    }
    @Test
    public void testSetters(){
        testAggressive.setFoodTaken(3.0);
        testAggressive.setHostility(5.0);
        testAggressive.setIsAlive(4.0);
        testAggressive.setReproductionRate(40.0);

        assertTrue(
                testAggressive.getFoodTaken() == 3.0 &&
                        testAggressive.getHostility() == 5.0 &&
                        testAggressive.getIsAlive() == 4.0 &&
                        testAggressive.getReproductionRate() == 40.0
                );
    }
    @Test
    public void testSettersDefault(){

    }
}