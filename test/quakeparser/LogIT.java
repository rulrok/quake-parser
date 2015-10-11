/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quakeparser;

import java.io.File;
import java.io.FileNotFoundException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rulrok
 */
public class LogIT {

    public LogIT() {
    }

    Log minimalLog;

    private final String[] lines = {
        "0:00 ------------------------------------------------------------",
        "0:00 InitGame: \\sv_floodProtect\\1\\sv_maxPing\\0\\sv_minPing\\0\\sv_maxRate\\10000\\sv_minRate\\0\\sv_hostname\\Code Miner Server\\g_gametype\\0\\sv_privateClients\\2\\sv_maxclients\\16\\sv_allowDownload\\0\\dmflags\\0\\fraglimit\\20\\timelimit\\15\\g_maxGameClients\\0\\capturelimit\\8\\version\\ioq3 1.36 linux-x86_64 Apr 12 2009\\protocol\\68\\mapname\\q3dm17\\gamename\\baseq3\\g_needpass\\0",
        "15:00 Exit: Timelimit hit.",
        "20:34 ClientConnect: 2",
        "20:34 ClientUserinfoChanged: 2 n\\Isgalamido\\t\\0\\model\\xian/default\\hmodel\\xian/default\\g_redteam\\\\g_blueteam\\\\c1\\4\\c2\\5\\hc\\100\\w\\0\\l\\0\\tt\\0\\tl\\0",
        "20:37 ClientUserinfoChanged: 2 n\\Isgalamido\\t\\0\\model\\uriel/zael\\hmodel\\uriel/zael\\g_redteam\\\\g_blueteam\\\\c1\\5\\c2\\5\\hc\\100\\w\\0\\l\\0\\tt\\0\\tl\\0",
        "20:37 ClientBegin: 2",
        "20:37 ShutdownGame:",
        "20:37 ------------------------------------------------------------",
        "20:37 ------------------------------------------------------------",};

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        minimalLog = new Log(lines);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of iterator method, of class Log.
     */
    @Test
    public void testReadFromArray() {

        System.out.println("read from array");

        assertNotNull(minimalLog.iterator());

    }

    /**
     * Test of reading an existing file
     */
    @Test
    public void testReadFromFile() {
        System.out.println("read from file");

        File logFile = new File("src/games.log");

        Log log;
        try {
            log = new Log(logFile);

            assertNotNull(log.iterator());
        } catch (FileNotFoundException ex) {
            fail(ex.getMessage());
        }
    }

    @Test(expected = FileNotFoundException.class)
    public void testFailReadFromFile() throws FileNotFoundException {
        System.out.println("must fail read from file");

        File logFile = new File("another/path/games.log");

        Log log = new Log(logFile);
    }

}
