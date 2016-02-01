/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.faces.bean.*;

import model.Persona;
import org.primefaces.model.StreamedContent;
import persist.PersonaDAOHibernate;
import service.PersonaService;
import util.ExportReport;

/**
 *
 * @author hterrero
 */
@ManagedBean
@RequestScoped
public class ViewPersonaBean implements Serializable {
    @ManagedProperty(value = "#{personaService}")
    private PersonaService personaService;
    private List<Persona> personas;


    public void setPersonaService(PersonaService personaService) {
        this.personaService = personaService;
    }

    //Session session;
   public String init() {
personas=personaService.findAll();
        return null;
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }
}
