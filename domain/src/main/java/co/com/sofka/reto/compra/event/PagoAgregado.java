package co.com.sofka.reto.compra.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.compra.value.*;

public class PagoAgregado extends DomainEvent {
    private final PagoId entityId;
    private final PagoServicio servicio;
    private final PagoValor valor;

    public PagoAgregado(PagoId entityId, PagoServicio servicio, PagoValor valor) {
        super("sofka.compra.PagoAgregado");
        this.entityId = entityId;
        this.servicio = servicio;
        this.valor = valor;
    }

    public PagoId getEntityId() {
        return entityId;
    }

    public PagoServicio getServicio() {
        return servicio;
    }

    public PagoValor getValor() {
        return valor;
    }

}
