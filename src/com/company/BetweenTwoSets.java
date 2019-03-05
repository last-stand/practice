package com.company;

public class BetweenTwoSets {
    private static int euclidGcd(int a, int b) {
        while (b > 0)
        {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private static int lcm(int a, int b)
    {
        return a * (b / euclidGcd(a, b));
    }

    private static int arrayLCM(int[] array) {
        int lcm = array[0];
        for (int i = 1; i < array.length; i++) {
            lcm = lcm(array[i], lcm);
        }
        return lcm;
    }

    private static int arrayGCD(int[] array) {
        int gcd = array[0];
        for (int i = 1; i < array.length; i++) {
            gcd = euclidGcd(array[i], gcd);
        }
        return gcd;
    }

    public static int getTotalX(int[] a, int[] b) {
        int count = 0;
        int lcm = arrayLCM(a);
        int gcd = arrayGCD(b);

        System.out.println("LCM " + lcm);
        System.out.println("GCD " + gcd);
        for (int i = lcm, j = 2; i <= gcd; i=lcm*j, j++) {
            if(gcd%i == 0) {
                ++count;
                System.out.println("Intger " +i);
            }
        }
        return count;
    }

}

// Possible input
//    int[] a = {2, 4};
//    int[] b = {16, 32, 96};
//     System.out.println(BetweenTwoSets.getTotalX(a, b)); //3
//
//    int[] c = {2, 3, 6};
//    int[] d = {42, 84};
//    System.out.println(BetweenTwoSets.getTotalX(c, d)); //2
