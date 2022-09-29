package com.backend.QuizUp_Backend.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MathUtil {

    // Function to generate a list of, m random non-negative integers, whose sum is n
    public static List<Integer> getRandomPercentage(Integer m, Integer n){
        // Create an array of size m where every element is initialized to 0
        int[] arr = new int[m];
        List<Integer> integers = new ArrayList<>();

        // To make the sum of the final list as n
        for (int i = 0; i < n; i++) {
            // Increment any random element from the array by 1
            arr[(int)(Math.random() * m)]++;
        }
        Arrays.stream(arr).forEach(integers::add);
        return integers;
    }
}
