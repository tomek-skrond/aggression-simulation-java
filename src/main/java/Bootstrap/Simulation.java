package Bootstrap;

import Interactions.InteractionAgent;
import Organisms.*;
import Organisms.Abstractions.Organism;
import ResultToFiles.ResultToFileHandler;
import StructureOrganisation.Batch;
import StructureOrganisation.Interfaces.IRandomizer;
import StructureOrganisation.StructureOrganisationAgent;


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

            //TODO:food to 0 after gatherCycleOutput
            //interactions.evaluateBatches();

            /*
            for(Batch b : structOrg.getBatches()){
                System.out.println(b);
            }*/

            structOrg.setOrganisms(
                    structOrg.gatherCycleOutput()
            );

            int[] orgCounted = structOrg.countOrganisms();
            System.out.println("------------------------------");
            /*for(Batch b : structOrg.getBatches()){
                System.out.println(b);
            }*/
            System.out.println("cycle number: " + cycleCounter);
            System.out.println(
                    " A: " + orgCounted[0] + "\n" +
                    " D: " + orgCounted[1] + "\n" +
                    " P: " + orgCounted[2] + "\n" +
                    " S: " + orgCounted[3] + "\n" +
                    " O: " + (Organism.organismCounter - Empty.emptyCounter) + "\n"
            );
            System.out.println("size of batches: " + structOrg.getBatches().size());
            cycleCounter++;
        }
    }

    void setupInteractions(){
        interactions = new InteractionAgent(this.structOrg.getBatches());
    }
}