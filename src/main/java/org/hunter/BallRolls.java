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
		System.out.println(ballRolls.isScoreValid(4, 0, points, 0, 4));
		System.out.println(ballRolls.isScoreValid(1, 0, points, 0, 4));
		System.out.println(ballRolls.isScoreValid(1, 0, points, 0, 1));
	}

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

}
