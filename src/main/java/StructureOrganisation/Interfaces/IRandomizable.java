package StructureOrganisation.Interfaces;
import java.util.Random;

public interface IRandomizable {
    default int generateRandomIntInRange(int min,int max){
        return (int)(Math.random()*((max - min) + 1)) + min;
    }
}
