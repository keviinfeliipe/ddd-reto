package co.com.sofka.reto.compra.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.reto.compra.value.CompraId;
import co.com.sofka.reto.compra.value.MedioPagoId;

public class QuitarMedioPagoCommand extends Command {
    private final CompraId compraId;
    private final MedioPagoId medioPagoId;

    public QuitarMedioPagoCommand(CompraId compraId, MedioPagoId id) {
        this.compraId = compraId;
        this.medioPagoId = id;
    }

    public CompraId getCompraId() {
        return compraId;
    }

    public MedioPagoId getMedioPagoId() {
        return medioPagoId;
    }
}
