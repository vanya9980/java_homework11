import java.util.stream.Stream;

class ZipStreams {

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        // Злиття двох стрімів в один
        Stream<T> zipped = Stream.concat(first, second);

        // Використання flatMap для чергування елементів
        return zipped
                .flatMap(e -> Stream.of(e, null)) // Додаємо null для парних і непарних елементів
                .filter(e -> e != null); // Видаляємо null з результату
    }

    public static void main(String[] args) {
        Stream<String> firstStream = Stream.of("a", "b", "c");
        Stream<String> secondStream = Stream.of("1", "2", "3", "4");

        Stream<String> zippedStream = zip(firstStream, secondStream);
        zippedStream.forEach(System.out::println); // Очікуваний результат: a, 1, b, 2, c, 3
    }
}