package co.com.sofka.reto.canal.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.canal.Comunidad;
import co.com.sofka.reto.canal.VideoFactory;
import co.com.sofka.reto.canal.command.AgregarVideoCommand;
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
class AgregarVideoUseCaseTest {
    @Mock
    DomainEventRepository repository;
    @InjectMocks
    AgregarVideoUseCase useCase;
    @Test
    public void agregarVideoAlCanal(){
        //Arrange
        CanalId canalId = new CanalId();
        VideoFactory factory = VideoFactory.getInstance()
                .add(
                        VideoId.of("Video1"),
                        new VideoCategoria("Educativo"),
                        new VideoMultimedia("Video1")
                ).add(
                        VideoId.of("Video2"),
                        new VideoCategoria("Musica"),
                        new VideoMultimedia("Video2")
                );
        var comando = new AgregarVideoCommand(canalId, factory);
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