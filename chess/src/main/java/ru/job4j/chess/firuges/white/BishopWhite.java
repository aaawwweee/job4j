package ru.job4j.chess.firuges.white;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.ImpossibleMoveException;
import ru.job4j.chess.firuges.black.BishopBlack;

/**
 * @author Alexander Kashkin (kashkinmsk@gmail.com)
 * @version 1
 * @since 25.03.2019
 */
public class BishopWhite implements Figure {
    private final Cell position;

    public BishopWhite(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        if (!BishopBlack.isDiagonal(source, dest)) {
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

    @Override
    public Figure copy(Cell dest) {
        return new BishopWhite(dest);
    }
}
