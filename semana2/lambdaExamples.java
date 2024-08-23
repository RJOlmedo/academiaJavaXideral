import java.util.function.*;
import java.util.*;

public class lambdaExamples {

    public static void main(String[] args) {
        // Supplier<T> Example: Provides a result without taking any input.
        System.out.println("Supplier Examples:");
        Supplier<String> stringSupplier = () -> "Hello, World!";
        System.out.println(stringSupplier.get());

        Supplier<Double> randomSupplier = () -> Math.random();
        System.out.println(randomSupplier.get());

        Supplier<Date> dateSupplier = Date::new;
        System.out.println(dateSupplier.get());

        Supplier<List<String>> listSupplier = () -> Arrays.asList("Apple", "Banana", "Cherry");
        System.out.println(listSupplier.get());

        // Consumer<T> Example: Accepts a single input and performs an operation without returning a result.
        System.out.println("\nConsumer Examples:");
        Consumer<String> stringConsumer = s -> System.out.println(s.toUpperCase());
        stringConsumer.accept("hello");

        Consumer<Integer> squareConsumer = i -> System.out.println(i * i);
        squareConsumer.accept(4);

        Consumer<List<String>> listConsumer = list -> list.forEach(System.out::println);
        listConsumer.accept(Arrays.asList("Dog", "Cat", "Cow"));

        Consumer<String> printConsumer = System.out::println;
        printConsumer.accept("This is a message");

        // BiConsumer<T, U> Example: Accepts two inputs and performs an operation without returning a result.
        System.out.println("\nBiConsumer Examples:");
        BiConsumer<String, Integer> printStringAndInt = (str, num) -> System.out.println(str + " " + num);
        printStringAndInt.accept("Age:", 30);

        BiConsumer<Integer, Integer> multiplyAndPrint = (a, b) -> System.out.println(a * b);
        multiplyAndPrint.accept(5, 10);

        BiConsumer<String, String> concatAndPrint = (a, b) -> System.out.println(a + " " + b);
        concatAndPrint.accept("Hello", "World");

        Map<String, Integer> map = new HashMap<>();
        BiConsumer<String, Integer> mapConsumer = map::put;
        mapConsumer.accept("One", 1);
        mapConsumer.accept("Two", 2);
        System.out.println(map);

        // Predicate<T> Example: Accepts a single input and returns a boolean.
        System.out.println("\nPredicate Examples:");
        Predicate<Integer> isEven = n -> n % 2 == 0;
        System.out.println(isEven.test(4)); // true

        Predicate<String> isNotEmpty = str -> !str.isEmpty();
        System.out.println(isNotEmpty.test("Hello")); // true

        Predicate<List<?>> isNotEmptyList = list -> !list.isEmpty();
        System.out.println(isNotEmptyList.test(Arrays.asList(1, 2, 3))); // true

        Predicate<Integer> isPositive = n -> n > 0;
        System.out.println(isPositive.test(-5)); // false

        // BiPredicate<T, U> Example: Accepts two inputs and returns a boolean.
        System.out.println("\nBiPredicate Examples:");
        BiPredicate<String, Integer> lengthGreaterThan = (str, len) -> str.length() > len;
        System.out.println(lengthGreaterThan.test("Hello", 3)); // true

        BiPredicate<Integer, Integer> areEqual = Integer::equals;
        System.out.println(areEqual.test(5, 5)); // true

        BiPredicate<String, String> startsWith = (str, prefix) -> str.startsWith(prefix);
        System.out.println(startsWith.test("Hello", "He")); // true

        BiPredicate<List<String>, String> containsElement = List::contains;
        System.out.println(containsElement.test(Arrays.asList("a", "b", "c"), "b")); // true

        // Function<T, R> Example: Accepts a single input and returns a result.
        System.out.println("\nFunction Examples:");
        Function<String, Integer> stringLength = String::length;
        System.out.println(stringLength.apply("Hello")); // 5

        Function<Integer, String> intToString = Object::toString;
        System.out.println(intToString.apply(123)); // "123"

        Function<String, String> reverseString = str -> new StringBuilder(str).reverse().toString();
        System.out.println(reverseString.apply("Hello")); // "olleH"

        Function<Integer, Integer> square = n -> n * n;
        System.out.println(square.apply(5)); // 25

        // BiFunction<T, U, R> Example: Accepts two inputs and returns a result.
        System.out.println("\nBiFunction Examples:");
        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
        System.out.println(add.apply(10, 20)); // 30

        BiFunction<String, String, String> concatStrings = String::concat;
        System.out.println(concatStrings.apply("Hello, ", "World!")); // "Hello, World!"

        BiFunction<Integer, Integer, Double> power = Math::pow;
        System.out.println(power.apply(2, 3)); // 8.0

        BiFunction<String, Integer, String> repeatString = (str, n) -> str.repeat(n);
        System.out.println(repeatString.apply("Hello", 3)); // "HelloHelloHello"

        // UnaryOperator<T> Example: A specialization of Function where the input and output are the same type.
        System.out.println("\nUnaryOperator Examples:");
        UnaryOperator<Integer> increment = n -> n + 1;
        System.out.println(increment.apply(5)); // 6

        UnaryOperator<String> toUpperCase = String::toUpperCase;
        System.out.println(toUpperCase.apply("hello")); // "HELLO"

        UnaryOperator<List<String>> addElement = list -> {
            list.add("New Element");
            return list;
        };
        List<String> myList = new ArrayList<>(Arrays.asList("One", "Two"));
        System.out.println(addElement.apply(myList)); // ["One", "Two", "New Element"]

        UnaryOperator<Integer> squareOp = n -> n * n;
        System.out.println(squareOp.apply(4)); // 16

        // BinaryOperator<T> Example: A specialization of BiFunction where the inputs and output are the same type.
        System.out.println("\nBinaryOperator Examples:");
        BinaryOperator<Integer> multiply = (a, b) -> a * b;
        System.out.println(multiply.apply(3, 4)); // 12

        BinaryOperator<String> mergeStrings = (a, b) -> a + " " + b;
        System.out.println(mergeStrings.apply("Hello", "World")); // "Hello World"

        BinaryOperator<Integer> minOperator = BinaryOperator.minBy(Integer::compare);
        System.out.println(minOperator.apply(3, 5)); // 3

        BinaryOperator<Integer> maxOperator = BinaryOperator.maxBy(Integer::compare);
        System.out.println(maxOperator.apply(3, 5)); // 5
    }
}
