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
        int[] arr = {9,8,9,6,4,4,6,7,7};
        reverse(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(isStringPalindrome("mada"));
        System.out.println(reverseString(""));
        System.out.println(firstNonRepeatedCharacter("a"));
        System.out.println(singleNumber(arr));
        System.out.println(replace("gj", "XEP"));
        System.out.println(areAllCharactersUnique("Not Unique"));



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

        if (str == null) {
            return true;
        }

        for (char c : str.toCharArray()) {
            if (str.indexOf(c) != str.lastIndexOf(c)) {
                return false;
            }
        }

        return true;
    }

    public static String replace(String a, String b) {
        if( a.equals("" )){
            return new String("");
        }
                if(b == null || b.equals("")){
            return a;
        }

        char [] arr = a.toCharArray();
        char space = ' ';
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr.length;i++) {
            if (arr[i] == space) {

                sb.append(b);
            } else {
                sb.append(arr[i]);
            }
        }


        String str = new String(sb);

        return  str;

    }

    public static int singleNumber(int[] A) {

        int result = 0;

     StringBuilder sb = new StringBuilder();
        for(Integer n : A){
            sb.append(n);
        }

        String str = new String(sb);
        System.out.println(sb);

        for (char c : str.toCharArray()) {
            if (str.indexOf(c) == str.lastIndexOf(c)) {
                result = Character.getNumericValue(c);


            }



        }
        return result;

    }

    public static Character firstNonRepeatedCharacter(String str) {
        Character result = null;
        if(str == null || str.equals("")){
            result = null;
        }


        for(char c : str.toCharArray()){
            if( str.indexOf(c) ==  str.lastIndexOf(c)) {
                result = c;



            }

            break;



    }
        return result;





}


    public static String reverseString(String str){
        String outputString = null;


        if(str == null ){
            return null;
        }

        if (str.isEmpty()){
            outputString = "";
        }
        else {

            String inputString = str;
            char[] arr = str.toCharArray();
            char[] result = new char[arr.length];

            for (int i = 0; i < arr.length; i++) {
                result[i] = arr[arr.length - i - 1];
            }

             outputString = String.valueOf(result);
        }



        return outputString;
    }

    public static boolean isStringPalindrome(String str){

        if(str == null || str.equals("")){
            return true;
        }

        else
        {
            char [] arr = str.toCharArray();
            char [] result = new char [arr.length];

            for(int i = 0; i< arr.length; i++){
                result[i] = arr[arr.length-i-1];
            }

            String s = String.valueOf(result);
            if(str.equals(s)){
                return true;
            }
            else {
                return false;
            }


        }


    }





    }







