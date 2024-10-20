package pub.ta.open.interest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pub.ta.open.interest.Entity.MOEXData;
import pub.ta.open.interest.Entity.MOEXId;

@Repository
public interface MOEXRepository extends JpaRepository<MOEXData, MOEXId> {
    MOEXData findFirstByIdFutures(String futures);
}