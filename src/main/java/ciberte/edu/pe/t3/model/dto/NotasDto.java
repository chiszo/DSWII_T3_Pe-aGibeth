package ciberte.edu.pe.t3.model.dto;

import lombok.Data;

@Data
public class NotasDto implements DtoEntity{
    private Double exaparcial;
    private Double exafinal;
    private String nomcursoCurso;
    private String apealumnoAlumno;
    private String nomalumnoAlumno;
}
