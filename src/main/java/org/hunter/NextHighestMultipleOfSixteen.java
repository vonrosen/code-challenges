package org.hunter;

public class NextHighestMultipleOfSixteen {

    public static void main(String [] args) {
        NextHighestMultipleOfSixteen n = new NextHighestMultipleOfSixteen();
        System.out.println(n.nextHighest(1));
        System.out.println(n.nextHighest(16));
        System.out.println(n.nextHighest(17));
        System.out.println(n.nextHighest(31));
        System.out.println(n.nextHighest(65));
    }

    public int nextHighest(int n) {
        if (n < 16) {
            return 16;
        }

        if (n % 16 == 0) {
            return n;
        }

        int rem = n % 16;
        return n + 16 - rem;
    }

}
