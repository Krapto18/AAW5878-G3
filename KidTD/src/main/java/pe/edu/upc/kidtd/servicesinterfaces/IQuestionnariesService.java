package pe.edu.upc.kidtd.servicesinterfaces;

import pe.edu.upc.kidtd.entities.Questionnaries;

import java.util.List;

public interface IQuestionnariesService {
    public List<Questionnaries> list();
    public void insert(Questionnaries questionnarie);

    public Questionnaries listId(int id);
    public void delete(int id);
    public void update(Questionnaries questionnarie);
}
