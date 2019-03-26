package ru.job4j;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import ru.job4j.chess.Logic;
import ru.job4j.chess.firuges.*;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.PawnBlack;
import ru.job4j.chess.firuges.white.BishopWhite;
import ru.job4j.chess.firuges.white.PawnWhite;


/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Tests for BlackBishop
     */
    @Test
    public void whenBlackBishopMovesRightUp() {
        Logic l = new Logic();
        BishopBlack bb = new BishopBlack(Cell.D2);
        l.add(bb);
        boolean rst = l.move(Cell.D2, Cell.B4);
        assertThat(rst, is(true));
    }

    @Test
    public void whenBlackBishopMovesRightDown() {
        Logic l = new Logic();
        BishopBlack bb = new BishopBlack(Cell.D2);
        l.add(bb);
        boolean rst = l.move(Cell.D2, Cell.E3);
        assertThat(rst, is(true));
    }

    @Test
    public void whenBlackBishopMovesLeftUp() {
        Logic l = new Logic();
        BishopBlack bb = new BishopBlack(Cell.D2);
        l.add(bb);
        boolean rst = l.move(Cell.D2, Cell.C1);
        assertThat(rst, is(true));
    }

    @Test
    public void whenBlackBishopMovesLeftDown() {
        Logic l = new Logic();
        BishopBlack bb = new BishopBlack(Cell.D2);
        l.add(bb);
        boolean rst = l.move(Cell.D2, Cell.E1);
        assertThat(rst, is(true));
    }

    @Test
    public void whenBlackBishopMovesOnBusyCell() {
        Logic l = new Logic();
        BishopBlack bb = new BishopBlack(Cell.D2);
        PawnBlack pb = new PawnBlack(Cell.F4);
        l.add(bb);
        l.add(pb);
        boolean rst = l.move(Cell.D2, Cell.F4);
        assertThat(rst, is(false));
    }

    @Test
    public void whenBlackBishopMovesHorizontally() {
        Logic l = new Logic();
        BishopBlack bb = new BishopBlack(Cell.D2);
        l.add(bb);
        boolean rst = l.move(Cell.D2, Cell.D5);
        assertThat(rst, is(false));
    }

    @Test
    public void whenBlackBishopTriesToMoveThrowBusyCell() {
        Logic l = new Logic();
        BishopBlack bb = new BishopBlack(Cell.C2);
        BishopWhite bw = new BishopWhite(Cell.B3);
        l.add(bb);
        l.add(bw);
        boolean rst = l.move(Cell.C2, Cell.A4);
        assertThat(rst, is(false));
    }

    /**
     * Tests for WhiteBishop
     */
    @Test
    public void whenWhiteBishopMovesRightUp() {
        Logic l = new Logic();
        BishopWhite bw = new BishopWhite(Cell.D2);
        l.add(bw);
        boolean rst = l.move(Cell.D2, Cell.B4);
        assertThat(rst, is(true));
    }

    @Test
    public void whenWhiteBishopMovesRightDown() {
        Logic l = new Logic();
        BishopWhite bw = new BishopWhite(Cell.D2);
        l.add(bw);
        boolean rst = l.move(Cell.D2, Cell.E3);
        assertThat(rst, is(true));
    }

    @Test
    public void whenWhiteBishopMovesLeftUp() {
        Logic l = new Logic();
        BishopWhite bw = new BishopWhite(Cell.D2);
        l.add(bw);
        boolean rst = l.move(Cell.D2, Cell.C1);
        assertThat(rst, is(true));
    }

    @Test
    public void whenWhiteBishopMovesLeftDown() {
        Logic l = new Logic();
        BishopWhite bw = new BishopWhite(Cell.D2);
        l.add(bw);
        boolean rst = l.move(Cell.D2, Cell.E1);
        assertThat(rst, is(true));
    }

    @Test
    public void whenWhiteBishopMovesOnBusyCell() {
        Logic l = new Logic();
        BishopWhite bw = new BishopWhite(Cell.D2);
        PawnBlack pb = new PawnBlack(Cell.F4);
        l.add(bw);
        l.add(pb);
        boolean rst = l.move(Cell.D2, Cell.F4);
        assertThat(rst, is(false));
    }

    @Test
    public void whenWhiteBishopMovesHorizontally() {
        Logic l = new Logic();
        BishopWhite bw = new BishopWhite(Cell.D2);
        l.add(bw);
        boolean rst = l.move(Cell.D2, Cell.D5);
        assertThat(rst, is(false));
    }

    @Test
    public void whenWhiteBishopTriesToMoveThrowBusyCell() {
        Logic l = new Logic();
        BishopBlack bb = new BishopBlack(Cell.B3);
        BishopWhite bw = new BishopWhite(Cell.C2);
        l.add(bb);
        l.add(bw);
        boolean rst = l.move(Cell.C2, Cell.A4);
        assertThat(rst, is(false));
    }

    /**
     * Tests for BlackPawn
     */
    @Test
    public void whenBlackPawnMovesUp() {
        Logic l = new Logic();
        PawnBlack pb = new PawnBlack(Cell.D2);
        l.add(pb);
        boolean rst = l.move(Cell.D2, Cell.D1);
        assertThat(rst, is(true));
    }

    @Test
    public void whenBlackPawnTriesToMoveRight() {
        Logic l = new Logic();
        PawnBlack pb = new PawnBlack(Cell.D2);
        l.add(pb);
        boolean rst = l.move(Cell.D2, Cell.C2);
        assertThat(rst, is(false));
    }

    @Test
    public void whenBlackPawnTriesToMoveLeft() {
        Logic l = new Logic();
        PawnBlack pb = new PawnBlack(Cell.D2);
        l.add(pb);
        boolean rst = l.move(Cell.D2, Cell.E2);
        assertThat(rst, is(false));
    }

    @Test
    public void whenBlackPawnTriesToMoveDown() {
        Logic l = new Logic();
        PawnBlack pb = new PawnBlack(Cell.D2);
        l.add(pb);
        boolean rst = l.move(Cell.D2, Cell.D3);
        assertThat(rst, is(false));
    }
    @Test
    public void whenBlackPawnTriesToMoveOnBusyCell() {
        Logic l = new Logic();
        PawnBlack pb = new PawnBlack(Cell.D2);
        PawnWhite pw = new PawnWhite(Cell.D1);
        l.add(pb);
        l.add(pw);
        boolean rst = l.move(Cell.D2, Cell.D1);
        assertThat(rst, is(false));
    }
}
