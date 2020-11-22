package Organisms;

public class SubmissiveOrganism extends Organism{
    public SubmissiveOrganism(){
        super();
        this.hostility = 0.0;
    }
    public SubmissiveOrganism(Double _reproductionRate, Double _hostility,
                              Double _foodTaken, Double _isAlive){
        super(_reproductionRate,_hostility,_foodTaken,_isAlive);
    }
}
