package StructureOrganisation.Interfaces;

import Organisms.Abstractions.Organism;

public interface IPairable {
    void setFirst(Organism o);
    void setSecond(Organism o);
    Organism getFirst();
    Organism getSecond();
}
