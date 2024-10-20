package pub.ta.open.interest.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;
import lombok.Data;

import java.io.Serializable;
import java.time.OffsetDateTime;

@Data
@Embeddable
public class MOEXId implements Serializable {
    @Column(name = "date")
    private OffsetDateTime date;
    @Column(name = "futures", length = 10)
    private String futures;
}
