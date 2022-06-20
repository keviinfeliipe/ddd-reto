package co.com.sofka.reto.cuenta.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.reto.cuenta.event.PasswordDePersonaCambiado;
import co.com.sofka.reto.cuenta.service.EnviarMensajeService;

import java.util.List;

public class NotificarMensajeUseCase extends UseCase<TriggeredEvent<PasswordDePersonaCambiado>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<PasswordDePersonaCambiado> event) {
        var evento = event.getDomainEvent();
        var servicio = getService(EnviarMensajeService.class).orElseThrow();
        servicio.enviarMenaje(evento.getEmail(),"Se modificó la contrase de la cuenta");
        emit().onResponse(new ResponseEvents(List.of()));
    }
}
