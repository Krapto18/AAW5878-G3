package pe.edu.upc.kidtd.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Questions")
public class Questions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int question_id;

    @ManyToOne
    @JoinColumn(name = "questionnaire_id")
    private Questionnaries questionnaire;

    @Column(name = "question_text", nullable = false, length = 255)
    private String question_text;

    public Questions() {
    }

    public Questions(int question_id, Questionnaries questionnaire, String question_text) {
        this.question_id = question_id;
        this.questionnaire = questionnaire;
        this.question_text = question_text;
    }

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
