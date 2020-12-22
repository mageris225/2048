public class RandomGenerator {

    private final int lowerValue = 2;
    private final int higherValue = 4;
    private final int percentageToRollLowerValue = 2;
    private final int maxPercentage = 10;
    private final int minPercentage = 1;
    private final int maxCoordinate = 3;
    private final int minCoordinate = 0;

    public void randomValue(Map map) {
        while (true) {
            if(setRandomValue(map))
            break;
        }
    }

    private boolean setRandomValue(Map map){
        int randomX = getRandomCoordinate();
        int randomY = getRandomCoordinate();

        if (map.tileIsFree(randomX, randomY)) {
            map.setValue(randomX, randomY, getRandomValue());
            return true;
        }
        return false;
    }

    private int getRandomCoordinate() {
        return (int) (Math.random() * (maxCoordinate - minCoordinate + 1) + minCoordinate);
    }

    private int getProbability() {
        return (int) (Math.random() * (maxPercentage - minPercentage + minPercentage) + minPercentage);
    }

    private int getRandomValue() {
        if(getProbability() > percentageToRollLowerValue)
            return lowerValue;

        return higherValue;
    }
}