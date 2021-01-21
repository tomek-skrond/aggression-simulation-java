package Organisms;

import Organisms.Abstractions.Organism;

/**
 * Organizm o charakterze agresywnym - współczynnik agresji = 1.5
 **/
public class AggressiveOrganism extends Organism {

    public static int aggressiveCounter = 0;

    /**
     * Konstruktor domyślny
     **/
    public AggressiveOrganism(){
        super();
        this.hostility = 1.5;
        aggressiveCounter++;
    }

    /**
     *
     * @param _hostility
     * @param _foodTaken
     * @param _isAlive
     */
    public AggressiveOrganism(double _reproductionRate,double _hostility,
                              double _foodTaken,double _isAlive){
        super(_reproductionRate,_hostility,_foodTaken,_isAlive);
        aggressiveCounter++;
    }

    /**
     * Konstruktor umożliwiający funkcję klonowania
     * @param source
     */
    public AggressiveOrganism(AggressiveOrganism source){
        super(source);
        this.hostility = 1.5;
        aggressiveCounter++;
    }

    @Override
    public Organism cloneObject(){
        aggressiveCounter++;
        return new AggressiveOrganism(this);
    }

    /**
     * Funkcja interakcji okreslajaca interakcje z innym organizmem(o1)
     * @param o1
     */
    @Override
    public void objectInteraction(Organism o1){
        if(o1.getHostility() == 2.0){
            this.setFoodTaken(0.0);
            o1.setFoodTaken(0.0);
        }
        if(o1.getHostility() == 1.5){
            this.setFoodTaken(1.5);
            o1.setFoodTaken(0.5);
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
    /**
     * toString - zwraca String opisujący instancję Organizmu
     * @return String
     */
    @Override
    public String toString(){
        return "Aggressive " + super.toString();
    }
}
