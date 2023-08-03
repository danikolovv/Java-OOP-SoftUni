package InterfacesAndAbstraction.Exercise.P06MilitaryElite;

import java.util.List;

public interface Commando extends SpecialisedSoldier{
    void addMission(Mission mission);
    List<Mission> getMissions();
}
