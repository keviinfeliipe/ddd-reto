package co.com.sofka.reto.canal.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.reto.canal.value.CanalDescripcion;
import co.com.sofka.reto.canal.value.CanalId;

public class CambiarDescripcionCommand extends Command {
    private final CanalId canalId;
    private final CanalDescripcion descripcion;

    public CambiarDescripcionCommand(CanalId canalId, CanalDescripcion descripcion) {
        this.canalId = canalId;
        this.descripcion = descripcion;
    }

    public CanalId getCanalId() {
        return canalId;
    }

    public CanalDescripcion getDescripcion() {
        return descripcion;
    }
}
