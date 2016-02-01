/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persist;

import model.Persona;

/**
 *
 * @author hterrero
 */
public interface PersonaDAO extends GenericDAO<Persona, String> {
    public Persona findByUuid(String uuid);
    public Persona find(String id);
    
    
}
