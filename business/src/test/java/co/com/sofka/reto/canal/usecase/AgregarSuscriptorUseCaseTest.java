package co.com.sofka.reto.canal.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.canal.Comunidad;
import co.com.sofka.reto.canal.SuscriptorFactory;
import co.com.sofka.reto.canal.command.AgregarSuscriptorCommand;
import co.com.sofka.reto.canal.event.CanalCreado;
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
class AgregarSuscriptorUseCaseTest {

    @Mock
    DomainEventRepository repository;
    @InjectMocks
    AgregarSuscriptorUseCase useCase;
    @Test
    public void agregarSuscriptorAlCanal(){
        //Arrange
        CanalId canalId = new CanalId();
        SuscriptorFactory factory = SuscriptorFactory.getInstance()
                .add(
                        CanalId.of("Canal1"),
                        SuscriptorId.of("Suscriptor1"),
                        new SuscriptorTipo(SuscriptorTipo.Tipos.BASIC),
                        CanalId.of("CanalSuscriptor1")
                ).add(
                        CanalId.of("Canal1"),
                        SuscriptorId.of("Suscriptor2"),
                        new SuscriptorTipo(SuscriptorTipo.Tipos.PREMIUN),
                        CanalId.of("CanalSuscriptor2")
                );

        var comando = new AgregarSuscriptorCommand(canalId, factory);
        when(repository.getEventsBy(canalId.value())).thenReturn(historico());
        useCase.addRepository(repository);
        //act
        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase, new RequestCommand<>(comando))
                .orElseThrow()
                .getDomainEvents();
        //Assert
        Assertions.assertEquals(2, events.size());
    }

    private List<DomainEvent> historico() {
        ComunidadId comunidadId = ComunidadId.of("000000001");
        Comunidad comunidad = new Comunidad(comunidadId);
        CanalDescripcion descripcion = new CanalDescripcion("Este canal esta orientado a enseñar a programar");
        return List.of(new CanalCreado(comunidad,descripcion));
    }
}