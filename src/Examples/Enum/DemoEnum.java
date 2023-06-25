package Examples.Enum;

public class DemoEnum {
    public static void main(String[] args) {

        Months[] months = Months.values();

        for (Months month : months) {
            System.out.println(month + " " + month.days);

//            switch (month) {
//                case JANUARY, FEBRUARY, MARCH, APRIL -> { break; }
//            }
        }
    }
}
