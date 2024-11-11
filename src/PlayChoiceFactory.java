import java.util.List;

public interface PlayChoiceFactory {
    PlayChoice convertToPlayChoice(String choice);

    List<PlayChoice> getAllChoices();
}
