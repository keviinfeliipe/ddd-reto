package co.com.sofka.reto.compra.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.reto.compra.Compra;
import co.com.sofka.reto.compra.command.AgregarMedioPagoCommand;

public class AgregarMedioPagoUseCase extends UseCase<RequestCommand<AgregarMedioPagoCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarMedioPagoCommand> command) {
        var comando = command.getCommand();
        var compra = Compra.from(comando.getCompraId(),repository().getEventsBy(comando.getCompraId().value()));
        compra.agregarMedioPagos(comando.getFactory());
        emit().onResponse(new ResponseEvents(compra.getUncommittedChanges()));
    }
}
