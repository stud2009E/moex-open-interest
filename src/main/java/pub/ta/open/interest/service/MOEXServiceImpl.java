package pub.ta.open.interest.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pub.ta.open.interest.Entity.MOEXData;
import pub.ta.open.interest.MOEXProvider;
import pub.ta.open.interest.Tools;
import pub.ta.open.interest.dto.MOEXDataDto;
import pub.ta.open.interest.exception.MOEXException;
import pub.ta.open.interest.mapper.MOEXDataMapper;
import pub.ta.open.interest.mapper.MOEXMapper;
import pub.ta.open.interest.repository.MOEXRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Data
public class MOEXServiceImpl {

    @Autowired
    private MOEXRepository repository;
    private MOEXMapper mapper = new MOEXDataMapper();

    @Transactional
    public List<MOEXData> save(String futures) {

        MOEXData oldData = repository.findFirstByIdFutures(futures);
        if (oldData == null){
            return saveList(futures);
        }else{
            return saveOne(futures);
        }
    }

    private List<MOEXData> saveOne(String futures){
        List<MOEXDataDto> dts;
        List<MOEXData> data = new ArrayList<>();

        MOEXProvider provider = new MOEXProvider();
        MOEXDataDto[] arrDto = provider.getByDate(Tools.getDate(), futures);
        dts = Arrays.stream(arrDto).toList();
        if (dts.isEmpty()){
            throw new MOEXException("Нет данных для сохранения");
        }
        data.add(repository.save(mapper.fromDto(dts, futures)));
        return data;
    }

    private List<MOEXData> saveList(String futures){
        MOEXProvider provider = new MOEXProvider();
        List<MOEXDataDto> dts;
        List<MOEXData> data = new ArrayList<>();
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