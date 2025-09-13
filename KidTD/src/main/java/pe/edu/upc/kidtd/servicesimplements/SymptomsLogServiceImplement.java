package pe.edu.upc.kidtd.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.kidtd.entities.SymptomsLog;
import pe.edu.upc.kidtd.repositories.ISymptomsLogRepository;
import pe.edu.upc.kidtd.servicesinterfaces.ISymptomsLogService;

import java.util.List;
@Service
public class SymptomsLogServiceImplement implements ISymptomsLogService {
    @Autowired
    private ISymptomsLogRepository repositorySL;
    @Override
    public List<SymptomsLog> list() {
        return repositorySL.findAll();
    }

    @Override
    public void insert(SymptomsLog symptomsLog) {
            repositorySL.save(symptomsLog);
    }

    @Override
    public void delete(int id) {
            repositorySL.deleteById(id);
    }

    @Override
    public void update(SymptomsLog symptomsLog) {
            repositorySL.save(symptomsLog);
    }

    @Override
    public SymptomsLog findById(int id) {
        return repositorySL.findById(id).orElse(null);
    }
}
