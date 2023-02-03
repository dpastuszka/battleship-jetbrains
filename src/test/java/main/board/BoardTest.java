package main.board;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Java6Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class BoardTest {

    @Test
    void shouldReturnEmptyBoardWithProperSize() {
        Board board = new Board();
        board.generateMap();
        Cell[][] generatedMap = board.getMap();
        assertThat(generatedMap.length).isEqualTo(10);
        assertThat(generatedMap[0].length).isEqualTo(10);
        assertThat(generatedMap[9].length).isEqualTo(10);
    }

    @Test
    void shouldReturnEmptyBoardWithAllEmptyCells() {
        Board board = new Board();
        board.generateMap();
        Cell[][] generatedMap = board.getMap();
        for (Cell[] row : generatedMap)
        {
            for (Cell cell : row)
            {
                assertThat(cell.getCellStatus()).isEqualTo(CellStatus.EMPTY);
            }
        }
    }
}