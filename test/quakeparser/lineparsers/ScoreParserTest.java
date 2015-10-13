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
public class ScoreParserTest {

    public ScoreParserTest() {
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

    String scoreLine = "5:54 score: 7  ping: 6  client: 5 Assasinu Credi";

    /**
     * Test of processLine method, of class ScoreParser.
     */
    @Test
    public void testProcessLine() {
        System.out.println("score parser line");

        ILine line = new LogLine(new Date(5, 54), Event.score);
        line.setRawLine(scoreLine);

        ScoreParser instance = new ScoreParser();

        ILine expResult = new LogLine(new Date(5, 54), Event.score, "5", "7", "6");
        ILine result = instance.processLine(line);

        assertEquals(expResult, result);
    }

}
