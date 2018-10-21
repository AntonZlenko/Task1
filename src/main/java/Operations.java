import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

abstract class Operations {

    //Метод для подбора камней для ожерелья(в центре блилиант, по бокам 2 корунда и еще 4 аквамарина
    public static ArrayList<Gem> Selections(ArrayList<Gem> dateBase) {
        ArrayList <Gem> forNecklace = new ArrayList<Gem>();
        System.out.println("Gems for necklace"+"\n");
        int numOfDiamonds = 0;
        int numOfEmeralds = 0;
        int numOfRubies = 0;

        for (int i = 0; i < dateBase.size(); i++) {
            //Подбираем алмаз с 20...21 каратами и добавляем в ArrayList Gems
            if(dateBase.get(i).getName().equals("Diamond") &&
                    compareWeight(dateBase.get(i).getWeight(),20,21) &&
                    numOfDiamonds < 1) {
                forNecklace.add(dateBase.get(i));
                numOfDiamonds++;
            }

            if(compareWeight(dateBase.get(i).getWeight(),10,11) &&
                    numOfEmeralds < 2 && dateBase.get(i).getName().equals("Emerald")) {
                forNecklace.add(dateBase.get(i));
                numOfEmeralds++;
            }

            if(compareWeight(dateBase.get(i).getWeight(),10,11) &&
                    numOfRubies < 4 && dateBase.get(i).getName().equals("Ruby")) {
                forNecklace.add(dateBase.get(i));
                numOfRubies++;
            }
        }
        return forNecklace;
    }
    //Метод выводит общую цену и вес ожерелья
    public static void getWeightAndPriceNechlace(ArrayList<Gem> necklace) {
        BigDecimal allStonesWeight = new BigDecimal(0);
        BigDecimal allStonesPrice = new BigDecimal(0);

        for (int i = 0; i < necklace.size(); i++) {
            BigDecimal weight = new BigDecimal(necklace.get(i).getWeight());
            allStonesWeight = allStonesWeight.add(weight).setScale(3, RoundingMode.HALF_UP);
            allStonesPrice = allStonesPrice.add(necklace.get(i).getPrice()).setScale(3,RoundingMode.HALF_UP);
        }

        System.out.println("Total price "+allStonesPrice+" $");
        System.out.println("Total weight "+allStonesWeight+" carats");
        System.out.println();
    }
    //Метод сортирует камни по цене(сверху дорогие, снизу дешевые)
    public static void sortByPrice(ArrayList<Gem> necklace) {
        System.out.println("Sort by price"+"\n");
        for (int i = 0; i < necklace.size(); i++) {
            for (int j = 0; j < necklace.size(); j++) {

                if (necklace.get(i).getPrice().doubleValue() >
                        necklace.get(j).getPrice().doubleValue()) {
                    Gem obj = necklace.get(i);
                    necklace.set(i,necklace.get(j));
                    necklace.set(j,obj);
                }
            }
        }
    }
    //Метод выводит в консоль камни с которые "попадают" в заданный диапазон
    public static void showGemsInRanges(ArrayList<Gem> necklace,double rangeDoun,double rangeUp) {
        System.out.println("Gems in refraction rage"+"\n");
        int num = 0;
        for (int i = 0; i < necklace.size(); i++) {
            if (necklace.get(i).getClarity() > rangeDoun &&
                    necklace.get(i).getClarity() < rangeUp) {
                System.out.println(necklace.get(i).toString());
                num++;
            }
        }
        if (num == 0) {
            System.out.println("Gems not found");
        }
    }
    //Метод генерирует вес
    public static double generateWeight() {
        double a = new BigDecimal((Math.random()*50)+0.01).
                setScale(3,RoundingMode.HALF_DOWN).doubleValue();
        return a;
    }
    //Метод для проверки попадает ли вес в "рамки"
    public static boolean compareWeight (double weight, double rangeDoun,
                                         double rangeUp) {
        if(weight > rangeDoun && weight < rangeUp) {
            return true;
        } else {
            return false;
        }
    }
    public static int generateClarity() {
        int a = (int)(Math.random()*12)+1;
        return a;
    }

    //Выводит в консоль все элементы ArrayList
    public static void showArray(ArrayList<Gem> gemsArray) {
        for (Gem obj:gemsArray) {
            System.out.println(obj.toString());
        }
    }
}

