package com.lifetech.domain.dao;

        import com.lifetech.domain.model.Position;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.data.jpa.repository.Query;
        import org.springframework.stereotype.Repository;

        import java.util.List;

@Repository
public interface PositionDAO extends JpaRepository<Position, Long> {
    @Query("select p from Position p where p.date = (select max(p.date) from Position p where p.strap.id = ?1)")
    Position findPositionByStrap(long strapId);
}
