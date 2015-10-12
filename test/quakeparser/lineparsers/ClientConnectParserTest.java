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
public class ClientConnectParserTest {

    public ClientConnectParserTest() {
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

    String clientConnectLine = "21:15 ClientConnect: 2";

    /**
     * Test of processLine method, of class ClientConnectParser.
     */
    @Test
    public void testProcessLine() {
        System.out.println("client connect line parser");

        ILine line = new LogLine(new Date(21, 15), Event.ClientConnect);
        line.setRawLine(clientConnectLine);

        ClientConnectParser instance = new ClientConnectParser();

        ILine expResult = new LogLine(new Date(21, 15), Event.ClientConnect, "2", "", "");
        ILine result = instance.processLine(line);

        assertEquals(expResult, result);
    }

}
