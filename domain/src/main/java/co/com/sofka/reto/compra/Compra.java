package co.com.sofka.reto.compra;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.compra.event.*;
import co.com.sofka.reto.compra.value.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Compra extends AggregateEvent<CompraId> {

    protected Set<Membresia> membresias;
    protected Set<Pago> pagos ;
    protected Set<MedioPago>  medioPagos;
    protected CompraSaldo saldo;

    public Compra(CompraId entityId, CompraSaldo saldo) {
        super(entityId);
        subscribe(new CompraChange(this));
        appendChange(new CompraCreada(saldo)).apply();
    }

    private Compra(CompraId entityId) {
        super(entityId);
        subscribe(new CompraChange(this));
    }

    public static Compra from(CompraId id, List<DomainEvent> events){
        var compra = new Compra(id);
        events.forEach(compra::applyEvent);
        return compra;
    }

    public void agregarMembresias(MembresiaFactory factory){
        factory.membresias().forEach(membresia -> appendChange(new MembresiaAgregada(membresia.identity(), membresia.tipo(), membresia.valor())).apply());
    }

    public Optional<Membresia> obtenerMembresiaPorId(MembresiaId id){
        return membresias()
                .stream()
                .filter(membresia -> membresia.identity().equals(id))
                .findFirst();
    }

    public void quitarMembresia(MembresiaId id){
        Objects.requireNonNull(id);
        appendChange(new MembresiaQuitada(id)).apply();
    }

    public void agregarPago(PagoId pagoId, PagoServicio servicio, PagoValor valor){
        Objects.requireNonNull(pagoId);
        Objects.requireNonNull(servicio);
        Objects.requireNonNull(valor);
        appendChange(new PagoAgregado(pagoId,servicio,valor)).apply();
    }

    public void agregarPagos(PagoFactory factory){
        factory.pagos().forEach(pago -> appendChange(new PagoAgregado(pago.identity(),pago.servicio(),pago.valor())).apply());
    }

    public Optional<Pago> obtenerPagoPorId(PagoId id){
        return pagos()
                .stream()
                .filter(membresia -> membresia.identity().equals(id))
                .findFirst();
    }

    public void agregarMedioPagos(MedioPagoFactory factory){
        factory.pagos().forEach(medioPago -> appendChange(new MedioPagoAgregado(medioPago.identity(),medioPago.numero(),medioPago.fecha(),medioPago.titular())).apply());
    }

    public void quitarMedioPago(MedioPagoId id){
        appendChange(new MedioPagoQuitado(id)).apply();
    }

    public Optional<MedioPago> obtenerMedioPagoPorId(MedioPagoId id){
        return medioPagos()
                .stream()
                .filter(membresia -> membresia.identity().equals(id))
                .findFirst();
    }

    public Set<Membresia> membresias() {
        return membresias;
    }

    public Set<Pago> pagos() {
        return pagos;
    }

    public Set<MedioPago> medioPagos() {
        return medioPagos;
    }

    public CompraSaldo saldo() {
        return saldo;
    }
}
