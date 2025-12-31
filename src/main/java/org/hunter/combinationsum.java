package org.hunter;

import java.util.*;

class combinationsum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        combinationSum(candidates, target, 0, 0, ans, new ArrayList<>());
        return ans;
    }

    void combinationSum(int [] candidates, int target, int index, int sum, List<List<Integer>> ans, List<Integer> cur){
        if(sum == target){
            ans.add(new ArrayList<>(cur));
            return;
        }
        if(sum > target){
            return;
        }
        for(int i = index; i < candidates.length; ++i){
            cur.add(candidates[i]);
            combinationSum(candidates, target, i, sum + candidates[i], ans, cur);
            cur.remove(cur.size() - 1);
        }
    }
}
