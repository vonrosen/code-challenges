package org.hunter;

public class NumberOfAlternatingGroups {

    public int numberOfAlternatingGroups(int[] colors) {
        if(colors.length == 1 || colors.length == 2) {
            return 0;
        }
        int ans = 0;
        for(int i = 0; i < colors.length; ++i) {
            int color = colors[i];
            if(i == 0) {
                if(colors[colors.length - 1] != color && color != colors[i + 1]) {
                    ++ans;
                }
            }else if (i == colors.length - 1) {
                if(colors[0] != color && colors[i - 1] != color) {
                    ++ans;
                }
            }else {
                if(colors[i - 1] != color && color != colors[i + 1]) {
                    ++ans;
                }
            }
        }
        return ans;
    }

}
