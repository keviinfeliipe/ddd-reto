package co.com.sofka.reto.compra.value;

import co.com.sofka.domain.generic.Identity;

public class MedioPagoId extends Identity {
    private MedioPagoId(String uuid) {
        super(uuid);
    }

    public MedioPagoId() {
    }

    public static MedioPagoId of(String id){
        return new MedioPagoId(id);
    }
}
