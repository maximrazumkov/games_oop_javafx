package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        if (!isDiagonal(source, dest)) {
            throw new IllegalStateException(
                    String.format("Could not way by diagonal from %s to %s", source, dest)
            );
        }
        int size = Math.abs(source.x - dest.x);
        Cell[] steps = new Cell[size];
        int deltaX = (source.x - dest.x) < 0 ? 1 : -1;
        int deltaY = (source.y - dest.y) < 0 ? 1 : -1;
        int x = position.x + 1;
        int y = position.y + 1;
        int idx = 0;
        for (Cell cell : Cell.values()) {
            if (idx == steps.length) {
                break;
            }
            if (cell.x != x || cell.y != y) {
                continue;
            }
            x += deltaX;
            y += deltaY;
            steps[idx++] = cell;
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        //TODO check diagonal
        return (Math.abs(source.x - dest.x)) == (Math.abs(source.y - dest.y));
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
