package com.lifetech.domain.dao;

        import TrackerResident.Coordinate;
        import com.lifetech.domain.model.Position;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.data.jpa.repository.Query;
        import org.springframework.scheduling.annotation.Async;
        import org.springframework.stereotype.Repository;

        import javax.transaction.Transactional;
        import java.util.List;

@Repository
@Transactional
public interface PositionDAO extends JpaRepository<Position, Long> {
    @Query(value = "select * from Position p where p.strap_id=?1  ORDER BY p.date DESC LIMIT 1;\n", nativeQuery = true)
    Position findPositionByStrap(long strapId);

    @Query(value = "select * from Position p where p.strap_id=?1  ORDER BY p.date DESC LIMIT 30;\n", nativeQuery = true)
    List<Position> positionHistory(long strapId);

    @Override
    @Transactional
    <S extends Position> S save(S s);
}
