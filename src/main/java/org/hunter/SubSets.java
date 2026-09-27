package org.hunter;

import java.util.ArrayList;
import java.util.List;

public class SubSets {

    public static void main(String [] args) {
        int [] nums = new int[]{1,2,3};
        SubSets s = new SubSets();
        var ans = s.subsets(nums);
        for (List<Integer> list : ans) {
            System.out.println(list);
        }
        System.out.println("");
        nums = new int[]{0};
        ans = s.subsets(nums);
        for (List<Integer> list : ans) {
            System.out.println(list);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        subsets(nums, 0, new ArrayList<>(), ans);
        return ans;
    }

    void subsets(int [] nums, int index, List<Integer> list, List<List<Integer>> ans) {
        for (int i = index; i < nums.length; ++i) {
            list.add(nums[i]);
            ans.add(new ArrayList<>(list));
            subsets(nums, i + 1, list, ans);
            list.removeLast();
        }
    }

}
