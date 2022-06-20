package co.com.sofka.reto.canal.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.reto.canal.Comunidad;
import co.com.sofka.reto.canal.command.CrearCanalCommand;
import co.com.sofka.reto.canal.event.CanalCreado;
import co.com.sofka.reto.canal.value.CanalDescripcion;
import co.com.sofka.reto.canal.value.CanalId;
import co.com.sofka.reto.canal.value.ComunidadId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CrearCanalUseCaseTest {

    @Test
    public void crearCanal(){
        //Arrange
        CanalId canalId = new CanalId();
        ComunidadId comunidadId = ComunidadId.of("000000001");
        Comunidad comunidad = new Comunidad(comunidadId);
        CanalDescripcion descripcion = new CanalDescripcion("Este canal esta orientado a enseñar a programar");
        var comando = new CrearCanalCommand( canalId, comunidad, descripcion);
        var usecase = new CrearCanalUseCase();
        //Act
        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(usecase,new RequestCommand<>(comando))
                .orElseThrow()
                .getDomainEvents();
        var event = (CanalCreado)events.get(0);
        //Assert
        Assertions.assertEquals("000000001", event.getComunidad().identity().value());
        Assertions.assertEquals("Este canal esta orientado a enseñar a programar", event.getDescripcion().value());
    }

}