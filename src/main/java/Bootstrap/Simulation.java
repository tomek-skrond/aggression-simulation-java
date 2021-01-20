package Bootstrap;

import Interactions.InteractionAgent;
import Organisms.Abstractions.Organism;
import ResultToFiles.ResultToFile;
import StructureOrganisation.Interfaces.IRandomizer;
import StructureOrganisation.StructureOrganisationAgent;

import java.io.FileWriter;
import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class Simulation implements IRandomizer {

    private int howManyCycles;
    StructureOrganisationAgent structOrg;
    private InteractionAgent interactions; //assign when all structures are organised(put in batches)


    public Simulation(int _aggressive,int _dominant,int _passive,int _submissive,int _howManyCycles) throws Exception {

        int [] paramsList = {_aggressive,_dominant,_passive,_submissive};

        this.howManyCycles = _howManyCycles;

        this.structOrg = new StructureOrganisationAgent(paramsList);

        simulationMainLoop();
    }
    public Simulation() throws Exception {
        int[] randomInts = generateRandomIntArray(4, 3, 50);

        this.howManyCycles = generateRandomNumberInRange(5,15);

        this.structOrg = new StructureOrganisationAgent(randomInts);

        simulationMainLoop();
    }

     void simulationMainLoop() throws Exception {
        int cycleCounter = 0;

        structOrg.initializeData();

        while(this.howManyCycles != cycleCounter){

            structOrg.constructData(structOrg.getOrganisms());
            int[] orgCounted = structOrg.countOrganisms();


            String cycleNote =
                        "\n" + "------------------------------" + "\n" +
                            "cycle number: " + cycleCounter +
                            " A: " + orgCounted[0] + " " +
                            " D: " + orgCounted[1] + " " +
                            " P: " + orgCounted[2] + " " +
                            " S: " + orgCounted[3] + " " +
                            " O: " + (Arrays.stream(orgCounted).sum()) + " " + "\n" +
                            "size of batches: " + structOrg.getBatches().size();

            //resultHandler = new ResultToFileHandler(cycleNote);

            ResultToFile results = (msg, filename) -> {
                FileWriter writer = new FileWriter(filename);
                writer.write(msg);
                writer.close();
            };
            results.saveToFile(cycleNote,"wyniki_symulacji");

            System.out.println(cycleNote);
            this.setupInteractions();
            interactions.fightForFood();

            executeDuplication();
            structOrg.backupOrganismSet();
            structOrg.setOrganisms(structOrg.gatherCycleOutput());
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