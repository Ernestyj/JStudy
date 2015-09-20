package eugene.lambda.model_music;

import java.util.stream.Stream;

import static java.util.stream.Stream.concat;

/**
 * Created by Jian on 2015/8/14.
 */
public interface Performance {

    public String getName();

    public Stream<Artist> getMusicians();

    // TODO: test
    public default Stream<Artist> getAllMusicians() {
        return getMusicians().flatMap(artist -> {
            return concat(Stream.of(artist), artist.getMembers());
        });
    }

}
