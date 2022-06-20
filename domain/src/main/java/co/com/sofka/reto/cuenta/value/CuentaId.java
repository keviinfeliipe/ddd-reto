package co.com.sofka.reto.cuenta.value;

import co.com.sofka.domain.generic.Identity;

public class CuentaId extends Identity {
    private CuentaId(String uuid) {
        super(uuid);
    }

    public CuentaId() {
    }

    public static CuentaId of(String id){
        return new CuentaId(id);
    }
}
