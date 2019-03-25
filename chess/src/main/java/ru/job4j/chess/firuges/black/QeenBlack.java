package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.ImpossibleMoveException;

/**
 * @author Alexander Kashkin (kashkinmsk@gmail.com)
 * @version 1
 * @since 25.03.2019
 */
public class QeenBlack implements Figure {
    private final Cell position;

    public QeenBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        if (!queenPossibleWay(source, dest)) {
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

    public static boolean queenPossibleWay(Cell source, Cell dest) {
        boolean result = false;
        if (!source.equals(dest) && ((Math.abs(source.x - dest.x) == Math.abs(source.y - dest.y))
        || (source.x == dest.x || source.y == dest.y))) {
            result = true;
        }
        return result;
    }

    @Override
    public Figure copy(Cell dest) {
        return new QeenBlack(dest);
    }
}
