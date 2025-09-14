package pe.edu.upc.kidtd.servicesinterfaces;

import pe.edu.upc.kidtd.entities.Goal;
import pe.edu.upc.kidtd.entities.SymptomsLog;

import java.util.List;

public interface IGoalService {
    public List<Goal> list();
    public void insert(Goal goal);
    public void delete(int id);
    public void update(Goal goal);
    public Goal findById(int id);
}
