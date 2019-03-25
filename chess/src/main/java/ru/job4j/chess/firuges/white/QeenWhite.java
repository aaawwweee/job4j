package ru.job4j.chess.firuges.white;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.ImpossibleMoveException;
import ru.job4j.chess.firuges.black.QeenBlack;

/**
 * @author Alexander Kashkin (kashkinmsk@gmail.com)
 * @version 1
 * @since 25.03.2019
 */
public class QeenWhite implements Figure {
    private final Cell position;

    public QeenWhite(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        if (!QeenBlack.queenPossibleWay(source, dest)) {
            throw new ImpossibleMoveException("Wrong way");
        }
        int length = dest.x - source.x != 0 ? Math.abs(dest.x - source.x) : Math.abs(dest.y - source.y);
        int dX = (dest.x - source.x) * 8 / length;
        int dY = (dest.y - source.y) / length;
        Cell[] cells = Cell.values();
        Cell[] steps = new Cell[length];
        for (int i  = 1; i - 1 < length; i++) {
            steps[i - 1] = cells[(source.x * 8 + source.y) + dX * i + dY * i];
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new QeenWhite(dest);
    }
}
