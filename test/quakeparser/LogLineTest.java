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
public class LogLineTest {

    public LogLineTest() {
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
     * Test of equals method, of class LogLine.
     */
    @Test
    public void testEqualsFullObject() {
        System.out.println("equals full object");

        Object obj = new LogLine(new Date(12, 12), Event.Item, "1", "2", "22");
        LogLine instance = new LogLine(new Date(12, 12), Event.Item, "1", "2", "22");

        boolean expResult = true;
        boolean result = instance.equals(obj);

        assertEquals(expResult, result);
    }

    /**
     * Test of hashCode method, of class LogLine.
     */
    @Test
    public void testHashCodeFullObject() {
        System.out.println("hashCode");

        Object obj = new LogLine(new Date(12, 12), Event.Item, "1", "2", "22");
        LogLine instance = new LogLine(new Date(12, 12), Event.Item, "1", "2", "22");

        int expResult = obj.hashCode();
        int result = instance.hashCode();

        assertEquals(expResult, result);
    }

}
