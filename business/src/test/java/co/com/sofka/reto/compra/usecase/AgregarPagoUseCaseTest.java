package co.com.sofka.reto.compra.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.compra.PagoFactory;
import co.com.sofka.reto.compra.command.AgregarPagoCommand;
import co.com.sofka.reto.compra.event.CompraCreada;
import co.com.sofka.reto.compra.value.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith({MockitoExtension.class})
class AgregarPagoUseCaseTest {
    @Mock
    DomainEventRepository repository;
    @InjectMocks
    AgregarPagoUseCase useCase;
    @Test
    public void agregarPago(){
        //Arrage
        CompraId  compraId =  new CompraId();
        PagoFactory factory = PagoFactory.getInstance()
                .add(
                        PagoId.of("Pago1"),
                        new PagoServicio(PagoServicio.Servicios.MENBRESIA),
                        new PagoValor(16000)
                ).add(
                        PagoId.of("Pago2"),
                        new PagoServicio(PagoServicio.Servicios.MENBRESIA),
                        new PagoValor(12000)
                );

        var comando = new AgregarPagoCommand(compraId,factory);
        when(repository.getEventsBy(comando.getCompraId().value())).thenReturn(historico());
        useCase.addRepository(repository);

        //Act
        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase,new RequestCommand<>(comando))
                .orElseThrow()
                .getDomainEvents();
        //Assert
        Assertions.assertEquals(2, events.size());

    }

    private List<DomainEvent> historico() {
        CompraSaldo saldo = new CompraSaldo(10000);
        return List.of(
                new CompraCreada(saldo)
        );
    }
}