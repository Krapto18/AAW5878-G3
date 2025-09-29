package pe.edu.upc.kidtd.dtos;

import pe.edu.upc.kidtd.entities.User;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class PredictionDTO {
    private int predictionId;
    private User user;
    private DecimalFormat predictionScore;
    private String explanationText;
    private LocalDate predictedAt;

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

    public DecimalFormat getPredictionScore() {
        return predictionScore;
    }

    public void setPredictionScore(DecimalFormat predictionScore) {
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
