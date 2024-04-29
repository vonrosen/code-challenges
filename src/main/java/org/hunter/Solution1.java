package org.hunter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

public class Solution1{

	public static void main(String [] args) {
		int []nums = new int[]{0,1,1,0,0,0,0,1,0,1,0,1,1,0,0,0,0,1,1,1,0,0,1,1,1,0,1,1,0,1,1,0,1,0,1,0,1,0,1,0,0,0,0,
				1,1,1,0,1,0,1,1,1,0,0,1,0,0,1,1,0,1,0,0,1,1,0,0,0,1,0,1,1,1,0,1,0,1,1,1,1,1,1,1,1,1,0,0,0,1,0,0,0,1,0
				,0,0,1,1,0,1,1,0,1,1,1,1,0,1,0,0,1,0,0,1,1,0,1,1,0,1,0,0,1,0,0,1,0,1,0,0,1,0,1,1,0,1,0,0,0,1,0,1,1,0,
				1,0,0,1,0,1,1,1,1,1,1,0,0,0,1,1,0,0,0,0,0,0,1,1,1,1,1,0,1,0,0,1,0,1,0,0,0,0,1,1,1,0,1,0,0,1,1,1,0,1,1,1,1,1,1,0,1,1,1,1,1,0,1,1,0,0,1,0,1,0,0,1,0,1,1,1,0,0,0,0,1,1,1,0,0,1,1,1,1,1,0,1,1,0,0,1,0,1,1,0,0,1,0,1,1,1,1,0,0,0,0,0,1,1,0,1,1,1,1,0,1,1,0,0,0,1,0,0,1,0,1,1,0,0,0,0,0,0,0,0,1,1,1,0,0,0,1,0,0,0,0,1,0,1,0,1,1,1,0,1,1,0,1,0,1,1,0,0,0,1,0,0,0,0,0,1,0,1,0,0,1,0,0,0,1,1,0,1,1,1,0,1,1,0,1,1,0,1,1,0,1,0,0,0,0,1,1,0,1,0,1,1,0,1,0,0,1,1,0,0,0,0,1,1,0,1,1,1,0,1,0,1,1,0,0,1,0,1,0,1,0,0,1,0,1,0,0,0,1,0,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,0,0,1,1,1,1,1,0,1,0,1,1,0,1,0,0,1,0,1,1,0,1,0,1,1,0,1,0,0,1,0,1,0,0,1,1,1,0,1,1,1,1,0,0,1,0,1,1,1,1,0,1,1,0,1,1,0,0,0,0,0,0,0,1,1,0,1,0,0,0,0,0,1,0,0,0,0,0,1,0,1,0,1,1,1,0,0,1,0,0,0,0,0,1,1,1,0,0,1,0,1,1,1,1,1,1,0,1,1,1,1,0,1,0,1,0,1,0,1,1,1,0,1,1,1,0,0,0,1,1,1,0,0,0,0,0,0,1,0,1,1,0,0,0,1,1,0,0,1,0,0,1,0,1,1,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,1,1,1,1,1,1,0,0,1,1,0,1,1,1,0,1,1,1,0,0,0,1,1,0,1,0,1,0,0,0,0,1,1,1,0,1,1,1,1,1,0,0,0,1,1,1,1,0,1,1,1,1,1,0,1,1,1,0,0,0,0,0,1,0,1,0,1,1,1,0,1,1,1,0,1,0,0,1,1,1,1,1,1,0,1,0,0,0,1,0,1,1,1,1,1,0,1,1,0,0,0,1,1,1,1,0,0,0,0,1,0,1,1,0,1,1,0,1,0,1,0,0,1,1,1,1,0,1,0,0,1,0,0,0,0,1,1,1,0,1,1,0,0,0,1,0,0,1,0,0,0,0,1,1,0,0,0,0,0,1,1,0,0,0,0,0,0,0,1,1,1,1,1,1,1,0,0,1,0,1,0,1,1,1,1,0,0,1,0,1,1,1,1,0,0,0,0,1,0,1,1,1,0,0,1,1,1,1,1,1,1,0,1,1,1,1,1,0,0,1,1,0,0,0,0,1,1,1,0,1,1,0,1,0,0,0,0,0,0,0,1,1,1,1,0,0,1,1,0,1,1,1,1,0,1,0,1,1,0,1,0,1,1,0,1,1,0,1,0,0,0,0,1,1,1,1,0,1,0,0,0,0,1,0,1,0,0,0,0,0,1,1,0,1,0,0,1,1,0,1,0,1,1,1,1,1,0,1,0,0,1,0,0,1,0,1,0,1,0,0,1,0,1,0,1,1,0,0,0,0,1,1,0,0,0,1,1,0,0,1,0,0,0,1,1,1,1,0,1,1,0,1,0,0,0,0,0,1,1,1,0,0,0,0,1,0,0,0,0,1,1,1,0,1,0,1,1,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,1,0,1,0,1,1,1,1,0,0,0,1,0,1,0,0,1,0,0,0,1};
		int k = 1;
		Solution1 solution1 = new Solution1();
		System.out.println(solution1.findMaxLength(nums));
	}

