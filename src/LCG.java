import java.util.stream.Stream;

class LCG {
    public static Stream<Long> generate(long seed, long a, long c, long m) {
        return Stream.iterate(seed, x -> (a * x + c) % m);
    }
    public static void main(String[] args) {
        long a = 25214903917L;
        long c = 11L;
        long m = (1L << 48); // 2^48
        long seed = System.currentTimeMillis() % m; // Використовуємо поточний час як seed

        Stream<Long> randomNumbers = generate(seed, a, c, m);

        // Виведемо перші 10 випадкових чисел для перевірки
        randomNumbers.limit(10).forEach(System.out::println);
    }
}