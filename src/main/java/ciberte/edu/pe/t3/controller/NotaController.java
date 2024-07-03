package ciberte.edu.pe.t3.controller;

import ciberte.edu.pe.t3.model.dto.DtoEntity;
import ciberte.edu.pe.t3.model.dto.NotasDto;
import ciberte.edu.pe.t3.service.INotasService;
import ciberte.edu.pe.t3.util.DtoUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@PreAuthorize("hasRole('supervisor')")
@AllArgsConstructor
@RestController
@RequestMapping(path = "api/t3/notas")
public class NotaController {

    private INotasService iNotasService;

    @GetMapping("/pubs-dto")
    public ResponseEntity<List<DtoEntity>> obtenerNotas(){
        List<DtoEntity>notasDtoList = new ArrayList<>();
        notasDtoList = iNotasService.listarNotas()
                .stream()
                .map(x -> new DtoUtil().convertirADto(x,new NotasDto()))
                .collect(Collectors.toList());
        if(notasDtoList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(notasDtoList, HttpStatus.OK);
    }
}
