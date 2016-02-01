

package model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Past;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Persona implements Serializable{

    private String id;

    @NotBlank
    @Length(max = 20, min = 5)
    private String nombre;
    @NotBlank
    @Length(max = 20, min = 5)
    private String apellido;

    @Past
    private Date fechaNacimiento;

    @Email(message = "Este email no es valido caco de mano")
    private String email;
    private Status status;
    private Set<PersonDetail> personDetail = new HashSet<>();


    public Persona()
    {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Set<PersonDetail> getPersonDetail() {
        return personDetail;
    }

    public void setPersonDetail(Set<PersonDetail> personDetail) {
        this.personDetail = personDetail;
    }

    public void addPersonDetail(PersonDetail personDetail) {
        personDetail.setPersona(this);
        getPersonDetail().add(personDetail);
    }


}