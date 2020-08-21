package tj.modul3.bowling;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BowlingScoreTest {
    BowlingScore bowlingScore;

    @BeforeEach
    void setUp() {
        bowlingScore = new BowlingScore();
    }

    @Test
    @DisplayName("Should return maximum score when strike in all frames")
    void shouldReturnMaxScoreWhenStrikeInAllFrames() {
        //given
        bowlingScore.calculateScore("x,x,x,x,x,x,x,x,x,x,x,x");

        //when
        int result = bowlingScore.getScore();

        //then
        Assertions.assertThat(result).isEqualTo(300);
    }

    @Test
    @DisplayName("Should return sum of rolls when half of them are miss")
    void shouldReturnScoreWhenMissesGiven() {
        //given
        bowlingScore.calculateScore("9,-,9,-,9,-,9,-,9,-,9,-,9,-,9,-,9,-,9,-");

        //when
        int result = bowlingScore.getScore();

        //then
        Assertions.assertThat(result).isEqualTo(90);
    }

    @Test
    @DisplayName("Should return sum of rolls when strike given")
    void shouldReturnScoreWhenSpareGiven() {
        //given
        bowlingScore.calculateScore("5,/,5,/,5,/,5,/,5,/,5,/,5,/,5,/,5,/,5,/,5");

        //when
        int result = bowlingScore.getScore();

        //then
        Assertions.assertThat(result).isEqualTo(150);
    }

    @Test
    @DisplayName("Should return sum of rolls when spare given")
    void shouldReturnScoreWhenStrikeGiven() {
        //given
        bowlingScore.calculateScore("5,5,x,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5");

        //when
        int result = bowlingScore.getScore();

        //then
        Assertions.assertThat(result).isEqualTo(110);
    }

    @Test
    @DisplayName("Should return sum of rolls when strike spare given")
    void shouldReturnScoreWhenStrikeAndSpareGiven() {
        //given
        bowlingScore.calculateScore("5,5,x,5,/,5,5,5,5,5,/,x,5,5,5,5,5,5");

        //when
        int result = bowlingScore.getScore();

        //then
        Assertions.assertThat(result).isEqualTo(135);
    }

    @Test
    @DisplayName("Should return sum of rolls when strike spare given and spare as last")
    void shouldReturnScoreWhenSpareGivenAsLast() {
        //given
        bowlingScore.calculateScore("5,5,x,5,/,5,5,5,5,5,/,x,5,5,5,5,5,/,5");

        //when
        int result = bowlingScore.getScore();

        //then
        Assertions.assertThat(result).isEqualTo(140);
    }

    @Test
    @DisplayName("Should return sum of rolls when strike spare given and strike as last")
    void shouldReturnScoreWhenStrikeGivenAsLast() {
        //given
        bowlingScore.calculateScore("5,5,x,5,/,5,5,5,5,5,/,x,5,5,5,5,x,5,/");

        //when
        int result = bowlingScore.getScore();

        //then
        Assertions.assertThat(result).isEqualTo(145);
    }

}
