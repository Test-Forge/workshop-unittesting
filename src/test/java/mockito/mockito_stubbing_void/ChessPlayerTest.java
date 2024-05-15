package mockito.mockito_stubbing_void;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

class ChessPlayerTest {

    @Test
    public void testAssignCategorySpy() throws Exception {

        ChessPlayer chessPlayer = new ChessPlayer("Magnus", 30);
        ChessPlayer chessPlayerSpy = spy(chessPlayer);

        doNothing().when(chessPlayerSpy).assignCategory(); // this will return null on the 'assignCategory()'
        chessPlayerSpy.assignCategory();

        assertEquals("Senior", chessPlayerSpy.getCategory());

    }

    @Test
    public void testAssignCategoryMock() throws Exception {

        ChessPlayer chessPlayerMock = mock(ChessPlayer.class);

        when(chessPlayerMock.getAge()).thenReturn(30);

        // doCallRealMethod() - used to call the real method upon a mock object
        doCallRealMethod().when(chessPlayerMock).assignCategory();
        doCallRealMethod().when(chessPlayerMock).getCategory();
        chessPlayerMock.assignCategory();

        assertEquals("Senior", chessPlayerMock.getCategory());
    }

    @Test
    public void testAssignCategoryMockException() throws Exception {

        ChessPlayer chessPlayerMock = mock(ChessPlayer.class);
        doThrow(Exception.class).when(chessPlayerMock).assignCategory(); // use 'doThrow' when you want to test whether an exception is thrown
        assertThrows(Exception.class, chessPlayerMock::assignCategory);
    }

    @Test
    public void testAssignScoreStats() {
        ChessPlayer chessPlayer = new ChessPlayer("Magnus", 30);
        ChessPlayer chessPlayerSpy = spy(chessPlayer);

        doAnswer((chessP) -> {
            ChessPlayer player = (ChessPlayer)chessP.getMock();
            player.setWins(3);
            player.setPoints(9);
            return null;
        }).when(chessPlayerSpy).assignScoreStats();

        chessPlayerSpy.assignScoreStats();
        assertSame(3, chessPlayerSpy.getWins());
        assertSame(9, chessPlayerSpy.getPoints());
    }

}