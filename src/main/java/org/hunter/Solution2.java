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
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;

public class Solution2{

	public static void main(String [] args) {
		Solution2 solution2 = new Solution2();
		ListNode head = new ListNode();
		head.val = 100;
		head.next = new ListNode();
		head.next.val = 90;
//		head.next.next = new ListNode();
//		head.next.next.val = 3;
//		head.next.next.next = new ListNode();
//		head.next.next.next.val = 4;
//		head.next.next.next.next = new ListNode();
//		head.next.next.next.next.val = 5;

//		System.out.println(solution2.minDays(new int[]{7,7,7,7,12,7,7}, 2, 3));
		System.out.println(solution2.maximalSquare(new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}}));

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

	//1*2-3/4+5*6-7*8+9/10
	//2 - 1 + 30 - 56 + 1
	public int calculate(String s) {
		s = s.replace(" ", "");
		List<Integer> nums = new ArrayList<>();
		List<String> ops = new ArrayList<>();
		StringBuilder last = new StringBuilder();
		for(char c : s.toCharArray()){
			if(c == '-' || c == '+' || c == '*' || c == '/'){
				nums.add(Integer.parseInt(last.toString()));
				ops.add(String.valueOf(c));
				last = new StringBuilder();
			}else{
				last.append(c);
			}
		}
		nums.add(Integer.parseInt(last.toString()));
		if(ops.isEmpty()){
			return nums.get(0);
		}
		List<String> tmpOps = new ArrayList<>(ops);
		int i = 0;
		while(!tmpOps.isEmpty()){
			String op = tmpOps.remove(0);
			if(op.equals("*")){
				Integer left = nums.get(i);
				Integer right = nums.get(i + 1);
				nums.remove(i);
				nums.remove(i);
				nums.add(i, left * right);
				ops.remove(i);
			}else if(op.equals("/")){
				Integer left = nums.get(i);
				Integer right = nums.get(i + 1);
				nums.remove(i);
				nums.remove(i);
				nums.add(i, left / right);
				ops.remove(i);
			}else{
				++i;
			}
		}
		if(ops.isEmpty()){
			return nums.get(0);
		}
		int ans = 0;
		for(i = 0; i < ops.size(); ++i){
			String op = ops.get(i);
			if(op.equals("+")){
				Integer left = nums.get(i);
				Integer right = nums.get(i + 1);
				if(left != null && right != null){
					ans += left + right;
					nums.set(i, null);
					nums.set(i + 1, null);
				}else if(left != null){
					ans += left;
					nums.set(i, null);
				}else if(right != null){
					ans += right;
					nums.set(i + 1, null);
				}
			}
			else if(op.equals("-")){
				Integer left = nums.get(i);
				Integer right = nums.get(i + 1);
				if(left != null && right != null){
					ans += left - right;
					nums.set(i, null);
					nums.set(i + 1, null);
				}else if(left != null){
					ans -= left;
					nums.set(i, null);
				}else if(right != null){
					ans -= right;
					nums.set(i + 1, null);
				}
			}
		}
		return ans;
	}

	
boolean oneEditApart2(String s1, String s2){
    int diff = 0;
    String small;
    String big;
    if(s1.length() > s2.length()){
      big = s1;
      small = s2;
    }else{
      big = s2;
      small = s1;
    }
    int smallIndex = 0;
    for(int largeIndex = 0; largeIndex < big.length(); ++largeIndex){
      if(smallIndex < small.length()){
        if(big.charAt(largeIndex) == small.charAt(smallIndex)){
          ++smallIndex;
        }else{
          diff++;
        }
      }else{
        diff++;
      }
    }
    return diff <= 1;
  }

	public int findPeakElement(int[] nums) {
		return findPeakElement(nums, 0, nums.length - 1);
	}

	Integer findPeakElement(int[] nums, int start, int end){
		if(start == end){
			if(start == 0 && start == nums.length - 1){
				return start;
			}
			if(start == 0){
				if(nums[start] > nums[start + 1]){
					return start;
				}
				return null;
			}
			if(start == nums.length - 1){
				if(nums[start] > nums[start - 1]){
					return start;
				}
				return null;
			}
			if(nums[start - 1] < nums[start] && nums[start] > nums[start + 1]){
				return start;
			}
			return null;
		}
		int mid = start + (end - start) / 2;
		Integer peak = findPeakElement(nums, start, mid);
		Integer peak2 = findPeakElement(nums, mid + 1, end);
		if(peak != null){
			return peak;
		}
		return peak2;
	}

	

	class ListNode2{

	ListNode2 next;
	ListNode2 prev;
	int val;
	int key;

}

class LRUCache {

	Map<Integer,ListNode2> cache;
	int capacity;
	ListNode2 head;
	ListNode2 tail;

	public LRUCache(int capacity) {
		this.cache = new HashMap<>();
		this.capacity = capacity;
	}

	public int get(int key) {
		if(cache.containsKey(key)){
			ListNode2 node = cache.get(key);
			remove(node);
			add(node);
			return cache.get(key).val;
		}
		return -1;
	}

	public void put(int key, int value) {
		if(cache.containsKey(key)){
			ListNode2 node = cache.get(key);
			node.val = value;
			remove(node);
			cache.put(key, node);
			add(node);
			return;
		}
		ListNode2 node = new ListNode2();
		node.val = value;
		node.key = key;
		if(cache.size() == capacity){
			int keyToRemove = head.key;
			remove(head);
			cache.remove(keyToRemove);
		}
		add(node);
		cache.put(key, node);
	}

	void remove(ListNode2 node){
		if(cache.size() == 1){
			head = null;
			tail = null;
			return;
		}
		if(cache.size() == 2){
			head = tail;
			head.prev = null;
			tail = head;
			tail.next = null;
			return;
		}
		if(node == head){
			head = head.next;
			head.prev = null;
			return;
		}
		if(node == tail){
			tail = tail.prev;
			tail.next = null;
			return;
		}
		node.prev.next = node.next;
		node.next.prev = node.prev;
	}

