package ru.javawebinar.topjava;

import java.util.*;


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
        int[] arr = {1,2,3,4,5,6,7,8,10};
        int[] arr1 = {1,5,23,2,6,3,1,8,12,3};



        int[][] mm = {{1,1,1},{0,0,0}};
       // reverse(arr);
        System.out.println(Arrays.toString(arr));

        System.out.println(isStringPalindrome("mada"));
        System.out.println(reverseString(""));
        System.out.println(firstNonRepeatedCharacter("a"));
      //  System.out.println(singleNumber(arr));
        System.out.println(replace("gj", "XEP"));
        System.out.println(areAllCharactersUnique("Not Unique"));
                System.out.println(Arrays.toString(mm));
        System.out.println(binarySearch(arr1,9));
        System.out.println(duplicate(arr1));
        System.out.println(findMissingNumber(arr));



    }
    public static int findMissingNumber(int[] arr) {


        int result = 0;
        List<Integer>  list = new ArrayList<>(10);
        Set<Integer> arrSet = new HashSet<>();
        for(int i = 1;i < 11; i++){
            list.add(i);
        }

        for(int i  = 0; i < arr.length; i++){
            arrSet.add(arr[i]);

        }
        list.removeAll(arrSet);
        result = list.get(0);

        return result;
    }



    public static String duplicate(int[] numbers){
        if(numbers == null){
            return null;
        }
        int count = 0;

        Set<Integer> set  = new HashSet<>();

        for(int i = 0; i < numbers.length; i++) {
            for(int j = 0; j < numbers.length;j++){
                if(numbers[i]== numbers[j]){
                    count++;
                }

            }
            if(count > 1) {
                set.add(numbers[i]);
            }
                count = 0;
            }

        Integer [] array = set.toArray(new Integer[set.size()]);
        return Arrays.toString(array);
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

    public static Boolean binarySearch(int[] arr, int n){

        if (arr.length == 0) {
            return  false;
        }

        int low = 0;
        int high = arr.length - 1;

        while(high >= low) {
            int middle = (low + high) / 2;
            if(arr[middle] == n) {
                return true;
            }
            if(arr[middle] < n) {
                low = middle + 1;
            }
            if(arr[middle] > n) {
                high = middle - 1;
            }
        }
        return false;
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
        if( a.equals("")){
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







