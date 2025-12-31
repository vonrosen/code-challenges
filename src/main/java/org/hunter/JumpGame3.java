package org.hunter;

import java.util.List;

public class JumpGame3 {

    public boolean canReach(int[] arr, int start) {
        boolean [] seen = new boolean[arr.length];
        return dfs(arr, start, seen);
    }

    boolean dfs(int [] arr, int start, boolean [] seen){
        if(!valid(arr, start, seen)) {
            return false;
        }
        if(arr[start] == 0){
            return true;
        }
        seen[start] = true;
        for(int index : nextIndices(arr, start, seen)) {
            if(dfs(arr, index, seen)) {
                return true;
            }
        }
        return false;
    }

    boolean valid(int [] arr, int index, boolean [] seen){
        if(index < 0 || index > arr.length - 1) {
            return false;
        }
        if(seen[index]){
            return false;
        }
        return true;
    }

    List<Integer> nextIndices(int [] arr, int index, boolean [] seen){
        return List.of(index + arr[index], index - arr[index]);
    }

}
