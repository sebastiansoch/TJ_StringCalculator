package tj.modul3.stringcalc;

import java.util.stream.Stream;

public class StringCalculator {
    InputParser parser;

    public String add(String input) {

        if (input.isEmpty()) {
            return "0";
        }

        parser = new InputParser();
        parser.parseInputString(input);

        if (parser.isInputError()) {
           return parser.getErrorMessage();
        }

        String separator = parser.getNumbersSeparator();
        String inputNumbers = parser.getNumbersToAdd();

        String[] numbers = inputNumbers.split(separator);
        double sum = Stream.of(numbers).mapToDouble(v -> Double.parseDouble(v)).sum();
        return String.valueOf(sum);
    }

}
