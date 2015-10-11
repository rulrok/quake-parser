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

/**
 *
 * @author rulrok
 */
public class GameIT {

    public GameIT() {
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
     * Test of totalKills method, of class Game.
     */
    @Test
    public void testTotalKills() {
        System.out.println("totalKills init game");
        Game instance = new Game();

        int expResult = 0;
        int result = instance.totalKills();

        assertEquals(expResult, result);
    }

    /**
     * Test of player register method, of class Game.
     */
    @Test
    public void testRegisterPlayer() {
        System.out.println("players");

        Game game = new Game();

        game.registerPlayer(1, "Reuel Ribeiro");

        String[] expResult = {"Reuel Ribeiro"};
        String[] result = game.players();

        assertArrayEquals(expResult, result);
    }

    /**
     * Test for a new created object
     */
    @Test
    public void testPlayersNewGame() {
        System.out.println("players empty game");

        Game game = new Game();

        String[] expResult = {};
        String[] result = game.players();

        assertArrayEquals(expResult, result);

    }

    /**
     * Test of kills method, of class Game.
     */
    @Test
    public void testKills() {
        System.out.println("kills");

        Game game = new Game();
        game.registerPlayer(1, "Reuel Ribeiro");
        game.registerPlayer(2, "[BOT] Player");

        //Add a kill without saying the reason
        game.addKill(1, 2);

        //Add a kill specifying how it occurred
        game.addKill(1, 2, MeansOfDeath.MOD_SHOTGUN);

        String[] expResult = {"\"Reuel Ribeiro\": 2", "\"[BOT] Player\": 0"};
        String[] result = game.kills();
        
        assertArrayEquals(expResult, result);
    }

}
