package com.CaseStudy.demo.Repository;
import com.CaseStudy.demo.Model.Player;
import com.CaseStudy.demo.Model.Score;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;


@Repository
public interface PlayerRepository extends JpaRepository<Player, UUID> {

    Optional<Player> findByUsername(String username);

    Boolean existByUsername(String username);

    List<Player> findAllByOrderByTotalCoinsDesc();

    List<Player> findAllByOrderByTotalDistanceDesc();

    @Query("SELECT p FROM Player p ORDER BY p.highScore DESC")
    List<Player> findTopPlayersByHighScore(@Param("limit") int limit);
}
