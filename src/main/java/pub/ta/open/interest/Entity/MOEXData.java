package pub.ta.open.interest.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name = "moex_data")
public class MOEXData {
    @EmbeddedId
    private MOEXId id;
    @Column(name = "op_juridical_long")
    private Double opJuridicalLong;
    @Column(name = "op_juridical_short")
    private Double opJuridicalShort;
    @Column(name = "op_physical_long")
    private Double opPhysicalLong;
    @Column(name = "op_physical_short")
    private Double opPhysicalShort;
    @Column(name = "op_summary")
    private Double opSummary;

    @Column(name = "np_juridical_long")
    private Double npJuridicalLong;
    @Column(name = "np_juridical_short")
    private Double npJuridicalShort;
    @Column(name = "np_physical_long")
    private Double npPhysicalLong;
    @Column(name = "np_physical_short")
    private Double npPhysicalShort;
    @Column(name = "np_summary")
    private Double npSummary;
}