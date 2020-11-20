package Organisms;


/**
    Organism abstraction/klasa abstrakcyjna dla organizmów
 **/
public abstract class Organism {


    private double reproductionRate;
    private double hostility;
    private double foodTaken;
    public double isAlive;

    /**
        Default constructor/Konstruktor domyślny
     **/
    public Organism(){
        this.reproductionRate = 0;
        this.hostility = 0;
        this.foodTaken = 0;
        this.isAlive = 0;
    }

    /**
     * Constructor/Konstruktor
     * @param _reproductionRate -- współczynnik reprodukcji - warunkuje prawdopodobieństwo rozmnożenia się organizmu w następnym cyklu
     * @param _hostility -- współczynnik agresji - warunkuje sposób interakcji z innymi organizmami
     * @param _foodTaken -- jedzenie, które udało się zdobyć przez organizm w iteracji
     * @param _isAlive -- określa prawdopodobieństwo przeżycia organizmu w następnym cyklu
     */
    public Organism(double _reproductionRate,double _hostility, double _foodTaken,double _isAlive){
        this.reproductionRate = _reproductionRate;
        this.hostility = _hostility;
        this.foodTaken = _foodTaken;
        this.isAlive = _isAlive;
    }

    @Override
    public String toString(){
        return "repr_rate: " + this.reproductionRate + "\n" +
                "hostility: " + this.hostility + "\n" +
                "food_taken: " + this.foodTaken + "\n" +
                "is_alive: " + this.isAlive;
    }

    public double getReproductionRate() {
        return this.reproductionRate;
    }

    public void setReproductionRate(double reproductionRate) {
        this.reproductionRate = reproductionRate;
    }

    public double getHostility() {
        return this.hostility;
    }

    public void setHostility(double hostility) {
        this.hostility = hostility;
    }

    public double getFoodTaken() {
        return this.foodTaken;
    }

    public void setFoodTaken(double foodTaken) {
        this.foodTaken = foodTaken;
    }

    public double getIsAlive() {
        return isAlive;
    }

    public void setIsAlive(double isAlive) {
        this.isAlive = isAlive;
    }

}
