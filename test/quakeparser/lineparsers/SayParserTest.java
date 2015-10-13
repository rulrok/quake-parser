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
public class SayParserTest {

    public SayParserTest() {
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

    String sayLine = "981:21 say: Oootsimo: team red";

    /**
     * Test of processLine method, of class SayParser.
     */
    @Test
    public void testProcessLine() {
        System.out.println("say line parser");

        ILine line = new LogLine(new Date(981, 21), Event.say);
        line.setRawLine(sayLine);

        SayParser instance = new SayParser();

        ILine expResult = new LogLine(new Date(981, 21), Event.say, "Oootsimo", "", "team red");
        ILine result = instance.processLine(line);

        assertEquals(expResult, result);
    }

}
