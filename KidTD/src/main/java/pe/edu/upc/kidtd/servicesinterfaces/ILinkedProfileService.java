package pe.edu.upc.kidtd.servicesinterfaces;

import pe.edu.upc.kidtd.entities.LinkedProfile;
import pe.edu.upc.kidtd.entities.Prediction;

import java.util.List;

public interface ILinkedProfileService {
    public List<LinkedProfile> list();
    public void  insert(LinkedProfile linkedProfile);
    public void delete(int id);
    public void update(LinkedProfile linkedProfile);
    public LinkedProfile findById(int id);
}
