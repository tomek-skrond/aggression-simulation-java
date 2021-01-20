package Organisms.Interfaces;

/**
 * interfejs deklarujący funkcjonalność
 */
public interface OrganismInterface {
    /**
     *
     * deklaracja getterów i setterów
     */

    /**
     * funkcja zwraca wartość boolean w zalezności od ilości pozyskanej żywności i ustawia
     * parametr isAlive według pozyskanej żywności
     * @return boolean
     */

    default boolean evaluateState(){
        if(this.getFoodTaken() >= 1.0){
            this.setIsAlive(1.0);
            return true;
        }
        else{
            setIsAlive(0.0);
            return false;
        }
    }

    double getReproductionRate();

    void setReproductionRate(Double reproductionRate);

    double getHostility();

    void setHostility(Double hostility);

    double getFoodTaken();

    void setFoodTaken(Double foodTaken);

    double getIsAlive();

    void setIsAlive(Double isAlive);

}
