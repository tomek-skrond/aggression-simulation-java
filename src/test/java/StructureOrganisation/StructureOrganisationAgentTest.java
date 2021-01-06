package StructureOrganisation;

import Organisms.Abstractions.Organism;
import Organisms.Enums.OrganismType;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

import static Organisms.Enums.OrganismType.*;

public class StructureOrganisationAgentTest extends TestCase {

    StructureOrganisationAgent structOrg = new StructureOrganisationAgent();
    List<Organism> checkList = createCheckList(5,A);

    public List<Organism> createCheckList(int N, OrganismType type){
        List<Organism> checkList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            checkList.add(structOrg.makeOrganismOfType(type));
        }
        return checkList;
    }

    public void testGenerateOrganisms() {

        List<Organism> list = structOrg.generateOrganisms(5, A);


        int i=0;
        for (var el : list) {

            System.out.println("hostility: " + el.getHostility());
            assert(
                    list.get(i).getHostility() == 1.5
            );

            i++;
        }

    }

    public void testGroupIntoPairs() {
        List<OrganismPair> pairs = structOrg.groupIntoPairs();

        assert(pairs.size() % 2 == 0);
    }

    public void testGroupIntoBatches() {
        List<Batch> batches = structOrg.groupIntoBatches();

        int b_size = batches.size();
        assert(b_size % 2 == 0);

        for (Batch batch : batches) {
            assert (batch.foodPacket == 2.0);
            assert (batch.pair.first.getHostility() == 1.5);
            assert (batch.pair.second.getHostility() == 1.5);
        }

    }
}