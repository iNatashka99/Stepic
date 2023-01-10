package javabasiccourse.streams.simple;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        pseudoRandomStream(13).limit(20).mapToObj(x -> " " + x).forEach(System.out::print);
        System.out.println();
        Integer[] ints = {13, 16, 25, 62, 384, 745, 502, 200};
        Comparator<Integer> comparator = Comparator.comparingInt(o -> o);
        BiConsumer<Integer, Integer> biConsumer = (t, u) -> System.out.println(t + " " + u);
        findMinMax(Arrays.stream(ints), comparator, biConsumer);

    }

    public static IntStream pseudoRandomStream(int seed) {
        return IntStream.iterate(seed, n -> ((n * n) / 10) % 1000);
    }

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {
        List<T> elements = stream.sorted(order).collect(Collectors.toList());
        if (!elements.isEmpty()) {
            minMaxConsumer.accept(elements.get(0), elements.get(elements.size() - 1));
        }
        else {
            minMaxConsumer.accept(null, null);
        }
    }

}
