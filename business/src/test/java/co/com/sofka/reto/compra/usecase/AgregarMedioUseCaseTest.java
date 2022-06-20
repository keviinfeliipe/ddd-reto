package co.com.sofka.reto.compra.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.compra.MedioPagoFactory;
import co.com.sofka.reto.compra.command.AgregarMedioPagoCommand;
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


@ExtendWith(MockitoExtension.class)
class AgregarMedioUseCaseTest {

    @Mock
    DomainEventRepository repository;
    @InjectMocks
    AgregarMedioPagoUseCase useCase;
    @Test
    public void agregarMedioPago90(){
        //Arrange
        CompraId compraId = new CompraId();
        MedioPagoFactory factory = MedioPagoFactory.getInstance()
                .add(
                        MedioPagoId.of("MedioPago1"),
                        new MedioPagoNumero("11111111"),
                        new MedioPagoFecha(3,2027),
                        new MedioPagoTitular("Kevin Felipe Vargas")
                ).add(
                        MedioPagoId.of("MedioPago2"),
                        new MedioPagoNumero("2222222"),
                        new MedioPagoFecha(2,2023),
                        new MedioPagoTitular("Kevin Felipe Vargas")
                );


        var comando = new AgregarMedioPagoCommand(compraId,factory);
        when(repository.getEventsBy(compraId.value())).thenReturn(historico());
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