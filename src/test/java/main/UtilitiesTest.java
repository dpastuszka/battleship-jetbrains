package main;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UtilitiesTest {

    Scanner mockScanner = mock(Scanner.class);

    @Test
    public void shouldParseCorrectCoordsInHorizontalRight() {

        when(mockScanner.nextLine()).thenReturn("A1 B1");
        Utilities.input = mockScanner;

        int[][] coordinates = Utilities.parseShipPlacementCoordinates(2);
        int[][] expectedCoordinates = {{0, 0}, {1, 0}};
        assertArrayEquals(expectedCoordinates, coordinates);

        verify(mockScanner, times(1)).nextLine();
    }

    @Test
    public void shouldParseCorrectCoordsInHorizontalLeft() {

        when(mockScanner.nextLine()).thenReturn("J10 J8");
        Utilities.input = mockScanner;

        int[][] coordinates = Utilities.parseShipPlacementCoordinates(3);
        int[][] expectedCoordinates = {{9, 7}, {9, 9}};
        assertArrayEquals(expectedCoordinates, coordinates);

        verify(mockScanner, times(1)).nextLine();
    }

    @Test
    public void shouldParseCorrectCoordsVerticalDownward() {
        when(mockScanner.nextLine()).thenReturn("D3 H3");
        Utilities.input = mockScanner;

        int[][] coordinates = Utilities.parseShipPlacementCoordinates(5);
        int[][] expectedCoordinates = {{3, 2}, {7, 2}};
        assertArrayEquals(expectedCoordinates, coordinates);

        verify(mockScanner, times(1)).nextLine();
    }

    @Test
    public void shouldParseCorrectCoordsVerticalUpward() {
        when(mockScanner.nextLine()).thenReturn("G7 E7");
        Utilities.input = mockScanner;

        int[][] coordinates = Utilities.parseShipPlacementCoordinates(3);
        int[][] expectedCoordinates = {{4, 6}, {6, 6}};
        assertArrayEquals(expectedCoordinates, coordinates);

        verify(mockScanner, times(1)).nextLine();
    }
//
//    @Test
//    public void shouldThrowExceptionWhenTooChoordsShort() {
//        when(mockScanner.nextLine()).thenReturn("G7 E7");
//        Utilities.input = mockScanner;
//        try {
//            int[][] coordinates = Utilities.parseShipPlacementCoordinates(4);
//            fail("Expected an IllegalArgumentException to be thrown");
//        } catch (IllegalArgumentException e) {
//            assertEquals("Error! Ship have to be vertical or horizontal", e.getMessage());
//        }
//
//        verify(mockScanner, times(1)).nextLine();
//    }
//
//    @Test
//    public void shouldThrowExceptionWhenCoordsTooLong() {
//        when(mockScanner.nextLine()).thenReturn("G7 E7");
//        Utilities.input = mockScanner;
//        try {
//            int[][] coordinates = Utilities.parseShipPlacementCoordinates(2);
//            fail("Expected an IllegalArgumentException to be thrown");
//        } catch (IllegalArgumentException e) {
//            assertEquals("Error! Ship have to be vertical or horizontal", e.getMessage());
//        }
//
//        verify(mockScanner, times(1)).nextLine();
//    }
//

//    @Test
//    public void shouldThrowIllegalArgumentExceptionWhenCoordinatesNotInLine() {
//        when(mockScanner.nextLine()).thenReturn("D2 E7");
//        Utilities.input = mockScanner;
//        try {
//            int[][] coordinates = Utilities.parseShipPlacementCoordinates(5);
//            fail("Expected an IllegalArgumentException to be thrown");
//        } catch (IllegalArgumentException e) {
//            assertEquals("Error! Ship have to be vertical or horizontal", e.getMessage());
//        }
//
//        verify(mockScanner, times(1)).nextLine();
//    }

    //todo test for coordinates out of map
}