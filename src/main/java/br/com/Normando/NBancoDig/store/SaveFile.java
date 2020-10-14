package br.com.Normando.NBancoDig.store;



import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;


@Component
public class SaveFile {

    // salvar no diretorio da app
    private String raiz=  System.getProperty("user.dir");;
    private String dirFiles = "files";

    public void salvarFoto(MultipartFile file) {
        this.salvar(this.dirFiles, file);
    }
    public void salvar(String diretorio, MultipartFile arquivo) {
        Path diretorioPath = Paths.get(this.raiz, diretorio);
        Path arquivoPath = diretorioPath.resolve(arquivo.getOriginalFilename());

        try {
            Files.createDirectories(diretorioPath);
            arquivo.transferTo(arquivoPath.toFile());
        } catch (IOException e) {
            throw new RuntimeException("Erro ao salvar arquivo.", e);
        }
    }
}
