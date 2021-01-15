package StructureOrganisation.Interfaces;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Arrays;

public interface IRandomizer {
    default int generateRandomNumberInRange(int min, int max){
        return (int)(Math.random()*((max - min) + 1)) + min;
    }
    default int [] generateRandomIntArray(int n,int min, int max){
        List<Integer> buff = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            buff.add(
                    generateRandomNumberInRange(min,max)
            );
        }

        return buff.stream()
                   .mapToInt(Integer::intValue)
                   .toArray();
    }
}
