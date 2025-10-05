package pe.edu.upc.kidtd.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.kidtd.entities.Prediction;
import pe.edu.upc.kidtd.repositories.IPredictionRepository;
import pe.edu.upc.kidtd.servicesinterfaces.IPredictionService;

import java.util.List;

@Service
public class PredictionServiceImplement implements IPredictionService {
    @Autowired
    private IPredictionRepository predictionRepository;
    @Override
    public List<Prediction> list() {
        return predictionRepository.findAll();
    }

    @Override
    public void insert(Prediction prediction) {
        predictionRepository.save(prediction);
    }

    @Override
    public void delete(int id) {
        predictionRepository.deleteById(id);
    }

    @Override
    public void update(Prediction prediction) {
        predictionRepository.save(prediction);
    }

    @Override
    public Prediction findById(int id) {
        return predictionRepository.findById(id).orElse(null);
    }

    @Override
    public List<String[]> PrediccionPromedio() {
        return predictionRepository.PrediccionPromedio();
    }

}
