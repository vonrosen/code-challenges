package org.hunter;

public class StringCompression2 {

    public int compress(char[] chars) {
        int indexComp = 0;
        int length = 0;
        char lastC = chars[0];
        for(int i = 0; i < chars.length; ++i) {
            char c = chars[i];
            if(lastC == c) {
                ++length;
            }
            if(lastC != c) {
                if(length > 1) {
                    chars[indexComp] = lastC;
                    ++indexComp;
                    String lengthS = String.valueOf(length);
                    for(char l : lengthS.toCharArray()) {
                        chars[indexComp] = l;
                        ++indexComp;
                    }
                }else {
                    chars[indexComp] = lastC;
                    ++indexComp;
                }
                length = 1;
            }
            lastC = c;
        }
        if(length > 1) {
            chars[indexComp] = lastC;
            ++indexComp;
            String lengthS = String.valueOf(length);
            for(char l : lengthS.toCharArray()) {
                chars[indexComp] = l;
                ++indexComp;
            }
        }else {
            chars[indexComp] = lastC;
            ++indexComp;
        }
        return indexComp;
    }

}
