package co.com.sofka.reto.canal.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.reto.canal.SuscriptorFactory;
import co.com.sofka.reto.canal.value.CanalId;
import co.com.sofka.reto.canal.value.SuscriptorId;
import co.com.sofka.reto.canal.value.SuscriptorTipo;

public class AgregarSuscriptorCommand extends Command {
    private final CanalId canalId;
    private final SuscriptorFactory factory;


    public AgregarSuscriptorCommand(CanalId canalId, SuscriptorFactory factory) {
        this.canalId = canalId;
        this.factory = factory;
    }

    public CanalId getCanalId() {
        return canalId;
    }

    public SuscriptorFactory getFactory() {
        return factory;
    }
}
