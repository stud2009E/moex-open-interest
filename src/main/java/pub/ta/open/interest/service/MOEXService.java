package pub.ta.open.interest.service;

import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pub.ta.open.interest.entity.MoexData;
import pub.ta.open.interest.MOEXProvider;
import pub.ta.open.interest.Tools;
import pub.ta.open.interest.dto.MOEXDataDto;
import pub.ta.open.interest.entity.MoexId;
import pub.ta.open.interest.mapper.MOEXMapper;
import pub.ta.open.interest.repository.MOEXRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@Data
public class MOEXService {

    private final MOEXRepository repository;
    private final MOEXMapper mapper;
    private final MOEXProvider provider;

    @Transactional
    public void firstSave(String futures){
        List<MOEXDataDto> dts;
        List<MoexData> data = new ArrayList<>();
        List<String> dates =  Tools.getListDate();
        for(String date : dates){
            MOEXDataDto[] arrDto = provider.getByDate(date, futures);
            dts = Arrays.stream(arrDto).toList();
            data.add(mapper.fromDto(dts, futures));
        }
        repository.saveAll(data);
    }

    /**
     * Получение данных по фьючерсу за пол года.
     * @param futures
     * @return
     */
    public List<MoexData> getByFutures(String futures) {
        LocalDate date = LocalDate.now().minusDays(182);
        return repository.findAllByIdFuturesAndIdDateGreaterThan(futures, date);
    }

    /**
     * Получение данные по фьючерсу с определенной даты.
     * @param futures
     * @param date
     * @return
     */
    public List<MoexData> getAllByFuturesFromDate(String futures, LocalDate date){
        return repository.findAllByIdFuturesAndIdDateGreaterThan(futures, date);
    }

    /**
     * Получение данных по фьючерсу за заданную дату.
     * @param futures
     * @param date
     * @return
     */
    public MoexData getOneByFuturesAndDate(String futures, LocalDate date){
        List<MOEXDataDto> dts;

        MoexId id = new MoexId(date, futures);

        Optional<MoexData> moexData = repository.findById(id);
        if (moexData.isPresent()){
            return moexData.get();
        }
        MOEXDataDto[] arrDto = provider.getByDate(Tools.getDate(date), futures);

        dts = Arrays.stream(arrDto).toList();
        if (dts.isEmpty()){
            throw new IllegalArgumentException("Нет данных для сохранения");
        }
        return repository.save(mapper.fromDto(dts, futures));
    }
    private List<MoexData> saveOne(String futures){
        List<MOEXDataDto> dts;
        List<MoexData> data = new ArrayList<>();

        MOEXDataDto[] arrDto = provider.getByDate(Tools.getDate(), futures);
        dts = Arrays.stream(arrDto).toList();
        if (dts.isEmpty()){
            throw new IllegalArgumentException("Нет данных для сохранения");
        }
        data.add(repository.save(mapper.fromDto(dts, futures)));
        return data;
    }

    private List<MoexData> saveList(String futures){

        List<MOEXDataDto> dts;
        List<MoexData> data = new ArrayList<>();
        List<String> dates =  Tools.getListDate();

        for(String date : dates){
            MOEXDataDto[] arrDto = provider.getByDate(date, futures);
            dts = Arrays.stream(arrDto).toList();
            data.add(mapper.fromDto(dts, futures));
        }
        repository.saveAll(data);
        return data;
    }
}