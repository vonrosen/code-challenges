package org.hunter;

public class MaxWater{

	public static void main(String [] args){
		MaxWater maxWater = new MaxWater();
		int [] height = new int[]{1,8,6,2,5,4,8,3,7};
		System.out.println(maxWater.maxArea(height));
		height = new int[]{1,1};
		System.out.println(maxWater.maxArea(height));
	}

	//t = quadratic. s = constant
//	public int maxArea(int[] height) {
//		int max = Integer.MIN_VALUE;
//		for(int i = 0; i < height.length; ++i){
//			for(int k = i + 1; k < height.length; ++k){
//				int w = k - i;
//				int h = Math.min(height[i], height[k]);
//				max = Math.max(w * h, max);
//			}
//		}
//		return max;
//	}

	//t = quadratic for worst case. s = constant
	public int maxArea(int[] height) {
		int max = Integer.MIN_VALUE;
		int maxHeight = Integer.MIN_VALUE;
		for(int i = 0; i < height.length; ++i){
			if(height[i] > maxHeight){
				for(int k = i + 1; k < height.length; ++k){
					int w = k - i;
					int h = Math.min(height[i], height[k]);
					max = Math.max(w * h, max);
				}
			}
			maxHeight = Math.max(maxHeight, height[i]);
		}
		return max;
	}

}
