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
public class ClientBeginParserTest {

    public ClientBeginParserTest() {
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

    String clientBeginLine = "1:01 ClientBegin: 3";

    /**
     * Test of processLine method, of class ClientBeginParser.
     */
    @Test
    public void testProcessLine() {
        System.out.println("client begin line parser");

        ILine line = new LogLine(new Date(1, 1), Event.ClientBegin);
        line.setRawLine(clientBeginLine);

        ClientBeginParser instance = new ClientBeginParser();

        ILine expResult = new LogLine(new Date(1, 1), Event.ClientBegin, "3", "", "");
        ILine result = instance.processLine(line);

        assertEquals(expResult, result);
    }

}
