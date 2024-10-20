package pub.ta.open.interest.mapper;

public interface Mapper<Dto, Entity>{
    Entity fromDto(Dto dto, String futures);
}