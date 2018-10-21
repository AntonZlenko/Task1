import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

abstract class Operations {

    //В ожерелье добавляем 1 Алмаз, 2 Изумруда и 4 рубина
    public static ArrayList<Gem> Selections(ArrayList<Gem> dateBase) {
        ArrayList <Gem> forNecklace = new ArrayList<Gem>();
        System.out.println("Gems for necklace"+"\n");
        int numOfDiamonds = 0;
        int numOfEmeralds = 0;
        int numOfRubies = 0;

        for (int i = 0; i < dateBase.size(); i++) {

            if(dateBase.get(i).getName().equals("Diamond") &&
                    compareWeight(dateBase.get(i).getWeight(),19,21) &&
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

    public static void getWeightAndPriceNecklace(ArrayList<Gem> necklace) {

        System.out.println("\n" + "Total:"+"\n");
        BigDecimal allStonesWeight = new BigDecimal(0);
        BigDecimal allStonesPrice = new BigDecimal(0);

        for (int i = 0; i < necklace.size(); i++) {
            BigDecimal weight = new BigDecimal(necklace.get(i).getWeight());
            allStonesWeight = allStonesWeight.add(weight).setScale(2, RoundingMode.HALF_UP);
            allStonesPrice = allStonesPrice.add(necklace.get(i).getPrice()).setScale(2,RoundingMode.HALF_UP);
        }
        System.out.println("price - "+allStonesPrice+" $");
        System.out.println("weight - "+allStonesWeight+" carats");
        System.out.println();
    }

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

    public static double generateWeight() {
        double a = new BigDecimal((Math.random()*50)+0.01).
                setScale(1,RoundingMode.HALF_DOWN).doubleValue();
        return a;
    }

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

    public static void showArray(ArrayList<Gem> gemsArray) {
        for (Gem obj:gemsArray) {
            System.out.println(obj.toString());
        }
    }
}

