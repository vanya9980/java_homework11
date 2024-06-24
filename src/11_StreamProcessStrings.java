import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class StringProcessor {
    public static List<String> processStrings(List<String> strings) {
        return strings.stream()
                .map(String::toUpperCase) // Перетворюємо рядки у верхній регістр
                .sorted(Comparator.reverseOrder()) // Сортуємо у зворотному порядку
                .collect(Collectors.toList()); // Збираємо результат у список
    }
    public static void main(String[] args) {
        List<String> strings = List.of("John", "Ivan", "Anna", "Peter", "Maria");
        List<String> processedStrings = processStrings(strings);
        System.out.println(processedStrings); // Очікуваний результат: [PETER, MARIA, JOHN, IVAN, ANNA]
    }
}