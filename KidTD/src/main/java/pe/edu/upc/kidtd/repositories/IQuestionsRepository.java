package pe.edu.upc.kidtd.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.kidtd.entities.Questions;

import java.util.List;

@Repository
public interface IQuestionsRepository extends JpaRepository<Questions,Integer> {
    @Query("SELECT q FROM Questions q WHERE q.questionnaire.questionnaire_id = :questionnaireId")
    List<Questions> buscarPorCuestionarioId(@Param("questionnaireId") int questionnaireId);
}
