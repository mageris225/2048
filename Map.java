public class Map  {

    private static Map instance = new Map(); //singleton

    private int[][] Map = new int[][]{{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};

    private Map() {}

    public static Map getInstance(){
        return instance;
    }

    public int width() {
        return Map.length;
    }

    public int height() {
        return Map[0].length;
    }

    public int getValue(int x, int y){
        return Map[x][y];
    }

    public void setValue(int x, int y,int value){
         Map[x][y]=value;
    }

    public boolean tileIsFree(int x, int y) {
        return getValue(x,y) == 0;
    }

    public void setTileFree(int x, int y){
        Map[x][y]=0;
    }

}
