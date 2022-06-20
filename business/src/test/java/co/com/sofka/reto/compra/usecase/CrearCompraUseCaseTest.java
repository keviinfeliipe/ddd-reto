package co.com.sofka.reto.compra.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.reto.compra.command.CrearCompraCommand;
import co.com.sofka.reto.compra.event.CompraCreada;
import co.com.sofka.reto.compra.value.CompraId;
import co.com.sofka.reto.compra.value.CompraSaldo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CrearCompraUseCaseTest {

    @Test
    public void crearCompra(){
        //Arrange
        CompraId compraId = new CompraId();
        CompraSaldo saldo = new CompraSaldo(10000);
        var comando = new CrearCompraCommand(compraId,saldo);
        var usecase = new CrearCompraUseCase();
        //Act
        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(usecase, new RequestCommand<>(comando))
                .orElseThrow()
                .getDomainEvents();
        var event = (CompraCreada)events.get(0);
        //Assert
        Assertions.assertEquals(10000,event.getSaldo().value());

    }
}