package com.company;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class RansomNote {
    /*
        String[] m1 = {"give", "me", "one", "grand", "today", "night"};
        String[] n1 = {"give", "one", "grand", "today"};
        String[] m2 = {"ive", "got", "a", "lovely", "bunch", "of", "coconuts"};
        String[] n2 = {"ive", "got", "some", "coconuts"};
        RansomNote.checkMagazine(m1, n1); // Yes
        RansomNote.checkMagazine(m2, n2); // No
     */
    static void checkMagazine(String[] magazine, String[] note) {
        HashMap<String, Integer> magazineMap = new LinkedHashMap<>();
        HashMap<String, Integer> noteMap = new LinkedHashMap<>();
        for (int i = 0; i < magazine.length; i++) {
            Integer wordCount = magazineMap.get(magazine[i]);
            if (wordCount == null) {
                magazineMap.put(magazine[i], 1);
            }
            else {
                magazineMap.put(magazine[i], ++wordCount);
            }
        }

        for (int i = 0; i < note.length; i++) {
            Integer wordCount = noteMap.get(note[i]);
            if (wordCount == null) {
                noteMap.put(note[i], 1);
            }
            else {
                noteMap.put(note[i], ++wordCount);
            }
        }

        boolean isNotValid = noteMap.entrySet().stream()
                .map(e -> magazineMap.getOrDefault(e.getKey(), 0) - e.getValue())
                .filter(e -> e < 0)
                .findFirst().isPresent();

        if (!isNotValid)
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
