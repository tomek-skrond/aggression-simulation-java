package Organisms.Abstractions;


import Organisms.Interfaces.CanInteract;
import Organisms.Interfaces.ICloneable;
import Organisms.Interfaces.OrganismInterface;

/**
    Organism abstraction/klasa abstrakcyjna dla organizmów
 **/
public abstract class Organism implements ICloneable, CanInteract, OrganismInterface {


    private Double reproductionRate;
    protected Double hostility;
    private Double foodTaken;
    protected Double isAlive;
    public static int organismCounter = 0;

    /**
        Default constructor/Konstruktor domyślny
     **/
    public Organism(){
        this.reproductionRate = 0.0;
        this.hostility = 0.0;
        this.foodTaken = 0.0;
        this.isAlive = 1.0;
        organismCounter++;
    }

    /**
     * Constructor/Konstruktor
     * @param _reproductionRate -- współczynnik reprodukcji - warunkuje prawdopodobieństwo rozmnożenia się organizmu w następnym cyklu
     * @param _hostility -- współczynnik agresji - warunkuje sposób interakcji z innymi organizmami
     * @param _foodTaken -- jedzenie, które udało się zdobyć przez organizm w iteracji
     * @param _isAlive -- określa prawdopodobieństwo przeżycia organizmu w następnym cyklu
     */
    public Organism(double _reproductionRate, double _hostility,
                    double _foodTaken, double _isAlive){
        this.reproductionRate = _reproductionRate;
        this.hostility = _hostility;
        this.foodTaken = _foodTaken;
        this.isAlive = _isAlive;
        organismCounter++;

    }

    public Organism(Organism source){
        this();
        this.foodTaken = source.foodTaken;
        this.hostility = source.hostility;
        this.reproductionRate = source.reproductionRate;
        this.isAlive = source.isAlive;
        organismCounter++;
    }

    @Override
    public String toString(){
        return "(r_r: " + this.reproductionRate + "," +
                "host: " + this.hostility + "," +
                "food: " + this.foodTaken + "," +
                "alive: " + this.isAlive + ")";
    }

    public boolean evaluateState(){
        if(this.getFoodTaken() >= 1.0){
            this.setIsAlive(1.0);
            return true;
        }
        else{
            setIsAlive(0.0);
            return false;
        }
    }

    public double getReproductionRate() {
        return reproductionRate;
    }

    public void setReproductionRate(Double reproductionRate) {
        this.reproductionRate = reproductionRate;
    }

    public double getHostility() {
        return hostility;
    }

    public void setHostility(Double hostility) {
        this.hostility = hostility;
    }

    public double getFoodTaken() {
        return foodTaken;
    }

    public void setFoodTaken(Double foodTaken) {
        this.foodTaken = foodTaken;
    }

    public double getIsAlive() {
        return isAlive;
    }

    public void setIsAlive(Double isAlive) {
        this.isAlive = isAlive;
    }
}
