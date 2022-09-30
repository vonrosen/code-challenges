package org.hunter;

public class BallRolls{

	/**
	 * We have the game of russian roulette but we are just going to consider the colors of the numbers for our
	 * pointing system. Any time ball lands on
	 *
	 * A number with red color - 3 points
	 * A number with Black color - 1 point
	 * A number with Green color - 0 points
	 *
	 * Given only 4 ball rolls, determine if that score is valid or not
	 * E.g.     score = 11; false -- because you can't reach the number 11 using only 3, 1, and 0.
	 * score = 4; true {3,1,0,0}
	 *
	 * 	Extension: Ask the candidate to generalize it for n ball rolls if they hardcode ball rolls.
	 */

	public static void main(String [] args){
		BallRolls ballRolls = new BallRolls();
		int [] points = new int[] {3,1,0};
		System.out.println(ballRolls.isScoreValid(4, 0, points, 0, 11));
		System.out.println(ballRolls.isScoreValidMem(4, points, 11));
		System.out.println(ballRolls.isScoreValid(4, 0, points, 0, 4));
		System.out.println(ballRolls.isScoreValidMem(4, points, 4));
		System.out.println(ballRolls.isScoreValid(1, 0, points, 0, 4));
		System.out.println(ballRolls.isScoreValidMem(1, points,4));
		System.out.println(ballRolls.isScoreValid(1, 0, points, 0, 1));
		System.out.println(ballRolls.isScoreValidMem(1, points,1));
	}

	//time complexity = O(2^N) where N = points.length. space complexity = 0(1)
	private boolean isScoreValid(int totalRolls, int rollNumber, int [] points, int currentScore,
			int targetScore){
		if(totalRolls == rollNumber){
			return currentScore == targetScore;
		}
		for(int i = 0; i < points.length; ++i){
			if(isScoreValid(totalRolls, rollNumber + 1, points, currentScore + points[i], targetScore)){
				return true;
			}
		}
		return false;
	}

	//DP solution
	//time complexity = O(TR * TS * NP) where TR = total rolls, TS = target score and NP = number of points. space
	// complexity = 0(TR * TS)
	private boolean isScoreValidMem(int totalRolls, int [] points, int targetScore){
		int [][] mem = new int[totalRolls][targetScore + 1];
		for(int i = 0; i < totalRolls; ++i){
			for(int j = 1; j < mem[0].length; ++j){
				for(int k = 0; k < points.length; ++k){
					if(i == 0){
						if(points[k] < mem[0].length){
							mem[i][points[k]] = 1;
						}
					}else{
						if(mem[i - 1][j] > 0){
							int newScore = j + points[k];
							if(newScore < mem[0].length){
								mem[i][newScore] = mem[i - 1][j] + 1;
							}
						}
					}
				}
			}
		}
		return mem[totalRolls - 1][targetScore] > 0;
	}

}
