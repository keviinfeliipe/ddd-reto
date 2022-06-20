package co.com.sofka.reto.canal.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.canal.value.CanalDescripcion;

public class DescripcionCambiada extends DomainEvent {
    private final CanalDescripcion descripcion;

    public DescripcionCambiada(CanalDescripcion descripcion) {
        super("sofka.canal.DescripcionCambiada");
        this.descripcion = descripcion;
    }

    public CanalDescripcion getDescripcion() {
        return descripcion;
    }
}
