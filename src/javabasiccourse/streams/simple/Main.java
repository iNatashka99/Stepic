package javabasiccourse.streams.simple;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        pseudoRandomStream(13).limit(20).mapToObj(x -> " " + x).forEach(System.out::print);
    }

    public static IntStream pseudoRandomStream(int seed) {
        return IntStream.iterate(seed, n -> ((n * n) / 10) % 1000);
    }

}
