package pub.ta.open.interest;

import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Tools {

    @Value("${period.days}")
    private static Integer period;

    /**
     * Получение даты в нужном формате.
     * @return дата
     */
    public static String getDate(){
        return getFormatter().format(java.time.LocalDate.now());
    };

    public static String getDate(LocalDate date){
        return getFormatter().format(date);
    };

    /**
     *Получение списка дат за которые нужны данные.
     * @return список дат
     */
    public static List<String> getListDate(){
        List<String> dates = new ArrayList<>();

        DateTimeFormatter formatter = getFormatter();

        for (int i = 1; i < 182; i++){
            LocalDate date = java.time.LocalDate.now().minusDays(i);
            dates.add(formatter.format(date));
        }
        return dates;
    }

    /**
     * Форматирование числовых строк ответа в Double.
     * @param value число в формате строки
     * @return число в формате Double
     */
    public static Double fillNumeric(String value){
        String strValue = value.replaceAll(" ", "");
        return Double.parseDouble(strValue.replace(',','.'));
    }

    private static DateTimeFormatter getFormatter(){
        return DateTimeFormatter.ofPattern("dd.MM.yy");
    }
}