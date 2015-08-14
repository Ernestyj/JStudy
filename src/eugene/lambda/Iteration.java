package eugene.lambda;

import eugene.lambda.model_music.Artist;
import eugene.lambda.model_music.SampleData;

import java.util.List;

/**
 * Created by Jian on 2015/8/14.
 */
public class Iteration {
    public static void main(String[] args){
        long count = new Iteration().internalCountArtistsFromLondonPrinted(SampleData.membersOfTheBeatles);
        System.out.println("internalCountArtistsFromLondonPrinted: " + count);

        System.out.println();
    }

    public long internalCountArtistsFromLondonPrinted(List<Artist> allArtists) {
        // BEGIN internal_count_londoners_printed
        long count = allArtists.stream()
                .filter(artist -> {
                    System.out.println(artist.getName());
                    return artist.isFrom("London");
                })
                .count();
        // END internal_count_londoners_printed
        return count;
    }
}
