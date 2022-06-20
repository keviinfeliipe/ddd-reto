package co.com.sofka.reto.compra.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.reto.compra.PagoFactory;
import co.com.sofka.reto.compra.value.*;

public class AgregarPagoCommand extends Command {
    private final CompraId compraId;
    private final PagoFactory factory;


    public AgregarPagoCommand(CompraId compraId, PagoFactory factory) {
        this.compraId = compraId;
        this.factory = factory;
    }

    public CompraId getCompraId() {
        return compraId;
    }

    public PagoFactory getFactory() {
        return factory;
    }
}