	void add(ListNode2 node){
		if(head == null){
			head = node;
			tail = node;
			return;
		}
		tail.next = node;
		node.prev = tail;
		tail = node;
		tail.next = null;
	}
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

	public int[][] merge(int[][] intervals) {
		Queue<int[]> q = new LinkedList<>();
		for(int i = 0; i < intervals.length; ++i){
			q.add(intervals[i]);
		}
		List<int[]> ans = new ArrayList<>();
		while(!q.isEmpty()){
			int[] interval = q.poll();
			int min = interval[0], max = interval[1];
			List<int[]> deleted = new ArrayList<>();
			for(int [] i: q){
				//1,3
				//2,4
				if(interval[0] <= i[1] && interval[1] >= i[0]){
					min = Math.min(i[0], min);
					max = Math.max(i[1], max);
					deleted.add(i);
				}
			}
			q.removeAll(deleted);
			if(!deleted.isEmpty()){
				q.add(new int[]{ min, max });
			}else{
				ans.add(new int[]{ min, max });
			}
		}
		int[][] ans2 = new int[ans.size()][2];
		for(int i = 0; i < ans.size(); ++i){
			int[] interval = ans.get(i);
			ans2[i][0] = interval[0];
			ans2[i][1] = interval[1];
		}
		return ans2;
	}
	
	public List<List<Integer>> shortestPath(int [] nodes, int [][] edges, int start){
		Set<Integer[]> spt = new HashSet<>();
		Set<Integer> visited = new HashSet<>();
		Queue<Integer[]> vertices = new PriorityQueue<>((v1, v2) -> {
			int d1 = v1[1];
			int d2 = v2[1];
			if(d1 < d2){
				return -1;
			}
			if(d1 == d2){
				return 0;
			}
			return 1;
		});
		Map<Integer,List<Integer[]>> graph = new HashMap<>();
		Map<Integer,Integer[]> nodeToVertex = new HashMap<>();
		for(int node : nodes){
			for(int i = 0; i < edges.length; ++i){
				if(edges[i][0] == node){
					graph.putIfAbsent(node, new ArrayList<>());
					graph.putIfAbsent(edges[i][1], new ArrayList<>());
					graph.get(node).add(new Integer[]{ edges[i][1], edges[i][2] });
					graph.get(edges[i][1]).add(new Integer[]{ node, edges[i][2] });
				}
			}
			if(node != start){
				Integer[] vertex = new Integer[]{node, Integer.MAX_VALUE};
				vertices.add(vertex);
				nodeToVertex.put(node, vertex);
			}else{
				Integer[] startNode = new Integer[]{node, 0};
				vertices.add(startNode);
				nodeToVertex.put(node, startNode);
			}
		}
		while(!vertices.isEmpty()){
			Integer[] node = vertices.poll();
			if(!visited.contains(node[0])){
				visited.add(node[0]);
				for(Integer[] edgeNode: graph.get(node[0])){
					Integer[] edgeVertex = nodeToVertex.get(edgeNode[0]);
					int d = node[1] + edgeNode[1];
					if(d < edgeVertex[1]){
						edgeNode[1] = d;
						vertices.remove(edgeNode);
						vertices.add(edgeNode);
					}
				}
				spt.add(node);
			}
		}
		List<List<Integer>> ans = new ArrayList<>();
		for(Integer[] node: spt){
			List<Integer> list = new ArrayList<>();
			list.add(node[0]);
			list.add(node[1]);

			ans.add(list);
		}
		return ans;
	}
	

	Node head;
	public Node treeToDoublyList(Node root) {
		if(root == null){
			return root;
		}
		doit(root);
		Node node = head;
		Node last = head;
		while(node != null){
			last = node;
			node = node.right;
		}
		head.left = last;
		last.right = head;
		return head;
	}

	Node doit(Node node){
		if(node == null){
			return null;
		}
		if((node.left == null && node.right == null) && head == null){
			head = node;
		}
		Node left = doit(node.left);
		if(left != null){
			left.right = node;
			node.left = left;
		}
		Node right = doit(node.right);
		if(right != null){
			node.right = right;
			right.left = node;
		}
		if(node.right != null){
			return node.right;
		}
		return node;
	}	


		public String minRemoveToMakeValid(String s) {
		Stack<Character> stack = new Stack<>();
		Stack<Integer> pos = new Stack<>();
		for(int i = 0; i < s.length(); ++i){
			char c = s.charAt(i);
			if(c == '('){
				stack.push(c);
				pos.push(i);
			}else if(c == ')'){
				if(!stack.isEmpty() && stack.peek() == '('){
					stack.pop();
					pos.pop();
				}else{
					stack.push(c);
					pos.push(i);
				}
			}
		}
		StringBuilder ans = new StringBuilder();
		for(int i = 0; i < s.length(); ++i){
			if(!pos.contains(i)){
				ans.append(s.charAt(i));
			}
		}
		return ans.toString();
	}

		List<List<Integer>> twoSum(int [] nums, int target, int index){
		List<List<Integer>> ans = new ArrayList<>();
		int low = index, high = nums.length - 1;
		while (low < high){
			if(nums[low] + nums[high] < target){
				++low;
			}else if(nums[low] + nums[high] > target){
				--high;
			}else{
				List<Integer> list = new ArrayList<>();
				list.add(nums[low]);
				list.add(nums[high]);
				ans.add(list);
				++low;
				--high;
			}
		}
		return ans;
	}

	public int numIslands(char[][] grid) {
		int ans = 0;
		boolean [][] visited = new boolean[grid.length][grid[0].length];
		for(int i = 0; i < grid.length; ++i){
			for(int j = 0; j < grid[0].length; ++j){
				if(dfsNumIslands(grid, i, j, visited)){
					ans++;
				}
			}
		}
		return ans;
	}

	boolean dfsNumIslands(char [][] grid, int i, int j, boolean [][] visited){
		if(!validNumIslands(grid, i, j, visited)){
			return false;
		}
		if(grid[i][j] == '1'){
			visited[i][j] = true;
            dfsNumIslands(grid, i - 1, j, visited);
			dfsNumIslands(grid, i, j + 1, visited);
			dfsNumIslands(grid, i + 1, j, visited);
			dfsNumIslands(grid, i, j - 1, visited);
			return true;
		}
		return false;
	}

