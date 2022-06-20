package co.com.sofka.reto.canal.value;

import co.com.sofka.domain.generic.Identity;

public class VideoId extends Identity {
    private VideoId(String uuid) {
        super(uuid);
    }

    public VideoId() {
    }

    public static VideoId of(String id){
        return new VideoId(id);
    }
}
