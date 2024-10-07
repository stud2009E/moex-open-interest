package pub.ta.open.interest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        MOEXProvider provider = new MOEXProvider();
        List<MOEXData> moexData = new ArrayList<>();
        System.out.println(Arrays.toString(provider.get()));
    }
}
