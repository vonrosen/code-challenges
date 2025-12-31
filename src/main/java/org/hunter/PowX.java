package org.hunter;

public class PowX {

    /**
     * key insight: 2^4 = 2^2 * 2^2
     * @param args
     */
    public static void main(String [] args) {
        PowX p = new PowX();
        System.out.println(p.myPow(2.00000, 10));
    }

    public double myPow(double x, int n) {
        return myPow(x, Math.abs(n), n);
    }

    public double myPow(double x, int n, int nOrig) {
        if(n == 0) {
            return 1;
        }
        if(n == 1) {
            if(nOrig < 0) {
                return 1 / x;
            }
            return x;
        }
        if(n % 2 == 0) {
            double value = myPow(x, n / 2, nOrig);
            return value * value;
        }
        double value = myPow(x, n / 2, nOrig);
        return value * value * (x < 0 ? 1 / x : x);
    }

    public double myPow2(double x, int n) {
        double origX = x;
        for(int i = 0; i < Math.abs(n) - 1; ++i) {
            x *= origX;
        }
        if(n < 0) {
            return 1 / x;
        }
        return x;
    }

}
