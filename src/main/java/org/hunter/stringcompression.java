package org.hunter;

class stringcompression {
    public int compress(char[] chars) {
        int left = 0;
        int ans = 0;
        int curPos = 0;
        int curLen = 1;
        for(int right = 0; right < chars.length; ++right){
            if(right == chars.length - 1 || chars[right] != chars[right + 1]){
                char [] lengthChars = String.valueOf(curLen).toCharArray();
                int length = lengthChars.length;  
                ans += curLen == 1 ? 1 : (length + 1);
                chars[curPos] = chars[left];
                ++curPos;
                if(curLen > 1){
                    int index = 0;
                    while(index < lengthChars.length){
                        chars[curPos] = lengthChars[index];
                        ++index;
                        ++curPos;
                    }
                }
                left = right + 1;                        
                curLen = 0;
            }            
            ++curLen;
        }
        return ans;
    }
}
