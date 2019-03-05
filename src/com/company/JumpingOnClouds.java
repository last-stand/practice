package com.company;

public class JumpingOnClouds {
    /*
    System.out.println(JumpingOnClouds.jumpingOnClouds(new int[]{0, 0, 1, 0, 0, 1, 0})); //4
    System.out.println(JumpingOnClouds.jumpingOnClouds(new int[]{0, 0, 0, 1, 0, 0})); //3
    */
    static int jumpingOnClouds(int[] c) {
        int count = -1, s = c.length;
        for (int i = 0; i < s; i++, count++) {
            if (i < s-2 &&  c[i+2] == 0){
                i++;
            }
        }
        return count;
    }
}
