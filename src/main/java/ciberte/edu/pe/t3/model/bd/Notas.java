package ciberte.edu.pe.t3.model.bd;

import ciberte.edu.pe.t3.model.bd.pk.AlumnoCursoId;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "notas")
public class Notas {
    @EmbeddedId
    private AlumnoCursoId alumnoCursoId;
    private Double exaparcial;
    private Double exafinal;

    @ManyToOne
    @MapsId("idalumno")
    @JoinColumn(name = "idalumno")
    @JsonBackReference
    private Alumno alumno;

    @ManyToOne
    @MapsId("idcurso")
    @JoinColumn(name = "idcurso")
    @JsonBackReference
    private Curso curso;

}
