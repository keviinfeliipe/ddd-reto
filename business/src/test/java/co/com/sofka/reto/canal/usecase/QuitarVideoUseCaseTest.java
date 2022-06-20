package co.com.sofka.reto.canal.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.canal.Comunidad;
import co.com.sofka.reto.canal.command.QuitarVideoCommand;
import co.com.sofka.reto.canal.event.CanalCreado;
import co.com.sofka.reto.canal.event.SuscriptorAgregado;
import co.com.sofka.reto.canal.event.VideoAgregado;
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
class QuitarVideoUseCaseTest {
    @Mock
    DomainEventRepository repository;

    @InjectMocks
    QuitarVideoUseCase useCase;

    @Test
    public void cambiarDescripcionAlCanal() {
        //Arrange
        CanalId canalId = new CanalId();
        VideoId videoId = VideoId.of("Video1");
        var comando = new QuitarVideoCommand(canalId,videoId);
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
                new VideoAgregado(
                        VideoId.of("Video1"),
                        new VideoCategoria("Educativo"),
                        new VideoMultimedia("xxxxxxx")
                ),
                new SuscriptorAgregado(
                        SuscriptorId.of("Suscriptor1"),
                        new SuscriptorTipo(SuscriptorTipo.Tipos.PREMIUN),
                        CanalId.of("Canal1")
                )
        );
    }
}