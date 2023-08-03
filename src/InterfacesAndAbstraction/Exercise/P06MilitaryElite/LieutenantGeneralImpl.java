package InterfacesAndAbstraction.Exercise.P06MilitaryElite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LieutenantGeneralImpl extends PrivateImpl implements LieutenantGeneral {
    private List<Private> privates;

    public LieutenantGeneralImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.privates = new ArrayList<>();
    }

    @Override
    public void addPrivate(Private priv) {
        privates.add(priv);
    }

    @Override
    public List<Private> getPrivates() {
        privates.sort(Comparator.comparingInt(Soldier::getId).reversed());
        return Collections.unmodifiableList(privates);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString()).append(System.lineSeparator());
        sb.append("Privates:").append(System.lineSeparator());
        for (Private priv : privates) {
            sb.append(" ").append(priv.toString()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
