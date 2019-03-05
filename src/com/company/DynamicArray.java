package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DynamicArray {
    /*
     List<List<Integer>> queries = new ArrayList() {
            {
                add(Arrays.asList(1, 0, 5));
                add(Arrays.asList(1, 1, 7));
                add(Arrays.asList(1, 0, 3));
                add(Arrays.asList(2, 1, 0));
                add(Arrays.asList(2, 1, 1));
            }
        };
        System.out.println(DynamicArray.dynamicArray(2, queries));

        Output:  7  3
    */
    static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        List<Integer> answerList = new ArrayList<>();
        List<List<Integer>> seqList = new ArrayList<>();
        int lastAnswer = 0;
        for (int i = 0; i < n; i++) {
            seqList.add(new ArrayList<>());
        }

        for (int i = 0; i < queries.size(); i++) {
            List<Integer> query = queries.get(i);
            int seqIndex = (query.get(1) ^ lastAnswer) % n;
            List<Integer> sequence = seqList.get(seqIndex);
            if (query.get(0) == 1) {
                sequence.add(query.get(2));
            }
            else {
                int answer = sequence.get(query.get(2)%sequence.size());
                if (answer != 0) {
                    lastAnswer = answer;
                    answerList.add(lastAnswer);
                }
            }
        }
        System.out.println(answerList.size());
        return answerList;
    }

    // For 1000 1000
    static List<List<Integer>> getQueriesFromFile(String file) {
        List<List<Integer>> queries = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line=br.readLine()) != null) {
                String[] query = line.trim().split("\\s+");
                queries.add(Arrays.asList(
                        Integer.parseInt(query[0]),
                        Integer.parseInt(query[1]),
                        Integer.parseInt(query[2])
                        )
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return queries;
    }

    static List<Integer> getBinaryNumber(int num) {
        List<Integer> binary = new ArrayList();
        for(int i = num; i > 0; i /= 2){
            binary.add(i%2);
        }
        Collections.reverse(binary);
        return binary;
    }
}
