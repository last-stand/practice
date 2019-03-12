package com.company;

public class MiscellaneousProblems {
    //371 = 3^3 + 7^3 + 1^3
    static String isArmstrongNumber(int number) {
        int temp = number;
        int sum = 0;
        while(temp > 0) {
            int digit = temp%10;
            sum += Math.pow(digit, 3);
            temp = temp/10;
        }
        if(sum == number) {
            return "Yes";
        }
        return "No";
    }
}
