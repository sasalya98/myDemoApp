package com.mycompany.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.ArrayList;
import java.util.Arrays;

import junit.framework.TestCase;


/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
    
    public void testMedianTrue(){
    	ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        assertTrue(new App().search(array, 0, 2.5,1, array2));
    }
    
    public void testMedianFalse(){
    	ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        assertFalse(new App().search(array, 0, 2.6,1, array2));
    }
    
    public void testMeanTrue(){
    	ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        assertTrue(new App().search(array, 0, 2.5,2, array2));
    }
    
    public void testMeanFalse(){
    	ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        assertFalse(new App().search(array, 0, 2.6,2, array2));
    }
    
    public void testPalindromeNumberTrue(){
    	ArrayList<Integer> array = new ArrayList<>(Arrays.asList(111, 222, 333, 444));
        ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(111, 222, 333, 444));
        assertTrue(new App().search(array, 4, 2.5,3, array2));
    }
    
    public void testPalindromeNumberFalse(){
    	ArrayList<Integer> array = new ArrayList<>(Arrays.asList(111, 222, 333, 444));
        ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(111, 222, 333, 444));
        assertFalse(new App().search(array, 0, 2.5,3, array2));
    }
		
    /*public void testFound() {
        ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        assertTrue(new App().search(array, 4, 2.0,-1, array2));
    }

    public void testNotFound() {
        ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        assertFalse(new App().search(array, 5, 2.0, -1, array2));
    }

    public void testEmptyArray() {
        ArrayList<Integer> array = new ArrayList<>();
        ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        assertFalse(new App().search(array, 1, 2.0, -1, array2));
    }

    public void testNull() {
        assertFalse(new App().search(null, 1, 2.0, -1, null));
    }*/
}
