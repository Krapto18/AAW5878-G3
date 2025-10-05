package pe.edu.upc.kidtd.servicesinterfaces;

import pe.edu.upc.kidtd.entities.QuestionsAnswers;

import java.util.List;

public interface IQuestionsAnswersService {
    public List<QuestionsAnswers> list();
    public void insert(QuestionsAnswers questionsAnswers);
    public void delete(int id);
    public void update(QuestionsAnswers questionsAnswers);
    public QuestionsAnswers findById(int id);
    public List<String[]> PuntuacionRespuestasAltoRiesgo();
}
