package pub.ta.open.interest.mapper;

import pub.ta.open.interest.Entity.MOEXData;
import pub.ta.open.interest.dto.MOEXDataDto;

import java.util.List;

public interface MOEXMapper extends Mapper<List<MOEXDataDto>, MOEXData>{
    @Override
    MOEXData fromDto(List<MOEXDataDto> dts, String futures);
}