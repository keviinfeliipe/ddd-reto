package co.com.sofka.reto.canal.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.canal.value.VideoCategoria;
import co.com.sofka.reto.canal.value.VideoMultimedia;
import co.com.sofka.reto.canal.value.VideoFecha;
import co.com.sofka.reto.canal.value.VideoId;

public class VideoAgregado extends DomainEvent {
    private final VideoId videoId;
    private final VideoCategoria categoria;
    private final VideoMultimedia multimedia;

    public VideoAgregado(VideoId videoId,VideoCategoria categoria, VideoMultimedia multimedia) {
        super("sofka.canal.VideoAgregado");
        this.videoId = videoId;
        this.categoria = categoria;
        this.multimedia = multimedia;
    }

    public VideoId getVideoId() {
        return videoId;
    }

    public VideoCategoria getCategoria() {
        return categoria;
    }

    public VideoMultimedia getMultimedia() {
        return multimedia;
    }
}
