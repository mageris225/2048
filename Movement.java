public class Movement {

    private void addValue(Map map, int rowToChange, int columnToChange, int currentRow, int currentColumn, int value) {
        map.setValue(rowToChange, columnToChange, value);
        map.setTileFree(currentRow, currentColumn);
    }

    private boolean nextTileIsFreeOrMatching(Map map, int rowToCheck, int columnToCheck, int rowNow, int columnNow) {
        return map.tileIsFree(rowToCheck, columnToCheck) || map.getValue(rowToCheck, columnToCheck) == map.getValue(rowNow, columnNow);
    }

    private void moveTile(Map map, int rowAddto, int columnAddTo, int rowNow, int columnNow, Directions directions) {
        if (map.tileIsFree(rowAddto, columnAddTo)) {
            addValue(map, rowAddto, columnAddTo, rowNow, columnNow, map.getValue(rowNow, columnNow));
        } else {
            if (directions == Directions.RIGHT)
                addValue(map, rowAddto, --columnAddTo, rowNow, columnNow, map.getValue(rowNow, columnNow));
            else if (directions == Directions.LEFT)
                addValue(map, rowAddto, ++columnAddTo, rowNow, columnNow, map.getValue(rowNow, columnNow));
            else if (directions == Directions.UP)
                addValue(map, ++rowAddto, columnAddTo, rowNow, columnNow, map.getValue(rowNow, columnNow));
            else if (directions == Directions.DOWN)
                addValue(map, --rowAddto, columnAddTo, rowNow, columnNow, map.getValue(rowNow, columnNow));
        }
    }

    private void rightMove(Map map, int INT) {
        int lastChangeableIndex = map.width() - 1;
        for (int column = map.width() - 2; column >= 0; column--) {
            if (!map.tileIsFree(INT, column)) {
                if (nextTileIsFreeOrMatching(map, INT, column + 1, INT, column)) {
                    if (map.getValue(INT, lastChangeableIndex) == map.getValue(INT, column)) {
                        addValue(map, INT, lastChangeableIndex, INT, column, map.getValue(INT, lastChangeableIndex) * 2);
                    } else {
                        moveTile(map, INT, lastChangeableIndex, INT, column, Directions.RIGHT);
                    }
                } else lastChangeableIndex--;
            }
        }
    }

    private void leftMove(Map map, int INT) {
        int lastChangeableIndex = 0;
        for (int column = 1; column < map.width(); column++) {
            if (!map.tileIsFree(INT, column)) {
                if (nextTileIsFreeOrMatching(map, INT, column - 1, INT, column)) {
                    if (map.getValue(INT, lastChangeableIndex) == map.getValue(INT, column)) {
                        addValue(map, INT, lastChangeableIndex, INT, column, map.getValue(INT, lastChangeableIndex) * 2);
                    } else {
                        moveTile(map, INT, lastChangeableIndex, INT, column, Directions.LEFT);
                    }
                } else lastChangeableIndex++;
            }
        }
    }

    private void upMove(Map map, int INT) {
        int lastChangeableIndex = 0;
        for (int row = 1; row < map.width(); row++) {
            if (!map.tileIsFree(row, INT)) {
                if (nextTileIsFreeOrMatching(map, row - 1, INT, row, INT)) {
                    if (map.getValue(lastChangeableIndex, INT) == map.getValue(row, INT)) {
                        addValue(map, lastChangeableIndex, INT, row, INT, map.getValue(lastChangeableIndex, INT) * 2);
                    } else {
                        moveTile(map, lastChangeableIndex, INT, row, INT, Directions.UP);
                    }
                } else lastChangeableIndex++;
            }
        }
    }

    private void downMove(Map map, int INT) {
        int lastChangeableIndex = map.width() - 1;
        for (int row = 2; row >= 0; row--) {
            if (!map.tileIsFree(row, INT)) {
                if (nextTileIsFreeOrMatching(map, row + 1, INT, row, INT)) {
                    if (map.getValue(lastChangeableIndex, INT) == map.getValue(row, INT)) {
                        addValue(map, lastChangeableIndex, INT, row, INT, map.getValue(lastChangeableIndex, INT) * 2);
                    } else {
                        moveTile(map, lastChangeableIndex, INT, row, INT, Directions.DOWN);
                    }
                } else lastChangeableIndex--;
            }
        }
    }

    public void move(Map map, Directions directions) {
        for (int INT = 0; INT < map.width(); INT++) {
            if (directions == Directions.RIGHT)
                rightMove(map, INT);
            else if (directions == Directions.LEFT)
                leftMove(map, INT);
            else if (directions == Directions.UP)
                upMove(map, INT);
            else if (directions == Directions.DOWN)
                downMove(map, INT);
        }
    }
}
