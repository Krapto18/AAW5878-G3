package pe.edu.upc.kidtd.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.kidtd.entities.LinkedProfile;
import pe.edu.upc.kidtd.entities.Prediction;
import pe.edu.upc.kidtd.repositories.ILinkedProfileRepository;
import pe.edu.upc.kidtd.servicesinterfaces.ILinkedProfileService;

import java.util.List;
@Service
public class LinkedProfileImplement implements ILinkedProfileService {
    @Autowired
    private ILinkedProfileRepository iLinkedProfileRepository;
    @Override
    public List<LinkedProfile> list() {
        return iLinkedProfileRepository.findAll();
    }

    @Override
    public void insert(LinkedProfile linkedProfile) {
        iLinkedProfileRepository.save(linkedProfile);
    }

    @Override
    public void delete(int id) {
        iLinkedProfileRepository.deleteById(id);
    }

    @Override
    public void update(LinkedProfile linkedProfile) {
        iLinkedProfileRepository.save(linkedProfile);
    }

    @Override
    public LinkedProfile findById(int id) {
        return iLinkedProfileRepository.findById(id).orElse(null);
    }
}
