package Encapsulation.Exercise.P05FootballTeamGenerator;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Team> teams = new HashMap<>();

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("END")) {
                break;
            }

            String[] tokens = input.split(";");
            String command = tokens[0];
            String teamName = tokens[1];

            try {
                switch (command) {
                    case "Team":
                        teams.putIfAbsent(teamName, new Team(teamName));
                        break;
                    case "Add":
                        if (!teams.containsKey(teamName)) {
                            System.out.println("Team " + teamName + " does not exist.");
                        } else {
                            String playerName = tokens[2];
                            int endurance = Integer.parseInt(tokens[3]);
                            int sprint = Integer.parseInt(tokens[4]);
                            int dribble = Integer.parseInt(tokens[5]);
                            int passing = Integer.parseInt(tokens[6]);
                            int shooting = Integer.parseInt(tokens[7]);

                            Player player = new Player(playerName, endurance, sprint, dribble, passing, shooting);
                            teams.get(teamName).addPlayer(player);
                        }
                        break;
                    case "Remove":
                        if (!teams.containsKey(teamName)) {
                            System.out.println("Team " + teamName + " does not exist.");
                        } else {
                            String playerName = tokens[2];
                            teams.get(teamName).removePlayer(playerName);
                        }
                        break;
                    case "Rating":
                        if (!teams.containsKey(teamName)) {
                            System.out.println("Team " + teamName + " does not exist.");
                        } else {
                            double rating = teams.get(teamName).getRating();
                            DecimalFormat df = new DecimalFormat("#");
                            System.out.println(teamName + " - " + df.format(rating));
                        }
                        break;
                    default:
                        System.out.println("Invalid command.");
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
