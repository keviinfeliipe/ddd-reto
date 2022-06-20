package co.com.sofka.reto.compra.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.reto.compra.MedioPagoFactory;
import co.com.sofka.reto.compra.value.*;

public class AgregarMedioPagoCommand extends Command {
    private final CompraId compraId;
    private final MedioPagoFactory factory;

    public AgregarMedioPagoCommand(CompraId compraId, MedioPagoFactory factory) {
        this.compraId = compraId;
        this.factory = factory;
    }

    public CompraId getCompraId() {
        return compraId;
    }

    public MedioPagoFactory getFactory() {
        return factory;
    }
}
