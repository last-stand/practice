package com.company;


import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class StringProblems {
    /*
    System.out.println(StringProblems.repeatedString("aba", 10)); //7
    System.out.println(StringProblems.repeatedString("a", 1000000000000L)); //1000000000000
    System.out.println(StringProblems.repeatedString("ababa", 3)); //2
    */
    static long repeatedString(String s, long n) {
        int l = s.length();
        long repeat = n/l;
        long remained = repeat > 0 ? (n % repeat) : n;
        long count = 0;
        for (int i = 0 ; i < l ; i++) {
            if (s.charAt(i) == 'a') {
                count++;
            }
        }
        count *= repeat;
        for (int i = 0 ; i < remained ; i++) {
            if (s.charAt(i) == 'a') {
                count++;
            }
        }
        return count;
    }

    static String twoStrings(String s1, String s2) {
        HashSet<Character> setS1 = new HashSet();
        String answer = "NO";
        for (int i = 0; i < s1.length() ; i++) {
            setS1.add(s1.charAt(i));
        }
        for (int i = 0; i < s2.length(); i++) {
            if (setS1.contains(s2.charAt(i)))
                answer = "YES";
        }
        return answer;
    }

    /*
        System.out.println(StringProblems.sherlockAndAnagrams("ifailuhkqq")); //3
        System.out.println(StringProblems.sherlockAndAnagrams("abcd")); //0
        System.out.println(StringProblems.sherlockAndAnagrams("kkkk")); //10
        System.out.println(StringProblems.sherlockAndAnagrams("cdcd")); //5
    */
    static int sherlockAndAnagrams(String s) {
        int count = 0;
        HashMap<String, Integer> substrMap = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1 ; j <= s.length(); j++) {
                char[] strChars = s.substring(i, j).toCharArray();
                Arrays.sort(strChars);
                String sorted = new String(strChars);
                if(substrMap.containsKey(sorted)){
                    Integer value = substrMap.get(sorted);
                    count = count + value;
                    substrMap.put(sorted, ++value);
                }
                else {
                    substrMap.put(sorted, 1);
                }
            }
        }
        return count;
    }

}
