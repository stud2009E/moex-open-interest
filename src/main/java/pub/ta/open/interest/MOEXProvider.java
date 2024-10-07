package pub.ta.open.interest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class MOEXProvider {
    private final RestTemplate restTemplate = new RestTemplate();
    public MOEXData[] get() {

        String url = "https://www.moex.com/api/contract/OpenOptionService/03.10.2024/F/NASD/json";

        ResponseEntity<MOEXData[]> response =
                restTemplate.getForEntity(
                        url,
                        MOEXData[].class);
        MOEXData[] employees = response.getBody();

        return employees;
    }
}