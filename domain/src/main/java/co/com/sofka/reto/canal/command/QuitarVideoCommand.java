package co.com.sofka.reto.canal.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.reto.canal.value.CanalId;
import co.com.sofka.reto.canal.value.VideoId;

public class QuitarVideoCommand extends Command {
    private final CanalId canalId;
    private final VideoId videoId;

    public QuitarVideoCommand(CanalId canalId, VideoId videoId) {
        this.canalId = canalId;
        this.videoId = videoId;
    }

    public CanalId getCanalId() {
        return canalId;
    }

    public VideoId getVideoId() {
        return videoId;
    }
}
