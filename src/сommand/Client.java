package сommand;

public class Client {
    Command addDecoration;
    Command findByStem;
    Command calculateBouquetCost;
    Command showBouquet;
    Command sortByFreshness;

    public Client(Command addDecoration, Command findByStem, Command calculateBouquet,
                  Command showBouquet, Command sortByFreshness) {
        this.addDecoration = addDecoration;
        this.calculateBouquetCost = calculateBouquet;
        this.findByStem = findByStem;
        this.showBouquet = showBouquet;
        this.sortByFreshness = sortByFreshness;
    }

    public void addDecoration() throws Exception {
        addDecoration.execute();
    }
    public void calculateBouquetCost() throws Exception {
        calculateBouquetCost.execute();
    }
    public void findByStem() throws Exception {
        findByStem.execute();
    }
    public void showBouquet() throws Exception {
        showBouquet.execute();
    }
    public void sortByFreshness() throws Exception {
        sortByFreshness.execute();
    }
}


