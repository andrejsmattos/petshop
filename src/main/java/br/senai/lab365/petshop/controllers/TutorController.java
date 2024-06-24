package br.senai.lab365.petshop.controllers;


import br.senai.lab365.petshop.models.Tutor;
import br.senai.lab365.petshop.services.TutorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tutores")
public class TutorController {

    private final TutorService tutorService;

    public TutorController(TutorService tutorService){
        this.tutorService = tutorService;
    }

    @PostMapping
    public ResponseEntity<String> cadastrar(@RequestBody Tutor tutor){
        tutorService.cadastrar(tutor);
        return
    }


}
