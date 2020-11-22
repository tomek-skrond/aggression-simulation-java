package Organisms;


/**
    Organism abstraction/klasa abstrakcyjna dla organizmów
 **/
public abstract class Organism {


    private Double reproductionRate;
    protected Double hostility;
    private Double foodTaken;
    protected Double isAlive;

    /**
        Default constructor/Konstruktor domyślny
     **/
    public Organism(){
        this.reproductionRate = 0.0;
        this.hostility = 0.0;
        this.foodTaken = 0.0;
        this.isAlive = 1.0;
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

    public Double getReproductionRate() {
        return reproductionRate;
    }

    public void setReproductionRate(Double reproductionRate) {
        this.reproductionRate = reproductionRate;
    }

    public Double getHostility() {
        return hostility;
    }

    public void setHostility(Double hostility) {
        this.hostility = hostility;
    }

    public Double getFoodTaken() {
        return foodTaken;
    }

    public void setFoodTaken(Double foodTaken) {
        this.foodTaken = foodTaken;
    }

    public Double getIsAlive() {
        return isAlive;
    }

    public void setIsAlive(Double isAlive) {
        this.isAlive = isAlive;
    }

}
