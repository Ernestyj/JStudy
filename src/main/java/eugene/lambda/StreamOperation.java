package eugene.lambda;

import eugene.lambda.model_music.Album;
import eugene.lambda.model_music.Track;
import eugene.reflect.Arrays;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

/**
 * Created by Jian on 2015/8/14.
 */
public class StreamOperation {
    public static void main(String[] args){
        List<String> collected = Stream.of("a", "b", "c")
                .collect(Collectors.toList());
        System.out.println(collected);

        collected = Stream.of("a", "b", "hello")
                .map(string -> string.toUpperCase())
                .collect(Collectors.toList());
        System.out.println(collected);

        List<String> beginWithNumbers = Stream.of("a", "1abc", "abc1")
                .filter(value -> Character.isDigit(value.charAt(0)))
                .collect(Collectors.toList());
        System.out.println(beginWithNumbers);

        List<Integer> together = Stream.of(asList(1, 2), asList(3, 4))
                .flatMap(numbers -> numbers.stream())
                .collect(Collectors.toList());
        System.out.println(together);

        List<Track> tracks = asList(new Track("Bakai", 524),
                new Track("Violets for Your Furs", 378),
                new Track("Time Was", 451));
        Track shortestTrack = tracks.stream()
                .min(Comparator.comparing(track -> track.getLength()))
                .get();
        System.out.println(shortestTrack.getName());

        int sum = Stream.of(1, 2, 3)
                .reduce(0, (acc, element) -> acc + element);
        System.out.println(sum);

        //reduce展开示例
        BinaryOperator<Integer> accumulator = (acc, element) -> acc + element;
        sum = accumulator.apply(
                    accumulator.apply(
                            accumulator.apply(0, 1),
                    2),
                3);

        System.out.println();
    }

    //Stream整合操作示例
    public Set<String> findLongTracks(List<Album> albums){
        return  albums.stream()
                    .flatMap(album -> album.getTracks())
                    .filter(track -> track.getLength() > 60)
                    .map(track -> track.getName())
                    .collect(Collectors.toSet());
    }
    //map using reduce
    public static <I, O> List<O> map(Stream<I> stream, Function<I, O> mapper) {
        return stream.reduce(new ArrayList<O>(), (acc, x) -> {
            // We are copying data from acc to new list instance. It is very inefficient,
            // but contract of Stream.reduce method requires that accumulator function does
            // not mutate its arguments.
            // Stream.collect method could be used to implement more efficient mutable reduction,
            // but this exercise asks to use reduce method.
            List<O> newAcc = new ArrayList<>(acc);
            newAcc.add(mapper.apply(x));
            return newAcc;
        }, (List<O> left, List<O> right) -> {
            // We are copying left to new list to avoid mutating it.
            List<O> newLeft = new ArrayList<>(left);
            newLeft.addAll(right);
            return newLeft;
        });
    }
    //filter using reduce
    public static <I> List<I> filter(Stream<I> stream, Predicate<I> predicate) {
        List<I> initial = new ArrayList<>();
        return stream.reduce(initial,
                (List<I> acc, I x) -> {
                    if (predicate.test(x)) {
                        // We are copying data from acc to new list instance. It is very inefficient,
                        // but contract of Stream.reduce method requires that accumulator function does
                        // not mutate its arguments.
                        // Stream.collect method could be used to implement more efficient mutable reduction,
                        // but this exercise asks to use reduce method explicitly.
                        List<I> newAcc = new ArrayList<>(acc);
                        newAcc.add(x);
                        return newAcc;
                    } else {
                        return acc;
                    }
                },
                StreamOperation::combineLists);
    }

    private static <I> List<I> combineLists(List<I> left, List<I> right) {
        // We are copying left to new list to avoid mutating it.
        List<I> newLeft = new ArrayList<>(left);
        newLeft.addAll(right);
        return newLeft;
    }

}
