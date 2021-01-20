package Organisms;

import Organisms.Abstractions.Organism;

/**
 * Organizm dominujący współczynnik agresji = 2
 */
public class DominantOrganism extends Organism {
    public static int dominantCounter = 0;

    public DominantOrganism(){
        super();
        this.hostility = 2.0;
        dominantCounter++;

    }
    public DominantOrganism(double _reproductionRate, double _hostility,
                            double _foodTaken, double _isAlive){

        super(_reproductionRate,_hostility,_foodTaken,_isAlive);
        this.hostility = 2.0;
        dominantCounter++;
    }

    /**
     * Konstruktor dla prototypów
     * @param source
     */
    public DominantOrganism(DominantOrganism source){
        super(source);
        this.hostility = 2.0;
        dominantCounter++;
    }

    /**
     * Funkcja klonująca(prototypy)
     * @return DominantOrganism
     */
    @Override
    public Organism cloneObject(){
        dominantCounter++;
        return new DominantOrganism(this);
    }

    /**
     * Funkcja interakcji
     * @param o1
     */
    @Override
    public void objectInteraction(Organism o1){
        if(o1.getHostility() == 2.0){
            this.setFoodTaken(0.0);
            o1.setFoodTaken(0.0);
        }
        if(o1.getHostility() == 1.5){
            this.setFoodTaken(1.0);
            o1.setFoodTaken(1.0);
        }
        if(o1.getHostility() == 1.0){
            this.setFoodTaken(2.0);
            o1.setFoodTaken(0.0);
        }
        if(o1.getHostility() == 0.5){
            this.setFoodTaken(2.0);
            o1.setFoodTaken(0.0);
        }
    }

    @Override
    public String toString(){
        return "Dominant " + super.toString();
    }
}
