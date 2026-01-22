package org.hunter;

public class ReverseInteger {

    public int reverse(int x) {
        StringBuilder sb = new StringBuilder(String.valueOf(x));
        boolean isNeg = false;
        if(sb.charAt(0) == '-') {
            sb.delete(0, 1);
            isNeg = true;
        }
        long value = Long.parseLong(sb.reverse().toString());
        if(isNeg) {
            value = -value;
        }
        if (value < Integer.MIN_VALUE || value > Integer.MAX_VALUE) {
            return 0;
        }
        return (int)value;
    }

}
