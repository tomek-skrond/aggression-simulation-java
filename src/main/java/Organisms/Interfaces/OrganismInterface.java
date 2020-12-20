package Organisms.Interfaces;

import Organisms.Abstractions.Organism;

public interface OrganismInterface {
    Double getReproductionRate();

    void setReproductionRate(Double reproductionRate);

    Double getHostility();

    void setHostility(Double hostility);

    Double getFoodTaken();

    void setFoodTaken(Double foodTaken);

    Double getIsAlive();

    void setIsAlive(Double isAlive);

}
