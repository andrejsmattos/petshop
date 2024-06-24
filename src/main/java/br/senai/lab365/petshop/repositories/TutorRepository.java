package br.senai.lab365.petshop.repositories;

import br.senai.lab365.petshop.models.Tutor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TutorRepository {

    private static List<Tutor> tutores = new ArrayList<>();
    private static int ultimoId;

    public List<Tutor> listar(){
        return tutores;
    }

    public Tutor listarTutorPorId(int id){
        return tutores.stream()
                .filter(tutor -> id == tutor.getId())
                .findFirst()
                .orElse(null);
    }

    public void adicionarTutor(Tutor tutor){
        tutor.setId(++ultimoId);
        tutores.add(tutor);
    }

    public void removerTutor(Tutor tutor){
        tutores.remove(tutor);
    }

}
