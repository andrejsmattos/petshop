package repositories;

import models.Tutor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TutorRepository {

    private static List<Tutor> tutores = new ArrayList<>();

    private static int ultimoId;


}
