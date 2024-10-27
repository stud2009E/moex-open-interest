package pub.ta.open.interest.mapper;

import pub.ta.open.interest.entity.MoexData;
import pub.ta.open.interest.dto.MOEXDataDto;
import pub.ta.open.interest.exception.MOEXException;

import java.util.List;

public interface MOEXMapper extends Mapper<List<MOEXDataDto>, MoexData>{
    @Override
    MoexData fromDto(List<MOEXDataDto> dts, String futures) throws MOEXException;
}