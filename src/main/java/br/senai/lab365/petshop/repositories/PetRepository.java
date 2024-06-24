package br.senai.lab365.petshop.repositories;

import br.senai.lab365.petshop.models.Pet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PetRepository {

    private static final List<Pet> pets = new ArrayList<>();
    private static int ultimoId;

    public List<Pet> listar(){
        return pets;
    }

    public Pet listarPetPorId(int id){
        return pets.stream()
                .filter(pet -> id == pet.getId())
                .findFirst()
                .orElse(null);
    }

    public void adicionarPet(Pet pet) {
        pet.setId(++ultimoId);
        pets.add(pet);
    }

    public void deletarPetPorId(int id){
        pets.removeIf(pet -> id == pet.getId());
    }

    public void removerPet(Pet pet) {
        pets.remove(pet);
    }

}
