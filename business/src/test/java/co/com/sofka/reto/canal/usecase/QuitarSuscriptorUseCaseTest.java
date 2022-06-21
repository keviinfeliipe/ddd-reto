package co.com.sofka.reto.canal.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.canal.Comunidad;
import co.com.sofka.reto.canal.command.QuitarSuscriptorCommand;
import co.com.sofka.reto.canal.event.CanalCreado;
import co.com.sofka.reto.canal.event.SuscriptorAgregado;
import co.com.sofka.reto.canal.value.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class QuitarSuscriptorUseCaseTest {
    @Mock
    DomainEventRepository repository;

    @InjectMocks
    QuitarSuscriptorUseCase useCase;

    @Test
    public void quitarSuscritor() {
        //Arrange
        CanalId canalId = new CanalId();
        SuscriptorId suscriptorId = SuscriptorId.of("Suscriptor1");
        var comando = new QuitarSuscriptorCommand(canalId,suscriptorId);
        when(repository.getEventsBy(canalId.value())).thenReturn(historico());
        useCase.addRepository(repository);
        //Act
        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase, new RequestCommand<>(comando))
                .orElseThrow()
                .getDomainEvents();
        //Assert
        Assertions.assertEquals(1, events.size());
    }

    private List<DomainEvent> historico() {
        ComunidadId comunidadId = new ComunidadId();
        Comunidad comunidad = new Comunidad(comunidadId);
        CanalDescripcion descripcion = new CanalDescripcion("Este canal esta orientado a enseñar a programar");
        return List.of(
                new CanalCreado(comunidad,descripcion),
                new SuscriptorAgregado(
                        CanalId.of("Canal1"),
                        SuscriptorId.of("Suscriptor1"),
                        new SuscriptorTipo(SuscriptorTipo.Tipos.PREMIUN),
                        CanalId.of("CanalSuscriptor1")
                )
        );
    }
}

