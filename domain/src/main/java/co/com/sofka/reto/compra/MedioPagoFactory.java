package co.com.sofka.reto.compra;

import co.com.sofka.reto.compra.value.MedioPagoFecha;
import co.com.sofka.reto.compra.value.MedioPagoId;
import co.com.sofka.reto.compra.value.MedioPagoNumero;
import co.com.sofka.reto.compra.value.MedioPagoTitular;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class MedioPagoFactory {
    public static MedioPagoFactory instance;
    private Set<MedioPago> pagos;

    public MedioPagoFactory() {
        this.pagos = new HashSet<>();
    }

    public static MedioPagoFactory getInstance(){
        if (Objects.isNull(instance)){
            instance = new MedioPagoFactory();
            return instance;
        }
        return instance;
    }

    public MedioPagoFactory add(MedioPagoId medioPagoId, MedioPagoNumero numero, MedioPagoFecha fecha, MedioPagoTitular titular){
        pagos.add(new MedioPago(medioPagoId,numero,fecha,titular));
        return this;
    }

    public Set<MedioPago> pagos() {
        return pagos;
    }
}
