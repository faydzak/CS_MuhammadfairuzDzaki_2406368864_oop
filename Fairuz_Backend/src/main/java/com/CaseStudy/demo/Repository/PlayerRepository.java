package com.CaseStudy.demo.Repository;
import com.CaseStudy.demo.Model.Player;
import com.CaseStudy.demo.Model.Score;
import com.CaseStudy.demo.
@Repository
public interface PlayerRepository extends JpaRepository<Player, UUID> {

    Optional<Player> findByUsername(String username);

    List<Player> findAllByOrderByTotalCoinsDesc();

    @Query("SELECT p FROM Player p ORDER BY p.highScore DESC")
    List<Player> findTopPlayersByHighScore(@Param("limit") int limit);
}
