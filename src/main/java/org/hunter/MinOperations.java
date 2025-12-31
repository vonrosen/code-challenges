package org.hunter;

public class MinOperations {

    /**
     * greedy solution. find the 2 diffs above and below the number
     * and use the smallest one as the next n until you get to zero
     * @param n
     * @return
     */
    public int minOperations(int n) {
        int ops = 0;
        while (n > 0) {
            ++ops;
            int low = 0, high = 0;
            for(int i = 0; i <= n; ++i) {
                high = (int)Math.pow(2, i);
                if(high >= n) {
                    break;
                }
                low = high;
            }
            int diff1 = high - n;
            int diff2 = n - low;
            n = Math.min(diff1, diff2);
        }
        return ops;
    }

    //impossible. time complexity = O(3^(10^5))
    int min(int currN, int numOps, int currNumber, int n) {
        if(currNumber == 0) {
            return numOps;
        }
        if(currN > n) {
            return numOps;
        }
        int times1 = min(currN + 1, numOps, currNumber, n);
        int times2 = min(currN + 1, numOps + 1, currNumber + (int)Math.pow(2, currN), n);
        int times3 = min(currN + 1, numOps + 1, currNumber - (int)Math.pow(2, currN), n);
        return Math.min(Math.min(times1, times2), times3);
    }

}
