package org.hunter;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        getCombos(k, n, 0, ans, new ArrayList<>(), 1);
        return ans;
    }

    void getCombos(int k, int n, int index, List<List<Integer>> ans, List<Integer> path, int sum) {
        if(path.size() == k) {
            if(sum == n) {
                ans.add(new ArrayList<>(path));
            }
            return;
        }
        for(int i = index; i <= 9; ++i) {
            path.add(i);
            getCombos(k, n, i + 1, ans, path, sum + i);
            path.remove(path.size() - 1);
        }
    }
}
