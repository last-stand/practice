package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayProblems {

    /*
    Input:
    reverseArray(new int[] {2, 9, 3, 6, 1})
    */
    static int[] reverseArray(int[] a) {
        int n = a.length;
        int[] reverseArr = new int[n];
        for(int i= 0; i < n; ++i){
            reverseArr[i] = a[n-i-1];
        }
        return reverseArr;
    }

    /*
    * Input:
       -9 -9 -9  1 1 1
        0 -9  0  4 3 2
       -9 -9 -9  1 2 3
        0  0  8  6 6 0
        0  0  0 -2 0 0
        0  0  1  2 4 0

        int intArr[][] = {{-9, -9, -9, 1, 1, 1},
                          {0, -9, 0, 4, 3, 2},
                          {-9, -9, -9, 1, 2, 3},
                          {0, 0, 8, 6, 6, 0},
                          {0, 0, 0, -2, 0, 0},
                          {0, 0, 1, 2, 4, 0}};
        Output: 28
    */
    static int hourglassSum(int[][] arr) {
        int n = 6;
        int maxCount =  Integer.MIN_VALUE;
        for (int i = 0; i <= n-3; i++) {
            int count = 0;
            for (int j = 0; j <= n-3; j++) {
                int topCount = arr[i][j] + arr[i][j+1] + arr[i][j+2];
                int midCount =  arr[i+1][j+1];
                int bottomCount = arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2];
                System.out.println(topCount +", " + midCount +", "+ bottomCount);
                count = topCount + midCount + bottomCount;
                maxCount = Math.max(maxCount, count);
            }
        }

        return maxCount;
    }


    // rotateLeft(new int[]{1, 2, 3, 4, 5}, 2); // 3, 4, 5, 1, 2
    // rotateLeft(new int[]{1, 2, 3, 4, 5}, 4); // 5, 1, 2, 3, 4
    static int[] rotateLeft(int[] arr, int d){
        int size = arr.length;
        int[] rotatedArray = new int[size];
        for (int i = 0; i < size; i++) {
            int index = (i + size - d) % size;
            rotatedArray[index] = arr[i];
        }
        return rotatedArray;
    }


//    int[] arr = ArrayProblems.matchingStrings(
//            new String[]{"aba", "baba", "aba", "xzxb"},
//            new String[]{"aba", "xzxb", "ab"});
//    Output: 2 1 0
    static int[] matchingStrings(String[] strings, String[] queries){
        int[] results = new int[0];
        for (int i = 0; i < queries.length; i++) {
            int count = 0;
            for (int j = 0; j < strings.length; j++) {
                if (queries[i].equals(strings[j])){
                    ++count;

                }
            }
            results = Arrays.copyOf(results, results.length + 1);
            results[results.length-1] = count;
        }
        return results;
    }

//    int[][] queries1 = {
//            {1, 2, 100},
//            {2, 5, 100},
//            {3, 4, 100}
//    };
//    arrayManipulation(5, queries1);
//    Output: 200
//
//    int[][] queries2 = {
//                {2, 6, 8},
//                {3, 5, 7},
//                {1, 8, 1},
//                {5, 9, 15}
//    };
//    arrayManipulation(10, queries2);
//    Output: 31
    static long arrayManipulation(int n, int[][] queries) {

        long[] arr = new long[n];
        long max = 0;
        int m = queries.length;

        for (int i=0; i < m; i++){
            int a = queries[i][0]-1;
            int b = queries[i][1];
            int k = queries[i][2];
            arr[a] += k;
            if(b < n)
                arr[b] -= k;
        }
        for (int i = 1; i < n; i++){
            arr[i] += arr[i-1];
            if (arr[i] > max)
                max = arr[i];
        }

        return max;
    }


    /*
        ArrayProblems.minimumBribes(new int[]{2, 1, 5, 3, 4}); //3
        ArrayProblems.minimumBribes(new int[]{1, 2, 5, 3, 7, 8, 6, 4}); //7
        ArrayProblems.minimumBribes(new int[]{2, 5, 1, 3, 4}); //Too chaotic
    */
    static void minimumBribes(int[] q) {
        boolean isChaotic = false;
        int bribeCount = 0;
        for (int i = 0; i < q.length; i++) {
            if ((q[i] - (i+1)) > 2){
                isChaotic = true;
            }
        }
        if (isChaotic)
            System.out.println("Too chaotic");
        else {
            boolean hasMoreSwaps, sorted = false;;
            for (int i = 0; i < q.length - 1; i++) {
                if(!sorted) {
                    hasMoreSwaps = false;
                    for (int j = 0; j < q.length - i - 1; j++) {
                        if (q[j] > q[j + 1]) {
                            hasMoreSwaps = true;
                            int temp = q[j];
                            q[j] = q[j + 1];
                            q[j + 1] = temp;
                            ++bribeCount;
                        }
                    }
                    if (!hasMoreSwaps) {
                        sorted = true;
                    }
                }
            }
            System.out.println(bribeCount);
        }
    }


    /*
        ArrayProblems.minimumSwaps(new int[]{4, 3, 1, 2}); //3
        ArrayProblems.minimumSwaps(new int[]{2, 3, 4, 1, 5}); //3
        ArrayProblems.minimumSwaps(new int[]{7, 1, 3, 2, 4, 5, 6}); //5
        ArrayProblems.minimumSwaps(new int[]{1, 3, 5, 2, 4, 6, 7}); //3
    */
    static int minimumSwaps(int[] arr) {
        int swaps = 0;
        boolean[] visited = new boolean[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int j = i, cycles = 0;
                while (!visited[j]) {
                    visited[j] = true;
                    j = arr[j]-1;
                    ++cycles;
                }
                if(cycles > 0)
                    swaps += cycles-1;
        }
        return swaps;
    }

    static public int divisorSum(int n) {
        List<Integer> divisor = new ArrayList<>();
        int sum = 0;
        for(int i=1; i <= Math.sqrt(n); i++){
            if(n%i == 0){
                if(n/i != i) {
                    sum += n/i;
                    divisor.add(n/i);
                }
                sum += i;
                divisor.add(i);
            }
        }
        System.out.println(divisor);
        return sum;
    }

}
