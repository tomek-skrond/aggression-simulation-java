package Bootstrap;

import Interactions.InteractionAgent;
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
            interactions.fightForFood();
            //interactions.evaluateBatches();

            /*
            for(Batch b : structOrg.getBatches()){
                System.out.println(b);
            }*/

            structOrg.setOrganisms(
                    structOrg.gatherCycleOutput()
            );

            System.out.println("------------------------------");
            for(Batch b : structOrg.getBatches()){
                System.out.println(b);
            }
            System.out.println(structOrg.getBatches().size());
            cycleCounter++;
        }
    }

}