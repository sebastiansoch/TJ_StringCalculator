package tj.modul3.bowling;

public class BowlingScore {

    private int score;
    private int MAX_ROLLS;

    public void calculateScore(String rolls) {
        String[] split = prepareRolls(rolls);

        for (int i = 0; i < split.length; i++) {
            if (i > MAX_ROLLS) {
                break;
            }
            if (split[i].equals("/")) {
                score += calculateRollForSpare(split, i);
            } else if (split[i].equals("x")) {
                score += calculateRollForStrike(split, i);
            } else {
                score += parseRoll(split[i]);
            }
        }
    }

    private String[] prepareRolls(String rolls) {
        rolls = rolls.replaceAll("-", "0");
        String[] split = rolls.split(",");

        calcNbOfRollsForCalculation(split);

        return split;
    }

    private void calcNbOfRollsForCalculation(String[] split) {
        if (split[split.length - 2].equals("/")) {
            MAX_ROLLS = split.length - 2;
        } else if (split[split.length - 3].equals("x")) {
            MAX_ROLLS = split.length - 3;
        } else {
            MAX_ROLLS = split.length;
        }
    }

    private int calculateRollForStrike(String[] split, int i) {
        int roll1 = parseRoll(split[i + 1]);
        int roll2 = parseRoll(split[i + 2]);

        return 10 + roll1 + (roll2 > -1 ? roll2 : (10 - roll1));
    }

    private int calculateRollForSpare(String[] split, int i) {
        return 10 - parseRoll(split[i - 1]) + parseRoll(split[i + 1]);
    }

    public int getScore() {
        return score;
    }

    private int parseRoll(String roll) {
        if (roll.equals("x")) {
            return 10;
        } else if (roll.equals("/")) {
            return -1;
        }

        return Integer.parseInt(roll);
    }
}
