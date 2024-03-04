package com.mycompany.app;

import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {


        ArrayList<Integer> arr = new ArrayList<>();
        fillArrayList(arr);
        search(arr, 5);
        System.out.println( "Hello World!" );
    }
    public static boolean search(ArrayList<Integer> array, int e) {
        System.out.println("inside search");
        if (array == null) return false;

        for (int elt : array) {
            if (elt == e) return true;
        }
        return false;
    }
    public static void fillArrayList(ArrayList<Integer> array){
        for (int i = 0; i < array.size(); i++) {
            array.add(i);
        }
    }




}
