package ciberte.edu.pe.t3.model.bd;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "especialidad")
public class Especialidad {
    @Id
    private String idesp;
    private String nomesp;
    private Double costo;
}
