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
public class KillParserTest {

    public KillParserTest() {
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

    String killLine = "23:06 Kill: 1022 2 22: <world> killed Isgalamido by MOD_TRIGGER_HURT";

    /**
     * Test of processLine method, of class KillParser.
     */
    @Test
    public void testProcessLine() {
        System.out.println("processLine");

        ILine line = new LogLine(new Date(23, 06), Event.Kill);
        line.setRawLine(killLine);

        KillParser instance = new KillParser();

        ILine expResult = new LogLine(new Date(23, 06), Event.Kill, "1022", "2", "22");
        ILine result = instance.processLine(line);
        
        assertEquals(expResult, result);
    }

}
