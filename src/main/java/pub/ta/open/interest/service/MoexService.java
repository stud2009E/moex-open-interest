package pub.ta.open.interest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pub.ta.open.interest.entity.MoexData;
import pub.ta.open.interest.mapper.MoexDataMapper;
import pub.ta.open.interest.provider.MoexProvider;
import pub.ta.open.interest.utils.Tools;
import pub.ta.open.interest.dto.MOEXDataDto;
import pub.ta.open.interest.repository.MoexRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MoexService {

    private final MoexRepository repository;
    private final MoexProvider provider;

    @Transactional
    public void firstSave(String futures){
        List<MOEXDataDto> dts;
        List<MoexData> data = new ArrayList<>();
        List<LocalDate> dates =  Tools.getListDate();
        for(LocalDate date : dates){
            dts = provider.getByDate(date, futures);
            data.add(MoexDataMapper.fromDto(dts, futures));
        }
        repository.saveAll(data);
    }
    public List<MoexData> getByFutures(String futures) {
        LocalDate date = LocalDate.now().minusMonths(6);
        return repository.findAllByIdFuturesAndIdDateGreaterThan(futures, date);
    }
    public List<MoexData> getByFutures(String futures, LocalDate date){
        return repository.findAllByIdFuturesAndIdDateGreaterThan(futures, date);
    }
}