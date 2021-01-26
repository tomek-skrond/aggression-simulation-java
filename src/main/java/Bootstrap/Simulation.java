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
 * klasa obsulugujaca cykle symulacyjne
 */
public class Simulation implements IRandomizer {

    /**
     * decyduje o tym, czy zapis do pliku jest skrócony
     */
    boolean isShortened;
    /**
     * przechowuje informacje na temat symulacji, ktore sa zapisywane do pliku
     */
    String simulationNote = "";
    /**
     * licznik cykli symulacyjnych
     */
    private int howManyCycles;
    /**
     * instancja klasy organizujacej struktury organizmow
     */
    StructureOrganisationAgent structOrg;
    /**
     * instancja klasy interakcji, odpowiadajacej za interakcje miedzy organizmami
     */
    InteractionAgent interactions; //assign when all structures are organised(put in batches)

    /**
     * Konstruktor klasy Symulacji
     * @param _aggressive liczba agresywnych osobnikow
     * @param _dominant liczba dominujacych osobnikow
     * @param _passive liczba pasywnych osobnikow
     * @param _submissive liczba uleglych osobnikow
     * @param _howManyCycles liczba cykli
     * @param isShortened zmienna decydujaca o sposobie zapisu (skrocony czy normalny), skrocony zapis zapisuje dane do pliku csv
     * @throws Exception
     */
    public Simulation(int _aggressive,int _dominant,int _passive,int _submissive,int _howManyCycles,boolean isShortened) throws Exception {

        int [] paramsList = {_aggressive,_dominant,_passive,_submissive};

        this.isShortened = isShortened;

        this.howManyCycles = _howManyCycles;

        this.structOrg = new StructureOrganisationAgent(paramsList);

        simulationMainLoop();
    }

    /**
     * Konstruktor domyslny klasy Symulacji
     * @throws Exception
     */
    public Simulation() throws Exception {
        int[] randomInts = generateRandomIntArray(4, 3, 50);

        this.isShortened = true;

        this.howManyCycles = generateRandomNumberInRange(5,15);

        this.structOrg = new StructureOrganisationAgent(randomInts);


    }

    /**
     * Glowna petla symulacyjna
     * @throws Exception
     */
     void simulationMainLoop() throws Exception {
        int cycleCounter = 0;

        simulationNote = "";
        structOrg.initializeData();

        while(this.howManyCycles != cycleCounter){

            structOrg.constructData(structOrg.getOrganisms());
            int[] orgCounted = structOrg.countOrganisms();

            this.updateSimulationNote(orgCounted,cycleCounter);

            ResultToFile results = (msg, filename) -> {
                FileWriter writer = new FileWriter(filename);
                writer.write(msg);
                writer.close();
            };

            this.saveNote(results);

            this.setupInteractions();
            interactions.fightForFood();

            executeDuplication();
            structOrg.backupOrganismSet();
            structOrg.setOrganisms(structOrg.gatherCycleOutput());
            cycleCounter++;
        }
         System.out.println(simulationNote);

     }

    /**
     * metoda umozliwiajaca poprawne zduplikowanie organizmow
     */
    void executeDuplication() {
        List<Organism> duplicationResults = interactions.duplication();
        this.structOrg.setOrganisms(duplicationResults);
        this.structOrg.constructData(this.structOrg.getOrganisms());
    }

    /**
     * Metoda przygotowujaca klase interakcji do dzialania
     */
    void setupInteractions(){
        interactions = new InteractionAgent(this.structOrg);
    }

    /**
     * Metoda aktualizujaca opis cyklu
     * @param orgCounted tablica liczb organizmow w biezacym cyklu (orgCounted[0] - agresywne, [1] - dominujace, [2] - pasywne, [3] - ulegle)
     * @param cycleCounter licznik cykli symulacyjnych
     */
    void updateSimulationNote(int[] orgCounted, int cycleCounter){

        if(this.isShortened){
            if(this.simulationNote.equals("")){
                this.simulationNote +=
                        "cycle,aggresive,dominant,passive,submissive,batches_count" + "\n";
            }
            this.simulationNote +=
                           cycleCounter + "," +
                            + orgCounted[0] + "," +
                            + orgCounted[1] + "," +
                            + orgCounted[2] + "," +
                            + orgCounted[3] + "," +
                            + structOrg.getBatches().size() + "\n";

        }else{
            this.simulationNote +=
                    "\n" + "------------------------------" + "\n" +
                            "cycle number: " + cycleCounter +
                            " A: " + orgCounted[0] + " " +
                            " D: " + orgCounted[1] + " " +
                            " P: " + orgCounted[2] + " " +
                            " S: " + orgCounted[3] + " " +
                            " O: " + (Arrays.stream(orgCounted).sum()) + " " + "\n" +
                            "size of batches: " + structOrg.getBatches().size();
        }

    }

    /**
     * Metoda zapisujaca do pliku wyniki symulacji
     * @param res delegat intefejsu ResultToFile
     * @throws Exception
     */
    void saveNote(ResultToFile res) throws Exception {
        if(this.isShortened){
            res.saveToFile(simulationNote,"wyniki_symulacji_short.csv");
        }else{
            res.saveToFile(simulationNote,"wyniki_symulacji.txt");
        }
    }
}