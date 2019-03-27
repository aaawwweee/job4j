package ru.job4j;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import ru.job4j.chess.firuges.*;
import ru.job4j.chess.firuges.black.QeenBlack;
import ru.job4j.chess.firuges.ImpossibleMoveException;


public class AppTest {
    /**
     * Tests for BlackBishop
     */
    @Test
    public void whenBlackQueenMoves2Times() {
        QeenBlack qeenBlack = new QeenBlack(Cell.D8);
        Cell[] result = new Cell[3];
        try {
            result = qeenBlack.way(Cell.D6, Cell.D3);
        } catch (ImpossibleMoveException ex) {
            ex.getMessage();
        }
        Cell expected = Cell.D3;
        assertThat(result[2], is(expected));
    }
}