    private boolean validNumIslands(char [][] grid, int i, int j, boolean [][] visited){
		if(i > grid.length - 1){
			return false;
		}
		if(j > grid[0].length - 1){
			return false;
		}
        if(i < 0){
            return false;
        }
        if(j < 0){
            return false;
        }
		if(visited[i][j]){
			return false;
		}
		if(grid[i][j] == '0'){
			return false;
		}
		return true;
	}

	
	public List<List<Integer>> threeSum2(int[] nums) {
		Arrays.sort(nums);
		Map<String,List<Integer>> dedupe = new HashMap<>();
		for(int i = 0; i < nums.length; ++i){
			if(nums[i] > 0){
				break;
			}
			for(List<Integer> list : twoSum(nums, -nums[i], i + 1)){
				list.add(nums[i]);
				Collections.sort(list);
				dedupe.put(list.get(0) + "x" + list.get(1) + "x" + list.get(2), list);
			}
		}
		return new ArrayList<>(dedupe.values());
	}

	public int[][] kClosest2(int[][] points, int k) {
		Queue<Integer[]> q = new PriorityQueue<>((p1, p2) -> {
			double p1Dist = Math.sqrt((Math.pow(p1[0], 2) + Math.pow(p1[1], 2)));
			double p2Dist = Math.sqrt((Math.pow(p2[0], 2) + Math.pow(p2[1], 2)));
			if(p1Dist < p2Dist){
				return -1;
			}
			if(p1Dist == p2Dist){
				return 0;
			}
			return 1;
		});
		for(int i = 0; i < points.length; ++i){
			q.add(new Integer[]{points[i][0], points[i][1]});
		}
		int [][] ans = new int[k][2];
		for(int i = 0; i < k; ++i){
			Integer [] a = q.poll();
			ans[i] = new int[]{ a[0], a[1] };
		}
		return ans;
	}

		public static int quickestWayUp(List<List<Integer>> ladders, List<List<Integer>> snakes) {
		Map<Integer,Integer> lad = new HashMap<>();
		Map<Integer,Integer> snak = new HashMap<>();
		for(List<Integer> l: ladders){
			lad.put(l.get(0), l.get(1));
		}
		for(List<Integer> s: snakes){
			snak.put(s.get(0), s.get(1));
		}

		// Write your code here
		Queue<State> q = new LinkedList<>();
		Set<Integer> visited = new HashSet<>();

		q.add(new State(0, 1));

		while(!q.isEmpty()){
			State state = q.poll();
			if(state.square == 100){
				return state.moves;
			}
			if(!visited.contains(state.square)){
				visited.add(state.square);
				if(state.square < 100){
					if(lad.containsKey(state.square)){
						q.add(new State(state.moves, lad.get(state.square)));
					}else if(snak.containsKey(state.square)){
						q.add(new State(state.moves, snak.get(state.square)));
					}else{
						for(int i = 1; i <= 6; ++i){
							q.add(new State(state.moves + 1, state.square + i));
						}
					}
				}
			}
		}
		return -1;
	}

	static class State{
		int moves;
		int square;

		State(int moves, int square){
			this.moves = moves;
			this.square = square;
		}
	}


