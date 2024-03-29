package time;

import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class ChangeTimePlusMain {
    public static void main(String[] args) {
        LocalDateTime dt = LocalDateTime.of(2018, 1, 1, 13, 30, 59);
        System.out.println("dt.plus(10, ChronoUnit.YEARS) = " + dt.plus(10, ChronoUnit.YEARS));

        System.out.println("dt.plusYears(10) = " + dt.plusYears(10));

        Period period = Period.ofYears(10);
        LocalDateTime plus = dt.plus(period);
        System.out.println("plus = " + plus);
    }
}
