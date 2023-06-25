package Examples.Enum;

public enum Months {
    JANUARY(31),
    FEBRUARY(28),
    MARCH(31),
    APRIL(30);

    public final int days;
    Months(int days) {
        this.days = days;

    }
}
