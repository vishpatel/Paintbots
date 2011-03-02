

import org.junit.Before;
import org.junit.Test;
import paintbots.BoardSquare;
import paintbots.MoveRequest;
import static paintbots.MoveRequest.MoveType.*;

import static paintbots.InternalBoardSquare.*;

import java.awt.*;
import java.lang.reflect.Method;

import static org.junit.Assert.*;

public class MassDestructionPaintbotTest {
    BoardSquareDO rock = new BoardSquareDO(SquareType.ROCK);
    BoardSquareDO normal = new BoardSquareDO(SquareType.NORMAL);
    BoardSquareDO opponent = new BoardSquareDO(Color.RED);
    MassDestructionPaintbot bot;
    private static void fillBoard(BoardSquare[][] scan, int offset) {
        for(int x=offset;x<scan.length-offset;x++) {
            for(int y=offset;y<scan[x].length-offset;y++){
                System.out.print("Board["+x+"]["+y+"]=" + scan[x][y].getSquareType() + "\t");
            }
            System.out.print("\n");
        }
    }

    @Before
    public void setUp() {
        bot = new MassDestructionPaintbot();
        bot.reset(Color.BLUE);
    }

    @Test
    public void inFrontOfRock() throws Throwable {
        BoardSquare[][] scan = new BoardSquare[][] {
            {normal,rock,normal},
            {normal,normal,normal},
            {normal,normal,normal}
        };
        assertEquals(ROTATE_LEFT, getMoveType(bot.getMove(scan, null)));

    }

    @Test
    public void shouldMoveToOpponentColor() throws Throwable {
        BoardSquare[][] scan = new BoardSquare[][] {
            {normal,rock,normal},
            {normal,normal,opponent},
            {normal,normal,normal}
        };
        assertEquals(ROTATE_RIGHT, getMoveType(bot.getMove(scan, null)));
    }

    private MoveRequest.MoveType getMoveType(MoveRequest request) throws Throwable {
        Method m = request.getClass().getDeclaredMethod("getMovetype");
        m.setAccessible(true);
        return (MoveRequest.MoveType)m.invoke(request);
    }

}
