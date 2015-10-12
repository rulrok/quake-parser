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
public class ClientDisconnectParserTest {

    public ClientDisconnectParserTest() {
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

    String clientDisconnectLine = "13:27 ClientDisconnect: 4";

    /**
     * Test of processLine method, of class ClientDisconnectParser.
     */
    @Test
    public void testProcessLine() {
        System.out.println("client disconnect line parser");

        ILine line = new LogLine(new Date(13, 27), Event.ClientDisconnect);
        line.setRawLine(clientDisconnectLine);

        ClientDisconnectParser instance = new ClientDisconnectParser();

        ILine expResult = new LogLine(new Date(13, 27), Event.ClientDisconnect, "4", "", "");
        ILine result = instance.processLine(line);

        assertEquals(expResult, result);
    }

}
