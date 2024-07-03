package ciberte.edu.pe.t3.service;

import ciberte.edu.pe.t3.model.bd.Notas;
import ciberte.edu.pe.t3.repository.NotasRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class NotasService implements INotasService{
    NotasRepository notasRepository;

    @Override
    public List<Notas> listarNotas() {
        return notasRepository.findAll();
    }
}
