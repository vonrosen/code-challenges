package org.hunter;

import java.util.*;

public class BeautifulIndices {

    //ababababazzabababb
    public static void main(String [] args) {
        BeautifulIndices beautifulIndices = new BeautifulIndices();
//        System.out.println(beautifulIndices.beautifulIndices("isawsquirrelnearmysquirrelhouseohmy",
//                "my",
//                "squirrel",
//                15)); //[16,33]
//        System.out.println(beautifulIndices.beautifulIndices("bavgoc",
//                "ba",
//                "c",
//                6)); //[0]
        System.out.println(beautifulIndices.beautifulIndices("szzdko",
                "dk",
                "d",
                2)); //
//        System.out.println(beautifulIndices.beautifulIndices("ababababazzabababb",
//                "aba",
//                "bb",
//                10)); //[6,11,13]
    }

    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        List<Integer> is = new ArrayList<>();
        TreeMap<Integer,Integer> js = new TreeMap<>();
        for(int i = 0; i < s.length(); ++i) {
            if(s.startsWith(a, i)) {
                is.add(i);
            }
        }
        for(int i = 0; i < s.length(); ++i) {
            if(s.startsWith(b, i)) {
                js.put(i, i);
            }
        }
        List<Integer> ans = new ArrayList<>();
        if(js.isEmpty()) {
            return ans;
        }
        for(int i : is) {
            if(!js.subMap(i - k, true, i + k, true).isEmpty()){
                ans.add(i);
            }
        }
        return ans;
    }
}
