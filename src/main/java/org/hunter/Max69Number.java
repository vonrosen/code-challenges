package org.hunter;

public class Max69Number {

    public int maximum69Number(int num) {
        StringBuilder s = new StringBuilder(String.valueOf(num));
        for(int i = 0; i < s.length(); ++i){
            if(s.charAt(i) == '6') {
                s.replace(i, i + 1, "9");
                return Integer.parseInt(s.toString());
            }
        }
        return Integer.parseInt(s.toString());
    }

}
