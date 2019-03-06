package com.company;

public class SaveThePrisoner {

    public static int saveThePrisoner(int prisoners, int sweets, int start){
        int position = (sweets + start)-1;
        if(position > prisoners) {
            if(position % prisoners == 0)
                return prisoners;
            return position % prisoners;
        }
        return position;
    }
}

 /*
        System.out.println(SaveThePrisoner.saveThePrisoner(4, 6, 2)); //3
        System.out.println(SaveThePrisoner.saveThePrisoner(5, 2, 1)); //2
        System.out.println(SaveThePrisoner.saveThePrisoner(5, 2, 2)); //3
        System.out.println(SaveThePrisoner.saveThePrisoner(7, 19, 2)); //6
        System.out.println(SaveThePrisoner.saveThePrisoner(3, 7, 3)); //3
    */
