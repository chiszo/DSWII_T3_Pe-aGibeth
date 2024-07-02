package ciberte.edu.pe.t3.service;


import ciberte.edu.pe.t3.model.bd.Rol;
import ciberte.edu.pe.t3.model.bd.Usuario;
import ciberte.edu.pe.t3.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service
public class DetalleUsuarioService implements UserDetailsService {
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        Usuario usuario = obtenerUsuarioXNombreusuario(username);
        return autenticacionUsuario(
                usuario,obtenerListaRoles(usuario.getRoles())
        );
    }

    public Usuario obtenerUsuarioXNombreusuario(String nomusuario){
        return usuarioRepository.findByNomusuario(nomusuario);
    }

    public List<GrantedAuthority>obtenerListaRoles(Set<Rol> roles){
        List<GrantedAuthority> authorityList = new ArrayList<>();
        for (Rol rol : roles){
            authorityList.add(new
                    SimpleGrantedAuthority("ROLE_"+ rol.getNomrol()));
        }
        return authorityList;
    }

    private UserDetails autenticacionUsuario(
            Usuario usuario, List<GrantedAuthority> authorityList
    ){
        return new User(
                usuario.getNomusuario(),
                usuario.getPassword(),
                usuario.getActivo(),
                true,true,true,
                authorityList
        );
    }
}
