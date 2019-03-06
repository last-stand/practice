package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DenseRanking {
    static int[] climbingTheLeaderboard(int[] scores, int[] alice) {
        int[] rankings = new int[alice.length];
        List<Integer> scoresList = Arrays.stream(scores).boxed().collect(Collectors.toList());
        TreeSet<Integer> leaderBoardSet = (TreeSet<Integer>) new TreeSet<>(scoresList).descendingSet();
        int leaderBoardSetSize = leaderBoardSet.size();

        for(int i = 0 ; i < alice.length; i++) {
            leaderBoardSet.add(alice[i]);
            int ranking = leaderBoardSet.headSet(alice[i]).size();
            rankings[i] = ranking + 1;
            if (leaderBoardSet.size() > leaderBoardSetSize)
                leaderBoardSet.remove(alice[i]);
        }
        return rankings;
    }

    // Optimized
    static int[] climbingLeaderboard(int[] scores, int[] alice) {
        int[] rankings = new int[alice.length];
        scores = IntStream.of(scores).distinct().sorted().toArray();
        alice = IntStream.of(alice).sorted().toArray();

        for (int i = 0; i < alice.length; i++) {
           int index = Arrays.binarySearch(scores, alice[i]);
           if(index < 0) {
               rankings[i] = scores.length - Math.abs(index)+2;
           }
           else{
               rankings[i] = scores.length - index;
           }
        }
        return rankings;
    }
}

/*
        int[] scores1 = {100, 100, 50, 40, 40, 20, 10};
        int[] alice1 = {5, 25, 50, 120};
        int[] ranks1 = DenseRanking.climbingLeaderboard(scores1, alice1); // 6, 4, 2, 1
        System.out.println(Arrays.toString(ranks1));

        int[] scores2 = {100, 90, 90, 80, 75, 60};
        int[] alice2 = {50, 65, 77, 90, 102};
        int[] ranks2 = DenseRanking.climbingLeaderboard(scores2, alice2); // 6, 5, 4, 2, 1
        System.out.println(Arrays.toString(ranks2));
    */

