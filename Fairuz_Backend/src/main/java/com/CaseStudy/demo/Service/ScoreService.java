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
    private final   ScoreRepository scoreRepository;
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

        playerRepository.findById(score.getPlayerId())
                .orElseThrow(() -> new RuntimeException("Player not found with id: " + score.getPlayerId()));


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

    public  Optional<Score> getScoreById(UUID scoreId) {
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


    public Optional<Score> getHighestScoreByPlayerId(UUID playerId){
     List<Score> scores = scoreRepository.findHighestScoreByPlayerId(playerId);
     if (scores.isEmpty()){
         return Optional.empty();
     }
     return Optional.of(scores.get(0));
    }
    public List<Score> getScoresAboveValue(Integer minValue){
        return scoreRepository.findByValueGreaterThan(minValue);
    }
    public List<Score> getRecentScores(){
        return scoreRepository.findAllByOrderByCreatedAtDesc();
    }
    public Integer getTotalCoinsByPlayerId(UUID playerId) {
        Integer total = scoreRepository.getTotalCoinsByPlayerId(playerId);
        return total != null ? total : 0;
    }

    public Integer getTotalDistanceByPlayerId(UUID playerId) {
        Integer total = scoreRepository.getTotalDistanceByPlayerId(playerId);
        return total != null ? total : 0;
    }
    @Transactional
    public Score UpdateScore(UUID scoreId, Score UpdateScore){
        Score existingScore = scoreRepository.findById(scoreId)
                .orElseThrow(()-> new RuntimeException("Score Not found" + scoreId));
         if (UpdateScore.getValue() != null) {
             existingScore.setValue(UpdateScore.getValue());
         }
         if (UpdateScore.getCoinsCollected() != null) {
             existingScore.setCoinsCollected(UpdateScore.getCoinsCollected());
         }
         if (UpdateScore.getDistanceTravelled() != null) {
             existingScore.setDistanceTravelled(UpdateScore.getDistanceTravelled());
         }
         return scoreRepository.save(existingScore);

    }
    @Transactional
    public void deleteScore(UUID scoreId) {
        if (!scoreRepository.existsById(scoreId)) {
            throw new RuntimeException("Score not found with id: " + scoreId);
        }
        scoreRepository.deleteById(scoreId);
    }
    @Transactional
    public void deleteScoresByPlayerId(UUID playerId) {
        List<Score> scoresToDelete = scoreRepository.findByPlayerID(playerId);
        scoreRepository.deleteAll(scoresToDelete);
    }
    public List<Score> getScoresByPlayerOrderByValue(UUID playerId) {
        return scoreRepository.findByPlayerIdOrderByValue(playerId);
    }

    public List<Score> getLeaderboard(int limit) {
        List<Score> sortedScores = scoreRepository.findTopScores(limit);
        return sortedScores.subList(0, Math.min(limit, sortedScores.size()));
    }

}
