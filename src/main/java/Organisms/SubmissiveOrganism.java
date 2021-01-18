package Organisms;

import Organisms.Abstractions.Organism;

/**
 * Organizm uległy współczynnik agresji = 0.5
 */
public class SubmissiveOrganism extends Organism {

    int deadCounter = 0;
    boolean duplicateIndicator = false;
    public static int submissiveCounter = 0;

    public SubmissiveOrganism(){
        super();
        this.hostility = 0.5;
        submissiveCounter++;
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
        this.hostility = 0.5;
        submissiveCounter++;
    }

    /**
     * Konstruktor dla prototypów
     * @param source
     */
    public SubmissiveOrganism(SubmissiveOrganism source){
        super(source);
        this.hostility = 0.5;
        submissiveCounter++;
    }

    /**
     * Funkcja
     * @return SubmissiveOrganism
     */
    @Override
    public Organism cloneObject(){
        submissiveCounter++;
        return new SubmissiveOrganism(this);
    }
    @Override
    public void objectInteraction(Organism o1){

        if(o1.getHostility() == 2.0){
            this.setFoodTaken(0.0);
            o1.setFoodTaken(2.0);
        }
        if(o1.getHostility() == 1.5){
            this.setFoodTaken(0.0);
            o1.setFoodTaken(2.0);
        }
        if(o1.getHostility() == 1.0){
            this.setFoodTaken(1.0);
            o1.setFoodTaken(1.0);
        }
        if(o1.getHostility() == 0.5){
            this.setFoodTaken(1.0);
            o1.setFoodTaken(1.0);
        }
        if(deadCounter == 50){
            duplicateIndicator = true;
        }
    }

    @Override
    public String toString(){
        return "Submissive " + super.toString();
    }
}
