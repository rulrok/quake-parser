/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quakeparser.lineparsers;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import quakeparser.Date;
import quakeparser.Event;
import quakeparser.LogLine;
import quakeparser.contracts.ILine;

/**
 *
 * @author rulrok
 */
public class ItemParserTest {

    public ItemParserTest() {
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

    String itemLine = "20:42 Item: 2 item_armor_body";

    /**
     * Test of processLine method, of class ItemParser.
     */
    @Test
    public void testProcessLine() {
        System.out.println("parse item line");

        ILine line = new LogLine(new Date(20, 42), Event.Item);
        line.setRawLine(itemLine);

        ItemParser instance = new ItemParser();

        ILine expResult = new LogLine(new Date(20, 42), Event.Item, "2", "", "item_armor_body");
        ILine result = instance.processLine(line);

        assertEquals(expResult, result);
    }

}
