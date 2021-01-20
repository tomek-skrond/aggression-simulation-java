package Organisms.Interfaces;

import Organisms.Abstractions.Organism;

/**
 * interfejs deklarujący funkcjonalność interakcji organizmów
 */
public interface CanInteract {
    /**
     * funkcja interakcji, przyjmuje parametr o1 (klasy Organism)
     * @param o1
     */
    void objectInteraction(Organism o1);
}
