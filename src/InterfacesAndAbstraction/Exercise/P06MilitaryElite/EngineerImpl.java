package InterfacesAndAbstraction.Exercise.P06MilitaryElite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EngineerImpl extends SpecialisedSoldierImpl implements Engineer {
    private List<Repair> repairs;

    public EngineerImpl(int id, String firstName, String lastName, double salary, Corps corps) {
        super(id, firstName, lastName, salary, corps);
        this.repairs = new ArrayList<>();
    }

    @Override
    public void addRepair(Repair repair) {
        repairs.add(repair);
    }

    @Override
    public List<Repair> getRepairs() {
        return Collections.unmodifiableList(repairs);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString()).append(System.lineSeparator());
        sb.append("Repairs:").append(System.lineSeparator());
        for (Repair repair : repairs) {
            sb.append(" ").append(repair.toString()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
