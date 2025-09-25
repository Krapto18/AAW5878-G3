package pe.edu.upc.kidtd.servicesinterfaces;

import pe.edu.upc.kidtd.entities.ProfessionalDiagnosis;
import java.util.List;

public interface IProfessionalDiagnosisService {
    public List<ProfessionalDiagnosis> list();
    public void insert(ProfessionalDiagnosis diagnosis);
    public void delete(int id);
    public void update(ProfessionalDiagnosis diagnosis);
    public ProfessionalDiagnosis findById(int id);
}
