package pe.edu.upc.kidtd.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.kidtd.entities.Prediction;

import java.util.List;

@Repository
public interface IPredictionRepository extends JpaRepository<Prediction, Integer> {
    @Query("SELECT TO_CHAR(p.predictedAt, 'YYYY-MM') AS mes, \n" +
            "ROUND(AVG(p.predictionScore), 2) AS score_promedio_mensual, \n" +
            "COUNT(p.predictionId) AS total_predicciones FROM Prediction p\n" +
            "GROUP BY mes ORDER BY mes")
    public List<String[]> PrediccionPromedio();

}
