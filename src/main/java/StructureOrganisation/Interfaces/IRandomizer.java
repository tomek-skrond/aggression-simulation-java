package StructureOrganisation.Interfaces;
import java.util.ArrayList;
import java.util.List;


/**
 * interfejs implementujący funkcje losujące
 */
public interface IRandomizer {
    /**
     * funkcja generująca losowe liczby całkowite z danego zakresu (min,max)
     * @param min - minimqlnq liczba w zakresie
     * @param max - maksymalna liczba w zakresie
     * @return int
     */
    default int generateRandomNumberInRange(int min, int max){
        return (int)(Math.random()*((max - min) + 1)) + min;
    }

    /**
     * funkcja generująca tablicę losowych liczb całkowitych w zakresie (min,max)
     * @param n - rozmiar generowanej tablicy
     * @param min - minimalna liczba w zakresie
     * @param max - maksymalna liczba w zakresie
     * @return int[]
     */
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
