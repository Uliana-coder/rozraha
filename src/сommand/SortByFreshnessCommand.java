package сommand;
import bouquet.Bouquet;

import java.io.IOException;

public class SortByFreshnessCommand implements Command {
    Bouquet bouquet;
    public SortByFreshnessCommand(Bouquet bouquet) {
        this.bouquet = bouquet;
    }
    @Override
    public void execute() throws IOException {
        bouquet.sortByFreshness();
    }
}
