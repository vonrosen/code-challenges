import java.util.*;

class validnumber {
    Set<Character> digits = Set.of('0', '1', '2', '3', '4', '5', '6',
            '7', '8', '9');

    public boolean isNumber(String s) {
        int countE = 0;
        for(char c : s.toLowerCase().toCharArray()){
            if(c == 'e'){
                ++countE;
            }
        }
        if(countE > 1){
            return false;
        }
        boolean containsE = s.toLowerCase().contains("e");
        String [] arr = s.split("[Ee]");
        if(arr.length > 2 || arr.length < 1){
            return false;
        }
        if(arr.length == 1){
            if(containsE){
                return false;
            }
            return isInteger(arr[0]) || isDecimal(arr[0]);
        }
        return (isInteger(arr[0]) || isDecimal(arr[0])) && isInteger(arr[1]);
    }

    boolean isInteger(String s){
        if(s.length() == 0){
            return false;
        }
        int index = 0;
        boolean containsDigit = false;
        for(char c : s.toCharArray()){
            if(c == '-' || c == '+'){
                if(index > 0){
                    return false;
                }
                if(s.length() == 1){
                    return false;
                }
            }else{
                if(!digits.contains(c)){
                    return false;
                }
                containsDigit = true;
            }
            ++index;
        }
        return containsDigit;
    }

    boolean isDecimal(String s){
        if(s.length() == 0){
            return false;
        }
        int index = 0;
        int dotCount = 0;
        boolean containsDigit = false;
        for(char c : s.toCharArray()){
            if(c == '-' || c == '+'){
                if(index > 0){
                    return false;
                }
                if(s.length() == 1){
                    return false;
                }
            }else if(c == '.'){
                if(s.length() == 1){
                    return false;
                }
                ++dotCount;
            }else{
                if(!digits.contains(c)){
                    return false;
                }
                containsDigit = true;
            }
            if(dotCount > 1){
                return false;
            }
            ++index;
        }
        return containsDigit;
    }
}
