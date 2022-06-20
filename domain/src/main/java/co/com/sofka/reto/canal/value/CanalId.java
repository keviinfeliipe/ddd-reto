package co.com.sofka.reto.canal.value;

import co.com.sofka.domain.generic.Identity;

public class CanalId extends Identity {
    private CanalId(String uuid) {
        super(uuid);
    }

    public CanalId() {
    }

    public static CanalId of(String id){
        return new CanalId(id);
    }
}
