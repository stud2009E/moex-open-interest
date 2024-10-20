package pub.ta.open.interest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableScheduling
public class App 
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);

//        MOEXProvider provider = new MOEXProvider();
//        MOEXService service = new MOEXService();
//        MOEXDataDto[] arrDto = provider.getByDate(Tools.getDate(), "NASD");
//        service.save(Arrays.stream(arrDto).toList(),"NASD");

//        List<MOEXDataDto> moexData = new ArrayList<>();
//        System.out.println(Arrays.toString(provider.getByDate(Tools.getDate(), "NASD")));
    }
}