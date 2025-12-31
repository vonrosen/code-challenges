package org.hunter;

class equalizestringsbyaddingorremovingcharactersatends {
    
    public int minOperations(String initial, String target) {
        Integer [][] mem = new Integer[initial.length()][target.length()];
        int length = 0;
        for(int i = 0; i < initial.length(); ++i){
            for(int j = 0; j < target.length(); ++j){
                length = Math.max(length, minOperations(initial, target, i, j, mem));
            }
        }
        return initial.length() - length + target.length() - length;
    }
    
    int minOperations(String initial, String target, int i, int j, Integer[][] mem){
        if(i > initial.length() - 1 || j > target.length() - 1){
            return 0;
        }
        if(mem[i][j] != null){
            return mem[i][j];
        }
        if(initial.charAt(i) != target.charAt(j)){
            return 0;
        }
        int ans = 1 + minOperations(initial, target, i + 1, j + 1, mem);
        mem[i][j] = ans;
        return ans;
    }
}
