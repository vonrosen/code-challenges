package org.hunter;

import java.util.ArrayList;
import java.util.List;

public class Divide {

    public static void main(String [] args){
        int [] nums = new int[]{4,2,9,8,2,12,7,12,10,5,8,5,5,7,9,2,5,11};

        Divide d = new Divide();
        int k = 14;
        int [][] ans = d.divideArray(nums, k);
//        for(int i = 0; i < ans.length; ++i){
//            for(int j = 0; j < ans[i].length; ++j){
//                System.out.print(ans[i][j] + " ");
//            }
//            System.out.println("");
//        }

        nums = new int[]{1,3,4,8,7,9,3,5,1};
        k = 2;
        ans = d.divideArray(nums, k);
        for(int i = 0; i < ans.length; ++i){
            for(int j = 0; j < ans[i].length; ++j){
                System.out.print(ans[i][j] + " ");
            }
            System.out.println("");
        }

    }

    public int[][] divideArray(int[] nums, int k) {
        List<List<Integer>> list = new ArrayList<>();
        divideArray(nums, k, 0, new ArrayList<>(), list);
        int [][] ans = new int[list.size()][3];
        int i = 0;
        for(List<Integer> l : list){
            for(int j = 0; j < l.size(); ++j){
                ans[i][j] = l.get(j);
            }
            ++i;
        }
        return ans;
    }

    void divideArray(int [] nums, int k, int index, List<Integer> list, List<List<Integer>> ans){
        if(list.size() == 3){
            if(Math.abs(list.get(0) - list.get(1)) > k){
                return;
            }
            if(Math.abs(list.get(0) - list.get(2)) > k){
                return;
            }
            if(Math.abs(list.get(1) - list.get(2)) > k){
                return;
            }
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i = index; i < nums.length; ++i){
            list.add(nums[i]);
            divideArray(nums, k, i + 1, list, ans);
            list.remove(list.size() - 1);
        }
    }
}
