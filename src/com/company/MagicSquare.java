package com.company;

public class MagicSquare {
    public static int formingMagicSquare(int[][] s) {
        int[][][] possibleMagicSquares = {
                {{8, 1, 6}, {3, 5, 7}, {4, 9, 2}},
                {{6, 1, 8}, {7, 5, 3}, {2, 9, 4}},
                {{4, 9, 2}, {3, 5, 7}, {8, 1, 6}},
                {{2, 9, 4}, {7, 5, 3}, {6, 1, 8}},
                {{8, 3, 4}, {1, 5, 9}, {6, 7, 2}},
                {{4, 3, 8}, {9, 5, 1}, {2, 7, 6}},
                {{6, 7, 2}, {1, 5, 9}, {8, 3, 4}},
                {{2, 7, 6}, {9, 5, 1}, {4, 3, 8}},
        };
        int minimumCost = Integer.MAX_VALUE;
        for (int x = 0; x < possibleMagicSquares.length; x++) {
            int cost = 0;
            for (int i = 0; i < s.length; i++) {
                for (int j = 0; j < s.length; j++) {
                    cost += Math.abs(possibleMagicSquares[x][i][j] - s[i][j]);
                }
            }
            minimumCost = Math.min(minimumCost, cost);
        }
        return minimumCost;
    }
}


//  Input:
//    int[][] magicArray = {{5, 3, 4},
//                          {1, 5, 8},
//                          {6, 4, 2}};
//    System.out.println(MagicSquare.formingMagicSquare(magicArray));
// Output: 7
