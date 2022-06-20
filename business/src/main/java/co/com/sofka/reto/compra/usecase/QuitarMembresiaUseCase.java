package co.com.sofka.reto.compra.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.reto.compra.Compra;
import co.com.sofka.reto.compra.command.QuitarMembresiaCommand;

public class QuitarMembresiaUseCase extends UseCase<RequestCommand<QuitarMembresiaCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<QuitarMembresiaCommand> command) {
        var comando = command.getCommand();
        var compra = Compra.from(comando.getCompraId(), repository().getEventsBy(comando.getCompraId().value()));
        compra.quitarMembresia(comando.getMembresiaId());
        emit().onResponse(new ResponseEvents(compra.getUncommittedChanges()));
    }
}
