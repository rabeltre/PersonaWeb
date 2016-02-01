package service;

import model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persist.PersonaDAO;

import java.util.List;

/**
 * Created by rabeltre on 16-Jan-16.
 */
@Service("personaService")
public class PersonaService {
   @Autowired
    private PersonaDAO personaDao;

    public List<Persona> findAll() {
        return personaDao.findAll();
    }

    public void save (Persona persona){
        personaDao.makePersistent(persona);

    }
    public Persona find(String id){
        return personaDao.find(id);
    }

    public void delete(Persona persona){
        personaDao.makeTransient(persona);
    }
//Este es un comentario
}
