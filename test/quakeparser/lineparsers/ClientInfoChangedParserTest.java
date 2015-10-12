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
public class ClientInfoChangedParserTest {

    public ClientInfoChangedParserTest() {
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

    String clientInfoChangedLine = "18:01 ClientUserinfoChanged: 3 n\\Isgalamido\\t\\0\\model\\uriel/zael\\hmodel\\uriel/zael\\g_redteam\\\\g_blueteam\\\\c1\\5\\c2\\5\\hc\\100\\w\\0\\l\\0\\tt\\0\\tl\\0";

    /**
     * Test of processLine method, of class ClientInfoChangedParser.
     */
    @Test
    public void testProcessLine() {
        System.out.println("client info changed line parser");

        ILine line = new LogLine(new Date(18, 1), Event.ClientUserinfoChanged);
        line.setRawLine(clientInfoChangedLine);

        ClientInfoChangedParser instance = new ClientInfoChangedParser();

        ILine expResult = new LogLine(new Date(18, 1), Event.ClientUserinfoChanged, "3", "", "Isgalamido");
        ILine result = instance.processLine(line);

        assertEquals(expResult, result);
    }

}
