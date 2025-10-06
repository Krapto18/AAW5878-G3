package pe.edu.upc.kidtd.servicesinterfaces;

import pe.edu.upc.kidtd.entities.SymptomsLog;

import java.util.List;

public interface ISymptomsLogService {
    public List<SymptomsLog> list();
    public void insert(SymptomsLog symptomsLog);
    public void delete(int id);
    public void update(SymptomsLog symptomsLog);
    public SymptomsLog findById(int id);
    public List<String[]> CumplimientoDeRegistroDeSintomas();
}
