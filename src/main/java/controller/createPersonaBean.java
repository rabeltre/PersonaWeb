package controller;

import model.Persona;
import service.PersonaService;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.Serializable;

/**
 * Created by rabeltre on 23-Jan-16.
 */

@ManagedBean
@ViewScoped
public class createPersonaBean implements Serializable{
    private Persona persona;
    @ManagedProperty(value = "#{personaService}")
    private PersonaService personaService;
    private String id;
private boolean accion;
    private String titulo ="Iniciado";

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public boolean isAccion() {
        return accion;
    }

    public void setAccion(boolean accion) {
        this.accion = accion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {

        this.id = id;
    }

    public void setPersonaService(PersonaService personaService) {
        this.personaService = personaService;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public String init(){
        if(this.getId()!=null){
            this.persona = personaService.find(this.getId());
            this.accion= true;
            this.titulo = "Actualizar y eliminar persona";

        }
        else{
            persona =new Persona();
            this.accion =false;
            this.titulo = "Crear  persona";

        }
return null;

    }




    public void onSave1() throws IOException {
personaService.save(getPersona());
        FacesContext.getCurrentInstance().getExternalContext().redirect("/");


    }
    public String onSave(){
        personaService.save(this.getPersona());
   return "viewPersona?faces-redirect=true";


    }
    public String onDelete(){
        personaService.delete(this.getPersona());
        return "viewPersona?faces-redirect=true";


    }


}
