package com.company;

public class ViralAdvertising {

    public static int viralAdvertising(int n) {
        int shared = 5, liked, cumulative = 0;
        for (int i = 1; i <= n; i++) {
            liked = (int) Math.floor(shared/2);
            shared = 3 * liked;
            cumulative += liked;
        }
        return cumulative;
    }
}

/*
    ViralAdvertising.viralAdvertising(5); //24
    ViralAdvertising.viralAdvertising(3); //9
*/
