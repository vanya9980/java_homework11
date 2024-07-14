import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class NamesFormatter {
    public static String formatNames(List<String> names) {
        return IntStream.range(0, names.size()) // Створюємо стрім індексів
                .filter(i -> i % 2 != 0)       // Фільтруємо лише непарні індекси
                .mapToObj(i -> (i + 1) + ". " + names.get(i)) // Форматуємо рядки
                .collect(Collectors.joining(", ")); // Об'єднуємо їх у один рядок
    }

    public static void main(String[] args) {
        List<String> names = List.of("John", "Ivan", "Anna", "Peter", "Maria");
        System.out.println(formatNames(names)); // Очікуваний результат: "2. Ivan, 4. Peter"
    }
}