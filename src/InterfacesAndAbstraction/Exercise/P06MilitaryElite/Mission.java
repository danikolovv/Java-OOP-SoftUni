package InterfacesAndAbstraction.Exercise.P06MilitaryElite;

public class Mission {
    private String codeName;
    private MissionState state;

    public Mission(String codeName, MissionState state) {
        this.codeName = codeName;
        this.state = state;
    }

    @Override
    public String toString() {
        return String.format("Code Name: %s State: %s", codeName, state.name());
    }
}
