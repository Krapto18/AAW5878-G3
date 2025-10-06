package pe.edu.upc.kidtd.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.kidtd.dtos.CumplimientoMetasDTO;
import pe.edu.upc.kidtd.dtos.CumplimientoRegistroSintomasDTO;
import pe.edu.upc.kidtd.dtos.SymptomsLogDTO;
import pe.edu.upc.kidtd.entities.SymptomsLog;
import pe.edu.upc.kidtd.servicesinterfaces.ISymptomsLogService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/SymptomsLog")
public class SymptomsLogController {
    @Autowired
    private ISymptomsLogService slS;

    @GetMapping
    public List<SymptomsLogDTO> listSymptomsLogs() {
        return slS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x, SymptomsLogDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    public void insertSymptomsLog(@RequestBody SymptomsLogDTO s){
        ModelMapper m = new ModelMapper();
        SymptomsLog symptomsLog=m.map(s, SymptomsLog.class);
        slS.insert(symptomsLog);
    }

    @PutMapping
    public ResponseEntity<String> updateSymptomsLog(@RequestBody SymptomsLogDTO dto) {
        ModelMapper m = new ModelMapper();
        SymptomsLog sl = m.map(dto, SymptomsLog.class);
        SymptomsLog exist = slS.findById(sl.getLogId());
        if (exist == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un registro con el ID: " + sl.getLogId());
        }
        slS.update(sl);
        return ResponseEntity.ok("Registro con ID " + sl.getLogId() + " modificado correctamente.");
    }
    @GetMapping("/query6")
    public ResponseEntity<?> CumplimientoRegistroSintomas() {
        List<CumplimientoRegistroSintomasDTO> qDto = new ArrayList<>();
        List<String[]> lic = slS.CumplimientoDeRegistroDeSintomas();

        if (lic.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No hay data");
        }

        for (String[] columna:lic) {

            CumplimientoRegistroSintomasDTO dto = new CumplimientoRegistroSintomasDTO();
            dto.setMood_entry(columna[0]);
            dto.setCantidad(Integer.parseInt(columna[1]));
            dto.setPorcentaje(Double.parseDouble(columna[2]));
            qDto.add(dto);
        }
        return ResponseEntity.ok(qDto);
    }

}
