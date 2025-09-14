package pe.edu.upc.kidtd.dtos;

import pe.edu.upc.kidtd.entities.Questionnaries;

public class QuestionsDTO {
    private int question_id;
    private Questionnaries questionnaire;
    private String question_text;

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public Questionnaries getQuestionnaire() {
        return questionnaire;
    }

    public void setQuestionnaire(Questionnaries questionnaire) {
        this.questionnaire = questionnaire;
    }

    public String getQuestion_text() {
        return question_text;
    }

    public void setQuestion_text(String question_text) {
        this.question_text = question_text;
    }
}
