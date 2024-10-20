package pub.ta.open.interest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);

        MOEXProvider provider = new MOEXProvider();
        List<MOEXData> moexData = new ArrayList<>();
        System.out.println(Arrays.toString(provider.get(Tools.getDate(), "NASD")));
    }
}