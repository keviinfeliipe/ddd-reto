package co.com.sofka.reto.canal.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.canal.value.SuscriptorId;

public class SuscriptorQuitado extends DomainEvent {
    private final SuscriptorId suscriptorId;

    public SuscriptorQuitado(SuscriptorId suscriptorId) {
        super("sofka.canal.SuscriptorQuitado");
        this.suscriptorId = suscriptorId;
    }

    public SuscriptorId getSuscriptorId() {
        return suscriptorId;
    }
}
