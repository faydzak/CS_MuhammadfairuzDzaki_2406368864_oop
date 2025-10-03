package com.CaseStudy.demo.Model;

import jakarta.persistence.*;
import java.util.UUID;
@Entity
@Table (name = "scores")
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "score_id")
    private UUID scoreId;

    @Column(name = "player_id", nullable = false)
    private UUID playerId;

    // Defines the relationship: Many Scores to One Player
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "player_id", insertable = false, updatable = false)
    private Player player;

    // ... other fields and methods
}