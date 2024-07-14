import java.util.Iterator;
import java.util.function.Supplier;
import java.util.stream.Stream;

class StreamZipper {
    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second){
        Iterator<T> secondIterator = second.iterator();
        return first.filter(ignore -> secondIterator.hasNext()).flatMap(f -> Stream.of(f, secondIterator.next()));
    }

    public static void main(String[] args) {
        Supplier<Stream<String>> streamSupplier1 = () -> Stream.of("A", "B", "C");
        Supplier<Stream<String>> streamSupplier2 = () -> Stream.of("1", "2", "3", "4");

        Stream<String> result = zip(streamSupplier1.get(), streamSupplier2.get());
        result.forEach(System.out::println);
    }
}