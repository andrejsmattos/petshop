package br.senai.lab365.petshop.controllers;


import br.senai.lab365.petshop.models.Tutor;
import br.senai.lab365.petshop.services.TutorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tutores")
public class TutorController {

    private final TutorService tutorService;

    public TutorController(TutorService tutorService){
        this.tutorService = tutorService;
    }

    @PostMapping()
    public ResponseEntity<String> cadastrar(@RequestBody Tutor tutor){
        tutorService.cadastrar(tutor);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Tutor cadastrado com sucesso!");
    }

    @GetMapping
    public List<Tutor> buscar (){
        return tutorService.listar();
    }

    @GetMapping("/{id}")
    public Tutor buscar(@PathVariable int id){
        return tutorService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable int id){
        return tutorService.deletarTutor(id)
                ? ResponseEntity.ok("Tutor removido com sucesso!")
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body("O tutor com este id não foi encontrado.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizar(@PathVariable int id, @RequestBody Tutor tutor){
        return tutorService.atualizar(id, tutor)
                ? ResponseEntity.ok("Tutor atualizado com sucesso!")
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body("O tutor com este id não foi encontrado.");
    }

}
