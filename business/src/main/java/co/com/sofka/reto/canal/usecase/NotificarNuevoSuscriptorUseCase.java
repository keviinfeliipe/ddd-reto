package co.com.sofka.reto.canal.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.reto.canal.event.SuscriptorAgregado;
import co.com.sofka.reto.canal.service.EnviarNotificacionService;

import java.util.List;

public class NotificarNuevoSuscriptorUseCase extends UseCase<TriggeredEvent<SuscriptorAgregado>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<SuscriptorAgregado> event) {
        var evento = event.getDomainEvent();
        var servicio = getService(EnviarNotificacionService.class).orElseThrow();
        servicio.enviarNotificacion(evento.getCanalId(),"Tiene un nuevo suscriptor.");
        emit().onResponse(new ResponseEvents(List.of()));
    }
}
