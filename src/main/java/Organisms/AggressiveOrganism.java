package Organisms;

import Organisms.Abstractions.Organism;

/**
 * Organizm o charakterze agresywnym - współczynnik agresji = 1.5
 **/
public class AggressiveOrganism extends Organism {
    /**
     * Konstruktor domyślny
     **/
    public AggressiveOrganism(){
        super();
        this.hostility = 1.5;
    }

    /**
     * Konstruktor
     */
    public AggressiveOrganism(double _reproductionRate,double _hostility,
                              double _foodTaken,double _isAlive){
        super(_reproductionRate,_hostility,_foodTaken,_isAlive);
    }

    /**
     * Konstruktor umożliwiający funkcję klonowania
     * @param source
     */
    public AggressiveOrganism(AggressiveOrganism source){
        super(source);
        this.hostility = 1.5;
    }

    public Organism getObj(){
        return new AggressiveOrganism();
    }

    @Override
    public Organism cloneObject(){
        return new AggressiveOrganism(this);
    }

    @Override
    public void objectInteraction(Organism o1){
        if(o1.getHostility() == 2.0){

        }
        if(o1.getHostility() == 1.5){

        }
        if(o1.getHostility() == 1.0){

        }
        if(o1.getHostility() == 0.5){

        }
    }
}
