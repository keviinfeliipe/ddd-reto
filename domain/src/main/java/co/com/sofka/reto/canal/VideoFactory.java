package co.com.sofka.reto.canal;

import co.com.sofka.reto.canal.value.VideoCategoria;
import co.com.sofka.reto.canal.value.VideoId;
import co.com.sofka.reto.canal.value.VideoMultimedia;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class VideoFactory {

    public static VideoFactory instance;
    private final Set<Video> videos;

    private VideoFactory(){
        videos = new HashSet<>();
    }

    public static VideoFactory getInstance(){
         if (Objects.isNull(instance)){
             instance = new VideoFactory();
             return instance;
         }
        return instance;
    }

    public VideoFactory add(VideoId videoId, VideoCategoria categoria, VideoMultimedia multimedia){
        videos.add(new Video(videoId,categoria,multimedia));
        return this;
    }

    protected Set<Video> videos() {
        return videos;
    }
}
