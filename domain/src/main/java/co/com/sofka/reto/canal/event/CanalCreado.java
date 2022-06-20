package co.com.sofka.reto.canal.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.canal.Comunidad;
import co.com.sofka.reto.canal.value.CanalDescripcion;

public class CanalCreado extends DomainEvent {

    private final Comunidad comunidad;
    private final CanalDescripcion descripcion;

    public CanalCreado(Comunidad comunidad,CanalDescripcion descripcion) {
        super("sofka.canal.CanalCreado");
        this.comunidad = comunidad;
        this.descripcion = descripcion;
    }

    public CanalDescripcion getDescripcion() {
        return descripcion;
    }

    public Comunidad getComunidad() {
        return comunidad;
    }
}
