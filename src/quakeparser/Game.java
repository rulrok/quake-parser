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

/**
 *
 * @author rulrok
 */
public class Game implements IGame {

    private final int PLAYER_WORLD_ID = 1023;

    private int totalKills;

    private final Map<Integer, String> players;

    private final Map<Integer, Integer> kills;

    private final Map<MeansOfDeath, Integer> killsByMeans;

    public Game() {
        totalKills = 0;
        players = new HashMap<>();
        kills = new HashMap<>();
        killsByMeans = new HashMap<>(MeansOfDeath.values().length);

        _registerWorld(); //Add <world> player to the game
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
            if (i == PLAYER_WORLD_ID) {
                continue;
            }
            String player = players.get(i);
            int playerKills = kills.get(i);
            result.add("\"" + player + "\": " + playerKills);
        }

        return result.toArray(new String[]{});
    }

    void registerPlayer(int id, String playerName) {

        players.put(id, playerName);
        kills.put(id, 0);

    }

    void addKill(int killerID, int killedID) {
        int playerTotalKills = kills.get(killerID);

        kills.put(killerID, ++playerTotalKills);

        totalKills++;
    }

    void addKill(int killerID, int killedID, MeansOfDeath death) {
        addKill(killerID, killedID);

        int occurrences = this.killsByMeans.containsKey(death) ? this.killsByMeans.get(death) : 0;

        this.killsByMeans.put(death, ++occurrences);
    }

    private void _registerWorld() {
        players.put(PLAYER_WORLD_ID, "<world>");
        kills.put(PLAYER_WORLD_ID, 0);

    }

}
