package org.hunter;


public class RearrangeBinaryString {

    /**
     * 001011
     *
     * 010101
     * 101010
     * 110100
     * 111000
     *
     * @param s
     * @return
     */
    public int secondsToRemoveOccurrences(String s) {
        int ans = 0;
        boolean seenZero = false;
        for(int i = 0; i < s.length(); ++i) {
            int c = s.charAt(i);
            if(c == '0') {
                seenZero = true;
            }
            if(seenZero && c == '1') {
                ++ans;
            }
        }
        return ans;
    }

    public int secondsToRemoveOccurrences2(String s) {
        int ans = 0;
        StringBuilder sb = new StringBuilder(s);
        while(test(sb)) {
            rearrange(sb);
            ++ans;
        }
        return ans;
    }

    private void rearrange(StringBuilder sb) {
        for(int i = 0; i < sb.length(); ++i) {
            char c1 = sb.charAt(i);
            if(i < sb.length() - 1) {
                char c2 = sb.charAt(i + 1);
                if(c1 == '0' && c2 == '1') {
                    sb.replace(i, i + 1, "1");
                    sb.replace(i + 1, i + 2, "0");
                    i++;
                }
            }
        }
    }

    private boolean test(StringBuilder sb) {
        return sb.toString().contains("01");
    }
}
