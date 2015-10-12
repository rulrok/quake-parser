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
    
    String killLine = "23:06 Kill: 1022 2 22: <world> killed Isgalamido by MOD_TRIGGER_HURT";
    

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

        

        ILine expResult = new LogLine(
                new Date(23, 06),
                Event.Kill,
                "1022",
                "2",
                "22"
        );

        ILine result = LineParser.parseLine(killLine);

        assertEquals(expResult, result);
    }
    
    @Test
    public void testSimpleLineParse(){
        System.out.println("simple line parser");
        
        ILine expResult = new LogLine(new Date(23,06), Event.Kill);
        ILine result = LineParser.basicParse(killLine);
        
        assertEquals(expResult, result);
        
    }

}
