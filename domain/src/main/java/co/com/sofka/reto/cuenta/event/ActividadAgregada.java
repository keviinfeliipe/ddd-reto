package co.com.sofka.reto.cuenta.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.cuenta.value.ActividadDescripcion;
import co.com.sofka.reto.cuenta.value.ActividadId;
import co.com.sofka.reto.cuenta.value.ActividadTipo;
import co.com.sofka.reto.cuenta.value.ActividadVinculo;

public class ActividadAgregada extends DomainEvent {

    private final ActividadId actividadId;
    private final ActividadTipo tipo;
    private final ActividadDescripcion descripcion;
    private final ActividadVinculo vinculo;

    public ActividadAgregada(ActividadId actividadId, ActividadTipo tipo, ActividadDescripcion descripcion, ActividadVinculo vinculo) {
        super("sofka.cuenta.ActividadAgregada");
        this.actividadId = actividadId;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.vinculo = vinculo;
    }

    public ActividadId getActividadId() {
        return actividadId;
    }

    public ActividadTipo getTipo() {
        return tipo;
    }

    public ActividadDescripcion getDescripcion() {
        return descripcion;
    }

    public ActividadVinculo getVinculo() {
        return vinculo;
    }

}
