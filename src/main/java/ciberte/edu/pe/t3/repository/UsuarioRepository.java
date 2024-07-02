package ciberte.edu.pe.t3.repository;

import ciberte.edu.pe.t3.model.bd.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
    Usuario findByNomusuario(String nomusuario);
    Usuario findByNombres(String nombres);
}
