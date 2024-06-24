import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class NumberSorter {
    public static String sortNumbers(String[] input) {
        return Arrays.stream(input) // Створюємо стрім з масиву рядків
                .flatMap(s -> Arrays.stream(s.split(", "))) // Розбиваємо кожен рядок на окремі числа
                .map(Integer::parseInt) // Перетворюємо рядки на числа
                .sorted() // Сортуємо числа
                .map(String::valueOf) // Перетворюємо числа назад у рядки
                .collect(Collectors.joining(", ")); // Об'єднуємо їх у один рядок, розділяючи комами
    }

    public static void main(String[] args) {
        String[] input = {"1, 2, 0", "4, 5"};
        String sortedNumbers = sortNumbers(input);
        System.out.println(sortedNumbers); // Очікуваний результат: "0, 1, 2, 4, 5"
    }
}