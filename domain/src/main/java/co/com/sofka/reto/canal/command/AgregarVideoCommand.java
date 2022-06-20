package co.com.sofka.reto.canal.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.reto.canal.VideoFactory;
import co.com.sofka.reto.canal.value.*;

public class AgregarVideoCommand extends Command {
    private final VideoFactory factory;
    private final CanalId canalId;


    public AgregarVideoCommand(CanalId canalId, VideoFactory factory) {
        this.canalId = canalId;
        this.factory = factory;
    }

    public VideoFactory getFactory() {
        return factory;
    }

    public CanalId getCanalId() {
        return canalId;
    }
}
