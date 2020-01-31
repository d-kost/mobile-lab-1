package com.company;

import java.util.Arrays;

public class Main {

    public static int[] mergeArrays(int[] a1, int[] a2) {
        int sumLength = a1.length + a2.length;
        int [] result = new int [sumLength];

        int flag1 = 0, flag2 = 0;

        for (int i = 0; i < sumLength; i++) {

            if (flag2 >= a2.length){
                result[i] = a1[flag1];
                flag1 ++;
                continue;
            }

            if (flag1 >= a1.length){
                result[i] = a2[flag2];
                flag2 ++;
                continue;
            }

            if (a1[flag1] >= a2[flag2]){
                result[i] = a2[flag2];
                flag2 ++;
            } else {
                result[i] = a1[flag1];
                flag1 ++;
            }
        }
        return result;
    }

    public static long mortalFibonacciRabbits(int month, int live) {

        long [] years = new long[live+1];
        years[0] = 1;

        for (int i = 1; i < month; i++) {
            long tmp = years[0];
            years[0] = 0;

            for (int j = live; j >= 1; j--) {
                years[0] += j == live ? 0 : years[j];
                years[j] = years[j-1];
            }

            years[1] = tmp;
        }

        long result = Arrays.stream(years).sum();
        return result-years[years.length-1];

    }

    public static long rabbits(int k, int m) {

        long child = 1;
        long adult = 0;

        for (int i = 1; i < m; i++) {
            long tmp = child;
            child = adult*k;
            adult += tmp;
        }

        return child+adult;
    }

    public static void main(String[] args) {

        System.out.println("rabbits: " + rabbits(5, 32));

        System.out.println("mortal rabbits: " + mortalFibonacciRabbits(85, 19));

        int [] a = {0,1,2,2,3};
        int [] b = {1,3,3,4,6,8};
        System.out.println("merge arrays: " + Arrays.toString(mergeArrays(a, b)));

    }
}

