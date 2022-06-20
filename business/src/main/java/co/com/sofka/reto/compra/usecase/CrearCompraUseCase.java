package co.com.sofka.reto.compra.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.reto.compra.Compra;
import co.com.sofka.reto.compra.command.CrearCompraCommand;
import co.com.sofka.reto.compra.value.CompraId;

public class CrearCompraUseCase extends UseCase<RequestCommand<CrearCompraCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearCompraCommand> command) {
        var comando = command.getCommand();
        var compra = new Compra(new CompraId(),comando.getSaldo());
        emit().onResponse(new ResponseEvents(compra.getUncommittedChanges()));
    }
}
