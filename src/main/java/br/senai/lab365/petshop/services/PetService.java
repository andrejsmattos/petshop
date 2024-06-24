package br.senai.lab365.petshop.services;

import br.senai.lab365.petshop.models.Pet;
import br.senai.lab365.petshop.models.Tutor;
import org.springframework.stereotype.Service;
import br.senai.lab365.petshop.repositories.PetRepository;
import br.senai.lab365.petshop.repositories.TutorRepository;


import java.util.List;

@Service
public class PetService {

    private final PetRepository petRepository;
    private final TutorRepository tutorRepository;

    public PetService(PetRepository petRepository, TutorRepository tutorRepository){
        this.petRepository = petRepository;
        this.tutorRepository = tutorRepository;
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

    public boolean vincularPetAoTutor(int petId, int tutorId) {
        Tutor tutor = tutorRepository.listarTutorPorId(tutorId);
        if (tutor != null) {
            petRepository.vincularPetAoTutor(petId, tutor);
            return true;
        }
        return false;
    }


}