	public int longestOnes(int[] nums, int k) {
		int left = 0;
		int curr = 0;
		int ans = 0;
		for (int right = 0; right < nums.length; ++right) {
			if (nums[right] == 0) {
				curr++;
			}
			while (curr > k) {
				if(nums[left] == 0) {
					curr--;
				}
				++left;
			}
			ans = Math.max(ans, right - left + 1);
		}
		return ans;
	}

	public int minStartValue(int[] nums) {
		int cur = 1;
		while (true) {
			int sum = cur;
			boolean valid = true;
			for (int i = 0; i < nums.length; ++i) {
				sum += nums[i];
				if (sum < 1){
					++cur;
					valid = false;
					break;
				}
			}
			if (valid) {
				return cur;
			}
		}
	}

	public int[] getAverages(int[] nums, int k) {
		long [] prefix = new long[nums.length];
		prefix[0] = nums[0];
		for (int i = 1; i < nums.length; ++i) {
			prefix[i] = nums[i] + prefix[i - 1];
		}
		int [] ans = new int[nums.length];
		int divide = 2 * k + 1;
		for (int i = 0; i < nums.length; ++i) {
			if (i < k || nums.length - 1 - i < k) {
				ans[i] = -1;
			}else {
				if (i - k == 0) {
					ans[i] = (int)((prefix[i + k]) / divide);
				}else {
					ans[i] = (int)((prefix[i + k] - prefix[i - k - 1]) / divide);
				}

			}
		}
		return ans;
	}

	public boolean checkIfPangram(String sentence) {
		Set<Character> sentenceSet = new HashSet<>();
		for (char s : sentence.toCharArray()) {
			sentenceSet.add(s);
		}
		for (char a : "abcdefghijklmnopqrstuvwxyz".toCharArray()) {
			if(!sentenceSet.contains(a)) {
				return false;
			}
		}
		return true;
	}

	public int missingNumber(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i <= nums.length; ++i) {
			set.add(i);
		}
		Set<Integer> numSet = new HashSet<>();
		for (int i = 0; i < nums.length; ++i) {
			numSet.add(nums[i]);

		}
		for (int n : set) {
			if(!numSet.contains(n)) {
				return n;
			}
		}

