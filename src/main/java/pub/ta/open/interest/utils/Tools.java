package pub.ta.open.interest.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Tools {
    public static List<LocalDate> getListDate(){
        List<LocalDate> dates = new ArrayList<>();
        for (int i = 1; i < 182; i++){
            dates.add(java.time.LocalDate.now().minusDays(i));
        }
        return dates;
    }
    public static Double fillNumeric(String value){
        String strValue = value.replaceAll(" ", "");
        return Double.parseDouble(strValue.replace(',','.'));
    }
}