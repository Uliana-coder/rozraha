package сommand;
import bouquet.Bouquet;

public class FindByStemCommand implements Command {
    Bouquet bouquet;
    public FindByStemCommand(Bouquet bouquet) {
        this.bouquet = bouquet;
    }
    @Override
    public void execute() throws Exception {
        bouquet.findByStem();
    }
}
