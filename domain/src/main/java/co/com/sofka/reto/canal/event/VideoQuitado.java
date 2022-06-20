package co.com.sofka.reto.canal.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.canal.value.VideoId;

public class VideoQuitado extends DomainEvent {
    private final VideoId videoId;

    public VideoQuitado(VideoId videoId) {
        super("sofka.canal.VideoQuitado");
        this.videoId = videoId;
    }

    public VideoId getVideoId() {
        return videoId;
    }
}
