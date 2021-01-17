package StructureOrganisation;

import Organisms.*;
import Organisms.Abstractions.Organism;
import Organisms.Enums.OrganismType;
import StructureOrganisation.Interfaces.IRandomizer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class StructureOrganisationAgent implements IRandomizer {




    private List<Organism> organisms;
    private List<OrganismPair> pairs;
    public List<Batch> batches;
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
    StructureOrganisationAgent generateOrganisms(){

        List<List<Organism>> l = new ArrayList<>();

        int i = 0;
        for(OrganismType type : OrganismType.values()){
            //this.organisms.add((Organism) makeOrganismsOfType(type,i));
            l.add(makeOrganismsOfType(type,paramsList[i]));
            i++;
        }

        this.organisms = l.stream()
                          .flatMap(x->x.stream())
                          .collect(Collectors.toList());

        return this;
    }

    private boolean validateParity(){
        return this.organisms.size() % 2 == 0;
    }

    void backupOrganismSet(){
        if(!validateParity()){

            this.organisms.remove(
                    generateRandomNumberInRange(0,this.organisms.size()-1)
            );
        }
    }

   StructureOrganisationAgent groupIntoPairs() {

        this.backupOrganismSet();


        for (int i = 0; i < this.organisms.size()/2; i++) {

            this.pairs.add(
                    new OrganismPair()
            );
        }

       //this.pairs.get(i).setFirst(this.organisms.get(i+j));
       //this.pairs.get(i).setSecond(this.organisms.get(i+j));


        List<Organism> org = this.organisms;
        Organism[] orgArr = new Organism[organisms.size()];
        org.toArray(orgArr);

        Organism[][] resultArr = new Organism[organisms.size()/2][];

        int counter = 0;

        for (int i = 0; i < organisms.size(); i+=2) {
           resultArr[counter] = Arrays.copyOf(
                   getSlice(orgArr,i,i+2),resultArr.length+2
           );
           this.pairs.get(counter).setFirst(resultArr[counter][0]);
           this.pairs.get(counter).setSecond(resultArr[counter][1]);

           counter++;
        }

       return this;
    }
    private Organism[] getSlice(Organism[] arr,int startIndex,int endIndex){
        return Arrays.copyOfRange(arr,startIndex,endIndex);
    }

    StructureOrganisationAgent groupIntoBatches(){

        for (OrganismPair p : this.pairs) {
            this.batches.add(
                    new Batch(p, 2.0)
            );
        }
        return this;
    }

    public void initializeData(){
        this.generateOrganisms()
                .shuffle()
                .groupIntoPairs()
                .groupIntoBatches();
    }

    public void constructData(ArrayList<Organism> organisms){
        this.organisms = organisms;
        this.pairs = new ArrayList<>();
        this.batches = new ArrayList<>();

        this.shuffle()
                .groupIntoPairs()
                .groupIntoBatches();
    }

    public ArrayList<Organism> gatherCycleOutput(){
        ArrayList<Batch> inputBatches = this.getBatches();
        List<Organism> buff = new ArrayList<>();

        for(Batch b : inputBatches){
            if(b.getPair().first.getFoodTaken() == 0.0) {
                inputBatches.remove(b.pair.first);
            }
            else if(b.getPair().second.getFoodTaken() == 0.0){
                inputBatches.remove(b.pair.second);
            }
            else if(b.getPair().first != null){
                buff.add(b.getPair().first);

            }
            else if(b.getPair().second != null){
                buff.add(b.getPair().second);
            }
        }
        this.organisms = buff;
        return (ArrayList) buff;
    }

    StructureOrganisationAgent shuffle(){
        Collections.shuffle(this.organisms);
        return this;
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

    public int[] getParamsList() {
        return paramsList;
    }

    public void setOrganisms(List<Organism> organisms) {
        this.organisms = organisms;
    }
}
