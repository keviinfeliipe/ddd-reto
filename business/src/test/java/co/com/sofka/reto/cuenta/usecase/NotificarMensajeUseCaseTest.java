package co.com.sofka.reto.cuenta.usecase;

import co.com.sofka.business.generic.ServiceBuilder;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.reto.cuenta.event.PasswordDePersonaCambiado;
import co.com.sofka.reto.cuenta.service.EnviarMensajeService;
import co.com.sofka.reto.cuenta.value.PersonaEmail;
import co.com.sofka.reto.cuenta.value.PersonaPassword;
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
class NotificarMensajeUseCaseTest {

    @Mock
    EnviarMensajeService service;
    @InjectMocks
    NotificarMensajeUseCase useCase;
    @Test
    public void enviarCoreo(){
        //Arrange
        PersonaEmail email = new PersonaEmail("kf11.vargas@gmail.com");
        PersonaPassword password = new PersonaPassword("12345*");
        var evento = new PasswordDePersonaCambiado(email,password);
        doNothing().when(service).enviarMenaje(any(),any());
        useCase.addServiceBuilder(new ServiceBuilder().addService(service));
        //Act
        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase,new TriggeredEvent<>(evento))
                .orElseThrow()
                .getDomainEvents();
        //Assert
        Mockito.verify(service).enviarMenaje(any(),any());
        Assertions.assertEquals(0,events.size());

    }

}