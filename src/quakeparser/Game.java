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

    private final int WORLD_PLAYER_ID = 1022;

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

        if (killerID != WORLD_PLAYER_ID) {
            int playerTotalKills = kills.get(killerID);
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
        switch (line.event()) {
            case Kill:

                MeansOfDeath meanOfDeath = MeansOfDeath.valueOf(Integer.parseInt(line.eventIndirectObject()));
                int killerID = Integer.parseInt(line.eventSubject());
                int killedID = Integer.parseInt(line.eventDirectObject());

                addKill(killerID, killedID, meanOfDeath);

                break;
            case ClientConnect:

                int playerID = Integer.parseInt(line.eventSubject());

                players.put(playerID, null);
                kills.put(playerID, 0);

                break;
            case ClientUserinfoChanged:

                playerID = Integer.parseInt(line.eventSubject());
                String playerName = line.eventIndirectObject();

                players.put(playerID, playerName);
                break;
            case ShutdownGame:
                finished = true;
                break;
        }
    }

    @Override
    public boolean isFinished() {
        return finished;
    }

}
