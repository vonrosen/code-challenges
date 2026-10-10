package org.hunter;

public class MinDistance {

    public static void main(String [] args) {
        MinDistance m = new MinDistance();
        System.out.println(m.minDistance("double", "double"));
        System.out.println(m.minDistance("horse", "ros"));
        System.out.println(m.minDistance("intention", "execution"));
    }

    public int minDistance(String word1, String word2) {
        Integer [][] mem = new Integer[word1.length()][word2.length()];
        return minDistance(word1, word2, 0, 0, mem);
    }

    int minDistance(String word1, String word2, int i, int j, Integer [][] mem) {
        if (i > word1.length() - 1) {
            return word2.length() - j;
        }
        if (j > word2.length() - 1) {
            return word1.length() - i;
        }
        if (mem[i][j] != null) {
            return mem[i][j];
        }
        if (word1.charAt(i) == word2.charAt(j)) {
            return minDistance(word1, word2, i + 1, j + 1, mem);
        }
        //insert
        int op1 = 1 + minDistance(word1, word2, i, j + 1, mem);
        //delete
        int op2 = 1 + minDistance(word1, word2, i + 1, j, mem);
        //replace
        int op3 = 1 + minDistance(word1, word2, i + 1, j + 1, mem);
        int ans = Math.min(op1, Math.min(op2, op3));
        mem[i][j] = ans;
        return ans;
    }

}
