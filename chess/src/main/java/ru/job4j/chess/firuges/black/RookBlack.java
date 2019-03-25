package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.ImpossibleMoveException;

/**
 * @author Alexander Kashkin (kashkinmsk@gmail.com)
 * @version 1
 * @since 25.03.2019
 */
public class RookBlack implements Figure {
    private final Cell position;

    public RookBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        BishopBlack bishopBlack = new BishopBlack(source);
        if (bishopBlack.isDiagonal(source, dest)) {
            throw new ImpossibleMoveException("Wrong way.");
        }
        int length = Math.abs((dest.x - source.x) + (dest.y - source.y));
        int dX = ((dest.x - source.x) * 8) / length;
        int dY = (dest.y - source.y) / length;
        Cell[] steps = new Cell[length];
        for (int i = 1; i - 1 < length; i++) {
            steps[i - 1] = Cell.values()[(source.x * 8 + source.y) + dX * i + dY * i];
        }
        return steps;
    }
    @Override
    public Figure copy(Cell dest) {
        return new RookBlack(dest);
    }
}
