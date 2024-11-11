import java.util.Random;

public class AiPlayer {
    final Random random = new Random();

    public AiPlayer() {
    }

    PlayChoice play() {
        int i = random.nextInt(3);
        switch (i) {
            case 0: return PlayChoice.Rock;
            case 1: return PlayChoice.Paper;
            case 2: return PlayChoice.Scissors;
            default: return null;
        }
    }
}