package Interactions;

import Organisms.Abstractions.Organism;
import Organisms.SubmissiveOrganism;
import StructureOrganisation.Batch;
import StructureOrganisation.Interfaces.IRandomizer;
import StructureOrganisation.StructureOrganisationAgent;

import java.util.ArrayList;
import java.util.List;

/**
 * klasa wykonujaca interakcje miedzy organizmami
 */

public class InteractionAgent implements IRandomizer{

    List<Batch> batches;
    List<Organism> organisms;

    /**
     * Konstruktor
     * @param structOrg obiekt klasy StructureOrganisationAgent
     */
    public InteractionAgent(StructureOrganisationAgent structOrg){
        this.batches = structOrg.getBatches();
        this.organisms = structOrg.getOrganisms();
    }

    /**
     * funkcja wykonujaca interakcje miedzy wszystkimi organizmami
     */
    public void fightForFood(){
        //for b in batches -> b.interact
        for(Batch b : batches){
            b.getFirst().objectInteraction(b.getSecond());
        }
    }

    /**
     * Zwraca nowa liste organizmow, w ktorej organizmy o wspolczynniku jedzenia 2.0 sa skopiowane
     * @return List{Organism}
     */
    public List<Organism> duplication(){
        List<Organism> bufList = this.organisms;
        List<Organism> toClone = new ArrayList<>();

        this.resolveProbabilities();

        this.checkSpecialAbilities();

        for (Organism o : this.organisms) {
            if(o.getFoodTaken() == 2.0){
                toClone.add(o);
            }
        }

        bufList.addAll(toClone);

        setOrganisms(bufList);
        return bufList;
    }

    /**
     * sprawdza dodatkowe zachowania interakcyjne klas
     */
    private void checkSpecialAbilities() {
        List<Organism> buff = new ArrayList<>();
        for(Organism o : this.organisms){
            if(o instanceof SubmissiveOrganism){
                if(o.getFoodTaken() == 0.0){
                    SubmissiveOrganism.submissiveCounter--;
                }
            }
        }

        this.organisms.addAll(buff);
    }

    /**
     * losuje parametry dla organizmow z niecalkowitymi wspolczynnikami jedzenia
     */
    private void resolveProbabilities(){
        for(Organism o : this.organisms){
            if(o.getFoodTaken() == 0.5){
                o.setFoodTaken((double)generateRandomNumberInRange(0,1));
            }
            if(o.getFoodTaken() == 1.5){
                o.setFoodTaken((double)generateRandomNumberInRange(1,2));
            }
        }
    }

    /**
     * Setter
     * @param organisms lista organizmow
     */
    public void setOrganisms(List<Organism> organisms) {
        this.organisms = organisms;
    }
}
