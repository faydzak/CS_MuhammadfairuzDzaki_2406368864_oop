package com.CaseStudy.demo.Repository;

import com.CaseStudy.demo.Model.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ScoreRepository extends JpaRepository<Score, UUID> {

    List<Score> findByPlayerID(UUID playerId);

    List<Score> findByPlayerIdOrderByValue(UUID playerId);

    List<Score> findByValueGreaterThan(Integer minValue);

    List<Score> findAllByOrderByCreatedAtDesc();

    @Query("Select s FROM Score s ORDER BY s.value DESC")
    List<Score> findTopScores(@Param("Limit") int limit);

    @Query("SELECT s FROM Score s WHERE s.playerId = :playerId ORDER BY s.value DESC")
    List<Score> findHighestScoreByPlayerId(@Param("playerId") UUID playerId);

    // 3. Total Collected Coins by Player
    @Query("SELECT SUM(s.coinsCollected) FROM Score s WHERE s.playerId = :playerId")
    Integer getTotalCoinsByPlayerId(@Param("playerId") UUID playerId);

    // 4. Total Distance Traveled by Player
    @Query("SELECT SUM(s.distanceTravelled) FROM Score s WHERE s.playerId = :playerId")
    Integer getTotalDistanceByPlayerId(@Param("playerId") UUID playerId);

}
