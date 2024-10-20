package pub.ta.open.interest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class MOEXProvider {
    private final RestTemplate restTemplate = new RestTemplate();
    public MOEXData[] get(String date, String name) {

        String url = "https://www.moex.com/api/contract/OpenOptionService/" +
                date +
                "/F/" +
                name +
                "/json";

        ResponseEntity<MOEXData[]> response =
                restTemplate.getForEntity(
                        url,
                        MOEXData[].class);
        return response.getBody();
    }
}