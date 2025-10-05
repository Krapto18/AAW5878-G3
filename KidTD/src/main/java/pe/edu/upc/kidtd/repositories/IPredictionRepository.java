package pe.edu.upc.kidtd.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.kidtd.entities.Prediction;

import java.util.List;

@Repository
public interface IPredictionRepository extends JpaRepository<Prediction, Integer> {
    @Query("SELECT TO_CHAR(predicted_at, 'YYYY-MM') AS mes, ROUND(AVG(prediction_score), 2) AS " +
            "score_promedio_mensual, COUNT(prediction_id) AS total_predicciones " +
            "FROM predictions GROUP BY mes ORDER BY mes;")
    public List<String[]> PrediccionPromedio();

}
