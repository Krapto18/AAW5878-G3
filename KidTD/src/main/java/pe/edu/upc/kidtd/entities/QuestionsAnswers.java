package pe.edu.upc.kidtd.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "QuestionsAnswers")
public class QuestionsAnswers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int answer_id;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Questions questions;

    @Column(name = "answer_value", nullable = false, length = 255)
    private int answer_value;

    @Column(name = "answered_at", nullable = false)
    private Date answered_at;

    public QuestionsAnswers() {
    }

    public QuestionsAnswers(int answer_id, User user, Questions questions, int answer_value, Date answered_at) {
        this.answer_id = answer_id;
        this.user = user;
        this.questions = questions;
        this.answer_value = answer_value;
        this.answered_at = answered_at;
    }

    public int getAnswer_id() {
        return answer_id;
    }

    public void setAnswer_id(int answer_id) {
        this.answer_id = answer_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Questions getQuestions() {
        return questions;
    }

    public void setQuestions(Questions questions) {
        this.questions = questions;
    }

    public int getAnswer_value() {
        return answer_value;
    }

    public void setAnswer_value(int answer_value) {
        this.answer_value = answer_value;
    }

    public Date getAnswered_at() {
        return answered_at;
    }

    public void setAnswered_at(Date answered_at) {
        this.answered_at = answered_at;
    }
}
