package pe.edu.upc.kidtd.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.kidtd.entities.QuestionsAnswers;
import pe.edu.upc.kidtd.repositories.IQuestionsAnswersRepository;
import pe.edu.upc.kidtd.servicesinterfaces.IQuestionsAnswersService;

import java.util.List;

@Service
public class QuestionsAnswersImplement implements IQuestionsAnswersService {
    @Autowired
    private IQuestionsAnswersRepository repositoryAq;

    @Override
    public List<QuestionsAnswers> list() {
        return repositoryAq.findAll();
    }

    @Override
    public void insert(QuestionsAnswers questionsAnswers) {
        repositoryAq.save(questionsAnswers);
    }

    @Override
    public void delete(int id) {
        repositoryAq.deleteById(id);
    }

    @Override
    public void update(QuestionsAnswers questionsAnswers) {
        repositoryAq.save(questionsAnswers);
    }

    @Override
    public QuestionsAnswers findById(int id) {
        return repositoryAq.findById(id).orElse(null);
    }

//    @Override
//    public List<String[]> PuntuacionRespuestasAltoRiesgo() {
//        return repositoryAq.PuntuacionPromedioRespuestasAltoRiesgo();
//    }
}
