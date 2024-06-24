package br.senai.lab365.petshop.controllers;

import br.senai.lab365.petshop.models.Pet;
import br.senai.lab365.petshop.services.PetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetController {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @PostMapping()
    public ResponseEntity<String> cadastrar(@RequestBody Pet pet){
        petService.cadastrar(pet);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Pet cadastrado com sucesso!");
    }


    @GetMapping()
    public List<Pet> buscar() {
        return petService.listar();
    }

    @GetMapping("/{id}")
    public Pet buscar(@PathVariable int id){
        return petService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable int id){
        return petService.deletarPet(id)
                ? ResponseEntity.ok("Pet removido com sucesso!")
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body("O pet com este id não foi encontrado.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizar(@PathVariable int id, @RequestBody Pet pet){
        return petService.atualizar(id, pet)
                ? ResponseEntity.ok("Pet atualizado com sucesso!")
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body("O pet com este id não foi encontrado.");
    }
}
