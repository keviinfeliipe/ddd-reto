package co.com.sofka.reto.compra.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.reto.compra.value.CompraId;
import co.com.sofka.reto.compra.value.CompraSaldo;

public class CrearCompraCommand extends Command {
    private final CompraId id;
    private final CompraSaldo saldo;

    public CrearCompraCommand(CompraId id, CompraSaldo saldo) {
        this.id = id;
        this.saldo = saldo;
    }

    public CompraId getId() {
        return id;
    }

    public CompraSaldo getSaldo() {
        return saldo;
    }
}
