package co.com.sofka.reto.compra.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.compra.command.QuitarMembresiaCommand;
import co.com.sofka.reto.compra.event.CompraCreada;
import co.com.sofka.reto.compra.event.MembresiaAgregada;
import co.com.sofka.reto.compra.value.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class QuitarMembresiaUseCaseTest {

    @Mock
    DomainEventRepository repository;
    @InjectMocks
    QuitarMembresiaUseCase useCase;
    @Test
    public void quitarMembresia(){
        //Arrange
        CompraId compraId= new CompraId();
        MembresiaId membresiaId = MembresiaId.of("YouTube");
        var comando = new QuitarMembresiaCommand(compraId,membresiaId);
        when(repository.getEventsBy(comando.getCompraId().value())).thenReturn(historico());
        useCase.addRepository(repository);
        //Act
        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase,new RequestCommand<>(comando))
                .orElseThrow()
                .getDomainEvents();
        //Assert
        Assertions.assertEquals(1, events.size());
    }

    private List<DomainEvent> historico() {
        CompraSaldo saldo = new CompraSaldo(10000);
        return List.of(
                new CompraCreada(saldo),
                new MembresiaAgregada(
                        MembresiaId.of("YouTube"),
                        new MembresiaTipo(MembresiaTipo.Membresias.PREMIUN),
                        new MembresiaValor(16000)
                )
        );

    }
}