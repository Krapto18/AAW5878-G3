package pe.edu.upc.kidtd.dtos;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class PredictionDTO {
    private int predictionId;
    private SymptomsLogDTO log;
    private int predictionScore;
    private String explanationText;
    private LocalDate predictedAt;

    public int getPredictionId() {
        return predictionId;
    }

    public void setPredictionId(int predictionId) {
        this.predictionId = predictionId;
    }

    public SymptomsLogDTO getLog() {
        return log;
    }

    public void setLog(SymptomsLogDTO log) {
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
