import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class GameEngine {
    private final InputStream in;
    private final PrintStream out;
    private final Scanner scanner;
    private final AiPlayer aiPlayer = new AiPlayer();

    public GameEngine(InputStream in, PrintStream out) {
        this.in = in;
        this.out = out;
        this.scanner = new Scanner(in);
    }

    void run() {
        while (true) {
            displayMessage("Choose rock-paper-scissors");
            if (gameOver()) break;
            String choice = getNextChoice();
            PlayChoice playerPlay = convertToPlayChoice(choice);
            if (playerPlay == null) {
                displayError("Invalid choice, try again.");
                continue;
            }
            PlayChoice aiPlay = aiPlayer.play();
            Result result = compare(playerPlay, aiPlay);
            displayMessage("You played " + choice);
            displayMessage("Enemy played " + aiPlay.toString());
            reportResult(result, playerPlay, aiPlay);

        }
        displayMessage("Goodbye!");
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

    private PlayChoice convertToPlayChoice(String choice) {
        switch (choice) {
            case "Rock": return PlayChoice.Rock;
            case "Paper": return PlayChoice.Paper;
            case "Scissors": return PlayChoice.Scissors;
            default: return null;
        }
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
