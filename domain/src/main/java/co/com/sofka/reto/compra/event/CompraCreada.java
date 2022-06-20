package co.com.sofka.reto.compra.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.compra.value.CompraSaldo;

public class CompraCreada extends DomainEvent {
    private final CompraSaldo saldo;

    public CompraCreada(CompraSaldo saldo) {
        super("sofka.compra.CompraCreada");
        this.saldo = saldo;
    }

    public CompraSaldo getSaldo() {
        return saldo;
    }
}
