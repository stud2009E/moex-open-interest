package pub.ta.open.interest.mapper;

import org.springframework.context.annotation.Bean;
import pub.ta.open.interest.Entity.MOEXData;
import pub.ta.open.interest.Entity.MOEXId;
import pub.ta.open.interest.dto.MOEXDataDto;
import pub.ta.open.interest.exception.MOEXException;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

public class MOEXDataMapper implements MOEXMapper{
    @Override
    public MOEXData fromDto(List<MOEXDataDto> dts, String futures) {
        if (dts == null){
            throw new MOEXException("Пустой объект");
        }

        MOEXDataDto opDataDto = dts.get(0);
        MOEXDataDto npDataDto = dts.get(3);
        MOEXData moexData = new MOEXData();
        MOEXId id = new MOEXId();

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

    private OffsetDateTime fillDate(String date){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDateTime ldt = LocalDate.parse(date, formatter).atTime(LocalTime.NOON);
        return ldt.atOffset(ZoneOffset.UTC);

    }
}