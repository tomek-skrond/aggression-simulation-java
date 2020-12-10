package Organisms;

import Organisms.Abstractions.Organism;

/**
 * Organizm uległy współczynnik agresji = 0.5
 */
public class SubmissiveOrganism extends Organism {
    public SubmissiveOrganism(){
        super();
        this.hostility = 0.5;
    }

    /**
     * Konstruktor
     * @param _reproductionRate
     * @param _hostility
     * @param _foodTaken
     * @param _isAlive
     */
    public SubmissiveOrganism(Double _reproductionRate, Double _hostility,
                              Double _foodTaken, Double _isAlive){
        super(_reproductionRate,_hostility,_foodTaken,_isAlive);
    }

    /**
     * Konstruktor dla prototypów
     * @param source
     */
    public SubmissiveOrganism(SubmissiveOrganism source){
        super(source);
        this.hostility = 0.5;
    }

    /**
     * Funkcja
     * @return SubmissiveOrganism
     */
    @Override
    public Organism cloneObject(){
        return new SubmissiveOrganism(this);
    }
    @Override
    public void objectInteraction(Organism o1){

    }
}
