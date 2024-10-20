package pub.ta.open.interest;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MOEXData implements Serializable {
    @JsonProperty("JuridicalLong")
    Double juridicalLong;
    @JsonProperty("JuridicalShort")
    Double juridicalShort;
    @JsonProperty("PhysicalLong")
    Double physicalLong;
    @JsonProperty("PhysicalShort")
    Double physicalShort;
    @JsonProperty("Summary")
    Double summary;

    @JsonGetter
    public Double getJuridicalLong() {
        return juridicalLong;
    }
    @JsonGetter
    public Double getJuridicalShort() {
        return juridicalShort;
    }
    @JsonGetter
    public Double getPhysicalLong() {
        return physicalLong;
    }
    @JsonGetter
    public Double getPhysicalShort() {
        return physicalShort;
    }
    @JsonGetter
    public Double getSummary() {
        return summary;
    }
    @JsonSetter
    public void setJuridicalLong(String juridicalLong) {
        this.juridicalLong = Tools.fillNumeric(juridicalLong);
    }
    public void setJuridicalShort(String juridicalShort) {
        this.juridicalShort = Tools.fillNumeric(juridicalShort);
    }
    public void setPhysicalLong(String physicalLong) {
        this.physicalLong = Tools.fillNumeric(physicalLong);
    }
    public void setPhysicalShort(String physicalShort) {
        this.physicalShort = Tools.fillNumeric(physicalShort);
    }
    public void setSummary(String summary) {
        this.summary = Tools.fillNumeric(summary);
    }
    @Override
    public String toString() {
        return "MOEXData{" +
                ", juridicalLong='" + juridicalLong + '\'' +
                ", juridicalShort='" + juridicalShort + '\'' +
                ", physicalLong='" + physicalLong + '\'' +
                ", physicalShort='" + physicalShort + '\'' +
                ", Summary='" + summary + '\'' +
                '}';
    }
}