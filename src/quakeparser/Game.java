/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quakeparser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import quakeparser.contracts.IGame;
import quakeparser.contracts.ILine;

/**
 *
 * @author rulrok
 */
public class Game implements IGame {

    private final int WORLD_PLAYER_ID = 1023;

    private int totalKills;

    private final Map<Integer, String> players;

    private final Map<Integer, Integer> kills;

    private final Map<MeansOfDeath, Integer> killsByMeans;

    private boolean finished = false;

    public Game() {
        totalKills = 0;
        players = new HashMap<>();
        kills = new HashMap<>();
        killsByMeans = new HashMap<>(MeansOfDeath.values().length);
    }

    @Override
    public int totalKills() {
        return totalKills;
    }

    @Override
    public String[] players() {
        return players.values().toArray(new String[]{});
    }

    @Override
    public String[] kills() {

        List<String> result = new ArrayList<>();

        for (Integer i : players.keySet()) {
            String player = players.get(i);
            int playerKills = kills.get(i);
            result.add("\"" + player + "\": " + playerKills);
        }

        return result.toArray(new String[]{});
    }

    void registerPlayer(int id, String playerName) {

        if (id == WORLD_PLAYER_ID) {
            return;
        }

        players.put(id, playerName);
        kills.put(id, 0);

    }

    void addKill(int killerID, int killedID) {
        int playerTotalKills = kills.get(killerID);

        if (killerID != WORLD_PLAYER_ID) {
            kills.put(killerID, ++playerTotalKills);
        }

        totalKills++;
    }

    void addKill(int killerID, int killedID, MeansOfDeath death) {
        addKill(killerID, killedID);

        int occurrences = this.killsByMeans.containsKey(death) ? this.killsByMeans.get(death) : 0;

        this.killsByMeans.put(death, ++occurrences);
    }

    @Override
    public void addEvent(ILine line) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isFinished() {
        return finished;
    }

}
