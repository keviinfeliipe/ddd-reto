package co.com.sofka.reto.canal.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.canal.Comunidad;
import co.com.sofka.reto.canal.command.CambiarDescripcionCommand;
import co.com.sofka.reto.canal.event.CanalCreado;
import co.com.sofka.reto.canal.event.DescripcionCambiada;
import co.com.sofka.reto.canal.value.CanalDescripcion;
import co.com.sofka.reto.canal.value.CanalId;
import co.com.sofka.reto.canal.value.ComunidadId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class CambiarDescripcionUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @InjectMocks
    CambiarDescripcionUseCase useCase;

    @Test
    public void cambiarDescripcionAlCanal(){
        //Arrange
        CanalId canalId = new CanalId();
        CanalDescripcion descripcion = new CanalDescripcion("Este canal esta dedicado a enseñar a cocinar");
        var comando = new CambiarDescripcionCommand(canalId,descripcion);
        when(repository.getEventsBy(canalId.value())).thenReturn(historico());
        useCase.addRepository(repository);
        //Act
        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase, new RequestCommand<>(comando))
                .orElseThrow()
                .getDomainEvents();
        var event = (DescripcionCambiada)events.get(0);
        //Assert
        Assertions.assertEquals("Este canal esta dedicado a enseñar a cocinar",event.getDescripcion().value());

    }

    private List<DomainEvent> historico() {
        ComunidadId comunidadId = ComunidadId.of("000000001");
        Comunidad comunidad = new Comunidad(comunidadId);
        CanalDescripcion descripcion = new CanalDescripcion("Este canal esta orientado a enseñar a programar");
        return List.of(new CanalCreado(comunidad,descripcion));
    }
}