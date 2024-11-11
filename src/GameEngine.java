import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

public class GameEngine {
    private final InputStream in;
    private final PrintStream out;
    private final Scanner scanner;
    private final AiPlayer aiPlayer = new AiPlayer();
    private final PlayChoiceFactory playChoiceFactory;

    public GameEngine(InputStream in, PrintStream out, PlayChoiceFactory choiceFactory) {
        this.in = in;
        this.out = out;
        this.scanner = new Scanner(in);
        playChoiceFactory = choiceFactory;
    }

    void run() {
        while (true) {
            displayMessage("Choose " + getChoicesString());
            if (gameOver()) break;
            String choice = getNextChoice();
            PlayChoice playerPlay = playChoiceFactory.convertToPlayChoice(choice);
            if (playerPlay == null) {
                displayError("Invalid choice, try again.");
                continue;
            }
            RPS aiPlay = aiPlayer.play();
            Result result = compare(playerPlay, aiPlay);
            displayMessage("You played " + choice);
            displayMessage("Enemy played " + aiPlay.toString());
            reportResult(result, playerPlay, aiPlay);

        }
        displayMessage("Goodbye!");
    }

    private String getChoicesString() {
        List<PlayChoice> allChoices = playChoiceFactory.getAllChoices();
        String s = "";
        for (PlayChoice choice : allChoices) {
            s += "-" + choice;
        }
        return s.substring(1);
    }

    private String getNextChoice() {
        return scanner.next();
    }

    private boolean gameOver() {
        return !scanner.hasNext();
    }

    private void displayError(String msg) {
        out.println(msg);
    }

    private void displayMessage(String msg) {
        out.println(msg);
    }

    private PlayChoice generateAiChoice() {
        return aiPlayer.play();
    }

    private Result compare(PlayChoice playerPlay, PlayChoice aiPlay) {
        if (playerPlay.beats(aiPlay)) return Result.Win;
        if (aiPlay.beats(playerPlay)) return Result.Lose;
        return Result.Tie;
    }

    private void reportResult(Result result, PlayChoice playerPlay, PlayChoice aiPlay) {
        switch (result) {
            case Tie:
                displayMessage("It's a tie!");
                return;
            case Win:
                displayMessage(playerPlay + " beats " + aiPlay);
                displayMessage("You win!");
                return;
            case Lose:
                displayMessage(aiPlay + " beats " + playerPlay);
                displayMessage("You lose!");
                return;
        }

    }
}
