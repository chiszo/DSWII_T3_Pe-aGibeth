package ciberte.edu.pe.t3.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class FileService implements IFileService{

    private final Path pathFolder= Paths.get("uploads");

    private void validarExtension(String filename) throws Exception {
        String extension = filename.substring(filename.lastIndexOf('.') + 1).toLowerCase();
        if (!extension.equals("docx")) {
            throw new Exception("Extensión de archivo inválida. Se esperaba un archivo .doc.");
        }
    }

    private void validarTamanoArchivo(MultipartFile archivo) throws Exception {
        long maxSizeBytes = 2 * 1024 * 1024;
        if (archivo.getSize() > maxSizeBytes) {
            throw new Exception("El archivo ha excedido el tamaño máximo de 2MB.");
        }
    }

    @Override
    public void guardarArchivo(MultipartFile archivo) throws Exception {
        Files.copy(archivo.getInputStream(),
                this.pathFolder.resolve(archivo.getOriginalFilename()));
    }

    @Override
    public void guardarArchivos(List<MultipartFile> archivoList) throws Exception {
        for (MultipartFile archivo : archivoList) {
            validarExtension(archivo.getOriginalFilename());
            validarTamanoArchivo(archivo);
            this.guardarArchivo(archivo);
        }
    }
}
