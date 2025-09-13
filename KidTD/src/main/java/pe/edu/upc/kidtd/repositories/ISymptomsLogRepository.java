package pe.edu.upc.kidtd.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.kidtd.entities.SymptomsLog;

@Repository
public interface ISymptomsLogRepository extends JpaRepository<SymptomsLog,Integer> {
}
