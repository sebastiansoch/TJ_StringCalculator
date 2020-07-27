package tj.modul1.zadanie1;

class StringCalculator {
    int add(String input) {
        if (input.isEmpty()) {
            return 0;
        }

        String[] numbers = input.split(",");
        int result = 0;

        for (String number : numbers) {
            result += Integer.parseInt(number);
        }

        return result;
    }
}
