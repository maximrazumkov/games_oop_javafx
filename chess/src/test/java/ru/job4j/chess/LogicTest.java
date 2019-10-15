package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.KingBlack;
import ru.job4j.chess.firuges.white.QueenWhite;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LogicTest {

    @Test
    public void whenMoveThatFigureNotFound() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.D4));
        logic.add(new KingBlack(Cell.D5));
        logic.add(new BishopBlack(Cell.B6));
        logic.add(new QueenWhite(Cell.B5));
        boolean result = logic.move(Cell.D8, Cell.F6);
        assertThat(result, is(false));
    }

    @Test
    public void whenMove() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.D4));
        logic.add(new KingBlack(Cell.D5));
        logic.add(new BishopBlack(Cell.B6));
        logic.add(new QueenWhite(Cell.B5));
        boolean result = logic.move(Cell.D4, Cell.F6);
        assertThat(result, is(true));
    }

    @Test
    public void whenMoveThatPossionNotEmpty() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.D4));
        logic.add(new KingBlack(Cell.D5));
        logic.add(new BishopBlack(Cell.B6));
        logic.add(new QueenWhite(Cell.B5));
        logic.add(new QueenWhite(Cell.E5));
        boolean result = logic.move(Cell.D4, Cell.F6);
        assertThat(result, is(false));
    }

}
