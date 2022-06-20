package co.com.sofka.reto.compra;

import co.com.sofka.reto.compra.value.PagoId;
import co.com.sofka.reto.compra.value.PagoServicio;
import co.com.sofka.reto.compra.value.PagoValor;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class PagoFactory {
    public static PagoFactory instance;
    private Set<Pago> pagos;

    private PagoFactory() {
        this.pagos= new HashSet<>();
    }

    public static PagoFactory getInstance(){
        if (Objects.isNull(instance)){
            instance = new PagoFactory();
            return instance;
        }
        return instance;
    }

    public PagoFactory add(PagoId pagoId, PagoServicio servicio, PagoValor valor){
        pagos.add(new Pago(pagoId,servicio,valor));
        return this;
    }

    public Set<Pago> pagos() {
        return pagos;
    }
}
