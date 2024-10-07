package pub.ta.open.interest;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.time.OffsetDateTime;

public class MOEXData implements Serializable {
    @JsonProperty("Date")
    private String date;
    @JsonProperty("JuridicalLong")
    String juridicalLong;
    @JsonProperty("JuridicalShort")
    String juridicalShort;
    @JsonProperty("PhysicalLong")
    String physicalLong;
    @JsonProperty("PhysicalShort")
    String physicalShort;
    @JsonProperty("Summary")
    String Summary;

    public MOEXData() {
    }

    public MOEXData(String date, String juridicalLong, String juridicalShort, String physicalLong, String physicalShort, String summary) {
        this.date = date;
        this.juridicalLong = juridicalLong;
        this.juridicalShort = juridicalShort;
        this.physicalLong = physicalLong;
        this.physicalShort = physicalShort;
        Summary = summary;
    }

    @JsonGetter
    public String getDate() {
        return date;
    }

    @JsonGetter
    public String getJuridicalLong() {
        return juridicalLong;
    }

    @JsonGetter
    public String getJuridicalShort() {
        return juridicalShort;
    }

    @JsonGetter
    public String getPhysicalLong() {
        return physicalLong;
    }

    @JsonGetter
    public String getPhysicalShort() {
        return physicalShort;
    }

    @JsonGetter
    public String getSummary() {
        return Summary;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setJuridicalLong(String juridicalLong) {
        this.juridicalLong = juridicalLong;
    }

    public void setJuridicalShort(String juridicalShort) {
        this.juridicalShort = juridicalShort;
    }

    public void setPhysicalLong(String physicalLong) {
        this.physicalLong = physicalLong;
    }

    public void setPhysicalShort(String physicalShort) {
        this.physicalShort = physicalShort;
    }

    public void setSummary(String summary) {
        Summary = summary;
    }

    @Override
    public String toString() {
        return "MOEXData{" +
                "date='" + date + '\'' +
                ", juridicalLong='" + juridicalLong + '\'' +
                ", juridicalShort='" + juridicalShort + '\'' +
                ", physicalLong='" + physicalLong + '\'' +
                ", physicalShort='" + physicalShort + '\'' +
                ", Summary='" + Summary + '\'' +
                '}';
    }
}
