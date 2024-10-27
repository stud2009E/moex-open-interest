package pub.ta.open.interest.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class MoexId implements Serializable {
    @Column(name = "date")
    private LocalDate date;
    @Column(name = "futures", length = 10)
    private String futures;
}
