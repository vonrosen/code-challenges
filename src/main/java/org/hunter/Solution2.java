package org.hunter;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Solution2{

	public static void main(String [] args) {
		Solution2 solution2 = new Solution2();
		System.out.println(solution2.countComponents(4, new int[][]{
				{2, 3},
				{1, 2},
				{1, 3},
		}));

//		TreeNode node = new TreeNode(4);
//		node.left = new TreeNode(2);
//		node.left.left = new TreeNode(1);
//		node.left.right = new TreeNode(3);
//		node.right = new TreeNode(7);
//		solution2.insertIntoBST(node, 5);

//		ListNode head = new ListNode(3);
//		head.next = new ListNode(5);

//		System.out.println(solution2.simplifyPath("/a//b////c/d//././/.."));
//		System.out.println(solution2.makeGood("abBAcC"));

//		int [] ans = solution2.maxSlidingWindow(new int [] {1, 3, -1, -3, 5, 3, 6, 7}, 3);
//		for (int i = 0; i < ans.length; ++i) {
//			System.out.println(ans[i]);
//		}

//		System.out.println(solution2.pairSum(head));

//		ListNode tmp = solution2.reverseBetween(head, 1, 2);
//		while (tmp != null) {
//			System.out.println(tmp.val);
//			tmp = tmp.next;
//		}

		//[100],[80],[60],[70],[60],[75],[85]
//		StockSpanner stockSpanner = new StockSpanner();
//		stockSpanner.next(100);
//		stockSpanner.next(80);
//		stockSpanner.next(60);
//		stockSpanner.next(70);
//		stockSpanner.next(60);
//		stockSpanner.next(75);
//		stockSpanner.next(85);

	}

	public int findMaxLength(int[] nums) {
		int count = 0;
		int ans = 0;
		Map<Integer,Integer> countToIndex = new HashMap<>();
		countToIndex.put(0, 0);
		for (int i = 0; i < nums.length; ++i) {
			count += nums[i] == 1 ? 1 : -1;
			Integer index = countToIndex.get(count);
			if (index == null) {
				countToIndex.put(count, i);
			}else {
				ans = Math.max(ans, i - index + 1);
			}
		}
		return ans;
	}

	public boolean canConstruct(String ransomNote, String magazine) {
		Map<Character,Integer> countsRandomNote = new HashMap<>();
		for (Character c : ransomNote.toCharArray()) {
			countsRandomNote.put(c, countsRandomNote.getOrDefault(c, 0) + 1);
		}

		Map<Character,Integer> countsMagazine = new HashMap<>();
		for (Character c : magazine.toCharArray()) {
			countsMagazine.put(c, countsMagazine.getOrDefault(c, 0) + 1);
		}

		for(Character c : countsRandomNote.keySet()) {
			int count = countsRandomNote.get(c);
			if(countsMagazine.getOrDefault(c, 0) < count) {
				return false;
			}
		}

		return true;
	}

	public int numJewelsInStones(String jewels, String stones) {
		Map<Character,Integer> counts = new HashMap<>();
		for(Character c: stones.toCharArray()) {
			counts.put(c, counts.getOrDefault(c, 0) + 1);
		}

		int ans = 0;
		for(Character c: jewels.toCharArray()) {
			ans += counts.getOrDefault(c, 0);
		}

		return ans;
	}

	public int lengthOfLongestSubstring(String s) {
		int left = 0;
		int ans = 0;
		Map<Character,Integer> map = new HashMap<>();
		for(int right = 0; right < s.length(); ++right) {
			Character c = s.charAt(right);
			int count = map.getOrDefault(c, 0) + 1;
			map.put(c, count);
			while (count > 1) {
				map.put(s.charAt(left), map.getOrDefault(s.charAt(left), 1) - 1);
				count = map.getOrDefault(c, 0);
				left++;
			}
			ans = Math.max(ans, right - left + 1);
		}
		return ans;
	}

	public ListNode middleNode(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;
	}

	public ListNode deleteDuplicates(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode fast = head.next;
		ListNode slow = head;
		ListNode dedupe = new ListNode(head.val);

		while(fast != null) {
			if (slow.val != fast.val) {
				ListNode tmp = dedupe;
				while (tmp != null) {
					if (tmp.next == null) {
						tmp.next = new ListNode(fast.val);
						break;
					}
					tmp = tmp.next;
				}
			}
			slow = slow.next;
			fast = fast.next;
		}

		return dedupe;
	}

	public ListNode swapPairs2(ListNode head) {
		ListNode returnNode = head.next;
		ListNode prev = null;
		while (head != null && head.next != null) {
			ListNode nextNode = head.next.next;
			ListNode tmp = head.next;
			tmp.next = head;
			tmp.next.next = null;

			if(prev != null) {
				prev.next.next = tmp;
			}

			prev = tmp;
			head = nextNode;
		}
		return returnNode;
	}

	public ListNode swapPairs(ListNode head) {
		// Check edge case: linked list has 0 or 1 nodes, just return
		if (head == null || head.next == null) {
			return head;
		}

		ListNode dummy = head.next;     // Step 5
		ListNode prev = null;           // Initialize for step 3
		while (head != null && head.next != null) {
			if (prev != null) {
				prev.next = head.next;  // Step 4
			}
			prev = head;                // Step 3

			// Step 2
			ListNode nextNode = head.next.next;
			head.next.next = head;      // Step 1

			head.next = nextNode;       // Step 6
			head = nextNode;            // Move to next pair (Step 3)
		}

		return dummy;
	}

	/**
	 * [1,2,3,4,5,6]
	 * [1,2,3,6,5,4]
	 *
	 *
	 * @param head
	 * @return
	 */
	public int pairSum(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;

		ListNode prev = slow;
		while (fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}

		//2
		//5-1-2 = 2
		//5,4,2,1,6,
		//5,4,6,1,2
		ListNode tmp = slow;
		ListNode prev2 = null;
		while (tmp != null) {
			ListNode next = tmp.next;
			tmp.next = prev2;
			prev2 = tmp;
			tmp = next;
		}

		prev.next = prev2;

		slow = head;
		fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		int ans = 0;
		ListNode start = head;
		while (slow != null) {
			ans = Math.max(ans, slow.val + start.val);
			start = start.next;
			slow = slow.next;
		}

		return ans;
	}

	public ListNode reverse(ListNode head) {
		ListNode tmp = head;
		ListNode prev = null;
		while (tmp != null) {
			ListNode next = tmp.next;
			tmp.next = prev;
			if (next == null) {
				break;
			}
			prev = tmp;
			tmp = next;
		}
		return tmp;
	}

	public ListNode reverseList(ListNode head) {
		ListNode tmp = head;
		ListNode prev = null;
		while (tmp != null) {
			ListNode next = tmp.next;
			tmp.next = prev;
			prev = tmp;
			tmp = next;
		}
		return prev;
	}

	public ListNode reverseBetween(ListNode head, int left, int right) {
		if(left == right) {
			return head;
		}

		int counter = 1;

		ListNode tmp = head;
		ListNode lastBeforeLeft = null;
		ListNode firstReversed = null;
		ListNode rightFirst = null;
		ListNode prev = null;
		while (tmp != null) {
			if (counter == right) {
				rightFirst = tmp.next;
				break;
			}
			tmp = tmp.next;
			++counter;
		}

		counter = 1;
		tmp = head;

		while (tmp != null) {
			if (counter >= left && counter <= right) {
				if (counter == left) {
					lastBeforeLeft = prev;
					firstReversed = tmp;
				}
				ListNode next = tmp.next;
				tmp.next = prev;
				prev = tmp;
				if (counter == right) {
					if (lastBeforeLeft != null) {
						lastBeforeLeft.next = tmp;
					}
					if (firstReversed != null) {
						firstReversed.next = rightFirst;
					}
					if (left == 1) {
						return prev;
					}
					return head;
				}
				tmp = next;
				++counter;
			}
			else {
				prev = tmp;
				tmp = tmp.next;
				++counter;
			}
		}
		return head;
	}

	public String simplifyPath(String path) {
		StringBuilder s = new StringBuilder();
		Stack<String> paths = new Stack<>();
		for (char character : path.toCharArray()) {
			if (character != '/') {
				s.append(character);
			}else {
				if (s.length() > 0) {
					if (s.toString().equals(".")) {
						s.delete(0, s.length());
					}else if (s.toString().equals("..")) {
						if (!paths.isEmpty()) {
							paths.pop();
						}
						s.delete(0, s.length());
					}else{
						paths.push(s.toString());
						s.delete(0, s.length());
					}
				}
			}
		}
		if (s.length() > 0) {
			if (s.toString().equals("..")) {
				if(!paths.isEmpty()) {
					paths.pop();
				}
			}else if (!s.toString().equals(".")) {
				paths.push(s.toString());
			}
		}

		if (paths.isEmpty()) {
			return "/";
		}
		StringBuilder canonPath = new StringBuilder();
		for(int i = 0; i < paths.size(); ++i) {
			canonPath.append("/");
			canonPath.append(paths.get(i));
		}
		return canonPath.toString();
	}

	public String makeGood(String s) {
		StringBuilder sb = new StringBuilder();
		for (Character c : s.toCharArray()) {
			if (sb.length() > 0) {
				Character last = sb.charAt(sb.length() - 1);
				if (Character.isUpperCase(c) && Character.isLowerCase(last) &&
						Character.toLowerCase(c) == Character.toLowerCase(last)) {
					sb.deleteCharAt(sb.length() - 1);
				}else if (Character.isLowerCase(c) && Character.isUpperCase(last) &&
						Character.toLowerCase(c) == Character.toLowerCase(last)) {
					sb.deleteCharAt(sb.length() - 1);
				}else {
					sb.append(c);
				}
			}else {
				sb.append(c);
			}
		}
		return sb.toString();
	}

	public int[] maxSlidingWindow2(int[] nums, int k) {
		int [] ans = new int[nums.length - k + 1];
		int ctr = 0;
		for (int i = 0; i < nums.length; ++i) {
			if (i + k - 1 > nums.length - 1) {
				break;
			}
			int an = 0;
			for (int j = i; j < i + k; ++j) {
				an = Math.max(nums[j], an);
			}
			ans[ctr++] = an;
		}
		return ans;
	}

	public int[] maxSlidingWindow(int[] nums, int k) {
		Deque<Integer> deqeue = new LinkedList<>();
		int [] ans = new int[nums.length - k + 1];
		int ctr = 0;
		for (int i = 0; i < nums.length; ++i) {
			while (!deqeue.isEmpty() && nums[i] > nums[deqeue.getLast()]) {
				deqeue.removeLast();
			}
			deqeue.addLast(i);
			if (deqeue.getFirst() < deqeue.getLast() - k + 1) {
				deqeue.removeFirst();
			}
			if (i >= k - 1) {
				ans[ctr++] = nums[deqeue.getFirst()];
			}
		}
		return ans;
	}

	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
		int [] ans = new int[nums1.length];
		Stack<Integer> stack = new Stack<>();
		Map<Integer,Integer> map = new HashMap<>();
		for (int i = 0; i < nums2.length; ++i) {
			while (!stack.isEmpty() && nums2[i] > nums2[stack.peek()]) {
				int index = stack.pop();
				map.put(nums2[index], nums2[i]);
			}
			stack.push(i);
		}
		for (int i = 0; i < nums1.length; ++i) {
			Integer value = map.get(nums1[i]);
			ans[i] = value == null ? -1 : value;
		}
		return ans;
	}

	public int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return minDepth(root, 1);
	}

	public int minDepth(TreeNode root, int depth) {
		if (root == null) {
			return -1;
		}

		int left = minDepth(root.left, depth + 1);
		int right = minDepth(root.right, depth + 1);
		if (left == -1 && right == -1) {
			return depth;
		}
		if (left == -1) {
			return right;
		}

		if (right == -1) {
			return left;
		}

		return Math.min(left, right);
	}

	public int maxAncestorDiff(TreeNode root) {
		return maxAncestorDiff(root, new HashSet<>());
	}

	public int maxAncestorDiff(TreeNode root, Set<TreeNode> parents) {
		if(root == null) {
			return 0;
		}
		int max = 0;
		for (TreeNode node: parents) {
			max = Math.max(max, Math.abs(node.val - root.val));
		}

		parents.add(root);

		int left = maxAncestorDiff(root.left, parents);
		int right = maxAncestorDiff(root.right, parents);

		parents.remove(root);

		return Math.max(max, Math.max(left, right));
	}

	public int deepestLeavesSum(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();

		int sum = 0;
		queue.add(root);
		while(!queue.isEmpty()) {
			int size = queue.size();

			sum = 0;
			for(int i = 0; i < size; ++i) {
				TreeNode node = queue.remove();
				if(node.left != null) {
					queue.add(node.left);
				}
				if(node.right != null) {
					queue.add(node.right);
				}
				sum += node.val;
			}
		}
		return sum;
	}

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		if(root == null) {
			return List.of();
		}
		Queue<TreeNode> queue = new LinkedList<>();
		List<List<Integer>> ans = new ArrayList<>();
		boolean startLeft = true;
		queue.add(root);
		while(!queue.isEmpty()) {
			int size = queue.size();
			Deque<Integer> deque = new LinkedList<>();
			for(int i = 0; i < size; ++i) {
				TreeNode next = queue.remove();
				if(startLeft) {
					deque.addLast(next.val);
				}else {
					deque.addFirst(next.val);
				}
				if(next.left != null){
					queue.add(next.left);
				}
				if(next.right != null){
					queue.add(next.right);
				}
			}
			startLeft = !startLeft;
			ans.add(new ArrayList<>(deque));
		}
		return ans;
	}

	public TreeNode insertIntoBST(TreeNode root, int val) {
		if(root == null){
			return new TreeNode(val);
		}
		dfsInsertIntoBST(root, val);
		return root;
	}

	public boolean dfsInsertIntoBST(TreeNode root, int val) {
		if(root == null){
			return false;
		}
		boolean inserted;
		if(val < root.val){
			inserted = dfsInsertIntoBST(root.left, val);
			if(inserted){
				return true;
			}
		}
		if(val > root.val){
			inserted = dfsInsertIntoBST(root.right, val);
			if(inserted){
				return true;
			}
		}

		if(val < root.val){
			TreeNode newNode = new TreeNode(val);
			newNode.left = root.left;
			root.left = newNode;
			return true;
		}

		if(val > root.val){
			TreeNode newNode = new TreeNode(val);
			newNode.right = root.right;
			root.right = newNode;
			return true;
		}
		return false;
	}

	double closest = Double.MAX_VALUE;
	List<Integer> possible = new ArrayList<>();

	public int closestValue(TreeNode root, double target) {
		dfsClosestValue(root, target);
		int ans = Integer.MAX_VALUE;
		for(int val : possible){
			ans = Math.min(ans, val);
		}
		return ans;
	}
	public void dfsClosestValue(TreeNode root, double target) {
		if(root == null){
			return;
		}
		if(Math.abs(target - root.val) < closest){
			possible.clear();
			possible.add(root.val);
			closest = Math.abs(target - root.val);
		}else if (Math.abs(target - root.val) == closest){
			possible.add(root.val);
		}
		dfsClosestValue(root.left, target);
		dfsClosestValue(root.right, target);
	}

	public boolean validPath(int n, int[][] edges, int source, int destination) {
		Map<Integer,List<Integer>> map = new HashMap<>();
		for (int i = 0; i < edges.length; ++i){
			int x = edges[i][0], y = edges[i][1];
			map.putIfAbsent(x, new ArrayList<>());
			map.putIfAbsent(y, new ArrayList<>());
			map.get(x).add(y);
			map.get(y).add(x);
		}
		if(edges.length == 0){
			for(int i = 0; i < n; ++i){
				map.put(i, List.of(i));
			}
		}
		boolean [] seen = new boolean[n];
		return dfs(map, source, destination, seen);
	}

	boolean dfs(Map<Integer,List<Integer>> graph, int source, int destination, boolean [] seen){
		if(seen[source]){
			return false;
		}
		seen[source] = true;
		for(int y: graph.get(source)){
			if (y == destination){
				return true;
			}
			boolean result = dfs(graph, y, destination, seen);
			if(result){
				return true;
			}
		}
		return false;
	}

	public int countComponents(int n, int[][] edges) {
		Map<Integer,List<Integer>> graph = new HashMap<>();
		for(int i = 0; i < edges.length; ++i){
			int x = edges[i][0], y = edges[i][1];
			graph.putIfAbsent(x, new ArrayList<>());
			graph.putIfAbsent(y, new ArrayList<>());
			graph.get(x).add(y);
			graph.get(y).add(x);
		}

		int ans = 0;
		Set<Integer> seen = new HashSet<>();
		for(int i = 0; i < n; ++i){
			if(graph.get(i) == null){
				graph.put(i, List.of(i));
			}
			if(!seen.contains(i)){
				seen.add(i);
				++ans;
				dfsCountComponents(i, graph, seen);
			}

		}
		return ans;
	}

	void dfsCountComponents(int node, Map<Integer,List<Integer>> graph, Set<Integer> seen){
		for(int y : graph.get(node)) {
			if(!seen.contains(y)){
				seen.add(y);
				dfsCountComponents(y, graph, seen);
			}
		}
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

class MovingAverage {

	Queue<Integer> queue;
	int size;

	public MovingAverage(int size) {
		this.queue = new LinkedList<>();
		this.size = size;
	}

	public double next(int val) {
		queue.offer(val);
		while(queue.size() > size) {
			queue.poll();
		}
		int currSize = queue.size();
		int sum = 0;
		for (int v : queue) {
			sum += v;
		}
		return sum / currSize;
	}
}

class StockSpanner {

	private Stack<Integer> prices;
	private Map<Integer,Integer> map;

	public StockSpanner() {
		prices = new Stack<>();
		map = new HashMap<>();
	}

	public int next(int price) {
		int span = 1;
		while (!prices.isEmpty() && price >= prices.peek()) {
			int last = prices.pop();
			span += map.get(last);
		}
		prices.push(price);
		map.put(price, span);
		return span;
	}
}
