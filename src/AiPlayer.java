import java.util.Random;

public class AiPlayer {
    final Random random = new Random();

    public AiPlayer() {
    }

    RPS play() {
        int i = random.nextInt(3);
        switch (i) {
            case 0: return RPS.Rock;
            case 1: return RPS.Paper;
            case 2: return RPS.Scissors;
            default: return null;
        }
    }
}