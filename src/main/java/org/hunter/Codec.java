package org.hunter;

import java.util.ArrayList;
import java.util.List;

public class Codec {

    private static final Character DELIM = 'ü';

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str : strs) {
            sb.append(str);
            sb.append(DELIM);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        if(s.isEmpty()) {
            return List.of();
        }
        List<String> list = new ArrayList<>();
        StringBuilder token = new StringBuilder();
        for(int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if(c == DELIM) {
                list.add(token.toString());
                token = new StringBuilder();
            }else{
                token.append(c);
            }
        }
        return list;
    }
}
