import java.util.Iterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import java.util.Spliterator;
import java.util.Spliterators;

class StreamUtils {

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        Iterator<T> firstIterator = first.iterator();
        Iterator<T> secondIterator = second.iterator();

        Iterator<T> zippedIterator = new Iterator<>() {
            private boolean switchFlag = true;

            @Override
            public boolean hasNext() {
                return firstIterator.hasNext() && secondIterator.hasNext();
            }

            @Override
            public T next() {
                if (switchFlag) {
                    switchFlag = false;
                    return firstIterator.next();
                } else {
                    switchFlag = true;
                    return secondIterator.next();
                }
            }
        };

        Spliterator<T> spliterator = Spliterators.spliteratorUnknownSize(zippedIterator, Spliterator.ORDERED);
        return StreamSupport.stream(spliterator, false);
    }

    public static void main(String[] args) {
        Stream<String> firstStream = Stream.of("a", "b", "c");
        Stream<String> secondStream = Stream.of("1", "2", "3", "4");

        Stream<String> zippedStream = zip(firstStream, secondStream);
        zippedStream.forEach(System.out::println); // Очікуваний результат: a, 1, b, 2, c, 3
    }
}