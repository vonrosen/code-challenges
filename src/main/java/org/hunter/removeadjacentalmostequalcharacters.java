package org.hunter;

class removeadjacentalmostequalcharacters {
    public int removeAlmostEqualCharacters(String word) {
        int left = 0;
        int curLength = 1;
        int ans = 0;
        for(int right = 0; right < word.length(); ++right){                                    
            curLength = right - left + 1;
            if(adjacent(word, Math.max(0, right - 1), right)){
                if(word.length() - 1 == right){
                    ans += curLength / 2;
                }                
            }else{
                ans += (curLength - 1) / 2;
                left = right;
            }
        }
        return ans;
    }

    boolean adjacent(String word, int left, int right){
        char leftChar = word.charAt(left);
        char rightChar = word.charAt(right);
        return leftChar == rightChar || Math.abs((int)leftChar - (int)rightChar) == 1;
    }
}
