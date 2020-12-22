public class MapRender {

    public void printMap(Map map) {
        for (int i = 0; i < map.width(); ++i) {
            for (int j = 0; j < map.height(); ++j) {
                System.out.print(map.getValue(i,j) + "\t");
            }
            System.out.println();
        }
        instruction();
    }

    private void instruction(){
        System.out.println("To move w a s d, to quit q");
    }
}
