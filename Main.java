import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        Map map = Map.getInstance();
        RandomGenerator randomGenerator = new RandomGenerator();
        ConsoleInput consoleInput = new ConsoleInput();
        MapRender mapRender = new MapRender();
        Movement movement = new Movement();

        randomGenerator.randomValue(map);
        mapRender.printMap(map);

        boolean gameOver = false;
        do {
            int key = consoleInput.readConsoleInput();
            switch (key) {
                case 'a':
                    movement.move(map, Directions.LEFT);
                    break;
                case 'd':
                    movement.move(map, Directions.RIGHT);
                    break;
                case 'w':
                    movement.move(map, Directions.UP);
                    break;
                case 's':
                    movement.move(map, Directions.DOWN);
                    break;
                case 'q':
                    gameOver=true;
                    break;
            }

            randomGenerator.randomValue(map);
            mapRender.printMap(map);
        } while (!gameOver);

        System.out.println("Game over");

    }
}

