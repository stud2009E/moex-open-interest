package pub.ta.open.interest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import pub.ta.open.interest.dto.MOEXDataDto;

public class MOEXProvider {
    private final RestTemplate restTemplate = new RestTemplate();
    public MOEXDataDto[] getByDate(String date, String name) {

        String url = fillUrl(date, name);

        ResponseEntity<MOEXDataDto[]> response =
                restTemplate.getForEntity(
                        url,
                        MOEXDataDto[].class);
        return response.getBody();
    }
    private String fillUrl(String date, String name){
        return "https://www.moex.com/api/contract/OpenOptionService/" +
                date +
                "/F/" +
                name +
                "/json";
    }
}