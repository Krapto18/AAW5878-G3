package pe.edu.upc.kidtd.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.kidtd.entities.QuestionsAnswers;

import java.util.List;

@Repository
public interface IQuestionsAnswersRepository extends JpaRepository<QuestionsAnswers,Integer> {
    @Query("SELECT q.question_text, ROUND(AVG(qa.answer_value), 2) AS avg_respuesta_alto_riesgo " +
            "FROM question_answers qa JOIN questions q ON qa.question_id = q.question_id " +
            "WHERE qa.user_id IN (SELECT user_id FROM predictions WHERE prediction_score > 70) " +
            "GROUP BY q.question_text ORDER BY avg_respuesta_alto_riesgo DESC LIMIT 10;")
    public List<String[]> PuntuacionPromedioRespuestasAltoRiesgo();
}
