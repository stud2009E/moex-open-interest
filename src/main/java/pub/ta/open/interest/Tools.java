package pub.ta.open.interest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Tools {
    /**
     * Получение даты в нужном формате.
     * @return дата
     */
    public static String getDate(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yy");
        LocalDate currentDate = java.time.LocalDate.now();
        return formatter.format(currentDate);
    };

    public static Double fillNumeric(String value){
        String strValue = value.replaceAll(" ", "");
        return Double.parseDouble(strValue.replace(',','.'));
    }
}