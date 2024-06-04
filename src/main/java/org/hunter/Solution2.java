package org.hunter;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Solution2{

	public static void main(String [] args) {
		Solution2 solution2 = new Solution2();
		int [] nums = new int[]{7,2,5,10,8};
		int k = 2;
		System.out.println(solution2.splitArray(nums, k));

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

	public ListNode reverse2(ListNode node){
		ListNode head = node;
		ListNode prev = null;
		while(head != null){
			ListNode next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		return head;
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

	public int maxAreaOfIsland(int[][] grid) {
		int ans = 0;
		for(int i = 0; i < grid.length; ++i){
			for(int j = 0; j < grid[i].length; ++j){
				ans = Math.max(ans, dfsIsland(i, j, grid, new boolean[grid.length][grid[i].length], 0));
			}
		}
		return ans;
	}

	int dfsIsland(int i, int j, int[][] grid, boolean[][] seen, int ans){
		if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || seen[i][j] || grid[i][j] == 0){
			return ans;
		}
		seen[i][j] = true;
		return 1 + dfsIsland(i + 1, j, grid, seen, ans) +
				dfsIsland(i, j - 1, grid, seen, ans) +
				dfsIsland(i, j + 1, grid, seen, ans) +
				dfsIsland(i - 1, j, grid, seen, ans);
	}

	public int reachableNodes(int n, int[][] edges, int[] restricted) {
		Map<Integer,List<Integer>> graph = new HashMap<>();
		for (int i = 0; i < n; ++i){
			graph.put(i, new ArrayList<>());
		}
		for(int i = 0; i < edges.length; ++i){
			int x = edges[i][0], y = edges[i][1];
			graph.get(x).add(y);
			graph.get(y).add(x);
		}
		Set<Integer> restrictedSet = new HashSet<>();
		for(int i = 0; i < restricted.length; ++i){
			restrictedSet.add(restricted[i]);
		}
		return dfsReachable(0, graph, restrictedSet, new HashSet<>());
	}

	int dfsReachable(int x, Map<Integer,List<Integer>> graph, Set<Integer> restrictedSet,
			Set<Integer> seen){
		if(seen.contains(x)){
			return 0;
		}
		seen.add(x);
		if(restrictedSet.contains(x)){
			return 0;
		}
		int ans = 1;
		for(int y: graph.get(x)){
			ans += dfsReachable(y, graph, restrictedSet, seen);
		}
		return ans;
	}

	class State1{
		int x;
		int y;
		int steps;
		State1(int x, int y, int steps){
			this.x = x;
			this.y = y;
			this.steps = steps;
		}
	}

	int [][] directions = new int[][]{
			{-1, 0},
			{0, -1},
			{0, 1},
			{1, 0},
	};

	public int nearestExit(char[][] maze, int[] entrance) {
		Queue<State1> queue = new LinkedList<>();
		queue.add(new State1(entrance[0], entrance[1], 0));

		boolean [][] seen = new boolean[maze.length][maze[0].length];
		seen[entrance[0]][entrance[1]] = true;

		while(!queue.isEmpty()){
			State1 state = queue.remove();
			int x = state.x, y = state.y, steps = state.steps;
			if(maze[x][y] == '.' && (x == maze.length - 1 || y == maze[0].length - 1 || x == 0 || y == 0)
					&& !(x == entrance[0] && y == entrance[1])){
				return steps;
			}
			for(int i = 0; i < directions.length; ++i){
				int newX = x + directions[i][0], newY = y + directions[i][1];
				if(valid1(maze, newX, newY) && !seen[newX][newY]){
					seen[newX][newY] = true;
					queue.add(new State1(newX, newY, steps + 1));
				}
			}
		}
		return -1;
	}

	boolean valid1(char[][] maze, int x, int y){
		if(x < maze.length && x >= 0 && y < maze[0].length && y >= 0 && maze[x][y] == '.'){
			return true;
		}
		return false;
	}

	class State2{
		int x;
		int y;
		int value;
		int steps;
		State2(int x, int y, int value, int steps){
			this.x = x;
			this.y = y;
			this.value = value;
			this.steps = steps;
		}
	}


	public int snakesAndLadders(int[][] board) {
		Map<Integer,Integer[]> map = new HashMap<>();
		int x = board.length - 1, y = 0, inc = 1;
		for(int i = 1; i <= board.length * board.length; ++i){
			map.put(i, new Integer[]{x, y});
			if(i % board.length == 0){
				x--;
				if(inc == 1){
					inc = -1;
				}else{
					inc = 1;
				}
			}else{
				y += inc;
			}
		}
		Integer [] endXY = map.get(board.length * board.length);
		Queue<State2> queue = new LinkedList<>();
		queue.add(new State2(board.length - 1, 0, 1, 0));
		boolean [][] seen = new boolean[board.length][board[0].length];
		seen[board.length - 1][0] = true;

		while(!queue.isEmpty()){
			State2 state = queue.remove();
			int value = state.value, steps = state.steps;
			x = state.x;
			y = state.y;

			if(x == endXY[0] && y == endXY[1]){
				return steps;
			}
			for (int newValue = value + 1; newValue <= Math.min(value + 6, board.length * board.length); ++newValue){
				Integer[] xy = map.get(newValue);
				if(valid2(newValue, board, map) && !seen[xy[0]][xy[1]]){
					seen[xy[0]][xy[1]] = true;
					if(board[xy[0]][xy[1]] == -1){
						queue.add(new State2(xy[0], xy[1], newValue, steps + 1));
					}else{
						int destination = board[xy[0]][xy[1]];
						xy = map.get(destination);
						queue.add(new State2(xy[0], xy[1], destination, steps + 1));
					}
				}
			}
		}
		return -1;
	}

	boolean valid2(int value, int [][] board, Map<Integer,Integer[]> map){
		Integer[] xy = map.get(value);
		if(xy == null){
			return false;
		}
		if(xy[0] >= 0 && xy[0] < board.length && xy[1] >= 0 && xy[1] < board[0].length){
			return true;
		}
		return false;
	}

	class Mutation{
		String gene;
		int steps;

		Mutation(String gene, int steps){
			this.gene = gene;
			this.steps = steps;
		}
	}

	public int minMutation(String startGene, String endGene, String[] bank) {
		Queue<Mutation> queue = new LinkedList<>();
		Set<String> valid = new HashSet<>();
		for(int i = 0; i < bank.length; ++i){
			valid.add(bank[i]);
		}

		queue.add(new Mutation(startGene, 0));
		Set<String> seen = new HashSet<>();
		seen.add(startGene);

		while(!queue.isEmpty()){
			Mutation mutation = queue.remove();
			String gene = mutation.gene;
			int steps = mutation.steps;
			if(mutation.gene.equals(endGene)){
				return steps;
			}

			for(String geneMutation: getMutations(gene)){
				if(valid.contains(geneMutation) && !seen.contains(geneMutation)){
					seen.add(geneMutation);
					queue.add(new Mutation(geneMutation, steps + 1));
				}
			}
		}
		return -1;
	}

	List<String> getMutations(String gene){
		char [] chars = new char[]{'A', 'C', 'G', 'T'};
		List<String> mutations = new ArrayList<>();
		for(int i = 0; i < gene.length(); ++i){
			for(int j = 0; j < 4; ++j){
				if(gene.charAt(i) != chars[j]){
					if(i == 0){
						mutations.add(chars[j] + gene.substring(i + 1));
					}else if (i == gene.length() - 1){
						mutations.add(gene.substring(0, gene.length() - 1) + chars[j]);
					}else{
						mutations.add(gene.substring(0, i) + chars[j] + gene.substring(i + 1));
					}
				}
			}
		}
		return mutations;
	}


	public boolean canReach(int[] arr, int start) {
		boolean [] seen = new boolean[arr.length];
		return dfsCanReach(start, arr, seen);
	}

	boolean dfsCanReach(int start, int [] arr, boolean [] seen){
		if(seen[start]){
			return false;
		}
		if(arr[start] == 0){
			return true;
		}
		seen[start] = true;
		boolean canReachFirst = false, canReachSecond = false;
		if(validCanReach(start + arr[start], arr)){
			canReachFirst = dfsCanReach(start + arr[start], arr, seen);
		}
		if(canReachFirst){
			return canReachFirst;
		}
		if(validCanReach(start - arr[start], arr)){
			canReachSecond = dfsCanReach(start - arr[start], arr, seen);
		}
		return canReachSecond;
	}

	boolean validCanReach(int start, int [] arr){
		return start >= 0 && start < arr.length;
	}

	public int maximumDetonation(int[][] bombs) {
		int ans = 1;
		for(int i = 0; i < bombs.length; ++i){
			ans = Math.max(ans, dfsBombs(i, bombs, new boolean[bombs.length]));
		}
		return ans;
	}

	int dfsBombs(int i, int[][] bombs, boolean[] seen){
		if(seen[i]){
			return -1;
		}
		seen[i] = true;
		int ans = 1;
		for (int j = 0; j < bombs.length; ++j){
			if(i != j && inRange(i, j, bombs) && !seen[j]){
				ans += dfsBombs(j, bombs, seen);
			}
		}
		return ans;
	}

	boolean inRange(int i, int j, int[][] bombs){
		int jx = bombs[j][0], jy = bombs[j][1];
		int x = bombs[i][0], y = bombs[i][1], r = bombs[i][2];
		double d = Math.sqrt(Math.pow(jx - x, 2) + Math.pow(jy - y, 2));
		return d <= r;
	}

	class State3{
		String word;
		int steps;
		State3(String word, int steps){
			this.word = word;
			this.steps = steps;
		}
	}

	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Map<String,List<String>> graph = new HashMap<>();
		graph.put(beginWord, getAdjacent(beginWord, wordList));
		for(int i = 0; i < wordList.size(); ++i){
			String word = wordList.get(i);
			graph.put(word, getAdjacent(word, wordList));
		}
		Queue<State3> queue = new LinkedList<>();
		queue.add(new State3(beginWord, 1));
		Set<String> seen = new HashSet<>();
		seen.add(beginWord);
		while(!queue.isEmpty()){
			State3 state = queue.remove();
			String word = state.word;
			int steps = state.steps;
			if (word.equals(endWord)){
				return steps;
			}
			for(String adjacent : graph.getOrDefault(word, List.of())){
				if(!seen.contains(adjacent)){
					seen.add(adjacent);
					queue.add(new State3(adjacent, steps + 1));
				}
			}
		}
		return 0;
	}

	List<String> getAdjacent(String word, List<String> compareWords){
		List<String> adj = new ArrayList<>();
		char [] wordArray = word.toCharArray();
		for(int i = 0; i < compareWords.size(); ++i){
			String compare = compareWords.get(i);
			int diff = 0;
			for(int j = 0; j < wordArray.length; ++j){
				if(wordArray[j] != compare.charAt(j)){
					++diff;
				}
			}
			if(diff == 1){
				adj.add(compare);
			}
		}
		return adj;
	}

	public int minStoneSum(int[] piles, int k) {
		Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
		for(int i = 0; i < piles.length; ++i){
			maxHeap.add(piles[i]);
		}

		for(int i = 0; i < k; ++i){
			int max = maxHeap.remove();
			maxHeap.add(max - (max / 2));
		}

		int ans = 0;
		while(!maxHeap.isEmpty()){
			ans += maxHeap.remove();
		}
		return ans;
	}

	public int connectSticks(int[] sticks) {
		Queue<Integer> queue = new PriorityQueue<>();
		for(int i = 0; i < sticks.length; ++i){
			queue.add(sticks[i]);
		}
		int minCost = 0;
		while(queue.size() > 1){
			int cost1 = queue.remove();
			int cost2 = queue.remove();
			queue.add((cost1 + cost2));
			minCost += (cost1 + cost2);
		}
		return minCost;
	}

	//[3,2,3,1,2,4,5,5,6]
	//1,2,3,4,5,6
	//1,2,2,3,3,4,5,5,6
	//4
	public int findKthLargest(int[] nums, int k) {
		Queue<Integer> queue = new PriorityQueue<>();
		for(int n : nums){
			queue.add(n);
			if(queue.size() > k){
				queue.remove();
			}
		}
		return queue.remove();
	}

	public int[][] kClosest(int[][] points, int k) {
		Queue<Integer[]> queue = new PriorityQueue<>((Integer [] p1, Integer[] p2) -> {
			int x1 = p1[0], y1 = p1[1], x2 = p2[0], y2 = p2[1];

			int distance1 = (x1 * x1) + (y1 * y1);
			int distance2 = (x2 * x2) + (y2 * y2);

			return (distance2 - distance1);
		});
		for(int i = 0; i < points.length; ++i){
			queue.add(new Integer[]{ points[i][0], points[i][1] });
			if(queue.size() > k){
				queue.remove();
			}
		}
		int [][] ans = new int[k][2];
		for (int i = 0; i < k; ++i){
			Integer[] point = queue.remove();
			ans[i][0] = point[0];
			ans[i][1] = point[1];
		}
		return ans;
	}

	class KthLargest {

		Queue<Integer> queue;
		int k;

		public KthLargest(int k, int[] nums) {
			queue = new PriorityQueue<>();
			for(int i = 0; i < nums.length; ++i){
				queue.add(nums[i]);
				if(queue.size() > k){
					queue.remove();
				}
			}
			this.k = k;
		}

		public int add(int val) {
			queue.add(val);
			if(queue.size() > k){
				queue.remove();
			}

			return queue.peek();
		}
	}

	public int maximum69Number (int num) {
		String number = String.valueOf(num);
		StringBuilder max = new StringBuilder();

		boolean changed = false;
		for(char c : number.toCharArray()){
			if (c == '6' && !changed){
				max.append("9");
				changed = true;
			}else{
				max.append(c);
			}
		}
		return Integer.valueOf(max.toString());
	}

	public int maximumUnits(int[][] boxTypes, int truckSize) {
		Queue<Integer[]> queue = new PriorityQueue<>((Integer [] b1, Integer [] b2) -> {
			return b2[1] - b1[1];
		});

		for(int i = 0; i < boxTypes.length; ++i){
			queue.add(new Integer[]{  boxTypes[i][0], boxTypes[i][1] });
		}

		int ans = 0;
		while(truckSize > 0 && !queue.isEmpty()){
			Integer [] b = queue.remove();
			if(b[0] <= truckSize){
				truckSize -= b[0];
				ans += b[0] * b[1];
			}else{
				ans += truckSize * b[1];
				truckSize = 0;
			}
		}
		return ans;
	}

	public int maxNumberOfApples(int[] weight) {
		int wt = 5000;
		Arrays.sort(weight);
		int ans = 0;
		for(int i = 0; i < weight.length; ++i){
			if(wt >= weight[i]){
				wt -= weight[i];
				ans++;
			}else{
				break;
			}
		}
		return ans;
	}

	public int minSetSize(int[] arr) {
		Map<Integer,Integer> counts = new HashMap<>();
		List<Integer> ordered = new ArrayList<>();
		for(int i = 0; i < arr.length; ++i){
			counts.put(arr[i], counts.getOrDefault(arr[i], 0) + 1);
		}
		for(Integer count : counts.values()){
			ordered.add(count);
		}
		Collections.sort(ordered);
		int ans = 0;
		int removals = 0;
		while (removals < (arr.length / 2)){
			removals += ordered.get(ordered.size() - 1);
			ordered.remove(ordered.size() - 1);
			ans++;
		}
		return ans;
	}

	public int searchInsert(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;

		while (left <= right){
			int mid = left + (right - left) / 2;

			if (target == nums[mid]){
				return mid;
			}

			if (target > nums[mid]){
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return left;
	}

	public int[] answerQueries(int[] nums, int[] queries) {
		Arrays.sort(nums);
		int [] sums = new int[nums.length];
		sums[0] = nums[0];
		for(int i = 1; i < sums.length; ++i){
			sums[i] = nums[i] + sums[i - 1];
		}

		int [] ans = new int[queries.length];
		for(int i = 0; i < queries.length; ++i){
			ans[i] = binSearch(sums, queries[i]);
		}
		return ans;
	}

	int binSearch(int [] nums, int target){
		int left = 0;
		int right = nums.length - 1;

		while (left <= right){
			int mid = left + (right - left) / 2;

			if(nums[mid] == target){
				return mid + 1;
			}
			if(target < nums[mid]){
				right = mid - 1;
			}else{
				left = mid + 1;
			}
		}
		return left;
	}

	public int smallestDivisor(int[] nums, int threshold) {
		int left = 1;
		int right = 0;
		for(int i = 0; i < nums.length; ++i){
			right = Math.max(right, nums[i]);
		}

		while(left <= right){
			int mid = left + (right - left) / 2;
			if(check(nums, mid, threshold)){
				right = mid - 1;
			}else{
				left = mid + 1;
			}
		}
		return left;
	}

	boolean check(int [] nums, int divisor, int threshold){
		int sum = 0;
		for(int i = 0; i < nums.length; ++i){
			sum += (int)Math.ceil((double)nums[i] / (double)divisor);
		}
		return sum <= threshold;
	}

	public int maximizeSweetness(int[] sweetness, int k) {
		int left = Integer.MAX_VALUE;
		int right = 1;
		for(int i = 0; i < sweetness.length; ++i){
			left = Math.min(left, sweetness[i]);
			right += sweetness[i];
		}
		while(left <= right){
			int	mid = left + (right - left) / 2;
			if (check2(mid, sweetness, k)){
				left = mid + 1;
			}else{
				right = mid - 1;
			}
		}
		return right;
	}

	boolean check2(int target, int [] sweetness, int k){
		int cuts = 0;
		int left = 0;
		int sum = 0;
		while(left < sweetness.length){
			sum += sweetness[left];
			if(sum >= target){
				cuts++;
				sum = 0;
			}
			left++;
		}
		return cuts >= k + 1;
	}

	public int splitArray(int[] nums, int k) {
		int left = 0;
		int right = 1;
		for(int i = 0; i < nums.length; ++i){
			left = Math.max(left, nums[i]);
			right += nums[i];
		}
		while(left <= right){
			int mid = left + (right - left) / 2;
			if (check3(mid, nums, k)){
				right = mid - 1;
			}else{
				left = mid + 1;
			}
		}
		return left;
	}

	boolean check3(int largestSum, int []  nums, int k){
		int left = 0;
		int sum = 0;
		int splits = 0;
		while (left < nums.length){
			sum += nums[left];
			if (sum > largestSum){
				++splits;
				sum = nums[left];
			}
			++left;
		}
		return splits + 1 <= k;
	}

	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		List<List<Integer>> ans = new ArrayList<>();
		List<Integer> path = new ArrayList<>();
		path.add(0);
		dfsTarget(0, graph, ans, path);
		return ans;
	}

	void dfsTarget(int x, int [][] graph, List<List<Integer>> ans, List<Integer> path){
		if(x == graph.length - 1){
			ans.add(new ArrayList<>(path));
			return;
		}
		for(int node: graph[x]){
			path.add(node);
			dfsTarget(node, graph, ans, path);
			path.remove(path.size() - 1);
		}
	}

	public List<String> letterCombinations(String digits) {
		if(digits.isEmpty()){
			return List.of();
		}
		Map<Character,String> map = Map.of('2', "abc",
				'3', "def",
				'4', "ghi",
				'5', "jkl",
				'6', "mno",
				'7', "pqrs",
				'8', "tuv",
				'9', "wxyz");
		List<String> ans = new ArrayList<>();
		StringBuilder current = new StringBuilder();
		permute(0, digits, map, current, ans);
		return ans;
	}

	void permute(int index, String digits, Map<Character,String> map, StringBuilder current, List<String> ans){
		if(current.length() == digits.length()){
			ans.add(current.toString());
			return;
		}
		for(Character character : map.get(digits.charAt(index)).toCharArray()){
			current.append(character);
			permute(index + 1, digits, map, current, ans);
			current.deleteCharAt(current.length() - 1);
		}
	}

	public List<String> generateParenthesis(int n) {
		StringBuilder curr = new StringBuilder("(");
		List<String> ans = new ArrayList<>();
		int openCount = 1;
		backtrack(n, 0, curr, openCount, ans);
		return ans;
	}

	void backtrack(int n, int count, StringBuilder curr, int openCount, List<String> ans){
		if(count == n){
			ans.add(curr.toString());
			return;
		}
		if(curr.length() == (n * 2)){
			return;
		}
		for(char c : "()".toCharArray()){
			if(c == ')' && openCount > 0){
				++count;
			}
			curr.append(c);
			backtrack(n, count, curr, c == '(' ? openCount + 1: openCount - 1, ans);
			curr.deleteCharAt(curr.length() - 1);
		}
	}

	public int[] numsSameConsecDiff(int n, int k) {
		List<String> ans = new ArrayList<>();
		for(int i = 1; i < 10; ++i){
			StringBuilder curr = new StringBuilder();
			curr.append(i);
			backtrack2(n, k, curr, ans);
		}
		int [] arr = new int[ans.size()];
		for(int i = 0; i < ans.size(); ++i){
			arr[i] = Integer.parseInt(ans.get(i));
		}
		return arr;
	}

	void backtrack2(int n, int k, StringBuilder curr, List<String> ans){
		if(curr.length() == n){
			ans.add(curr.toString());
			return;
		}
		for(int i = 0; i < 10; ++i){
			if(Math.abs(Integer.parseInt(String.valueOf(curr.charAt(curr.length() - 1))) - i) == k){
				curr.append(i);
				backtrack2(n, k, curr, ans);
				curr.deleteCharAt(curr.length() - 1);
			}
		}
	}

	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> ans = new ArrayList<>();
		for(int i = 1; i < 10; ++i){
			List<Integer> curr = new ArrayList<>();
			curr.add(i);
			backtrack3(k, n, i, i, curr, ans);
		}
		return ans;
	}

	void backtrack3(int k, int n, int index, int sum, List<Integer> curr, List<List<Integer>> ans){
		if(sum == n && curr.size() == k){
			ans.add(new ArrayList<>(curr));
			return;
		}
		if(sum > n || curr.size() > k){
			return;
		}
		for(int i = index + 1; i < 10; ++i){
			curr.add(i);
			backtrack3(k, n, i, sum + i, curr, ans);
			curr.remove(curr.size() - 1);
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
