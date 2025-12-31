package org.hunter;

public class NumberOfAlternatingGroups2 {

    public int numberOfAlternatingGroups(int[] colors, int k) {
        int [] twiceColors = new int[colors.length * 2];
        for(int i = 0; i < twiceColors.length; ++i) {
            twiceColors[i] = colors[i % colors.length];
        }
        int ans = 0;
        int left = 0;
        int numbAlts = 0;
        for(int right = 1; right < twiceColors.length; ++right) {
            if(right < twiceColors.length - 1
                    && twiceColors[right] != twiceColors[right - 1]
                    && twiceColors[right] != twiceColors[right + 1]) {
                numbAlts++;
            }
            if(right - left + 2 == k) {
                if(numbAlts == k - 2) {
                    ans++;
                }
                ++left;
                if(twiceColors[left] != twiceColors[left - 1]
                        && twiceColors[left] != twiceColors[left + 1]) {
                    numbAlts--;
                }
            }
            if(left > colors.length - 1) {
                break;
            }
        }
        return ans;
    }

}
