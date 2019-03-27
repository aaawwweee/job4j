package ru.job4j.chess;

import ru.job4j.chess.firuges.*;

/**
 * @author Alexander Kashkin (kashkinmsk@gmail.com)
 * @version 1
 * @since 25.03.2019
 */
public class Logic {
    private final Figure[] figures = new Figure[32];
    private int index = 0;

    public void add(Figure figure) {
        this.figures[this.index++] = figure;
    }

    public boolean move(Cell source, Cell dest) throws FigureNotFoundException, ImpossibleMoveException,
            OccupiedWayException {
        boolean rst = false;
        int index = this.findBy(source);
        if (index == -1) {
            throw new FigureNotFoundException("No figure");
    }
        Cell[] steps = this.figures[index].way(source, dest);
        if (steps.length == 0 || !steps[steps.length - 1].equals(dest)) {
            throw new ImpossibleMoveException("Wrong way");
        }
        boolean checkIt = false;
        for (Cell step : steps) {
            for (Figure fig : figures) {
                if (fig.position().equals(step)) {
                    checkIt = true;
                }
            }
        }
        if (checkIt) {
            throw new OccupiedWayException("The Cell is busy");
        }
        if (steps.length > 0 && steps[steps.length - 1].equals(dest)) {
            rst = true;
            this.figures[index] = this.figures[index].copy(dest);
        }
        return rst;
}

    public void clean() {
        for (int position = 0; position != this.figures.length; position++) {
            this.figures[position] = null;
        }
        this.index = 0;
    }

    private int findBy(Cell cell) {
        int rst = -1;
        for (int index = 0; index != this.figures.length; index++) {
            if (this.figures[index] != null && this.figures[index].position().equals(cell)) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}
