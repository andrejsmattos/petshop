package controllers;

import models.Pet;
import org.springframework.web.bind.annotation.*;
import services.PetService;

import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetController {

    private final PetService petService;


    public PetController(PetService petService) {
        this.petService = petService;
    }

    @PostMapping()
    public void cadastrar(@RequestBody Pet pet){
        petService.cadastrar(pet);
    }

    @GetMapping()
    public List<Pet> buscar() {
//        var pets = petService.listar();
//        if (pets.isEmpty()){
//            // return 404
//            return null;
//        } else {
//            return pets;
//        }
        return List.of();
    }

    @GetMapping("/{id}")
    public String buscar(@PathVariable int id){
        return petService.excluir(id);
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable int id){
        return petService.deletar(id)
                ? "Excluído com sucesso!"
                : "O pet com este id não foi encontrado.";
    }

    @PutMapping("/{id}")
    public String atualizar(@PathVariable int id){
        return petService.atualizar(id)
                ? "Atualizado com sucesso"
                : "O pet com este id não foi encontrado.";
    }
}
