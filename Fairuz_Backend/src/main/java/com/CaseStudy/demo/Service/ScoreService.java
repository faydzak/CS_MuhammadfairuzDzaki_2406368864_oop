package com.CaseStudy.demo.Service;
import com.CaseStudy.demo.Model.Score;
import com.CaseStudy.demo.Model.Player;
import com.CaseStudy.demo.Repository.PlayerRepository;
import com.CaseStudy.demo.Repository.ScoreRepository;
import com.CaseStudy.demo.Service.PlayerService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ScoreService {

    // --- DEPENDENCIES ---
    private final ScoreRepository scoreRepository;
    private final PlayerRepository playerRepository;
    private final PlayerService playerService;


    @Autowired
    public ScoreService(ScoreRepository scoreRepository, PlayerRepository playerRepository, PlayerService playerService) {
        this.scoreRepository = scoreRepository;
        this.playerRepository = playerRepository;
        this.playerService = playerService;
    }

    @Transactional
    public Score createScore(Score score) {
        // Player Existence Validation
        playerRepository.findById(score.getPlayerId())
                .orElseThrow(() -> new RuntimeException("Player not found with id: " + score.getPlayerId()));

        // Save the new score
        Score savedScore = scoreRepository.save(score);

        // Update player statistics based on the new score
        playerService.updatePlayerStats(
                savedScore.getPlayerId(),
                savedScore.getValue(),
                savedScore.getCoinsCollected(),
                savedScore.getDistanceTravelled()
        );

        return savedScore;
    }

    public Optional<Score> getScoreById(UUID scoreId) {
        return scoreRepository.findById(scoreId);
    }

    public List<Score> getAllScores() {
        return scoreRepository.findAll();
    }

    public List<Score> getScoresByPlayerId(UUID playerId) {
        return scoreRepository.findByPlayerID(playerId);
    }

    public List<Score> getScoresByPlayerIdOrderByValue(UUID playerId) {
        return scoreRepository.findByPlayerIdOrderByValue(playerId);
    }

    public List<Score> getLeaderboard(int limit) {
        return scoreRepository.findTopScores(limit);
    }
    public List<Score> getHighestScoreByPlayerId(UUID playerId){
        return scoreRepository.findHighestScoreByPlayerId(playerId);
    }
    public List<Score> getScoresAboveValue(Integer minValue){
        return scoreRepository.findByValueGreaterThan(minValue);
    }
    public List<Score> getRecentScores(){
        return scoreRepository.findAllByOrderByCreatedAtDesc();
    }
    public int getTotalCoinsByPlayerId(UUID playerId){
        return scoreRepository.getTotalCoinsByPlayerId(playerId);
    }
    public int getTotalDistanceByPlayerId(UUID playerId){
        return scoreRepository.getTotalDistanceByPlayerId(playerId);
    }
    public Score UpdateScore(UUID scoreId, Score UpdateScore){
        Score existingScore = scoreRepository.save(existingScore)
                .orElseThrow(()-> new RuntimeException("Score Not found" + scoreId);
         if (UpdateScore.getValue() != null) {
             existingScore.setValue(UpdateScore.getValue());
         }
         if (UpdateScore.)

    }


}
