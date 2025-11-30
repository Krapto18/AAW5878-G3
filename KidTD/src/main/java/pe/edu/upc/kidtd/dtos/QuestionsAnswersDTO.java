package pe.edu.upc.kidtd.dtos;

import pe.edu.upc.kidtd.entities.Questions;
import pe.edu.upc.kidtd.entities.User;

import java.util.Date;

public class QuestionsAnswersDTO {
    private int answer_id;
    private UsersDTO user;
    private Questions questions;
    private int answer_value;
    private Date answered_at;

    public int getAnswer_id() {
        return answer_id;
    }

    public void setAnswer_id(int answer_id) {
        this.answer_id = answer_id;
    }

    public UsersDTO getUser() {
        return user;
    }

    public void setUser(UsersDTO user) {
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
