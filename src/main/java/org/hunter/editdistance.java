package org.hunter;

class editdistance {
    public int minDistance(String word1, String word2) {
        Integer [][] mem = new Integer[word1.length()][word2.length()];
        return minDistance(word1, word2, 0, 0, mem);
    }

    int minDistance(String word1, String word2, int i, int j, Integer [][] mem){
        if(i == word1.length()){
            return word2.length() - j;
        }
        if(j == word2.length()){
            return word1.length() - i;
        }
        if(mem[i][j] != null){
            return mem[i][j];
        }
        int ans = 0;
        if(word1.charAt(i) == word2.charAt(j)){
            ans = this.minDistance(word1, word2, i + 1, j + 1, mem);
        }else{
            ans = 1 + Math.min(Math.min(
                this.minDistance(word1, word2, i + 1, j, mem),//delete
                this.minDistance(word1, word2, i + 1, j + 1, mem)),//replace
                this.minDistance(word1, word2, i, j + 1, mem));//insert
        }
        mem[i][j] = ans;
        return ans;
    }

}
