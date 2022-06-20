package co.com.sofka.reto.cuenta.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.cuenta.value.PersonaNombre;

public class NombreDePersonaCambiado extends DomainEvent {
    private final PersonaNombre nombre;

    public NombreDePersonaCambiado(PersonaNombre nombre) {
        super("sofka.cuenta.NombreDePersonaCambiado");
        this.nombre = nombre;
    }

    public PersonaNombre getNombre() {
        return nombre;
    }
}
