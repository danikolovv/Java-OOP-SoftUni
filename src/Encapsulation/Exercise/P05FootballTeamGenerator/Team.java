package Encapsulation.Exercise.P05FootballTeamGenerator;

import java.util.ArrayList;
import java.util.List;

public class Team {

    private String name;
    private List<Player> players;

    public Team (String name) {
        this.setName(name);
        this.players = new ArrayList<>();
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void removePlayer(String name) {
        Player playerToRemove = null;
        for (Player player : players) {
            if (player.getName().equals(name)) {
                playerToRemove = player;
                break;
            }
        }

        if (playerToRemove != null) {
            players.remove(playerToRemove);
        } else {
            throw new IllegalArgumentException("Player " + name + " is not in " + this.name + " team.");
        }
    }

    public double getRating() {
        if (players.isEmpty()) {
            return 0;
        }

        double totalSkillLevel = 0;
        for (Player player : players) {
            totalSkillLevel += player.overallSkillLevel();
        }

        return totalSkillLevel / players.size();
    }
}
