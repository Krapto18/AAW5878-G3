package pe.edu.upc.kidtd.servicesinterfaces;

import pe.edu.upc.kidtd.entities.Questions;

import java.util.List;

public interface IQuestionsService {
    public List<Questions> list();
    public void insert(Questions questions);
    public void delete(int id);
    public void update(Questions questions);
    public Questions findById(int id);
}
