package org.hunter;

public class Interceptors {

    /**
     * how many interceptors do you need to fire to shoot down a missile
     * with certaintyPercent chance if each missile has succesPercent change of
     * intercepting
     * @param args
     */
    public static void main(String [] args) {
        Interceptors interceptors = new Interceptors();
        System.out.println(interceptors.interceptors(.99, .50));
        System.out.println(interceptors.interceptors(.99, .30));
        System.out.println(interceptors.interceptors(.99, .20));
    }

    public int interceptors(double certaintyPercent, double successPercent) {
        int left = 1;
        int right = 1000;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(canIntercept(mid, successPercent, certaintyPercent)) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }

    boolean canIntercept(int number, double successPercent, double certaintyPercent) {
        double failurePercent = 1 - successPercent;
        return 1 - Math.pow(failurePercent, number) >= certaintyPercent;
    }

}
