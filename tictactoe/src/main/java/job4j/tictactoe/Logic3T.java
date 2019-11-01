package job4j.tictactoe;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Predicate;

public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    public boolean fillBy(Predicate<Figure3T> predicate) {
        boolean result = false;
        int length = this.table.length;
        for (int i = 0; i < length; ++i) {
            Figure3T figure3T = table[i][i];
            if (predicate.test(figure3T)) {
                int y = 0;
                int x = 0;
                int diag = 0;
                int backDiag = 0;
                for (int j = 0; j < length; ++j) {
                    if (predicate.test(this.table[i][j])) {
                        ++x;
                    }
                    if (predicate.test(this.table[j][i])) {
                        ++y;
                    }
                    if (predicate.test(this.table[j][j])) {
                        ++diag;
                    }
                    if (predicate.test(this.table[length - 1 - j][j])) {
                        ++backDiag;
                    }
                }
                if (length == y || length == x || length == diag || length == backDiag) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    public boolean isWinnerX() {
        return this.fillBy(Figure3T::hasMarkX);
    }

    public boolean isWinnerO() {
        return this.fillBy(Figure3T::hasMarkO);
    }

    public boolean hasGap() {
        Optional<Figure3T> optFigure = Arrays.stream(this.table)
                .flatMap(Arrays::stream)
                .filter(figure3T -> !figure3T.hasMarkO() && !figure3T.hasMarkX()).findFirst();
        return optFigure.isPresent();
    }
}