	public static List<Integer> bfs(int n, int m, List<List<Integer>> edges, int s) {
		// Write your code here
		Map<Integer,List<Integer>> edgeMap = new HashMap<>();
		for(List<Integer> edge: edges){
			edgeMap.putIfAbsent(edge.get(0), new ArrayList<>());
			edgeMap.putIfAbsent(edge.get(1), new ArrayList<>());
			edgeMap.get(edge.get(0)).add(edge.get(1));
			edgeMap.get(edge.get(1)).add(edge.get(0));
		}
		Map<Integer,List<Integer>> graph = new HashMap<>();
		for(int i = 1; i <= n; ++i){
			graph.putIfAbsent(i, new ArrayList<>());
			if(edgeMap.get(i) != null){
				graph.get(i).addAll(edgeMap.get(i));
			}
		}
		Set<Integer> visited = new HashSet<>();
		List<Integer> ans = new ArrayList<>();
		Map<Integer,Integer> ans2 = new TreeMap<>();
		Queue<Integer> q = new LinkedList<>();
		q.add(s);
		visited.add(s);
		int depth = 1;
		while(!q.isEmpty()){
			int size = q.size();
			for(int i = 0; i < size; ++i){
				Integer node = q.poll();
				for(int nextNode : graph.get(node)){
					if(!visited.contains(nextNode)){
						visited.add(nextNode);
						ans2.put(nextNode, depth * 6);
						q.add(nextNode);
					}
				}
			}
			depth++;
		}
		for(int i = 1; i <= n; ++i){
			if(i != s){
				Integer dist = ans2.get(i);
				if(dist == null){
					ans.add(-1);
				}else{
					ans.add(dist);
				}
			}
		}
		return ans;
	}


	
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
	int ans = 1;
	Queue<TreeNode> q = new LinkedList<>();
	q.add(root);
	while(!q.isEmpty()){   
            int size = q.size();         
			for(int i = 0; i < size; ++i){
				TreeNode node = q.poll();
				if(node.left != null){
					q.add(node.left);
				}
				if(node.right != null){
					q.add(node.right);
				}
			}   
            if(!q.isEmpty()){
                ++ans;            
            }            
		}
		return ans;
    	}
	
	public TreeNode insertIntoBST(TreeNode root, int val) {
        	if(root == null){
			return new TreeNode(val);
		}
		insert(root, val);
		return root;        
	}	
    
    	boolean insert(TreeNode node, int val){
		if(node == null){
			return true;
		}
		if(node.val > val){
			if(insert(node.left, val)){
				node.left = new TreeNode(val);
			}
			return false;
		}else if(node.val < val){
			if(insert(node.right, val)){
				node.right = new TreeNode(val);
			}
			return false;
		}
		return false;
    	}

	public void qs(int [] arr){
		qs(arr, 0, arr.length - 1);
	}

	void qs(int [] arr, int start, int end){
		if(start >= end){
			return;
		}
		int pivot = qsp(arr, start, end);
		qs(arr, start, pivot);
		qs(arr, pivot + 1, end);
	}

	int qsp(int [] arr, int start, int end){
		int pivotValue = arr[start];
		int lastLowerIndex = start;
		for(int i = start; i <= end; ++i){
			if(arr[i] < pivotValue){
				lastLowerIndex++;
				int tmp = arr[lastLowerIndex];
				arr[lastLowerIndex] = arr[i];
				arr[i] = tmp;
			}
		}
		int tmp = arr[start];
		arr[start] = arr[lastLowerIndex];
		arr[lastLowerIndex] = tmp;
		return lastLowerIndex;
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


	Map<Integer,Integer> mem = new HashMap<>();

	public int climbStairs(int n) {
		if (n == 1){
			return 1;
		}

		if (n == 2){
			return 2;
		}

		if(mem.containsKey(n)){
			return mem.get(n);
		}

		mem.put(n, climbStairs(n - 1) + climbStairs(n - 2));
		return mem.get(n);
	}

	public int minCostClimbingStairs(int[] cost) {
		return dp(cost.length, cost);
	}

	int dp(int i, int[] cost){
		if(i == 1){
			return 0;
		}
		if(i == 2){
			return Math.min(cost[i - 1], cost[i - 2]);
		}
		if(mem.containsKey(i)){
			return mem.get(i);
		}
		mem.put(i, Math.min(cost[i - 1] + dp(i - 1, cost), cost[i - 2] + dp(i - 2, cost)));
		return mem.get(i);
	}

	public int coinChange(int[] coins, int amount){
		if(amount < 0){
			return -1;
		}

		if(amount == 0){
			return 0;
		}

		if(amount == 1){
			for(int i = 0; i < coins.length; ++i){
				if(amount == coins[i]){
					return 1;
				}else{
					return -1;
				}
			}
		}

		if(mem.containsKey(amount)){
			return mem.get(amount);
		}

		int numberCoins = Integer.MAX_VALUE;
		boolean notFound = true;
		for(int i = 0; i < coins.length; ++i){
			int tmp = coinChange(coins, amount - coins[i]);
			if (tmp != -1){
				notFound = false;
				numberCoins = Math.min(numberCoins, 1 + tmp);
			}
		}

		if(notFound){
			mem.put(amount, -1);
			return -1;
		}

		mem.put(amount, numberCoins);
		return numberCoins;
	}

	public int maxProfit(int[] prices, int fee) {
		int [][] mem = new int[prices.length][2];
		for(int i = 0; i < prices.length; ++i){
			Arrays.fill(mem[i], -1);
		}
		return dp3(0, fee, false, prices, mem);
	}

	int dp3(int i, int fee, boolean holding, int [] prices, int [][] mem){
		if(i == prices.length - 1){
			if(holding){
				if(prices[i] > fee){
					return prices[i] - fee;
				}else{
					return 0;
				}
			}else{
				return 0;
			}
		}

		if(mem[i][holding ? 1 : 0] != -1){
			return mem[i][holding ? 1 : 0];
		}

		//skip doing anything (buying or selling)
		int ans = dp3(i + 1, fee, holding, prices, mem);
		if(holding){
			ans = Math.max(ans, prices[i] - fee + dp3(i + 1, fee, false, prices, mem));
		}else{
			ans = Math.max(ans, -prices[i] + dp3(i + 1, fee, true, prices, mem));
		}

		mem[i][holding ? 1 : 0] = ans;
		return ans;
	}


	public int maxProfit(int[] prices) {
		int[][][] mem = new int[prices.length][2][2];
		for(int i = 0; i < prices.length; ++i){
			for(int j = 0; j < 2; ++j){
				Arrays.fill(mem[i][j], -1);
			}
		}
		return dp4(prices, 0, false, false, mem);
	}

	int dp4(int [] prices, int i, boolean holding, boolean coolDown, int[][][] mem){
		if(i == prices.length - 1){
			if(holding){
				return prices[i];
			}else{
				return 0;
			}
		}
		if(mem[i][holding ? 1: 0][coolDown ? 1: 0] != -1){
			return mem[i][holding ? 1: 0][coolDown ? 1: 0];
		}
		int ans;
		if(holding){
			ans = Math.max(prices[i] + dp4(prices,i + 1, false, true, mem),
					dp4(prices,i + 1, true, false, mem));
		}else{
			if(coolDown){
				ans = dp4(prices, i + 1, false, false, mem);
			}else{
				ans = Math.max(-prices[i] + dp4(prices, i + 1, true, false, mem),
						dp4(prices, i + 1, false, false, mem));
			}
		}
		mem[i][holding ? 1: 0][coolDown ? 1: 0] = ans;
		return ans;
	}

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int[][] mem = new int[obstacleGrid.length][obstacleGrid[0].length];
		for(int i = 0; i < mem.length; ++i){
			Arrays.fill(mem[i], -1);
		}
		return dp5(obstacleGrid, obstacleGrid.length - 1, obstacleGrid[0].length - 1, mem);
	}

	int dp5(int [][] grid, int row, int col, int[][] mem){
		if(grid[row][col] == 1){
			return 0;
		}
		if(row == 0 && col == 0){
			return 1;
		}

		if(mem[row][col] != -1){
			return mem[row][col];
		}

		int paths = 0;
		if(row > 0){
			if(grid[row - 1][col] != 1){
				paths += dp5(grid, row - 1, col, mem);
			}
		}

		if(col > 0){
			if(grid[row][col - 1] != 1){
				paths += dp5(grid, row, col - 1, mem);
			}
		}

		mem[row][col] = paths;
		return mem[row][col];
	}

	public int minFallingPathSum(int[][] matrix) {

		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < matrix.length; ++i){
			Map<String,Integer> mem = new HashMap<>();
			ans = Math.min(ans, dp6(matrix, 0, i, mem));
		}
		return ans;
	}

	int dp6(int[][] matrix, int row, int col, Map<String,Integer> mem){
		if(!valid(matrix, row, col)){
			return Integer.MAX_VALUE;
		}

		if(row == matrix.length - 1){
			return matrix[row][col];
		}

		if(mem.containsKey(row + "-" + col)){
			return mem.get(row + "-" + col);
		}

		int ans = Integer.MAX_VALUE;
		ans = Math.min(ans, dp6(matrix, row + 1, col - 1, mem));
		ans = Math.min(ans, dp6(matrix, row + 1, col, mem));
		ans = Math.min(ans, dp6(matrix, row + 1, col + 1, mem));

		if(ans != Integer.MAX_VALUE){
			ans += matrix[row][col];
		}

		mem.put(row + "-" + col, ans);
		return ans;
	}

	boolean valid(int [][] matrix, int row, int col){
		if(row > matrix.length - 1 || row < 0){
			return false;
		}
		if(col > matrix.length - 1 || col < 0){
			return false;
		}
		return true;
	}

	public boolean containsDuplicate(int[] nums) {
		Map<Integer,Integer> map = new HashMap<>();
		for(int i = 0; i < nums.length; ++i){
			map.putIfAbsent(nums[i], 0);
			map.put(nums[i], map.get(nums[i]) + 1);
			if(map.get(nums[i]) >= 2){
				return true;
			}
		}
		return false;
	}

	//O((N*log(N)) + N*(N*log(N)) = N*(N*log(N))
	public boolean checkInclusion(String s1, String s2) {
		if(s1.length() > s2.length()){
			return false;
		}
		char [] arr = s1.toCharArray();
		Arrays.sort(arr);
		String sortedS1 = new String(arr);

		for(int i = 0; i <= s2.length() - s1.length(); ++i){
			String sub = s2.substring(i, i + s1.length());
			char [] arrS2 = sub.toCharArray();
			Arrays.sort(arrS2);
			String sortedSub = new String(arrS2);
			if(sortedSub.equals(sortedS1)){
				return true;
			}
		}
		return false;
	}

	public boolean checkInclusion2(String s1, String s2) {
		Set<String> perms = new HashSet<>();
		perms(s1, 0, new HashSet<>(), new StringBuilder(), perms);
		for(String perm: perms){
			if(s2.contains(perm)){
				return true;
			}
		}
		return false;
	}

	public boolean closeStrings(String word1, String word2) {
		Map<Character,Integer> map1 = new HashMap<>();
		Map<Character,Integer> map2 = new HashMap<>();
		for(Character character : word1.toCharArray()){
			map1.putIfAbsent(character, 0);
			map1.put(character, map1.get(character) + 1);
		}

		for(Character character : word2.toCharArray()){
			map2.putIfAbsent(character, 0);
			map2.put(character, map2.get(character) + 1);
		}

		for(Character character1 : map1.keySet()){
			if(map2.get(character1) == null){
				return false;
			}
		}

		List<Integer> counts1 = new ArrayList<>(map1.values());
		Collections.sort(counts1);

		List<Integer> counts2 = new ArrayList<>(map2.values());
		Collections.sort(counts2);

		for(int i = 0; i < counts1.size(); ++i){
			if(!counts1.get(i).equals(counts2.get(i))){
				return false;
			}
		}

		return true;
	}

	void perms(String s, int index, Set<Integer> seen, StringBuilder sb, Set<String> ans){
		if(s.length() == sb.length()){
			ans.add(sb.toString());
			return;
		}
		if(index < 0){
			return;
		}
		for(int i = 0; i < s.length(); ++i){
			StringBuilder tmp = new StringBuilder(sb);
			tmp.append(s.charAt(i));
			if(!seen.contains(i)){
				seen.add(i);
				perms(s, i + 1, seen, tmp, ans);
				perms(s, i - 1, seen, tmp, ans);
				seen.remove(i);
			}
		}
	}



	public int[] sortedSquares(int[] nums) {
		int [] tmp = new int[nums.length];
		int left = 0;
		int right = nums.length - 1;

		for(int i = tmp.length - 1; i >= 0; --i){
			int square;
			if (Math.abs(nums[left]) < Math.abs(nums[right])){
				square = nums[right] * nums[right];
				--right;
			}else{
				square = nums[left] * nums[left];
				++left;
			}

			tmp[i] = square;
		}
		return tmp;
	}

	//O(2 * N) = O(N), O(N)
	public String reversePrefix(String word, char ch) {
		StringBuilder stringBuilder = new StringBuilder();
		for(int i = 0; i < word.length(); ++i){
			if(word.charAt(i) == ch){
				stringBuilder.append(word.charAt(i));
				if(i == word.length() - 1){
					return stringBuilder.reverse().toString();
				}
				return stringBuilder.reverse() + word.substring(i + 1);
			}
			stringBuilder.append(word.charAt(i));
		}
		return word;
	}

	public ListNode swapNodes(ListNode head, int k) {
		ListNode next = head;
		List<ListNode> list = new ArrayList<>();
		while(next != null){
			list.add(next);
			next = next.next;
		}

		ListNode swap1 = list.get(k - 1);
		ListNode swap2 = list.get(list.size() - k);

		list.remove(k - 1);
		list.add(k - 1, swap2);
		list.remove(list.size() - k);
		list.add(list.size() - k + 1, swap1);

		ListNode newHead = new ListNode();
		newHead.val = list.get(0).val;
		if(list.size() > 1){
			ListNode newHeadCopy = newHead;
			list.remove(0);
			for(ListNode node: list){
				newHead.next = new ListNode();
				newHead.next.val = node.val;
				newHead = newHead.next;
			}
			return newHeadCopy;
		}
		return newHead;
	}

	public int pairSum2(ListNode head) {
		List<Integer> first = new ArrayList<>();
		int n = 0;
		ListNode next = head;
		while(next != null){
			n++;
			next = next.next;
		}

		int i = 0;
		next = head;
		while(next != null){
			if (i <= (n / 2) - 1){
				first.add(next.val);
			}
			else{
				break;
			}
			++i;
			next = next.next;
		}

		ListNode prev = null;
		next = head;
		while(next != null){
			ListNode tmp = next.next;
			next.next = prev;
			prev = next;
			next = tmp;
		}

		List<Integer> second = new ArrayList<>();
		i = 0;
		next = prev;
		while (prev != null){
			if (i <= (n / 2) - 1){
				second.add(next.val);
			}else{
				break;
			}
			++i;
			next = next.next;
		}
		int ans = Integer.MIN_VALUE;
		i = 0;
		for(Integer f : first){
			ans = Math.max(ans, second.get(i) + f);
			++i;
		}
		return ans;
	}


	public int[] asteroidCollision(int[] asteroids) {
		Stack<Integer> stack = new Stack<>();
		Stack<Integer> finalStack = new Stack<>();
		for(int i = 0; i < asteroids.length; ++i){
			stack.add(i);
		}

		while(true){
			finalStack.push(stack.pop());
			boolean complete = true;
			while(!stack.isEmpty()){
				int fromIndex = stack.pop();
				if(finalStack.isEmpty()){
					finalStack.push(fromIndex);
					continue;
				}
				int finalIndex = finalStack.peek();
				if(fromIndex < finalIndex && asteroids[fromIndex] >= 0 && asteroids[finalIndex] < 0
						|| fromIndex > finalIndex && asteroids[fromIndex] < 0 && asteroids[finalIndex] >= 0){
					if(Math.abs(asteroids[fromIndex]) > Math.abs(asteroids[finalIndex])){
						finalStack.pop();
						finalStack.push(fromIndex);
						complete = false;
					}else if (Math.abs(asteroids[fromIndex]) == Math.abs(asteroids[finalIndex])){
						finalStack.pop();
					}
				}else{
					finalStack.push(fromIndex);
				}
			}

			if(complete){
				break;
			}
			stack = new Stack<>();
			for(int i = finalStack.size() - 1; i >= 0; --i){
				stack.push(finalStack.get(i));
			}
			finalStack = new Stack<>();
		}


		int [] ans = new int[finalStack.size()];
		int i = 0;
		while(!finalStack.isEmpty()){
			ans[i] = asteroids[finalStack.pop()];
			++i;
		}
		return ans;
	}


	public String predictPartyVictory(String senate) {
		Queue<Character> all = new LinkedList<>();
		Queue<Character> d = new LinkedList<>();
		Queue<Character> r = new LinkedList<>();

		for(Character senator : senate.toCharArray()){
			all.add(senator);
			if(senator == 'R'){
				r.add(senator);
			}else{
				d.add(senator);
			}
		}

		while(true){
			while(!all.isEmpty()){
				Character senator = all.poll();
				if(senator == 'R' && d.isEmpty()){
					return "Radiant";
				}
				if(senator == 'D' && r.isEmpty()){
					return "Dire";
				}
				if(senator == 'R'){
					all.remove('D');
					d.poll();
				}else{
					all.remove('R');
					r.poll();
				}
				all.add(senator);
			}
		}
	}

	public long subArrayRanges(int[] nums) {
		long ans = 0;
		for(int i = 0; i < nums.length; ++i){
			for(int j = i; j < nums.length; ++j){
				int max = nums[i], min = nums[i];
				for(int k = i; k <= j; ++k){
					max = Math.max(max, nums[k]);
					min = Math.min(min, nums[k]);
				}
				ans += max - min;
			}
		}
		return ans;
	}


	public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
		List<List<Integer>> ans = new ArrayList<>();
		if(root == null){
			return ans;
		}
		dfsPathSum(root, 0, targetSum, new ArrayList<>(), ans);
		return ans;
	}

	void dfsPathSum(TreeNode node, int currentSum, int targetSum, List<Integer> path, List<List<Integer>> ans){
		if(node.left == null && node.right == null){
			path.add(node.val);
			if(node.val + currentSum == targetSum){
				ans.add(new ArrayList<>(path));
			}
			return;
		}
		path.add(node.val);
		if(node.left != null){
			dfsPathSum(node.left, node.val + currentSum, targetSum, path, ans);
			path.remove(path.size() - 1);
		}
		if(node.right != null){
			dfsPathSum(node.right, node.val + currentSum, targetSum, path, ans);
			path.remove(path.size() - 1);
		}
	}


	public List<List<Integer>> levelOrder(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		List<List<Integer>> ans = new ArrayList<>();
		if(root == null){
			return ans;
		}
		List<Integer> first = new ArrayList<>();
		first.add(root.val);
		ans.add(first);
		queue.add(root);
		while(!queue.isEmpty()){
			List<Integer> level = new ArrayList<>();
			int size = queue.size();
			for(int i = 0; i < size; ++i){
				TreeNode node = queue.poll();
				if(node.left != null){
					level.add(node.left.val);
					queue.add(node.left);
				}
				if(node.right != null){
					level.add(node.right.val);
					queue.add(node.right);
				}
			}
			if(!level.isEmpty()){
				ans.add(level);
			}
		}
		return ans;
	}

	//O(n1 + n2) * O(log(n1 + n2), O(n1 + n2)
	public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
		List<Integer> ans = new ArrayList<>();
		dfsAllElements(root1, ans);
		dfsAllElements(root2, ans);
		Collections.sort(ans);
		return ans;
	}

	void dfsAllElements(TreeNode node, List<Integer> ans){
		if(node == null){
			return;
		}

		ans.add(node.val);
		dfsAllElements(node.left, ans);
		dfsAllElements(node.right, ans);
	}

	public int maximalNetworkRank(int n, int[][] roads) {
		Map<Integer,List<Integer>> graph = new HashMap<>();
		for(int[] road : roads){
			graph.putIfAbsent(road[0], new ArrayList<>());
			List<Integer> list = graph.get(road[0]);
			list.add(road[1]);
			graph.put(road[0], list);
			graph.putIfAbsent(road[1], new ArrayList<>());
			list = graph.get(road[1]);
			list.add(road[0]);
			graph.put(road[1], list);
		}
		if(graph.isEmpty()){
			return 0;
		}
		int ans = 0;
		for(int i = 0; i < n; ++i){
			for(int j = i + 1; j < n; ++j){
				ans = Math.max(ans, maximalNetworkRank(i, j, graph, new HashSet<>()));
			}

		}
		return ans;
	}

	int maximalNetworkRank(int city1, int city2, Map<Integer,List<Integer>> graph, Set<String> seen){
		int ans = 0;

		if(graph.get(city1) != null){
			for(Integer dest : graph.get(city1)){
				String key;
				if(dest >= city1){
					key = city1 + "-" + dest;
				}else{
					key = dest + "-" + city1;
				}
				if(!seen.contains(key)){
					seen.add(key);
					ans += 1;
				}
			}
		}
		if(graph.get(city2) != null){
			for(Integer dest : graph.get(city2)){
				String key;
				if(dest >= city2){
					key = city2 + "-" + dest;
				}else{
					key = dest + "-" + city2;
				}
				if(!seen.contains(key)){
					seen.add(key);
					ans += 1;
				}
			}
		}

		return ans;
	}

	//O(N!), O(N)
	public List<String> restoreIpAddresses(String s) {
		List<String> ans = new ArrayList<>();
		List<String> path = new ArrayList<>();
		backtrackIp(s, 0, path, ans);
		return ans;
	}

	void backtrackIp(String s, int start, List<String> path, List<String> ans){
		if(start > s.length() - 1){
			if(path.size() == 4){
				StringBuilder sb = new StringBuilder();
				for(String p: path){
					sb.append(p);
					sb.append(".");
				}
				sb.deleteCharAt(sb.length() - 1);
				ans.add(sb.toString());
			}
			return;
		}

		for(int end = start + 1; end <= s.length(); ++end){
			String sub = s.substring(start, end);
			if(sub.startsWith("0") && sub.length() > 1
				|| sub.length() == 19 && Long.parseLong(sub.substring(0, 3)) > 922
				|| sub.length() > 19){
				continue;
			}
			long ip = Long.parseLong(s.substring(start, end));
			if(ip >= 0 && ip <= 255){
				path.add(String.valueOf(ip));
				backtrackIp(s, end, path, ans);
				path.remove(path.size() - 1);
			}
		}
	}

	//O(N * (N * 2 * (N * log(N))) * N^2)  ,  O(2 * N)
	public List<String> topKFrequent2(String[] words, int k) {
		Map<String,Integer> counts = new HashMap<>();
		for(String word : words){
			counts.putIfAbsent(word, 0);
			counts.put(word, counts.get(word) + 1);
		}
		TreeMap<Integer,List<String>> sortedMap = new TreeMap<>(Comparator.reverseOrder());
		for(String word: counts.keySet()){
			int count = counts.get(word);
			sortedMap.putIfAbsent(count, new ArrayList<>());
			List<String> wordList = sortedMap.get(count);
			wordList.add(word);
			Collections.sort(wordList);
			sortedMap.put(count, wordList);
		}
		List<String> ans = new ArrayList<>();
		for(int count: sortedMap.keySet()){
			ans.addAll(sortedMap.get(count));
			if(ans.size() >= k){
				while (ans.size() > k){
					ans.remove(ans.size() - 1);
				}
				break;
			}
		}
		return ans;
	}

	class WordCount{
		int count;
		String word;
		WordCount(String word, int count){
			this.word = word;
			this.count = count;
		}
	}

	//O(N * (k * log(k))), O(N)
	public List<String> topKFrequent(String[] words, int k) {
		Queue<WordCount> heap = new PriorityQueue<>((wc1, wc2) -> {
			if(wc1.count < wc2.count){
				return -1;
			}
			if(wc1.count > wc2.count){
				return 1;
			}
			return wc2.word.compareTo(wc1.word);
		});
		Map<String,WordCount> counts = new HashMap<>();
		for(String word : words){
			counts.putIfAbsent(word, new WordCount(word, 0));
			WordCount wc = counts.get(word);
			wc.count++;
			counts.put(word, wc);
		}

		for(WordCount wc: counts.values()){
			if(heap.size() < k){
				heap.add(wc);
			}else if(heap.size() == k){
				WordCount removed = heap.remove();
				if(removed.count > wc.count){
					heap.add(removed);
				}else if(removed.count < wc.count){
					heap.add(wc);
				}else{
					if(removed.word.compareTo(wc.word) < 0){
						heap.add(removed);
					}else{
						heap.add(wc);
					}
				}
			}
		}
		List<String> tmp = new ArrayList<>();
		while(!heap.isEmpty()){
			tmp.add(heap.remove().word);
		}
		List<String> ans = new ArrayList<>();
		for(int i = tmp.size() - 1; i >= 0; --i){
			ans.add(tmp.get(i));
		}
		return ans;
	}

	public int maxIceCream(int[] costs, int coins) {
		Arrays.sort(costs);

		int ans = 0;
		for(int i = 0; i < costs.length; ++i){
			if(costs[i] > coins){
				return ans;
			}
			coins -= costs[i];
			++ans;
		}
		return ans;
	}

	int getPivot(int [] nums){
		int leftValue = nums[0];
		int left = 0;
		int right = nums.length - 1;

		while(left <= right){
			int mid = left + (right - left) / 2;

			if(mid < nums.length - 1 && nums[mid] > nums[mid + 1]){
				return mid + 1;
			}

			if(nums[mid] >= leftValue){
				left = mid + 1;
			}else{
				right = mid - 1;
			}
		}

		return -1;
	}

	public int search(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;

		if(nums[0] > nums[nums.length - 1]){
			int pivot = getPivot(nums);

			if(target < nums[0]){
				left = pivot;
			}else{
				right = pivot - 1;
			}
		}

		while(left <= right){
			int mid = left + (right - left) / 2;
			if(target < nums[mid]){
				right = mid - 1;
			}else if(target > nums[mid]){
				left = mid + 1;
			}else{
				return mid;
			}
		}
		return -1;
	}

	public int minDays(int[] bloomDay, int m, int k) {
		if((long)m * (long)k > bloomDay.length){
			return -1;
		}

		long max = Integer.MIN_VALUE;
		for(int i = 0; i < bloomDay.length; ++i){
			max = Math.max(bloomDay[i], max);
		}

		Set<Long> seenDays = new HashSet<>();

		long left = 0;
		long right = max * m * k;

		while(left <= right){
			long mid = left + (right - left) / 2;

			long bqs = getBqs(bloomDay, mid, k);

			if(m > bqs){
				left = mid + 1;
			}else if(m <= bqs){
				if(seenDays.contains(mid)){
					return (int)mid;
				}
				seenDays.add(mid);
				right = mid - 1;
			}else{
				return (int)mid;
			}
		}
		return (int)left;
	}

	long getBqs(int [] bloomDay, long days, int k){
		long used = 0;
		long bqs = 0;
		for(int i = 0; i < bloomDay.length; ++i){
			if(days >= bloomDay[i]){
				used++;
			}else{
				used = 0;
			}
			if(used == k){
				bqs++;
				used = 0;
			}
		}
		return bqs;
	}


	public int videoStitching(int[][] clips, int time) {
		Map<Integer,Queue<Integer>> map = new HashMap<>();
		for(int i = 0; i < clips.length; ++i){
			map.putIfAbsent(clips[i][0], new PriorityQueue<>(Comparator.reverseOrder()));
			Queue<Integer> queue = map.get(clips[i][0]);
			queue.add(clips[i][1]);
		}

		int ans = 1;
		int start = 0;
		if(map.get(start) == null){
			return -1;
		}
		int maxEnd = map.get(start).peek();
		while(start < time){
			if(maxEnd >= time){
				return ans;
			}
			Queue<Integer> queue = map.get(start);
			if(queue == null || queue.isEmpty()){
				return -1;
			}
			int nextStart = -1;
			for(int i = start; i <= queue.peek(); ++i){
				Queue<Integer> q = map.get(i);
				if(q != null){
					if(q.peek() >= maxEnd){
						maxEnd = q.peek();
						nextStart = i;
					}
				}
			}
			if(nextStart <= start){
				return -1;
			}
			start = nextStart;
			++ans;
		}
		return ans;
	}

	public int maximalSquare(char[][] matrix) {
		int [][] mem = new int[matrix.length][matrix[0].length];
		for(int i = 0; i < mem.length; ++i){
			Arrays.fill(mem[i], -1);
		}
		int depth = 0;
		for(int i = 0; i < matrix.length; ++i){
			for(int j = 0; j < matrix[0].length; ++j){
				depth = Math.max(depth, maximalSquare(matrix, i, j, 0, mem));
			}
		}
		return (int)Math.pow(depth, 2);
	}

	boolean validMaximalSquare(char [][] matrix, int row, int col){
		if(row >= matrix.length || col >= matrix[0].length){
			return false;
		}
		return true;
	}

	int maximalSquare(char [][] matrix, int row, int col, int depth, int [][] mem){
		if(!validMaximalSquare(matrix, row, col)){
			return 0;
		}
		if(mem[row][col] != -1){
			return mem[row][col];
		}
		int ans = 0;
		if(matrix[row][col] == '1'){
			int d1 = maximalSquare(matrix, row, col + 1, depth + 1, mem);
			int d2 = maximalSquare(matrix, row + 1, col + 1, depth + 1, mem);
			int d3 = maximalSquare(matrix, row + 1, col, depth + 1, mem);
			ans = 1 + Math.min(Math.min(d1, d2), d3);
		}
		mem[row][col] = ans;
		return ans;
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

class NumArray {

	int [] sums;

	public NumArray(int[] nums) {
		this.sums = new int[nums.length];
		this.sums[0] = nums[0];
		for(int i = 1; i < nums.length; ++i){
			this.sums[i] = sums[i - 1] + nums[i];
		}
	}

	public int sumRange(int left, int right) {
		if(left == 0){
			return sums[right];
		}
		return sums[right] - sums[left - 1];
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

class QueueWithStacks{

	Stack<Integer> s1 = new Stack<>();
	Stack<Integer> s2 = new Stack<>();

	public void enqueue(int v){
		if(s1.isEmpty() && s2.isEmpty()){
			s2.add(v);
			return;
		}
		s1.add(v);
	}

	public Integer dequeue(){
		if(s2.isEmpty()){
			return null;
		}
		int front = s2.pop();
		if(s2.isEmpty()){
			while(!s1.isEmpty()){
				s2.add(s1.pop());
			}
		}
		return front;
	}

	public Integer print(){
		return s2.peek();
	}

}

class ListNode2{

	ListNode2 next;
	ListNode2 prev;
	int val;
	int key;

}

class LRUCache {

	Map<Integer,ListNode2> cache;
	int capacity;
	ListNode2 head;
	ListNode2 tail;

	public LRUCache(int capacity) {
		this.cache = new HashMap<>(capacity);
		this.capacity = capacity;
	}

	public int get(int key) {
		if(cache.containsKey(key)){
			ListNode2 node = cache.get(key);
			remove(node);
			add(node);
			return cache.get(key).val;
		}
		return -1;
	}

	public void put(int key, int value) {
		if(cache.containsKey(key)){
			ListNode2 node = cache.get(key);
			node.val = value;
			remove(node);
			cache.put(key, node);
			add(node);
			return;
		}
		ListNode2 node = new ListNode2();
		node.val = value;
		node.key = key;
		if(cache.size() == capacity){
			remove(head);
			cache.remove(head.key);
		}
		cache.put(key, node);
		add(node);
	}

	void remove(ListNode2 node){
		if(cache.size() == 1){
			head = null;
			tail = null;
			return;
		}
		if(node == head){
			head = head.next;
			head.prev = null;
			return;
		}
		if(node == tail){
			tail = tail.prev;
			return;
		}
		node.prev.next = node.next;
		node.next.prev = node.prev;
	}

	void add(ListNode2 node){
		if(head == null){
			head = node;
			tail = node;
			return;
		}
		tail.next = node;
		node.prev = tail;
		tail = node;
	}
}

