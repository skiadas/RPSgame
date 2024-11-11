import java.util.Arrays;
import java.util.List;

public class RPSLSFactory implements PlayChoiceFactory {
    public PlayChoice convertToPlayChoice(String choice) {
        switch (choice) {
            case "Rock": return RPSLS.Rock;
            case "Paper": return RPSLS.Paper;
            case "Scissors": return RPSLS.Scissors;
            case "Lizard": return RPSLS.Lizard;
            case "Spock": return RPSLS.Spock;
            default: return null;
        }
    }

    public List<PlayChoice> getAllChoices() {
        return Arrays.asList(RPSLS.values());
    }

}
