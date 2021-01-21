package ResultToFiles;

/**
 * Interfejs okreslajacy funkcjonalnosc zapisu danych do pliku
 */
public interface ResultToFile {
    /**
     * Metoda zapisujaca wyniki symulacji do pliku
     * @param msg tresc do zapisania w pliku
     * @param filename nazwa pliku do ktorego zapisywane sa wyniki
     * @throws Exception
     */
    void saveToFile(String msg,String filename) throws Exception;
}
