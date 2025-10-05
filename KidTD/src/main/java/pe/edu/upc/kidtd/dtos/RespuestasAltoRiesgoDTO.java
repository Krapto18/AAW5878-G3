package pe.edu.upc.kidtd.dtos;

public class RespuestasAltoRiesgoDTO {
    private String question_text;
    private double avg_respuesta_alto_riesgo;

    public String getQuestion_text() {
        return question_text;
    }

    public void setQuestion_text(String question_text) {
        this.question_text = question_text;
    }

    public double getAvg_respuesta_alto_riesgo() {
        return avg_respuesta_alto_riesgo;
    }

    public void setAvg_respuesta_alto_riesgo(double avg_respuesta_alto_riesgo) {
        this.avg_respuesta_alto_riesgo = avg_respuesta_alto_riesgo;
    }
}