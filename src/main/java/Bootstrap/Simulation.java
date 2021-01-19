package Bootstrap;

import Interactions.InteractionAgent;
import Organisms.*;
import Organisms.Abstractions.Organism;
import ResultToFiles.ResultToFileHandler;
import StructureOrganisation.Batch;
import StructureOrganisation.Interfaces.IRandomizer;
import StructureOrganisation.StructureOrganisationAgent;

import java.util.Arrays;
import java.util.List;


public class Simulation implements IRandomizer {

    private final int passive;
    private final int submissive;
    private final int aggressive;
    private final int dominant;

    private int howManyCycles;
    StructureOrganisationAgent structOrg;
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

        simulationMainLoop();
    }
    public Simulation(){
        int[] randomInts = generateRandomIntArray(4, 3, 50);

        this.passive = randomInts[0];
        this.submissive = randomInts[1];
        this.aggressive = randomInts[2];
        this.dominant = randomInts[3];
        this.howManyCycles = generateRandomNumberInRange(5,15);

        this.structOrg = new StructureOrganisationAgent(randomInts);

        simulationMainLoop();
    }

     void simulationMainLoop(){
        int cycleCounter = 0;

        structOrg.initializeData();

        while(this.howManyCycles != cycleCounter){

            structOrg.constructData(structOrg.getOrganisms());
            this.setupInteractions();
            interactions.fightForFood();

            executeDuplication();
            structOrg.backupOrganismSet();
            //TODO:food to 0 after gatherCycleOutput


            structOrg.setOrganisms(
                    structOrg.gatherCycleOutput()
            );

            int[] orgCounted = structOrg.countOrganisms();

            System.out.println("------------------------------");
            System.out.println("cycle number: " + cycleCounter);
            System.out.println(
                    " A: " + orgCounted[0] + "\n" +
                    " D: " + orgCounted[1] + "\n" +
                    " P: " + orgCounted[2] + "\n" +
                    " S: " + orgCounted[3] + "\n" +
                    " O: " + (Arrays.stream(orgCounted).sum()) + "\n"
            );
            System.out.println("size of batches: " + structOrg.getBatches().size());
            cycleCounter++;
        }
    }

    private void executeDuplication() {
        List<Organism> duplicationResults = interactions.duplication();
        this.structOrg.setOrganisms(duplicationResults);
        this.structOrg.constructData(this.structOrg.getOrganisms());
    }

    void setupInteractions(){
        interactions = new InteractionAgent(this.structOrg);
    }
}