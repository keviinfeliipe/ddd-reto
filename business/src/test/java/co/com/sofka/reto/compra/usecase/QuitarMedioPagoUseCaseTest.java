package co.com.sofka.reto.compra.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.compra.command.QuitarMedioPagoCommand;
import co.com.sofka.reto.compra.event.CompraCreada;
import co.com.sofka.reto.compra.event.MedioPagoAgregado;
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
class QuitarMedioPagoUseCaseTest {
    @Mock
    DomainEventRepository repository;
    @InjectMocks
    QuitarMedioPagoUseCase useCase;
    @Test
    public void quitarMedioPago(){
        //Arrange
        CompraId compraId= new CompraId();
        MedioPagoId medioPagoId = MedioPagoId.of("Nequi");
        var comando = new QuitarMedioPagoCommand(compraId,medioPagoId);
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
                new MedioPagoAgregado(
                        MedioPagoId.of("Nequi"),
                        new MedioPagoNumero("11111111"),
                        new MedioPagoFecha(3,2027),
                        new MedioPagoTitular("Kevin Felipe Vargas")
                ),
                new MedioPagoAgregado(
                        MedioPagoId.of("RappyPay"),
                        new MedioPagoNumero("22222222"),
                        new MedioPagoFecha(3,2027),
                        new MedioPagoTitular("Kevin Felipe Vargas")
                )
        );
    }

}