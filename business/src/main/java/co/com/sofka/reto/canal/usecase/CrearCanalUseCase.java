package co.com.sofka.reto.canal.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.reto.canal.Canal;
import co.com.sofka.reto.canal.command.CrearCanalCommand;
import co.com.sofka.reto.canal.value.CanalId;

public class CrearCanalUseCase extends UseCase<RequestCommand<CrearCanalCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearCanalCommand> command) {
        var comando = command.getCommand();
        var canal = new Canal(new CanalId(),comando.getComunidad(),comando.getDescripcion());
        emit().onResponse(new ResponseEvents(canal.getUncommittedChanges()));
    }
}
