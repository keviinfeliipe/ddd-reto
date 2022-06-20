package co.com.sofka.reto.compra.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.reto.compra.value.CompraId;
import co.com.sofka.reto.compra.value.MembresiaId;

public class QuitarMembresiaCommand extends Command {
    private final CompraId compraId;
    private final MembresiaId membresiaId;

    public QuitarMembresiaCommand(CompraId compraId, MembresiaId membresiaId) {
        this.compraId = compraId;
        this.membresiaId = membresiaId;
    }

    public CompraId getCompraId() {
        return compraId;
    }

    public MembresiaId getMembresiaId() {
        return membresiaId;
    }
}
