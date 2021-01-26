package StructureOrganisation.Interfaces;

import Organisms.Abstractions.Organism;

/**
 * IPairable
 * okresla funkcjonalnosci klas implementujacych ten interfejs
 */
public interface IPairable {
    /**
     * setter pierwszego elementu pary
     * @param o Organizm
     */
    void setFirst(Organism o);

    /**
     * setter drugiego elementu pary
     * @param o Organizm
     */
    void setSecond(Organism o);

    /**
     * getter pierwszego elementu pary
     * @return Organism
     */
    Organism getFirst();
    /**
     * getter pierwszego elementu pary
     * @return Organism
     */
    Organism getSecond();
}
