package eugene.lambda.model_music;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Jian on 2015/8/14.
 */
public class MusicChapter extends AbsMusic {
    public List<String> getNamesOfArtists_Lambda() {
        return artists.stream()
                .map(artist -> artist.getName())
                .collect(Collectors.toList());
    }

    public List<String> getNamesOfArtists_MethodReference() {
        return artists.stream()
                .map(Artist::getName)
                .collect(Collectors.toList());
    }

    public List<Artist> artistsLivingInLondon() {
        return artists.stream()
                .filter(artist -> "London".equals(artist.getNationality()))
                .collect(Collectors.toList());
    }
}
