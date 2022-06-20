package co.com.sofka.reto.compra;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.reto.canal.value.SuscriptorFecha;
import co.com.sofka.reto.compra.value.*;

import java.time.LocalDate;

public class Pago extends Entity<PagoId> {
    private PagoServicio servicio;
    private PagoFecha fecha;
    private PagoValor valor;
    private PagoHabilitar habilitar;

    public Pago(PagoId entityId, PagoServicio servicio, PagoValor valor) {
        super(entityId);
        this.servicio = servicio;
        this.fecha = new PagoFecha(LocalDate.now().getDayOfMonth(), LocalDate.now().getMonth().getValue(),LocalDate.now().getYear());
        this.valor = valor;
        this.habilitar = new PagoHabilitar(true);
    }

    public PagoServicio servicio() {
        return servicio;
    }

    public PagoFecha fecha() {
        return fecha;
    }

    public PagoValor valor() {
        return valor;
    }

    public PagoHabilitar habilitar() {
        return habilitar;
    }
}
