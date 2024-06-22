package services;

import models.Pet;
import org.springframework.stereotype.Service;
import repositories.PetRepository;

@Service
public class PetService {

    private final PetRepository petRepository;

    public PetService(PetRepository petRepository){
        this.petRepository = petRepository;
    }

    public void cadastrar(Pet pet) {

    }

    public Pet listar() {
        return null;
    }


    public String deletar(int id) {
    }

    public boolean atualizar(int id) {
        return false;
    }
}
