package co.com.sofka.reto.compra;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.reto.compra.event.*;
import co.com.sofka.reto.compra.value.CompraSaldo;

import java.util.HashSet;

public class CompraChange extends EventChange {
    public CompraChange(Compra compra) {
        apply((CompraCreada event)->{
            compra.saldo = event.getSaldo();
            compra.medioPagos = new HashSet<>();
            compra.membresias = new HashSet<>();
            compra.pagos = new HashSet<>();
        });

        apply((MembresiaAgregada event)->{
            compra.membresias.add(new Membresia(event.getId(),event.getTipo(),event.getValor()));
        });

        apply((PagoAgregado event)->{
            compra.pagos.add(new Pago(event.getEntityId(),event.getServicio(),event.getValor()));
        });

        apply((MedioPagoAgregado event) ->{
            compra.medioPagos.add(new MedioPago(event.getEntityId(),event.getNumero(),event.getFecha(), event.getTitular()));
        });

        apply((MembresiaQuitada event)->{
            var membresia = compra.obtenerMembresiaPorId(event.getId()).
                    orElseThrow(() -> new IllegalArgumentException("No se encontró la membresia"));
            compra.membresias().remove(membresia);
        });

        apply((MedioPagoQuitado event)->{
            var mediopago = compra.obtenerMedioPagoPorId(event.getId())
                    .orElseThrow(() -> new IllegalArgumentException("No se encontró el medio de pago"));
            compra.medioPagos().remove(mediopago);
        });
    }
}