		return -1;
	}


	public int missingNumber2(int[] nums) {
		int sum = 0;
		for (int i = 0; i <= nums.length; ++i) {
			sum +=i;
		}
		int numSum = 0;
		for (int i = 0; i < nums.length; ++i) {
			numSum += nums[i];
		}
		return sum - numSum;
	}

	public int countElements(int[] arr) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < arr.length; ++i) {
			set.add(arr[i]);
		}
		int ans = 0;
		for (int i = 0; i < arr.length; ++i) {
			if(set.contains(arr[i] + 1)) {
				ans++;
			}
		}
		return ans;
	}

	public List<List<Integer>> findWinners(int[][] matches) {
		Map<Integer,Integer> losers = new TreeMap<>();
		for (int i = 0; i < matches.length; ++i) {
			losers.put(matches[i][1], losers.getOrDefault(matches[i][1], 0) + 1);
		}

		for (int i = 0; i < matches.length; ++i) {
			Integer value = losers.get(matches[i][0]);
			if (value == null) {
				losers.put(matches[i][0], 0);
			}
		}

		List<Integer> noLosses = new ArrayList<>();
		List<Integer> oneLoss = new ArrayList<>();

		for(Integer key : losers.keySet()) {
			Integer value = losers.get(key);
			if (0 == value) {
				noLosses.add(key);
			}
			if (1 == value) {
				oneLoss.add(key);
			}
		}
		return List.of(noLosses, oneLoss);
	}

	public int largestUniqueNumber(int[] nums) {
		Map<Integer, Integer> counts = new TreeMap<>();
		for (int i = 0; i < nums.length; ++i) {
			counts.put(nums[i], counts.getOrDefault(nums[i], 0) + 1);
		}

		int ans = -1;
		for (Integer key : counts.keySet()) {
			Integer value = counts.get(key);
			if (value == 1) {
				ans = key;
			}
		}
		return ans;
	}

	public int maxNumberOfBalloons(String text){
		HashSet<Character> set = new HashSet<>();
		for(Character c : "balloon".toCharArray()){
			set.add(c);
		}
		Map<Character,Integer> counts = new HashMap<>();
		for(Character c : text.toCharArray()){
			if(set.contains(c)){
				counts.put(c, counts.getOrDefault(c, 0) + 1);
			}
		}
		if(counts.size() != set.size()) {
			return 0;
		}
		if(counts.get('l') < 2) {
			return 0;
		}
		if(counts.get('o') < 2) {
			return 0;
		}
		int ans = counts.get('b');
		for(Character c: counts.keySet()) {
			Integer count = counts.get(c);
			if (c == 'o' || c == 'l') {
				count /= 2;
			}
			ans = Math.min(ans, count);
		}
		return ans;
	}

	public int findMaxLength2(int[] nums){
		long ans = 0;
		Map<Integer,Long> counts = new HashMap<>();
		for(int i = 0; i < nums.length; ++i){
			counts.clear();
			counts.put(nums[i], 1L);
			for(int k = i + 1; k < nums.length; ++k){
				counts.put(nums[k], counts.getOrDefault(nums[k], 0L) + 1L);
				if ((k - 1 + 1) % 2 == 0) {
					if(Objects.equals(counts.get(0), counts.get(1))){
						ans = Math.max(ans, k - i + 1);
					}
				}
			}
		}
		return (int)ans;
	}

	public int findMaxLength(int[] nums){
		int count = 0;
		Map<Integer,Integer> countToIndex = new HashMap<>();
		Map<Integer,Integer> countToAnswer = new HashMap<>();
		countToIndex.put(count, 0);
		countToAnswer.put(count, 0);
		for (int i = 0; i < nums.length; ++i) {
			if (nums[i] == 0) {
				count++;
			}
			if(nums[i] == 1) {
				count--;
			}
			Integer index = countToIndex.get(count);
			if (index != null) {
				countToIndex.put(count, i);
				countToAnswer.put(count, Math.max(countToAnswer.get(count), i - index + 1));
			}else{
				countToIndex.put(count, i);
				countToAnswer.put(count, 0);
			}
		}
		int ans = 0;
		for(Integer a : countToAnswer.keySet()) {
			ans = Math.max(ans, a);
		}
		return ans;
	}

	public int maxAncestorDiff(TreeNode root) {
		if(root == null){
			return 0;
		}
		return maxAncestorDiff(root, root.val, root.val);
	}

	public int maxAncestorDiff(TreeNode root, int min, int max) {
		if (root == null) {
			return max - min;
		}

		int left = maxAncestorDiff(root.left, Math.min(min, root.val), Math.max(max, root.val));
		int right = maxAncestorDiff(root.right, Math.min(min, root.val), Math.max(max, root.val));

		return Math.max(left, right);
	}

	public int diameterOfBinaryTree(TreeNode root) {
		return diameterOfBinaryTree2(root)[1];
	}

	public int [] diameterOfBinaryTree2(TreeNode root) {
		if(root == null) {
			return new int[]{ 0, 0 };
		}

		if (root.left == null && root.right == null) {
			return new int[]{ 0, 0 };
		}
		int [] left = new int[2];
		int [] right = new int[2];
		if (root.left != null) {
			left = diameterOfBinaryTree2(root.left);
			left[0]++;
		}

		if(root.right != null) {
			right = diameterOfBinaryTree2(root.right);
			right[0]++;
		}

		return new int[]{ Math.max(left[0], right[0]), Math.max(left[0] + right[0], Math.max(left[1], right[1])) };
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode() {}
	TreeNode(int val) { this.val = val; }
	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}
