package co.com.sofka.reto.compra.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.reto.compra.MembresiaFactory;
import co.com.sofka.reto.compra.value.CompraId;

public class AgregarMembresiaCommand extends Command {
    private final CompraId compraId;
    private final MembresiaFactory factory;

    public AgregarMembresiaCommand(CompraId compraId, MembresiaFactory factory) {
        this.compraId = compraId;
        this.factory = factory;
    }

    public CompraId getCompraId() {
        return compraId;
    }

    public MembresiaFactory getFactory() {
        return factory;
    }
}
