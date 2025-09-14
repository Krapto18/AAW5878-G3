package pe.edu.upc.kidtd.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.kidtd.dtos.ProfessionalDiagnosisDTO;
import pe.edu.upc.kidtd.entities.ProfessionalDiagnosis;
import pe.edu.upc.kidtd.servicesinterfaces.IProfessionalDiagnosisService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ProfessionalDiagnosis")
public class ProfessionalDiagnosisController {

    @Autowired
    private IProfessionalDiagnosisService pdService;

    @GetMapping
    public List<ProfessionalDiagnosisDTO> listProfessionalDiagnoses() {
        return pdService.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ProfessionalDiagnosisDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Integer id) {
        ProfessionalDiagnosis pd = pdService.findById(id);
        if (pd == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un diagnóstico con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        ProfessionalDiagnosisDTO dto = m.map(pd, ProfessionalDiagnosisDTO.class);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public void insertProfessionalDiagnosis(@RequestBody ProfessionalDiagnosisDTO dto) {
        ModelMapper m = new ModelMapper();
        ProfessionalDiagnosis pd = m.map(dto, ProfessionalDiagnosis.class);
        pdService.insert(pd);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProfessionalDiagnosis(@PathVariable("id") Integer id) {
        ProfessionalDiagnosis pd = pdService.findById(id);
        if (pd == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un diagnóstico con el ID: " + id);
        }
        pdService.delete(id);
        return ResponseEntity.ok("Diagnóstico con el ID " + id + " eliminado correctamente.");
    }

    @PutMapping
    public ResponseEntity<String> updateProfessionalDiagnosis(@RequestBody ProfessionalDiagnosisDTO dto) {
        ModelMapper m = new ModelMapper();
        ProfessionalDiagnosis pd = m.map(dto, ProfessionalDiagnosis.class);
        ProfessionalDiagnosis exist = pdService.findById(pd.getDiagnosisId());
        if (exist == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un diagnóstico con el ID: " + pd.getDiagnosisId());
        }
        pdService.update(pd);
        return ResponseEntity.ok("Diagnóstico con el ID " + pd.getDiagnosisId() + " modificado correctamente.");
    }
}
