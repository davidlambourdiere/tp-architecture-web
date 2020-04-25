package com.lifetech.domain.dao;

        import com.lifetech.domain.model.Position;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.data.jpa.repository.Query;
        import org.springframework.stereotype.Repository;

        import java.util.List;

@Repository
public interface PositionDAO extends JpaRepository<Position, Long> {
    //@Query(value = "select p from Position p where p.date = (select max(p.date) from Position p where p.strap.id = ?1)", nativeQuery = true)
    @Query(value = "select * from Position p where p.strap_id=?1   and p.date < CURRENT_TIMESTAMP LIMIT 1;\n", nativeQuery = true)
    Position findPositionByStrap(long strapId);
}
