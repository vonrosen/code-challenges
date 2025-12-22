package org.hunter;

public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int ans = 0;
        while (left < right) {
            int tmp = Math.min(height[left], height[right]) * (right - left);
            ans = Math.max(ans, tmp);
            if(height[left] < height[right]) {
                ++left;
            }else if(height[left] > height[right]) {
                --right;
            }
            else{
                ++left;
                --right;
            }
        }
        return ans;
    }

}
