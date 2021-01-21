package Organisms.Interfaces;

/**
 * interfejs deklarujący funkcjonalność
 */
public interface OrganismInterface {

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

    /**
     * deklaracja getterów i setterów
     */
    double getHostility();

    double getFoodTaken();

    void setFoodTaken(Double foodTaken);

    void setIsAlive(Double isAlive);

}
