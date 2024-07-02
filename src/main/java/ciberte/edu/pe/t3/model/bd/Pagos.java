package ciberte.edu.pe.t3.model.bd;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "pagos")
public class Pagos {
    @Id
    private String idalumno;
    @Id
    private String ciclo;
    @Id
    private Integer ncuota;
    private Double monto;
    private Date fecha;
    @ManyToOne
    @JoinColumn(name = "idalumno")
    private Alumno alumno;
}
