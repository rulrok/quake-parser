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
import quakeparser.contracts.ILine;

/**
 *
 * @author rulrok
 */
public class LineParserTest {

    public LineParserTest() {
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
     * Test of parseLine method, of class LineParser using a kill log line.
     */
    @Test
    public void testParseKillLine() {
        System.out.println("parse kill line");

        String line = "23:06 Kill: 1022 2 22: <world> killed Isgalamido by MOD_TRIGGER_HURT";

        ILine expResult = new LogLine(
                new Date(23, 06),
                Event.Kill,
                "1022",
                "2",
                "22"
        );

        ILine result = LineParser.parseLine(line);

        assertEquals(expResult, result);
    }

}
