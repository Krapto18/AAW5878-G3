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
    @JoinColumn(name="logId")
    private SymptomsLog log;
    @Column(name = "predictionScore", nullable = false)
    private int predictionScore;
    @Column(name="explanationText", nullable = false)
    private String explanationText;
    @Column(name="predictedAt",nullable = false)
    private LocalDate predictedAt;

    public Prediction() {
    }

    public Prediction(int predictionId, SymptomsLog log, int predictionScore, LocalDate predictedAt, String explanationText) {
        this.predictionId = predictionId;
        this.log = log;
        this.predictionScore = predictionScore;
        this.predictedAt = predictedAt;
        this.explanationText = explanationText;
    }

    public int getPredictionId() {
        return predictionId;
    }

    public void setPredictionId(int predictionId) {
        this.predictionId = predictionId;
    }

    public SymptomsLog getLog() {
        return log;
    }

    public void setLog(SymptomsLog log) {
        this.log = log;
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
