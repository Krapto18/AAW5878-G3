package pe.edu.upc.kidtd.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.kidtd.entities.Goal;
import pe.edu.upc.kidtd.repositories.IGoalRepository;
import pe.edu.upc.kidtd.servicesinterfaces.IGoalService;

import java.util.List;
@Service
public class GoalServiceImplement implements IGoalService {
    @Autowired
    private IGoalRepository gS;
    @Override
    public List<Goal> list() {
        return gS.findAll();
    }

    @Override
    public void insert(Goal goal) {
        gS.save(goal);
    }

    @Override
    public void delete(int id) {
        gS.deleteById(id);
    }

    @Override
    public void update(Goal goal) {
        gS.save(goal);
    }

    @Override
    public Goal findById(int id) {
        return gS.findById(id).orElse(null);
    }

    @Override
    public List<String[]> CumplimientoMetas() {
        return gS.CumplimientoMetas();
    }
}
