package org.hunter;

public class PredictTheWinner {

    /**
     * choose whatever number leaves your opponent with a lesser max number to choose from
     * @param args
     */
    public static void main(String [] args) {
        PredictTheWinner p = new PredictTheWinner();
//        int [] nums = new int [] {1,5,2};
        int [] nums = new int [] {1,5,233,7};
        System.out.println(p.predictTheWinner(nums));
    }

    public boolean predictTheWinner(int[] nums) {
        Integer [][][][] mem = new Integer[nums.length][nums.length][2][2];
        int [] scores = maxScores(nums, 0, nums.length - 1, true, mem);
        return scores[0] >= scores[1];
    }

    int [] maxScores(int [] nums, int left, int right, boolean isPlayerOne, Integer [][][][] mem) {
        if (left > right) {
            return new int[] {0,0};
        }
        if (isPlayerOne) {
            if (mem[left][right][0][0] != null) {
                return new int[] {
                        mem[left][right][0][0],
                        mem[left][right][0][1],
                };
            }

            int [] tmp = maxScores(nums, left + 1, right, !isPlayerOne, mem);
            int [] scoresLeft = new int[] {nums[left] + tmp[0], tmp[1]};
            tmp = maxScores(nums, left, right - 1, !isPlayerOne, mem);
            int [] scoresRight = new int[] {nums[right] + tmp[0], tmp[1]};
            if (scoresLeft[0] > scoresRight[0]) {
                mem[left][right][0][0] = scoresLeft[0];
                mem[left][right][0][1] = scoresLeft[1];
                return scoresLeft;
            }
            mem[left][right][0][0] = scoresRight[0];
            mem[left][right][0][1] = scoresRight[1];
            return scoresRight;
        }
        if (mem[left][right][1][0] != null) {
            return new int[] {
                    mem[left][right][1][0],
                    mem[left][right][1][1],
            };
        }
        int [] tmp = maxScores(nums, left + 1, right, !isPlayerOne, mem);
        int [] scoresLeft = new int[] {tmp[0], nums[left] + tmp[1]};
        tmp = maxScores(nums, left, right - 1, !isPlayerOne, mem);
        int [] scoresRight = new int[] {tmp[0], nums[right] + tmp[1]};
        if (scoresLeft[1] > scoresRight[1]) {
            mem[left][right][1][0] = scoresLeft[0];
            mem[left][right][1][1] = scoresLeft[1];
            return scoresLeft;
        }
        mem[left][right][1][0] = scoresRight[0];
        mem[left][right][1][1] = scoresRight[1];
        return scoresRight;
    }

}
