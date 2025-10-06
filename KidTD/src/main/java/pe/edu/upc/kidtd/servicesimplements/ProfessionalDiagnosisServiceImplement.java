package pe.edu.upc.kidtd.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.kidtd.entities.ProfessionalDiagnosis;
import pe.edu.upc.kidtd.repositories.IProfessionalDiagnosisRepository;
import pe.edu.upc.kidtd.servicesinterfaces.IProfessionalDiagnosisService;

import java.util.List;

@Service
public class ProfessionalDiagnosisServiceImplement implements IProfessionalDiagnosisService {

    @Autowired
    private IProfessionalDiagnosisRepository repositoryPD;

    @Override
    public List<ProfessionalDiagnosis> list() {
        return repositoryPD.findAll();
    }

    @Override
    public void insert(ProfessionalDiagnosis diagnosis) {
        repositoryPD.save(diagnosis);
    }

    @Override
    public void delete(int id) {
        repositoryPD.deleteById(id);
    }

    @Override
    public void update(ProfessionalDiagnosis diagnosis) {
        repositoryPD.save(diagnosis);
    }

    @Override
    public ProfessionalDiagnosis findById(int id) {
        return repositoryPD.findById(id).orElse(null);
    }

    @Override
    public List<String[]> DiagnosticoProfesionalvsSistema() {
        return repositoryPD.DiagnisticoProfesionalvsPrediccionSistema();
    }
}
