/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quakeparser;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import quakeparser.contracts.IDate;

/**
 *
 * @author rulrok
 */
public class DateTest {

    public DateTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of hours method, of class Date.
     */
    @Test
    public void testHours() {
        System.out.println("hours");
        Date instance = new Date(12, 12);

        int expResult = 12;
        int result = instance.hours();

        assertEquals(expResult, result);
    }

    /**
     * Test of minutes method, of class Date.
     */
    @Test
    public void testMinutes() {
        System.out.println("minutes");
        Date instance = new Date(14, 12);

        int expResult = 12;
        int result = instance.minutes();
        assertEquals(expResult, result);

    }

    /**
     * Test of after method, of class Date.
     */
    @Test
    public void testAfter() {
        System.out.println("after");
        IDate before = new Date(12, 0);
        Date after = new Date(12, 1);

        boolean expResult = true;
        boolean result = after.after(before);

        assertEquals(expResult, result);
    }

    /**
     * Test of before method, of class Date.
     */
    @Test
    public void testBefore() {
        System.out.println("before");
        IDate before = new Date(15, 15);
        Date after = new Date(15, 26);

        boolean expResult = true;
        boolean result = before.before(after);

        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Date.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");

        Object obj = new Date(12, 12);
        Date instance = new Date(12, 12);

        boolean expResult = true;
        boolean result = instance.equals(obj);

        assertEquals(expResult, result);

    }

    @Test
    public void testNotEquals() {
        System.out.println("not equals");

        Object obj = new Date(12, 11);
        Date instance = new Date(12, 12);

        boolean expResult = false;
        boolean result = instance.equals(obj);

        assertEquals(expResult, result);
    }

    /**
     * Test of hashCode method, of class Date.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");

        IDate other = new Date(12, 13);
        Date instance = new Date(12, 13);

        int expResult = other.hashCode();
        int result = instance.hashCode();

        assertEquals(expResult, result);
    }

}
