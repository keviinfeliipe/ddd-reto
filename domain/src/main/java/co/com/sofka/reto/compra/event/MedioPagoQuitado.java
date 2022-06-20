package co.com.sofka.reto.compra.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.compra.value.MedioPagoId;

public class MedioPagoQuitado extends DomainEvent {
    private final MedioPagoId id;

    public MedioPagoQuitado(MedioPagoId id) {
        super("sofka.reto.MedioPagoQuitado");
        this.id = id;
    }

    public MedioPagoId getId() {
        return id;
    }
}
