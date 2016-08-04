package ru.javawebinar.topjava;

import java.util.Arrays;

/**
 * User: gkislin
 * Date: 05.08.2015
 *
 * @link http://caloriesmng.herokuapp.com/
 * @link https://github.com/JavaOPs/topjava
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(areAllCharactersUnique("mamxiok"));
        int[] arr = {9,8,7,6,5,4,3,2,1};
        reverse(arr);
        System.out.println(Arrays.toString(arr));



    }

    public static int[] reverse(int[] arr){
        int k = arr.length / 2;
        int m = arr.length;
        for(int i = 0; i < k; i++){
            int tmp = arr[i];
            arr[i] = arr[m-1-i];
            arr[m-1-i] = tmp;
        }
        return arr;
    }


    public static boolean areAllCharactersUnique(String str) {
        if (str.equals("") || str == (String) null) {

            return true;
        }

        int count = 0;
        for (char c : str.toCharArray()) {
            if (str.indexOf(c) == str.lastIndexOf(c)) {
                count++;
            }
        }
        System.out.println(count);
        System.out.println(str.length());
        if (count == str.length()) {
            return true;
        } else {
            return false;
        }

    }





    }







