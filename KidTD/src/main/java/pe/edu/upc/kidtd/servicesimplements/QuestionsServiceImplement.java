package pe.edu.upc.kidtd.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.kidtd.entities.Questions;
import pe.edu.upc.kidtd.repositories.IQuestionsRepository;
import pe.edu.upc.kidtd.servicesinterfaces.IQuestionsService;

import java.util.List;
@Service
public class QuestionsServiceImplement implements IQuestionsService {
    @Autowired
    private IQuestionsRepository repositoryQ;

    @Override
    public List<Questions> list() {
        return repositoryQ.findAll();
    }

    @Override
    public void insert(Questions questions) {
        repositoryQ.save(questions);
    }

    @Override
    public void delete(int id) {
        repositoryQ.deleteById(id);
    }

    @Override
    public void update(Questions questions) {
        repositoryQ.save(questions);
    }

    @Override
    public Questions findById(int id) {
        return repositoryQ.findById(id).orElse(null);
    }

    @Override
    public List<Questions> search(int questionnaireId) {
        return repositoryQ.buscarPorCuestionarioId(questionnaireId);
    }
}
