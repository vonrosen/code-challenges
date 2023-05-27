package org.hunter;

public class LongestCommonSubsequence{

	public static void main(String [] args){
		LongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence();
		String text1 = "abcde";
		String text2 = "ace";
		System.out.println(longestCommonSubsequence.longestCommonSubsequence(text1, text2));
		text1 = "abc";
		text2 = "abc";
		System.out.println(longestCommonSubsequence.longestCommonSubsequence(text1, text2));
		text1 = "abc";
		text2 = "def";
		System.out.println(longestCommonSubsequence.longestCommonSubsequence(text1, text2));
		text1 = "psnw";
		text2 = "vozsh";
		System.out.println(longestCommonSubsequence.longestCommonSubsequence(text1, text2));
		text1 = "oxcpqrsvwf";
		text2 = "shmtulqrypy";
		System.out.println(longestCommonSubsequence.longestCommonSubsequence(text1, text2));
		text1 = "papmretkborsrurgtina";
		text2 = "nsnupotstmnkfcfavaxgl";
		System.out.println(longestCommonSubsequence.longestCommonSubsequence(text1, text2));
	}

	private int[][] memo;
	private String text1;
	private String text2;

	private int memoSolve(int p1, int p2) {
		// Check whether or not we've already solved this subproblem.
		// This also covers the base cases where p1 == text1.length
		// or p2 == text2.length.
		if (memo[p1][p2] != -1) {
			return memo[p1][p2];
		}

		// Option 1: we don't include text1[p1] in the solution.
		int option1 = memoSolve(p1 + 1, p2);

		// Option 2: We include text1[p1] in the solution, as long as
		// a match for it in text2 at or after p2 exists.
		int firstOccurence = text2.indexOf(text1.charAt(p1), p2);
		int option2 = 0;
		if (firstOccurence != -1) {
			option2 = 1 + memoSolve(p1 + 1, firstOccurence + 1);
		}

		// Add the best answer to the memo before returning it.
		memo[p1][p2] = Math.max(option1, option2);
		return memo[p1][p2];
	}

	public int longestCommonSubsequence(String text1, String text2) {
		Integer [][] mem = new Integer[text1.length() + 1][text2.length() + 1];
		return dfsMem(text1, text2, 0, 0, mem);
	}

	public int dfsMem(String text1, String text2, int pos1, int pos2, Integer [][] mem){
		if(text1.length() == 0 || text2.length() == 0){
			mem[pos1][pos2] = 0;
		}
		if(mem[pos1][pos2] != null){
			return mem[pos1][pos2];
		}
		int count2 = 0;
		int count1 = dfsMem(text1.substring(1), text2, pos1 + 1, pos2, mem);
		int index = text2.indexOf(text1.charAt(0));
		if(index != -1){
			count2 = 1 + dfsMem(text1.substring(1), text2.substring(index + 1), pos1 + 1, index + 1, mem);
		}
		mem[pos1][pos2] = Math.max(count1, count2);
		return mem[pos1][pos2];
	}

	public int dfs(String text1, String text2, String sub1, String sub2, int pos1, int pos2, int length){
		if(sub1.equals(sub2)){
			length = Math.max(length, sub1.length());
		}
		for(int i = pos1; i < text1.length(); ++i){
			for(int k = pos2; k < text2.length(); ++k){
				length = Math.max(length,
						dfs(text1,
								text2,
								sub1.concat(String.valueOf(text1.charAt(i))),
								sub2.concat(String.valueOf(text2.charAt(k))),
								i + 1,
								k + 1,
								length));
			}
		}
		return length;
	}

}
