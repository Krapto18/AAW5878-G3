package pe.edu.upc.kidtd.dtos;

public class PrediccionPromedioDTO {
    private String mes; // TO_CHAR(predicted_at, 'YYYY-MM')
    private double scorePromedioMensual; // AVG(prediction_score)
    private int totalPredicciones;

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public double getScorePromedioMensual() {
        return scorePromedioMensual;
    }

    public void setScorePromedioMensual(double scorePromedioMensual) {
        this.scorePromedioMensual = scorePromedioMensual;
    }

    public int getTotalPredicciones() {
        return totalPredicciones;
    }

    public void setTotalPredicciones(int totalPredicciones) {
        this.totalPredicciones = totalPredicciones;
    }
}