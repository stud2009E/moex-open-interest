package pub.ta.open.interest.provider;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pub.ta.open.interest.dto.MOEXDataDto;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Component
public class MoexProvider implements Provider<MOEXDataDto>{
    private final RestTemplate restTemplate = new RestTemplate();
    @Override
    public List<MOEXDataDto> getByDate(LocalDate date, String name) {
        String url = fillUrl(date, name);
        ResponseEntity<MOEXDataDto[]> response =
                restTemplate.getForEntity(
                        url,
                        MOEXDataDto[].class);
        return Arrays.stream(Objects.requireNonNull(response.getBody())).toList();
    }
    private String fillUrl(LocalDate date, String futures){
        return String.format("https://www.moex.com/api/contract/OpenOptionService/%s/F/%s/json", date.toString(), futures);
    }
}