package eugene.lambda.model_music;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jian on 2015/8/14.
 */
public abstract class AbsMusic {

    protected final List<Artist> artists;
    protected final List<Album> albums;

    public AbsMusic() {
        artists = new ArrayList<>();
        albums = new ArrayList<>();
        loadData("");
    }

    private void loadData(String file) {

    }

}