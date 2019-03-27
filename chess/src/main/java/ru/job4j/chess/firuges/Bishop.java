package ru.job4j.chess.firuges;

public abstract class Bishop implements Figure {

    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        if (!isDiagonal(source, dest)) {
            throw new ImpossibleMoveException("Wrong way.");
        }
        int dX = (dest.x - source.x) < 0 ? -1 : 1;
        int dY = (dest.y - source.y) < 0 ? -1 : 1;
        int length = Math.abs(dest.x - source.x);
        Cell[] steps = new Cell[length];
        for (int i = 0; i < length; i++) {
            steps[i] = Cell.values()[(source.x + dX * (i + 1)) * 8 + (source.y + dY * (i + 1))];
        }
        return steps;
    }
    public boolean isDiagonal(Cell source, Cell dest) {
        boolean result = false;
        if (Math.abs(dest.y - source.y) == Math.abs(dest.x - source.x)) {
            result = true;
        }
        return result;
    }
    public abstract Figure copy(Cell dest);
}
