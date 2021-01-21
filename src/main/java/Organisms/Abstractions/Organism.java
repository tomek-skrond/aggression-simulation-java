package Organisms.Abstractions;


import Organisms.Interfaces.CanInteract;
import Organisms.Interfaces.OrganismInterface;

/**
 * Organism abstraction/klasa abstrakcyjna dla organizmów
 **/
public abstract class Organism implements CanInteract, OrganismInterface {

    protected double hostility;
    private double foodTaken;
    protected double isAlive;
    public static int organismCounter = 0;

    /**
        Default constructor/Konstruktor domyślny
     **/
    public Organism(){
        this.hostility = 0.0;
        this.foodTaken = 0.0;
        this.isAlive = 1.0;
        organismCounter++;
    }

    /**
     * Constructor/Konstruktor
     * @param _hostility -- współczynnik agresji - warunkuje sposób interakcji z innymi organizmami
     * @param _foodTaken -- jedzenie, które udało się zdobyć przez organizm w iteracji
     * @param _isAlive -- określa prawdopodobieństwo przeżycia organizmu w następnym cyklu
     */
    public Organism(double _hostility,
                    double _foodTaken, double _isAlive){
        this.hostility = _hostility;
        this.foodTaken = _foodTaken;
        this.isAlive = _isAlive;
        organismCounter++;
    }

    /**
     * toString - zwraca String opisujący instancję Organizmu
     * @return String
     */
    @Override
    public String toString(){
        return "(" +
                "host: " + this.hostility + "," +
                "food: " + this.foodTaken + "," +
                "alive: " + this.isAlive + ")";
    }

    /**
     * getter zmiennej hostility
     * @return double
     */
    public double getHostility() {
        return hostility;
    }
    /**
     * setter zmiennej hostility
     * @return double
     */
    public void setHostility(Double hostility) {
        this.hostility = hostility;
    }
    /**
     * getter zmiennej foodTaken
     * @return double
     */
    public double getFoodTaken() {
        return foodTaken;
    }
    /**
     * setter zmiennej foodTaken
     */
    public void setFoodTaken(Double foodTaken) {
        this.foodTaken = foodTaken;
    }
    /**
     * getter zmiennej isAlive
     * @return double
     */
    public double getIsAlive() {
        return isAlive;
    }
    /**
     * setter zmiennej isAlive
     */
    public void setIsAlive(Double isAlive) {
        this.isAlive = isAlive;
    }
}
