package Bootstrap;

import Interactions.InteractionAgent;
import ResultToFiles.ResultToFileHandler;
import StructureOrganisation.Interfaces.IRandomizer;
import StructureOrganisation.StructureOrganisationAgent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;


public class Simulation implements IRandomizer {

    private final int passive;
    private final int submissive;
    private final int aggressive;
    private final int dominant;

    private int howManyCycles;
    private StructureOrganisationAgent structOrg;
    private ResultToFileHandler resultHandler = new ResultToFileHandler();
    private InteractionAgent interactions; //assign when all structures are organised(put in batches)


    public Simulation(int _passive,int _submissive,int _aggressive,int _dominant,int _howManyCycles){

        int [] paramsList = {_passive,_submissive,_aggressive,_dominant};

        this.passive = _passive;
        this.submissive = _submissive;
        this.aggressive = _aggressive;
        this.dominant = _dominant;
        this.howManyCycles = _howManyCycles;

        this.structOrg = new StructureOrganisationAgent(paramsList);
    }
    public Simulation(){
        int[] randomInts = generateRandomIntArray(4, 3, 50);

        this.passive = randomInts[0];
        this.submissive = randomInts[1];
        this.aggressive = randomInts[2];
        this.dominant = randomInts[3];
        this.howManyCycles = generateRandomNumberInRange(5,15);
    }

    private void simulationMainLoop(){
        int cycleCounter = 0;
        structOrg.constructData();
        while(this.howManyCycles == cycleCounter){

            //interactions.fightForFood();
            //interactions.evaluateBatches();
            cycleCounter++;
        }
    }

}