package org.hunter;

import java.util.*;

class searchsuggestionssystem {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> ans = new ArrayList<>();
        StringBuilder searchTerm = new StringBuilder();
        for(char c : searchWord.toCharArray()){
            searchTerm.append(c);
            List<String> recs = new ArrayList<>();
            int left = 0, right = products.length - 1;
            while(left <= right){
                int mid = left + (right - left) / 2;
                int compare = products[mid].compareTo(searchTerm.toString());
                if(compare >= 0){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }
            int length = Math.min(left + 3, products.length);
            for(int i = left; i < length; ++i){
                if(products[i].startsWith(searchTerm.toString())){
                    recs.add(products[i]);
                }
            }
            ans.add(recs);
        }
        return ans;        
    }
}
