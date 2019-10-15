package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BishopBlackTest {
    @Test
    public void whenPosition() {
        Figure bishopBlack = new BishopBlack(Cell.A1);
        assertThat(bishopBlack.position(), is(Cell.A1));
    }

    @Test
    public void whenCopy() {
        Figure bishopBlack = new BishopBlack(Cell.A1);
        bishopBlack = bishopBlack.copy(Cell.B2);
        assertThat(bishopBlack.position(), is(Cell.B2));
    }

    @Test
    public void whenWay() {
        Figure bishopBlack = new BishopBlack(Cell.C1);
        Cell[] calls = bishopBlack.way(Cell.C1, Cell.G5);
        Cell[] expected = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(calls, is(expected));
    }

    @Test
    public void whenWayNotDiagonal() {
        Figure bishopBlack = new BishopBlack(Cell.C1);
        String msg = null;
        try {
            bishopBlack.way(Cell.C1, Cell.G6);
        } catch (IllegalStateException ise) {
            msg = ise.getMessage();
        }
        assertThat(msg, is(String.format("Could not way by diagonal from %s to %s", Cell.C1, Cell.G6)));
    }
}
