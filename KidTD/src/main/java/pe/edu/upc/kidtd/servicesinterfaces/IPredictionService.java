package pe.edu.upc.kidtd.servicesinterfaces;

import pe.edu.upc.kidtd.entities.Prediction;

import java.util.List;

public interface IPredictionService {
    public List<Prediction> list();
    public void  insert(Prediction prediction);
    public void delete(int id);
    public void update(Prediction prediction);
    public Prediction findById(int id);
    public List<String[]> PrediccionPromedio();


}


