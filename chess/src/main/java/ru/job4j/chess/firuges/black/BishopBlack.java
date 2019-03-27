package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Bishop;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * @author Alexander Kashkin (kashkinmsk@gmail.com)
 * @version 1
 * @since 25.03.2019
 */

public class BishopBlack extends Bishop {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
