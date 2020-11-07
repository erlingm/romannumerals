package no.moldesoft.kevlinhenney.romannumerals;

import java.util.Arrays;
import java.util.List;

public class RomanNumerals {

    private final List<Pair> pairs = Arrays.asList(
            Pair.of(1000, "M"), Pair.of(900, "CM"),
            Pair.of(500, "D"), Pair.of(400, "CD"),
            Pair.of(100, "C"), Pair.of(90, "XC"),
            Pair.of(50, "L"), Pair.of(40, "XL"),
            Pair.of(10, "X"), Pair.of(9, "IX"),
            Pair.of(5, "V"), Pair.of(4, "IV"),
            Pair.of(1, "I")
    );

    private String roman(int number) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Pair pair : pairs) {
            for (int i = 0, l = number / pair.value; i < l; i++) {
                stringBuilder.append(pair.letters);
            }
            number %= pair.value;
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        new RomanNumerals().run(args);
    }

    private void run(String[] args) {
        if (args.length > 0) {
            for (String arg : args) {
                int number = Integer.parseInt(arg);
                System.out.printf("%d -> %s%n", number, roman(number));
            }
        } else {
            System.out.println("No number provided");
        }
    }
}

class Pair {
    final int value;
    final String letters;

    private Pair(int value, String letters) {
        this.value = value;
        this.letters = letters;
    }

    static Pair of(int value, String letters) {
        return new Pair(value, letters);
    }
}
