package ciberte.edu.pe.t3.repository;

import ciberte.edu.pe.t3.model.bd.Notas;
import ciberte.edu.pe.t3.model.bd.pk.AlumnoCursoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotasRepository extends JpaRepository<Notas, AlumnoCursoId> {
}
