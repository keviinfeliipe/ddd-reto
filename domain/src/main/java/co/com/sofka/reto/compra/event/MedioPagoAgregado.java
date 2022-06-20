package co.com.sofka.reto.compra.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.compra.value.MedioPagoFecha;
import co.com.sofka.reto.compra.value.MedioPagoId;
import co.com.sofka.reto.compra.value.MedioPagoNumero;
import co.com.sofka.reto.compra.value.MedioPagoTitular;

public class MedioPagoAgregado extends DomainEvent {
    private final MedioPagoId entityId;
    private final MedioPagoNumero numero;
    private final MedioPagoFecha fecha;
    private final MedioPagoTitular titular;

    public MedioPagoAgregado(MedioPagoId entityId, MedioPagoNumero numero, MedioPagoFecha fecha, MedioPagoTitular titular) {
        super("sofka.compra.MediopagoAgregado");
        this.entityId = entityId;
        this.numero = numero;
        this.fecha = fecha;
        this.titular = titular;
    }

    public MedioPagoId getEntityId() {
        return entityId;
    }

    public MedioPagoNumero getNumero() {
        return numero;
    }

    public MedioPagoFecha getFecha() {
        return fecha;
    }

    public MedioPagoTitular getTitular() {
        return titular;
    }
}
