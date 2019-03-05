package com.company;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DesignerPdfViewer {

    /*
        int[] charHeights1 = {1, 3, 1, 3, 1, 4, 1, 3, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5};
        System.out.println(DesignerPdfViewer.designerPdfViewer(charHeights1, "abc")); //9

        int[] charHeights2 = {1, 3, 1, 3, 1, 4, 1, 3, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 7};
        System.out.println(DesignerPdfViewer.designerPdfViewer(charHeights2, "zaba")); //28
    */

    private static int getCharAlphabetPosition(char letter) {
        return Character.toUpperCase(letter) - 64;
    }

    public static int designerPdfViewer2(int[] charHeights, String word) {
        int maxHeight = 0;
        int index;
        for (int i = 0; i < word.length(); i++) {
            index = getCharAlphabetPosition(word.charAt(i)) - 1;
            maxHeight = Math.max(maxHeight, charHeights[index]);
        }
        return maxHeight * word.length();
    }

    //Optimized
    public static int designerPdfViewer(int[] charHeights, String word) {
        int maxHeight = 0;
        int index;
        for (int i = 0; i < word.length(); i++) {
            index = (int) word.charAt(i) - 97;
            maxHeight = Math.max(maxHeight, charHeights[index]);
        }
        return maxHeight * word.length();
    }


}
