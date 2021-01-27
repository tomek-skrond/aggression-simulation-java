package StructureOrganisation;

import Organisms.*;
import Organisms.Abstractions.Organism;
import Organisms.Enums.OrganismType;
import StructureOrganisation.Interfaces.IRandomizer;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class StructureOrganisationAgent implements IRandomizer {

    private List<Organism> organisms;
    private List<OrganismPair> pairs;
    private List<Batch> batches;
    int [] paramsList;

    /**
     * StructureOrganisationAgent
     * Klasa odpowiadajaca za organizowanie struktur
     * @param orgParamsList lista parametrow symulacji (liczb odpowiadajacym poczatkowym liczbom danych organizmow)
     */
    public StructureOrganisationAgent(int [] orgParamsList){
        this.organisms = new ArrayList<>();
        this.pairs = new ArrayList<>();
        this.batches = new ArrayList<>();
        this.paramsList = orgParamsList;
    }

    /**
     * makeOrganismOfType
     * Funkcja odpowiada za wygenerowanie listy organizmow danego typu
     * @param type typ organizmu
     * @param howMany ile organizmow ma byc wygenerowanych
     * @return List{Organism}
     */
    List<Organism> makeOrganismsOfType(OrganismType type, int howMany){//
        List<Organism> buff = new ArrayList<>();

        for (int i = 0; i < howMany; i++) {
            switch(type){
                case A:
                    buff.add(new AggressiveOrganism());
                    break;
                case D:
                    buff.add(new DominantOrganism());
                    break;
                case P:
                    buff.add(new PassiveOrganism());
                    break;
                case S:
                    buff.add(new SubmissiveOrganism());
                    break;
            }
        }
        return buff;

    }

    /**
     * generateOrganisms
     * Funkcja generujaca liste organizmow gotowych do przetworzenia dalej,
     * organizmy generowane sa wedlug danych wejsciowych (paramsList)
     * @return List{Organism}
     */
    List<Organism> generateOrganisms(){//

        List<List<Organism>> l = new ArrayList<>();
        List<Organism> list;

        int i = 0;
        for(OrganismType type : OrganismType.values()){

            l.add(makeOrganismsOfType(type,paramsList[i]));
            i++;
        }

        list = l.stream()
                          .flatMap(x->x.stream())
                          .collect(Collectors.toList());
        this.organisms = list;

        return list;
    }

    /**
     * validateParity
     * Funkcja zwraca czy rozmiar tablicy organizmow jest parzysty
     * @return boolean
     */
    boolean validateParity(){//
        return this.organisms.size() % 2 == 0;
    }

    /**
     * backupOrganismSet
     * Funkcja usuwajaca nieparzystosc w zbiorze organizmow
     */
    public void backupOrganismSet(){//
        if(!validateParity()){

            this.organisms.add(
                    new PassiveOrganism()
            );
        }
    }

    /**
     * updatePairs
     * Funkcja zbierajaca wszystkie organizmy do par
     * @param orgs lista organizmow
     * @return List{OrganismPair}
     */
    ArrayList<OrganismPair> updatePairs(List<Organism> orgs) {//

        this.backupOrganismSet();

        List<OrganismPair> pairsBuff = new ArrayList<>();
        Organism[] orgArr = new Organism[orgs.size()];
        orgs.toArray(orgArr);

        Organism[][] resultArr = new Organism[orgs.size()/2][];

        int counter = 0;

        for (int i = 0; i < orgs.size(); i+=2) {
            resultArr[counter] = Arrays.copyOf(
                    getSlice(orgArr,i,i+2),resultArr.length+2
            );

            counter++;
        }
        for(Organism[] r : resultArr){
            List<Organism>l = new ArrayList<>(Arrays.asList(r));
            pairsBuff.add(
                    new OrganismPair(
                            l.get(0),l.get(1)
                    )
            );
        }

        return (ArrayList<OrganismPair>) pairsBuff;
    }

    /**
     * getSlice
     * funkcja pobierajaca fragment tablicy w danym zakresie
     * @param arr tablica organizmow
     * @param startIndex indeks rozpoczecia fragmentacji tablicy
     * @param endIndex indeks konca fragmentacji tablicy
     * @return Organism[]
     */
    Organism[] getSlice(Organism[] arr,int startIndex,int endIndex){//
        return Arrays.copyOfRange(arr,startIndex,endIndex);
    }

    /**
     * initializeData
     * inicjalizuje dane wejsciowe symulacji
     */
    public void initializeData(){//
        this.organisms = generateOrganisms();
        this.organisms = shuffle();
        this.pairs = updatePairs(this.organisms);
        this.batches = updateBatches(this.pairs);
    }

    /**
     * constructData
     * funkcja skladajaca dane, zeby byly gotowe do interakcji
     * @param organisms lista organizmow
     */
    public void constructData(ArrayList<Organism> organisms){//
        this.organisms = organisms;
        this.organisms = shuffle();
        this.pairs = this.updatePairs(this.organisms);
        this.batches = this.updateBatches(this.pairs);
    }

    /**
     * gatherCycleOutput
     * funkcja zbierajaca koncowa liste organizmow jako wynik cyklu
     * @return ArrayList{Organism}
     */
    public ArrayList<Organism> gatherCycleOutput(){
        ArrayList<Batch> inputBatches = this.getBatches();
        List<Organism> buff = new ArrayList<>();

        for(Batch b : inputBatches){
            Organism first = b.getFirst();
            Organism second = b.getSecond();

            if(first.evaluateState()){
                buff.add(first);
            }
            if(second.evaluateState()){
                buff.add(second);
            }
        }

        flushFood(buff);

        this.organisms = buff;
        this.pairs = this.updatePairs(buff);
        this.batches = updateBatches(this.pairs);
        return (ArrayList) this.organisms;
    }

    /**
     * flushFood
     * wyzerowanie jednostek jedzenia
     * @param orgs
     */
    void flushFood(List<Organism> orgs) {//
        for(Organism o : orgs){
            o.setFoodTaken(0.0);
        }
    }

    /**
     * updateBatches
     * zebranie par organizmow do Batchy
     * @param pairbuffArr pary organizmow
     * @return
     */
    List<Batch> updateBatches(List<OrganismPair> pairbuffArr) {//
        List<Batch> batchBuffArr = new ArrayList<>();
        for(OrganismPair p : pairbuffArr){
            batchBuffArr.add(
                    new Batch(p,2.0)
            );
        }
        return batchBuffArr;
    }

    /**
     * countOrganisms
     * zliczenie organizmow danych typow w cyklu
     * @return int[]
     */
    public int[] countOrganisms(){
        int[] orgCounted = new int[4];

        for (Organism o : this.organisms) {
            if(o instanceof AggressiveOrganism){
                orgCounted[0]++;
            }
            if(o instanceof DominantOrganism){
                orgCounted[1]++;
            }
            if(o instanceof PassiveOrganism){
                orgCounted[2]++;
            }
            if(o instanceof SubmissiveOrganism){
                orgCounted[3]++;
            }
        }
        return orgCounted;
    }

    /**
     * shuffle
     * potasowanie organizmow, w celu losowego dobrania ich w Batchach
     * @return List{Organism}
     */
    List<Organism> shuffle(){
        Collections.shuffle(this.organisms);
        return this.organisms;
    }

    /**
     * getOrganisms
     * getter
     * @return Array{Organism}
     */
    public ArrayList<Organism> getOrganisms() {
        return (ArrayList) this.organisms;
    }
    /**
     * getBatches
     * getter
     * @return Array{Batch}
     */
    public ArrayList<Batch> getBatches() {
        return (ArrayList) this.batches;
    }
    /**
     * setBatches
     * setter
     */
    public void setBatches(List<Batch> b) {
        this.batches = b;
    }
    /**
     * setOrganisms
     * setter
     */
    public void setOrganisms(ArrayList<Organism> oArray){
        this.organisms = oArray;
    }
    /**
     * getParamsList
     * getter
     * @return int[]
     */
    public int[] getParamsList() {
        return paramsList;
    }
    /**
     * setOrganisms
     * Setter
     */
    public void setOrganisms(List<Organism> organisms) {
        this.organisms = organisms;
    }

    /**
     * getPairs
     * getter
     * @return ArrayList{OrganismPair}
     */
    public ArrayList<OrganismPair> getPairs() {
        return (ArrayList<OrganismPair>) this.pairs;
    }
}
