package pe.edu.upc.kidtd.entities;

import jakarta.persistence.*;

import java.text.DecimalFormat;
import java.time.LocalDate;

@Entity
@Table(name = "Prediction")
public class Prediction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int predictionId;
    @ManyToOne
    @JoinColumn(name="userId")
    private User user;
    @Column(name = "predictionScore", nullable = false)
    private int predictionScore;
    @Column(name="explanationText", nullable = false)
    private String explanationText;
    @Column(name="predictedAt",nullable = false)
    private LocalDate predictedAt;

    public Prediction() {
    }

    public Prediction(int predictionId, User user, int predictionScore, String explanationText, LocalDate predictedAt) {
        this.predictionId = predictionId;
        this.user = user;
        this.predictionScore = predictionScore;
        this.explanationText = explanationText;
        this.predictedAt = predictedAt;
    }

    public int getPredictionId() {
        return predictionId;
    }

    public void setPredictionId(int predictionId) {
        this.predictionId = predictionId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getPredictionScore() {
        return predictionScore;
    }

    public void setPredictionScore(int predictionScore) {
        this.predictionScore = predictionScore;
    }

    public String getExplanationText() {
        return explanationText;
    }

    public void setExplanationText(String explanationText) {
        this.explanationText = explanationText;
    }

    public LocalDate getPredictedAt() {
        return predictedAt;
    }

    public void setPredictedAt(LocalDate predictedAt) {
        this.predictedAt = predictedAt;
    }
}
