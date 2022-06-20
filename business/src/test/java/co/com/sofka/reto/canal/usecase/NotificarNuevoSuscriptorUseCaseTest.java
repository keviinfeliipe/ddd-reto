package co.com.sofka.reto.canal.usecase;

import co.com.sofka.business.generic.ServiceBuilder;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.reto.canal.SuscriptorNuevoNotificado;
import co.com.sofka.reto.canal.service.EnviarNotificacionService;
import co.com.sofka.reto.canal.value.CanalId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;

@ExtendWith({MockitoExtension.class})
class NotificarNuevoSuscriptorUseCaseTest {
    @Mock
    EnviarNotificacionService service;
    @InjectMocks
    NotificarNuevoSuscriptorUseCase useCase;

    @Test
    public void enviarCoreo() {
        //Arrange
        CanalId canalId = CanalId.of("Canal1");
        var evento = new SuscriptorNuevoNotificado(canalId);
        doNothing().when(service).enviarNotificacion(any(), any());
        useCase.addServiceBuilder(new ServiceBuilder().addService(service));
        //Act
        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase, new TriggeredEvent<>(evento))
                .orElseThrow()
                .getDomainEvents();
        //Assert
        Mockito.verify(service).enviarNotificacion(any(), any());
        Assertions.assertEquals(0, events.size());
    }
}