package co.com.sofka.reto.compra.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.reto.compra.Compra;
import co.com.sofka.reto.compra.command.AgregarPagoCommand;

public class AgregarPagoUseCase extends UseCase<RequestCommand<AgregarPagoCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarPagoCommand> command) {
        var comando = command.getCommand();
        var compra = Compra.from(comando.getCompraId(), repository().getEventsBy(comando.getCompraId().value()));
        compra.agregarPagos(comando.getFactory());
        emit().onResponse(new ResponseEvents(compra.getUncommittedChanges()));
    }
}
