package pe.edu.upc.kidtd.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.kidtd.entities.Questionnaries;
import pe.edu.upc.kidtd.repositories.IQuestionnariesRepository;
import pe.edu.upc.kidtd.servicesinterfaces.IQuestionnariesService;

import java.util.List;

@Service
public class QuestionnariesServiceImplement implements IQuestionnariesService {
    @Autowired
    private IQuestionnariesRepository qR;

    @Override
    public List<Questionnaries> list() {
        return qR.findAll();
    }

    @Override
    public void insert(Questionnaries questionnarie) {
        qR.save(questionnarie);
    }

    @Override
    public Questionnaries listId(int id) {
        return qR.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        qR.deleteById(id);
    }

    @Override
    public void update(Questionnaries questionnarie) {
        qR.save(questionnarie);
    }
}
