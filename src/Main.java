
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import quakeparser.LogFile;
import quakeparser.QuakeParser;
import quakeparser.contracts.IGame;
import quakeparser.exceptions.ParserNotInitialized;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author rulrok
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        QuakeParser parser = new QuakeParser();

        LogFile log = new LogFile(new File("src/games.log"));

        parser.readLog(log);

        try {
            List<? super IGame> games = parser.games();

            for (Iterator<? super IGame> it = games.iterator(); it.hasNext();) {
                IGame game = (IGame) it.next();

                System.out.println(game.totalKills());
            }
        } catch (ParserNotInitialized ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
