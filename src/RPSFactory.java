import java.util.Arrays;
import java.util.List;

public class RPSFactory implements PlayChoiceFactory {
    public PlayChoice convertToPlayChoice(String choice) {
        switch (choice) {
            case "Rock": return RPS.Rock;
            case "Paper": return RPS.Paper;
            case "Scissors": return RPS.Scissors;
            default: return null;
        }
    }

    public List<PlayChoice> getAllChoices() {
        return Arrays.asList(RPS.values());
    }

}
