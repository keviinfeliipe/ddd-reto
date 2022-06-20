package co.com.sofka.reto.cuenta.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.cuenta.value.NotificacionId;

public class NotificacionQuitada extends DomainEvent {
    private final NotificacionId id;

    public NotificacionQuitada(NotificacionId id) {
        super("sofka.cuenta.NotificacionQuitada");
        this.id = id;
    }

    public NotificacionId getId() {
        return id;
    }
}
