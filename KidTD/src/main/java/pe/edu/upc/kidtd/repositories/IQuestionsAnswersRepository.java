package pe.edu.upc.kidtd.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.kidtd.entities.QuestionsAnswers;

@Repository
public interface IQuestionsAnswersRepository extends JpaRepository<QuestionsAnswers,Integer> {
}
