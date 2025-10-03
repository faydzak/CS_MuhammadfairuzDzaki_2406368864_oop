package com.CaseStudy.demo.Service;
import com.CaseStudy.demo.Model.Player;
import com.CaseStudy.demo.Model.Score;
import com.CaseStudy.demo.Repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    /**
     * Retrieves a player by their ID.
     * @param playerId The UUID of the player.
     * @return The found Player object.
     * @throws RuntimeException if no player is found with the given ID.
     */
    public Player getPlayerById(UUID playerId) {
        return playerRepository.findById(playerId)
                .orElseThrow(() -> new RuntimeException("Player not found with id: " + playerId));
    }

    /**
     * Retrieves a player by their username.
     * @param username The username of the player.
     * @return The found Player object.
     * @throws RuntimeException if no player is found with the given username.
     */
    public Player getPlayerByUsername(String username) {
        return playerRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Player not found with username: " + username));
    }

    /**
     * Creates a new player.
     * @param player The player object containing the username.
     * @return The saved Player object.
     * @throws RuntimeException if the username already exists.
     */
    public Player createPlayer(Player player) {
        if (playerRepository.existByUsername(player.getUsername())) {
            throw new RuntimeException("Username already exists: " + player.getUsername());
        }
        return playerRepository.save(player);
    }


    public Player updatePlayer(UUID playerId, Player playerUpdates) {
        // First, get the existing player or throw an exception if not found.
        Player existingPlayer = getPlayerById(playerId);

        if (playerUpdates.getHighScore() != null) {
            existingPlayer.setHighScore(playerUpdates.getHighScore());
        }
        if (playerUpdates.getTotalCoins() != null) {
            existingPlayer.setTotalCoins(playerUpdates.getTotalCoins());
        }
        if (playerUpdates.getTotalDistance() != null) {
            existingPlayer.setTotalDistance(playerUpdates.getTotalDistance());
        }

        return playerRepository.save(existingPlayer);
    }

    /**
     * Deletes a player by their ID.
     * @param playerId The UUID of the player to delete.
     * @throws RuntimeException if no player is found with the given ID.
     */
    public void deletePlayer(UUID playerId) {
        if (!playerRepository.existsById(playerId)) {
            throw new RuntimeException("Player not found with id: " + playerId);
        }
        playerRepository.deleteById(playerId);
    }

    public boolean isUsernameExists(String username) {
        return playerRepository.existByUsername(username);
    }

    // --- Leaderboard Methods ---

    public List<Player> getLeaderboardByHighScore(int limit) {
        return playerRepository.findTopPlayersByHighScore(limit);
    }

    public List<Player> getLeaderboardByTotalCoins() {
        return playerRepository.findAllByOrderByTotalCoinsDesc();
    }

    public List<Player> getLeaderboardByTotalDistance() {
        return playerRepository.findAllByOrderByTotalDistanceDesc();
    }
}
