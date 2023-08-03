package InterfacesAndAbstraction.Exercise.P06MilitaryElite;

public class SpecialisedSoldierImpl extends PrivateImpl implements SpecialisedSoldier {
    private Corps corps;

    public SpecialisedSoldierImpl(int id, String firstName, String lastName, double salary, Corps corps) {
        super(id, firstName, lastName, salary);
        this.corps = corps;
    }

    @Override
    public String getCorps() {
        return corps.name();
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" Corps: %s", corps.name());
    }
}
