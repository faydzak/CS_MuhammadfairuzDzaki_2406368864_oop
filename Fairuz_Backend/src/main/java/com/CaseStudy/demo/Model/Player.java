package com.CaseStudy.demo.Model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.UUID;
import java.time.LocalDateTime;
@Entity
@Table(name = "players")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID) // Auto-generates a UUID
    @Column(name = "player_id")
    private UUID playerId;

    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Column(name = "high_score")
    private Integer highScore = 0;

    @Column(name = "total_Coins")
    private Integer totalCoins = 0;

    @Column(name = "total_distance")
    private Integer totalDistance = 0;
    public Player() {
    }
    @CreationTimestamp
    @Column(name = "cratedAt", updatable = false)
    private LocalDateTime createdAt;

    // Constructor with username
    public Player(String username) {
        this.username = username;
    }

    // --- Getters and Setters ---

    public UUID getPlayerId() {
        return playerId;
    }

    public void setPlayerId(UUID playerId) {
        this.playerId = playerId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // Here is the getHighScore() method you mentioned
    public Integer getHighScore() {
        return highScore;
    }

    public void setHighScore(Integer highScore) {
        this.highScore = highScore;
    }

    public Integer getTotalCoins() {
        return totalCoins;
    }

    public void setTotalCoins(Integer totalCoins) {
        this.totalCoins = totalCoins;
    }

    // Here is the getTotalDistance() method you mentioned
    public Integer getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(Integer totalDistance) {
        this.totalDistance = totalDistance;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    // --- Business Methods ---

    public void updateHighScore(Integer newScore) {
        if (newScore > this.highScore) {
            this.highScore = newScore;
        }
    }

    public void addCoins(Integer coins) {
        this.totalCoins += coins;
    }

    public void addDistance(Integer distance) {
        this.totalDistance += distance;
    }
}

