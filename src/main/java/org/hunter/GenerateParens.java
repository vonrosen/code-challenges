package org.hunter;

import java.util.ArrayList;
import java.util.List;

public class GenerateParens {

    public static void main(String [] args) {
        GenerateParens generateParens = new GenerateParens();
        System.out.println(generateParens.generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        generate(n, ans, 0, 0, sb);
        return ans;
    }

    void generate(int n, List<String> ans, int numberOpen, int numberClosed, StringBuilder sb) {
        if(sb.length() == n * 2) {
            if(numberOpen == numberClosed) {
                ans.add(sb.toString());
            }
            return;
        }
        if(numberClosed > numberOpen) {
            return;
        }
        for(String possible : List.of("(", ")")) {
            int nOpen = 0, nClosed = 0;
            if (possible.equals("(")) {
                nOpen = 1;
            }else {
                nClosed = 1;
            }
            sb.append(possible);
            generate(n, ans, numberOpen + nOpen, numberClosed + nClosed, sb);
            sb.delete(sb.length() - 1, sb.length());
        }
    }
}
