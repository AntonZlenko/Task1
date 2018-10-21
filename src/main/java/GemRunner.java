import java.util.ArrayList;

public class GemRunner {
    public static void main(String[] args) {
        ArrayList<Gem> dataBase = new ArrayList<Gem>();
        for (int i = 0; i < 1000; i++) {

            Diamond obj = new Diamond(Operations.generateWeight(), Operations.generateClarity());
            obj.setName("Diamond");
            dataBase.add(obj);

            Emerald obj1 = new Emerald(Operations.generateWeight(), Operations.generateClarity());
            obj1.setName("Emerald");
            dataBase.add(obj1);

            Ruby obj2 = new Ruby(Operations.generateWeight(), Operations.generateClarity());
            obj2.setName("Ruby");
            dataBase.add(obj2);

        }

        ArrayList<Gem> necklace = new ArrayList<Gem>();

        necklace = Operations.Selections(dataBase);
        Operations.showArray(necklace);

        Operations.getWeightAndPriceNecklace(necklace);

        Operations.sortByPrice(necklace);

        Operations.showArray(necklace);

        Operations.showGemsInRanges(necklace,1,5);

    }
}
