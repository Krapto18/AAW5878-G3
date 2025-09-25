package pe.edu.upc.kidtd.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.kidtd.entities.Questions;

@Repository
public interface IQuestionsRepository extends JpaRepository<Questions,Integer> {
}
