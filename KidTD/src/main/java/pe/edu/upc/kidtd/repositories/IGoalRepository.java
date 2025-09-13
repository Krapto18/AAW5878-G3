package pe.edu.upc.kidtd.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.kidtd.entities.Goal;

@Repository
public interface IGoalRepository extends JpaRepository<Goal,Integer> {
}
