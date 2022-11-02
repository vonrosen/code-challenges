package org.hunter;

public class BallRollsForInterview{

	/**
	 * There is a game where there are 3 colored squares each which is assigned a number of points.
	 *
	 * A number with red color - 3 points
	 * A number with Black color - 1 point
	 * A number with Green color - 0 points
	 *
	 * The player rolls a ball and whatever square the ball lands on the player gets the number of points
	 * Players roll the ball once for each round of the game and adds the points for a total score.
	 *
	 * Write a function that verifies a score of this game is valid for a player given:
	 * - the number of rolls allowed
	 * - the points assigned to each color described above
	 * - a score to validate
	 *
	 * boolean isScoreValid(int numberOfRolls, int [] points, int score)
	 *
	 * Example 1:
	 * 4 rounds
	 * red = 3 points, black = 1 point, green = 0 points
	 * score to verify = 11
	 * result = false - you can't reach the number 11 using only 3, 1, and 0 after 4 rounds.
	 *
	 * Example 2:
	 * 5 rounds
	 * red = 3 points, black = 1 point, green = 0 points
	 * score to verify = 11
	 * result = true - you can reach 9 if you roll 3 on the first 3 rounds, 1 on the 4th round and 1 on the 5th round
	 *
	 * @param args
	 */
	public static void main(String [] args){
		BallRollsForInterview ballRollsForInterview = new BallRollsForInterview();
		int [] points = new int[] {3,1,0};
		System.out.println(ballRollsForInterview.isScoreValid(4, 0, points, 0, 11));
		System.out.println(ballRollsForInterview.isScoreValid(5, 0, points, 0, 11));
		System.out.println(ballRollsForInterview.isScoreValidMem(4, points, 11));
		System.out.println(ballRollsForInterview.isScoreValid(4, 0, points, 0, 4));
		System.out.println(ballRollsForInterview.isScoreValidMem(4, points, 4));
		System.out.println(ballRollsForInterview.isScoreValid(1, 0, points, 0, 4));
		System.out.println(ballRollsForInterview.isScoreValidMem(1, points,4));
		System.out.println(ballRollsForInterview.isScoreValid(1, 0, points, 0, 1));
		System.out.println(ballRollsForInterview.isScoreValidMem(1, points,1));
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
