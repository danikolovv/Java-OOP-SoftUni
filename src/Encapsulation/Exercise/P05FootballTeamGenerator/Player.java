package Encapsulation.Exercise.P05FootballTeamGenerator;

public class Player {

    private String name;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;

    public Player(String name, int endurance, int sprint, int dribble, int passing, int shooting) {
        this.setName(name);
        this.setEndurance(endurance);
        this.setSprint(sprint);
        this.setDribble(dribble);
        this.setPassing(passing);
        this.setShooting(shooting);
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    private void validateStatValue(int statValue, String statName) {
        if (statValue < 0 || statValue > 100) {
            throw new IllegalArgumentException(statName + " should be between 0 and 100.");
        }
    }

    public void setEndurance(int endurance) {
        validateStatValue(endurance, "Endurance");
        this.endurance = endurance;
    }

    public void setSprint(int sprint) {
        validateStatValue(sprint, "Sprint");
        this.sprint = sprint;
    }

    public void setDribble(int dribble) {
        validateStatValue(dribble, "Dribble");
        this.dribble = dribble;
    }

    public void setPassing(int passing) {
        validateStatValue(passing, "Passing");
        this.passing = passing;
    }

    public void setShooting(int shooting) {
        validateStatValue(shooting, "Shooting");
        this.shooting = shooting;
    }

    public String getName() {
        return name;
    }

    public double overallSkillLevel() {
        return (this.endurance + this.dribble + this.shooting + this.passing + this.sprint) / 5D;
    }
}
