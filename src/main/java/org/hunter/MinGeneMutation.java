package org.hunter;

import java.util.*;

public class MinGeneMutation {

    List<String> valid = List.of("A", "C", "G", "T");

    class State {
        String gene;
        int step;
        State(String gene, int step){
            this.gene = gene;
            this.step = step;
        }
    }

    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> bankSet = new HashSet<>();
        for(String gene : bank) {
            bankSet.add(gene);
        }

        Queue<State> queue = new LinkedList<>();
        queue.add(new State(startGene, 0));
        Set<String> seen = new HashSet<>();
        seen.add(startGene);

        while(!queue.isEmpty()){
            State state = queue.poll();
            String currentGene = state.gene;
            int step = state.step;
            if(currentGene.equals(endGene)){
                return step;
            }
            for(String nextGene : nextGenes(state.gene, bankSet, seen)) {
                seen.add(nextGene);
                queue.add(new State(nextGene, step + 1));
            }
        }
        return -1;
    }

    List<String> nextGenes(String gene, Set<String> bank, Set<String> seen){
        List<String> nextGenes = new ArrayList<>();
        for(int i = 0; i < gene.length(); ++i){
            for(int j = 0; j < valid.size(); ++j){
                String next = gene.substring(0, i) + valid.get(j) + gene.substring(i + 1);
                if(!next.equals(gene) && !seen.contains(next) && bank.contains(next)){
                    nextGenes.add(next);
                }
            }
        }
        return nextGenes;
    }

}
