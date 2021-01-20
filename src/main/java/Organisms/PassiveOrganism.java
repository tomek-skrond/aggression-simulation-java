package Organisms;

import Organisms.Abstractions.Organism;

/**
 *  * Organizm pasywny - współczynnik agresji = 1
 */
public class PassiveOrganism extends Organism {

    public static int passiveCounter = 0;

    public PassiveOrganism(){
        super();
        this.hostility = 1.0;
        passiveCounter++;
    }

    public PassiveOrganism(double _reproductionRate, double _hostility,
                           double _foodTaken, double _isAlive){
        super();
        this.hostility = 1.0;
        passiveCounter++;
    }

    /**
     * Konstruktor dla Prototypów
     * @param source
     */
    public PassiveOrganism(PassiveOrganism source){
        super(source);
        this.hostility = 0.5;
        passiveCounter++;
    }

    /**
     * Funkcja klonująca(prototypy)
     * @return PassiveOrganism
     */
    @Override
    public Organism cloneObject(){
        passiveCounter++;
        return new PassiveOrganism(this);
    }

    /**
     * Funkcja interakcji
     * @param o1
     */
    @Override
    public void objectInteraction(Organism o1){
        if(o1.getHostility() == 2.0){
            this.setFoodTaken(0.0);
            o1.setFoodTaken(2.0);
        }
        if(o1.getHostility() == 1.5){
            this.setFoodTaken(0.5);
            o1.setFoodTaken(1.5);
        }
        if(o1.getHostility() == 1.0){
            this.setFoodTaken(1.0);
            o1.setFoodTaken(1.0);
        }
        if(o1.getHostility() == 0.5){
            this.setFoodTaken(1.5);
            o1.setFoodTaken(0.5);
        }
    }

    @Override
    public String toString(){
        return "Passive " + super.toString();
    }
}
