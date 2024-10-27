package pub.ta.open.interest.provider;

import java.time.LocalDate;
import java.util.List;

public interface Provider<Dto> {
   List<Dto> getByDate(LocalDate date, String name);
}
