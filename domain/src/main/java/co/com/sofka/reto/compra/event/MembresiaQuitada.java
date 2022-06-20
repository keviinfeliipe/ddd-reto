package co.com.sofka.reto.compra.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.compra.value.MembresiaId;

public class MembresiaQuitada extends DomainEvent {
    private final MembresiaId id;

    public MembresiaQuitada(MembresiaId id) {
        super("sofka.compra.MembresiaQuitada");
        this.id = id;
    }

    public MembresiaId getId() {
        return id;
    }
}
