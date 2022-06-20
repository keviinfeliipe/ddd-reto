package co.com.sofka.reto.canal.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.reto.canal.Comunidad;
import co.com.sofka.reto.canal.value.CanalDescripcion;
import co.com.sofka.reto.canal.value.CanalId;

public class CrearCanalCommand extends Command {
    private final CanalId canalId;
    private final Comunidad comunidad;
    private final CanalDescripcion descripcion;

    public CrearCanalCommand(CanalId canalId, Comunidad comunidad, CanalDescripcion descripcion) {
        this.canalId = canalId;
        this.comunidad = comunidad;
        this.descripcion = descripcion;
    }

    public CanalId getCanalId() {
        return canalId;
    }

    public Comunidad getComunidad() {
        return comunidad;
    }

    public CanalDescripcion getDescripcion() {
        return descripcion;
    }
}
