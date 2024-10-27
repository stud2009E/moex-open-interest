package pub.ta.open.interest.mapper;

import pub.ta.open.interest.exception.MOEXException;

public interface Mapper<Dto, Entity>{
    Entity fromDto(Dto dto, String futures) throws MOEXException;
}