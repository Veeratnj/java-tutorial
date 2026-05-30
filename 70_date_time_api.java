import java.time.LocalDate;

// 70_date_time_api.java - beginner-friendly example for 70 date time api
public class 70DateTimeApi {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now(); LocalDate tomorrow = today.plusDays(1); System.out.println(today + " -> " + tomorrow);
    }
}
