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
public class ShutdownGameParserTest {

    public ShutdownGameParserTest() {
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

    String shutDownLine = "21:52 ShutdownGame:";

    /**
     * Test of processLine method, of class ShutdownGameParser.
     */
    @Test
    public void testProcessLine() {
        System.out.println("shutdown game line parser");

        ILine line = new LogLine(new Date(21, 52), Event.ShutdownGame);
        line.setRawLine(shutDownLine);

        ShutdownGameParser instance = new ShutdownGameParser();

        ILine expResult = new LogLine(new Date(21, 52), Event.ShutdownGame, "", "", "");
        ILine result = instance.processLine(line);

        assertEquals(expResult, result);
    }

}
