package pe.edu.upc.kidtd.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "\"Questionnaries\"")
public class Questionnaries {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int questionnaire_id;

    @Column(name = "title", nullable = false, length = 80)
    private String title;

    @Column(name = "version_number", nullable = false, length = 12)
    private int version_number;

    public Questionnaries() {

    }
    public Questionnaries(int questionnaire_id, String title, int version_number) {
        this.questionnaire_id = questionnaire_id;
        this.title = title;
        this.version_number = version_number;

    }

    public int getQuestionnaire_id() {
        return questionnaire_id;
    }

    public void setQuestionnaire_id(int questionnaire_id) {
        this.questionnaire_id = questionnaire_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getVersion_number() {
        return version_number;
    }

    public void setVersion_number(int version_number) {
        this.version_number = version_number;
    }
}
