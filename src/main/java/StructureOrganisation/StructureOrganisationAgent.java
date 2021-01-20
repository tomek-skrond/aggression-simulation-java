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
    private int [] paramsList;

    public StructureOrganisationAgent(int [] orgParamsList){
        this.organisms = new ArrayList<>();
        this.pairs = new ArrayList<>();
        this.batches = new ArrayList<>();
        this.paramsList = orgParamsList;
    }

    List<Organism> makeOrganismsOfType(OrganismType type, int howMany){
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
    List<Organism> generateOrganisms(){

        List<List<Organism>> l = new ArrayList<>();
        List<Organism> list;

        int i = 0;
        for(OrganismType type : OrganismType.values()){
            //this.organisms.add((Organism) makeOrganismsOfType(type,i));
            l.add(makeOrganismsOfType(type,paramsList[i]));
            i++;
        }

        list = l.stream()
                          .flatMap(x->x.stream())
                          .collect(Collectors.toList());
        this.organisms = list;

        return list;
    }

    private boolean validateParity(){
        return this.organisms.size() % 2 == 0;
    }

    public void backupOrganismSet(){
        if(!validateParity()){

            this.organisms.add(
                    new SubmissiveOrganism()
            );
        }
    }
    ArrayList<OrganismPair> updatePairs(List<Organism> orgs) {

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
    private Organism[] getSlice(Organism[] arr,int startIndex,int endIndex){
        return Arrays.copyOfRange(arr,startIndex,endIndex);
    }

    /*
    List<Batch> groupIntoBatches(){
        List<Batch> bufList = this.batches;

        for (OrganismPair p : this.pairs) {
            bufList.add(
                    new Batch(p, 2.0)
            );
        }
        return bufList;
    }
*/
    public void initializeData(){
        this.organisms = generateOrganisms();
        this.organisms = shuffle();
        this.pairs = updatePairs(this.organisms);
        this.batches = updateBatches(this.pairs);
        /*
        this.generateOrganisms()
                .shuffle()
                .groupIntoPairs()
                .groupIntoBatches();
         */
    }

    public void constructData(ArrayList<Organism> organisms){
        this.organisms = organisms;
        this.organisms = shuffle();
        this.pairs = this.updatePairs(this.organisms);
        this.batches = this.updateBatches(this.pairs);
        /*
        this.shuffle()
                .groupIntoPairs()
                .groupIntoBatches();

         */
    }

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

    private void flushFood(List<Organism> orgs) {
        for(Organism o : orgs){
            o.setFoodTaken(0.0);
        }
    }

    private List<Batch> updateBatches(List<OrganismPair> pairbuffArr) {
        List<Batch> batchBuffArr = new ArrayList<>();
        for(OrganismPair p : pairbuffArr){
            batchBuffArr.add(
                    new Batch(p,2.0)
            );
        }
        return batchBuffArr;
    }

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

    List<Organism> shuffle(){
        Collections.shuffle(this.organisms);
        return this.organisms;
    }

    public ArrayList<OrganismPair> getPairs() {
        return (ArrayList) this.pairs;
    }

    public ArrayList<Organism> getOrganisms() {
        return (ArrayList) this.organisms;
    }

    public ArrayList<Batch> getBatches() {
        return (ArrayList) this.batches;
    }

    public void setBatches(ArrayList<Batch> bArray){
        this.batches = bArray;
    }
    public void setOrganisms(ArrayList<Organism> oArray){
        this.organisms = oArray;
    }

    public int[] getParamsList() {
        return paramsList;
    }

    public void setOrganisms(List<Organism> organisms) {
        this.organisms = organisms;
    }
}
