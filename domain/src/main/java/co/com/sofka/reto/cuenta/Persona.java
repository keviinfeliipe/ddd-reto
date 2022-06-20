package co.com.sofka.reto.cuenta;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.reto.cuenta.value.PersonaEmail;
import co.com.sofka.reto.cuenta.value.PersonaPassword;
import co.com.sofka.reto.cuenta.value.PersonaId;
import co.com.sofka.reto.cuenta.value.PersonaNombre;

public class Persona extends Entity<PersonaId> {
    private PersonaNombre nombre;
    private PersonaEmail email;
    private PersonaPassword password;

    public Persona(PersonaId entityId, PersonaNombre nombre, PersonaEmail email, PersonaPassword password) {
        super(entityId);
        this.nombre = nombre;
        this.email = email;
        this.password = password;
    }

    public PersonaNombre nombre() {
        return nombre;
    }

    public PersonaEmail email() {
        return email;
    }

    public PersonaPassword password() {
        return password;
    }

    public void actualizarNombre(PersonaNombre nombre){
        this.nombre=nombre;
    }

    public void actualizarPassword(PersonaPassword password){
        this.password = password;
    }

    public void actualizarEmail(PersonaEmail email){
        this.email = email;
    }

}
