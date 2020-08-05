package tj.modul3.stringcalc;

import java.util.stream.Collectors;
import java.util.stream.Stream;

class InputParser {

    private String input;
    private String errorMessage;


    void parseInputString(String input) {
        this.input = input;

        int wrongSeparatorIdx = input.indexOf(",\n");
        if (wrongSeparatorIdx > -1) {
            errorMessage = "Number expected but '\n' found at position ".concat(String.valueOf(++wrongSeparatorIdx)).concat(".");
            return;
        }

        if (input.lastIndexOf(",") == input.length() - 1) {
            errorMessage = "Number expected but EOF found.";
            return;
        }

        String numbersToAdd = getNumbersToAdd();
        String separator = getNumbersSeparator();
        int commaSeparatorIdx = numbersToAdd.indexOf(",");
        if (input.startsWith("//") && (commaSeparatorIdx > -1)) {
            errorMessage = "'" + (separator.startsWith("\\") ? separator.substring(1) : separator) + "' expected but ',' found at position " + commaSeparatorIdx + ".";
            return;
        }

        String[] split = numbersToAdd.split(separator);
        String negativeNumbers = Stream.of(numbersToAdd.split(separator))
                .map(Double::parseDouble)
                .filter(v -> v < 0)
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

        if (!negativeNumbers.isEmpty()) {
            errorMessage = "Negative not allowed : " + negativeNumbers;
            return;
        }
    }

    boolean isInputError() {
        if (errorMessage == null) {
            return false;
        }

        return true;
    }

    String getErrorMessage() {
        return errorMessage;
    }

    String getNumbersSeparator() {
        String separator = null;
        if (input.startsWith("//")) {
            separator = input.substring(2, input.indexOf("\n"));
            if (separator.equals("|")) separator = "\\|";
        }

        return separator == null ? ",|\\n" : separator;
    }

    String getNumbersToAdd() {
        if (input.startsWith("//")) {
            return input.substring(input.indexOf("\n") + 1);
        }
        return input;
    }


}
