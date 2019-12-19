package сommand;
import bouquet.Bouquet;

public class CalculateBouquetCostCommand implements Command {
    Bouquet bouquet;
    public CalculateBouquetCostCommand(Bouquet bouquet) {
        this.bouquet = bouquet;
    }
    @Override
    public void execute(){
        bouquet.calculateBouquetCost();
    }
}
