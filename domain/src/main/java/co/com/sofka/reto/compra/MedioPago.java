package co.com.sofka.reto.compra;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.reto.compra.value.MedioPagoFecha;
import co.com.sofka.reto.compra.value.MedioPagoId;
import co.com.sofka.reto.compra.value.MedioPagoNumero;
import co.com.sofka.reto.compra.value.MedioPagoTitular;

public class MedioPago extends Entity<MedioPagoId> {

    private MedioPagoNumero numero;
    private MedioPagoFecha fecha;
    private MedioPagoTitular titular;

    public MedioPago(MedioPagoId entityId, MedioPagoNumero numero, MedioPagoFecha fecha, MedioPagoTitular titular) {
        super(entityId);
        this.numero = numero;
        this.fecha = fecha;
        this.titular = titular;
    }

    public MedioPagoNumero numero() {
        return numero;
    }

    public MedioPagoFecha fecha() {
        return fecha;
    }

    public MedioPagoTitular titular() {
        return titular;
    }
}
