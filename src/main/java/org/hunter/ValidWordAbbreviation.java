package org.hunter;

public class ValidWordAbbreviation {

    public static void main(String [] args) {
        ValidWordAbbreviation v = new ValidWordAbbreviation();
        System.out.println(v.validWordAbbreviation("internationalization", "i12iz4n"));
        System.out.println(v.validWordAbbreviation("internationalization", "i5a11o1"));
        System.out.println(v.validWordAbbreviation("hi", "2i"));
        System.out.println(v.validWordAbbreviation("a", "ab"));
        System.out.println(v.validWordAbbreviation("ab", "a"));
    }

    public boolean validWordAbbreviation(String word, String abbr) {
        StringBuilder number = new StringBuilder();
        int left = 0;
        for (int i = 0; i < abbr.length(); ++i) {
            char c = abbr.charAt(i);
            if (Character.isDigit(c)) {
                number.append(c);
            } else {
                if (!number.isEmpty()) {
                    if (number.charAt(0) == '0') {
                        return false;
                    }
                    int len = Integer.parseInt(number.toString());
                    left += len;
                }
                if(left > word.length() - 1) {
                    return false;
                }
                if(word.charAt(left) != abbr.charAt(i)) {
                    return false;
                }
                ++left;
                number = new StringBuilder();
            }
        }
        if (!number.isEmpty()) {
            if (number.charAt(0) == '0') {
                return false;
            }
            int len = Integer.parseInt(number.toString());
            left += len;
        }
        if(left != word.length()) {
            return false;
        }
        return true;
    }
}
