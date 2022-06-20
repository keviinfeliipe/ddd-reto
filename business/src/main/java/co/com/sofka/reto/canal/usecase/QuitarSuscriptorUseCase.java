package co.com.sofka.reto.canal.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.reto.canal.Canal;
import co.com.sofka.reto.canal.command.QuitarSuscriptorCommand;

public class QuitarSuscriptorUseCase extends UseCase<RequestCommand<QuitarSuscriptorCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<QuitarSuscriptorCommand> command) {
        var comando = command.getCommand();
        var canal = Canal.from(comando.getCanalId(), repository().getEventsBy(comando.getCanalId().value()));
        canal.quitarSuscriptor(comando.getSuscriptorId());
        emit().onResponse(new ResponseEvents(canal.getUncommittedChanges()));
    }
}
