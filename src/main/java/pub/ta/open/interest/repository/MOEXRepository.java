package pub.ta.open.interest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pub.ta.open.interest.entity.MoexData;
import pub.ta.open.interest.entity.MoexId;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MOEXRepository extends JpaRepository<MoexData, MoexId> {
    List<MoexData> findAllByIdFuturesAndIdDateGreaterThan(String futures, LocalDate date);
}