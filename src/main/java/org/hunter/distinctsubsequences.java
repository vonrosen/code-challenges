package org.hunter;

class distinctsubsequences {
    public int numDistinct(String s, String t) {
        Integer [][] mem = new Integer[s.length()][t.length()];
        return numDistinct(0, 0, s, t, mem);
    }

    int numDistinct(int i, int j, String s, String t, Integer [][] mem){
        if(i == s.length() || j == t.length()){
            return j == t.length() ? 1 : 0;
        }
        if(mem[i][j] != null){
            return mem[i][j];
        }
        int ans = 0;
        if(s.charAt(i) == t.charAt(j)){
            ans += numDistinct(i + 1, j + 1, s, t, mem) + numDistinct(i + 1, j, s, t, mem);
        }else{
            ans += numDistinct(i + 1, j, s, t, mem);
        }
        mem[i][j] = ans;
        return ans;
    }
}
