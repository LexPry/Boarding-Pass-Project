import java.time.LocalDate;
import java.time.LocalTime;

public class TimeDate
{
        protected TimeDate(LocalTime localTime, LocalDate localDate){
            this.localDate = localDate;
            this.localTime = localTime;
        }
        protected LocalTime  localTime;
        protected LocalDate localDate;

}
