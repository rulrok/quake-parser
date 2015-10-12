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
public class ExitParserTest {

    public ExitParserTest() {
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

    String exitLine = "27:14 Exit: Timelimit hit.";

    /**
     * Test of processLine method, of class ExitParser.
     */
    @Test
    public void testProcessLine() {
        System.out.println("exit line parser");

        ILine line = new LogLine(new Date(27, 14), Event.Exit);
        line.setRawLine(exitLine);

        ExitParser instance = new ExitParser();

        ILine expResult = new LogLine(new Date(27, 14), Event.Exit, "Timelimit hit.", "", "");
        ILine result = instance.processLine(line);

        assertEquals(expResult, result);
    }

}
