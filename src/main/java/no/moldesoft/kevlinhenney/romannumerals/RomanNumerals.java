package no.moldesoft.kevlinhenney.romannumerals;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class RomanNumerals {

    /**
     * From Joshua Bloch - Effective Java 3rd edition - item 6
     */
    private static final Pattern ROMAN_PATTERN =
            Pattern.compile("^(?=.)M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$", Pattern.CASE_INSENSITIVE);

    private final List<Pair> pairs = Arrays.asList(
            Pair.of(1000, "M"), Pair.of(900, "CM"),
            Pair.of(500, "D"), Pair.of(400, "CD"),
            Pair.of(100, "C"), Pair.of(90, "XC"),
            Pair.of(50, "L"), Pair.of(40, "XL"),
            Pair.of(10, "X"), Pair.of(9, "IX"),
            Pair.of(5, "V"), Pair.of(4, "IV"),
            Pair.of(1, "I")
    );

    public String roman(int number) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Pair pair : pairs) {
            for (int i = 0, l = number / pair.value; i < l; i++) {
                stringBuilder.append(pair.letters);
            }
            number %= pair.value;
        }
        return stringBuilder.toString();
    }

    /**
     * From Joshua Bloch - Effective Java 3rd edition - item 6
     */
    public boolean isRoman(String numeral) {
        return ROMAN_PATTERN.matcher(numeral).matches();
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
