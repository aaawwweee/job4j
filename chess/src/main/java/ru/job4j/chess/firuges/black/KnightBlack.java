package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.ImpossibleMoveException;

/**
 * @author Alexander Kashkin (kashkinmsk@gmail.com)
 * @version 1
 * @since 25.03.2019
 */
public class KnightBlack implements Figure {
    private final Cell position;

    public KnightBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        Cell[] steps = new Cell[0];
        if (source.y == dest.y + 2 && source.x == dest.x + 1
        || source.y == dest.y + 2 && source.x == dest.x - 1
        || source.y == dest.y - 1 && source.x == dest.x + 2
        || source.y == dest.y - 1 && source.x == dest.x - 2
        || source.y == dest.y - 2 && source.x == dest.x - 1
        || source.y == dest.y + 1 && source.x == dest.x - 2
        || source.y == dest.y - 2 && source.x == dest.x + 1
        || source.y == dest.y + 1 && source.x == dest.x + 2) {
            steps = new Cell[] {dest};
        } else {
            throw new ImpossibleMoveException("Wrong way");
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new KnightBlack(dest);
    }
}
