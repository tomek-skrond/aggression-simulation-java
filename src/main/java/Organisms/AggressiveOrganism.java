package Organisms;

/**
 * Organizm o charakterze agresywnym - współczynnik agresji = 2
 **/
public class AggressiveOrganism extends Organism{
    /**
     * Konstruktor domyślny
     **/
    public AggressiveOrganism(){
        super();
    }

    /**
     * Konstruktor
     */
    public AggressiveOrganism(double _reproductionRate,double _hostility,
                              double _foodTaken,double _isAlive){
        super(_reproductionRate,_hostility,_foodTaken,_isAlive);
    }

}
