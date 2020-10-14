package br.com.Normando.NBancoDig.controller;


import br.com.Normando.NBancoDig.store.SaveFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping(value="/files")
public class FileUploadController {

    @Autowired
    private SaveFile saveFile;

    @PostMapping
    private void upload(@RequestParam MultipartFile file) {
     saveFile.salvarFoto(file);

    }

}
