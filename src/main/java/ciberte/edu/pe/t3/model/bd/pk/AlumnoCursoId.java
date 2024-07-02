package ciberte.edu.pe.t3.model.bd.pk;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter @Setter
@Embeddable
public class AlumnoCursoId implements Serializable {
    private String idalumno;
    private String idcurso;
}
