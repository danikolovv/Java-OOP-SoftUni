package InterfacesAndAbstraction.Exercise.P06MilitaryElite;

import java.util.List;

public interface Engineer extends SpecialisedSoldier{
    void addRepair(Repair repair);
    List<Repair> getRepairs();
}
