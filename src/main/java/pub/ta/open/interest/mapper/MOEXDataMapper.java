package pub.ta.open.interest.mapper;

import org.springframework.stereotype.Component;
import pub.ta.open.interest.entity.MoexData;
import pub.ta.open.interest.entity.MoexId;
import pub.ta.open.interest.dto.MOEXDataDto;
import pub.ta.open.interest.exception.MOEXException;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
public class MOEXDataMapper implements MOEXMapper{
    @Override
    public MoexData fromDto(List<MOEXDataDto> dts, String futures) throws MOEXException {
        if (dts == null){
            throw new IllegalArgumentException("Пустой объект");
        }

        MOEXDataDto opDataDto = dts.get(0);
        MOEXDataDto npDataDto = dts.get(3);
        MoexData moexData = new MoexData();
        MoexId id = new MoexId();

//        Заполнение ключа
        id.setFutures(futures);
        id.setDate(fillDate(opDataDto.getDate()));
        moexData.setId(id);

//        Заполнение данных Open positions
        moexData.setOpJuridicalLong(opDataDto.getJuridicalLong());
        moexData.setOpJuridicalShort(opDataDto.getJuridicalShort());
        moexData.setOpPhysicalLong(opDataDto.getPhysicalLong());
        moexData.setOpPhysicalShort(opDataDto.getPhysicalShort());
        moexData.setOpSummary(opDataDto.getSummary());

//        Заполнение данных Number of persons
        moexData.setNpJuridicalLong(npDataDto.getJuridicalLong());
        moexData.setNpJuridicalShort(npDataDto.getJuridicalShort());
        moexData.setNpPhysicalLong(npDataDto.getPhysicalLong());
        moexData.setNpPhysicalShort(npDataDto.getPhysicalShort());
        moexData.setNpSummary(npDataDto.getSummary());

        return moexData;
    }

    private LocalDate fillDate(String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return LocalDate.parse(date, formatter);
    }
}