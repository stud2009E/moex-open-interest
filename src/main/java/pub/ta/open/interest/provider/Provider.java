package pub.ta.open.interest.provider;

import java.time.LocalDate;
import java.util.List;

public interface Provider<T> {
   List<T> getByDate(LocalDate date, String name);
}
