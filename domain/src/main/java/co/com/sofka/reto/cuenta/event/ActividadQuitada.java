package co.com.sofka.reto.cuenta.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.cuenta.value.ActividadId;

public class ActividadQuitada extends DomainEvent {
    private final ActividadId id;

    public ActividadQuitada(ActividadId id) {
        super("sofka.cuenta.ActividadQuitada");
        this.id = id;
    }

    public ActividadId getId() {
        return id;
    }
}
