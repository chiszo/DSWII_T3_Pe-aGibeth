package ciberte.edu.pe.t3.model.bd;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "alumno")
public class Alumno {
    @Id
    private String idalumno;
    private String apealumno;
    private String nomalumno;
    private String proce;

    @ManyToOne
    @JoinColumn(name = "idesp")
    private Especialidad especialidad;

    @OneToMany(mappedBy = "alumno",
            cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Set<Notas> notas = new HashSet<>();
}
