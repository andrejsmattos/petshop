package br.senai.lab365.petshop.services;

import br.senai.lab365.petshop.models.Pet;
import org.springframework.stereotype.Service;
import br.senai.lab365.petshop.repositories.PetRepository;

import java.util.List;

@Service
public class PetService {

    private final PetRepository petRepository;

    public PetService(PetRepository petRepository){
        this.petRepository = petRepository;
    }

    public void cadastrar(Pet pet) {
        petRepository.adicionarPet(pet);
    }

    public List<Pet> listar() {
        return petRepository.listar();
    }

    public Pet buscarPorId(int id) {
        return petRepository.listarPetPorId(id);
    }

    public boolean atualizar(int id, Pet petAtualizado) {
        Pet petExistente = petRepository.listarPetPorId(id);
        if (petExistente != null) {
            petExistente.setNome(petAtualizado.getNome());
            petExistente.setEspecie(petAtualizado.getEspecie());
            petExistente.setRaca(petAtualizado.getRaca());
            petExistente.setSexo(petAtualizado.getSexo());
            petExistente.setDataNascimento(petAtualizado.getDataNascimento());
            petExistente.setPeso(petAtualizado.getPeso());
            return true;
        }
        return false;
    }

    public boolean deletarPet(int id) {
        var petExcluir = petRepository.listarPetPorId(id);
        if (petExcluir != null) {
            petRepository.removerPet(petExcluir);
            return true;
        }
        return false;
    }


}
