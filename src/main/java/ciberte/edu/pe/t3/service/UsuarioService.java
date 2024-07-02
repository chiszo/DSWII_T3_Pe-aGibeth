package ciberte.edu.pe.t3.service;

import ciberte.edu.pe.t3.model.bd.Usuario;
import ciberte.edu.pe.t3.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UsuarioService implements IUsuarioService{

    UsuarioRepository usuarioRepository;

    @Override
    public Usuario obtenerUsuarioPorNomUsuario(String nomususario) {
        return usuarioRepository.findByNomusuario(nomususario);
    }
}
