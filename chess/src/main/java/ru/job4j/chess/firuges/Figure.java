package ru.job4j.chess.firuges;

/**
 * @author Alexander Kashkin (kashkinmsk@gmail.com)
 * @version 1
 * @since 25.03.2019
 */
public interface Figure {
    Cell position();

    Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException;

    default String icon() {
        return String.format(
                "%s.png", this.getClass().getSimpleName()
        );

    }

    Figure copy(Cell dest);

}
