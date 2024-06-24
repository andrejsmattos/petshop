package br.senai.lab365.petshop.services;

import br.senai.lab365.petshop.models.Tutor;
import br.senai.lab365.petshop.repositories.TutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TutorService {

    private final TutorRepository tutorRepository;

    public TutorService(TutorRepository tutorRepository){
        this.tutorRepository = tutorRepository;
    }

    public void cadastrar(Tutor tutor) {
        tutorRepository.adicionarTutor(tutor);
    }

    public List<Tutor> listar(){
        return tutorRepository.listar();
    }

    public Tutor buscarPorId(int id){
        return tutorRepository.listarTutorPorId(id);
    }

    public boolean deletarTutor(int id){
        var tutorExcluir = tutorRepository.listarTutorPorId(id);
        if(tutorExcluir != null){
            tutorRepository.removerTutor(tutorExcluir);
            return true;
        }
        return false;
    }

    public boolean atualizar (int id, Tutor tutorAtualizado){
        Tutor tutorExistente = tutorRepository.listarTutorPorId(id);
        if (tutorExistente != null){
            tutorExistente.setNome(tutorAtualizado.getNome());
            tutorExistente.setTelefone(tutorAtualizado.getTelefone());
            tutorExistente.setEmail(tutorAtualizado.getEmail());
            return true;
        }
        return false;
    }

}
