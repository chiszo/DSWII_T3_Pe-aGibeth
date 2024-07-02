package ciberte.edu.pe.t3.repository;

import ciberte.edu.pe.t3.model.bd.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RolRepository extends JpaRepository<Rol,Integer> {
    Rol findByNomrol(String nomrol);
}
