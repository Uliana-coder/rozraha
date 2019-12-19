package сommand;
import bouquet.Bouquet;

public class ShowBouquetCommand implements Command {
    Bouquet bouquet;
    public ShowBouquetCommand(Bouquet bouquet) {
        this.bouquet = bouquet;
    }
    @Override
    public void execute(){
        bouquet.showBouquet();
    }
}
