package main;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UtilitiesTest {

    Scanner mockScanner = mock(Scanner.class);

    @Test
    public void testParseShipPlacementCoordinatesCase1() {

        when(mockScanner.nextLine()).thenReturn("A1 B1");
        Utilities.input = mockScanner;

        int[][] coordinates = Utilities.parseShipPlacementCoordinates(2);
        int[][] expectedCoordinates = {{0, 0}, {1, 0}};
        assertArrayEquals(expectedCoordinates, coordinates);

        verify(mockScanner, times(1)).nextLine();
    }

    @Test
    public void testParseShipPlacementCoordinatesCase2() {
        when(mockScanner.nextLine()).thenReturn("A1 C1");
        Utilities.input = mockScanner;

        int[][] coordinates = Utilities.parseShipPlacementCoordinates(3);
        int[][] expectedCoordinates = {{0, 0}, {2, 0}};
        assertArrayEquals(expectedCoordinates, coordinates);

        verify(mockScanner, times(1)).nextLine();
    }

    @Test
    public void testParseShipPlacementCoordinatesCase3() {  //todo błąd w teście/ klasie
        when(mockScanner.nextLine()).thenReturn("D2 E7");
        Utilities.input = mockScanner;

        int[][] coordinates = Utilities.parseShipPlacementCoordinates(2);
        int[][] expectedCoordinates = {{3, 1}, {4, 6}};
        assertArrayEquals(expectedCoordinates, coordinates);

        verify(mockScanner, times(1)).nextLine();
    }
}