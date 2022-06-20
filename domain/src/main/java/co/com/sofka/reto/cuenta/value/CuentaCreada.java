package co.com.sofka.reto.cuenta.value;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.cuenta.Persona;

public class CuentaCreada extends DomainEvent {
    private final Persona persona;

    public CuentaCreada(Persona persona) {
        super("sofka.cuenta.CuentaCreada");
        this.persona = persona;
    }

    public Persona getPersona() {
        return persona;
    }
}
