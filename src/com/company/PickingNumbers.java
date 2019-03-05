package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PickingNumbers {
    public static int pickingNumbers(List<Integer> a) {
        Collections.sort(a);
        List<Integer> counterList = new ArrayList<>();
        for (int i = 0; i < a.size()-1; i++) {
            int count  = 1;
            for (int j = i+1; j < a.size(); j++) {
                if (Math.abs(a.get(i) - a.get(j)) <= 1) {
                    ++count;
                }
            }
            counterList.add(count);
        }
        return Collections.max(counterList);
    }
}

// Input:
// List<Integer> intArr = Arrays.asList(4, 6, 5, 3, 3, 1);
// System.out.println(PickingNumbers.pickingNumbers(intArr));
// Output: 3
