import paintbots.BoardSquare;
import static paintbots.InternalBoardSquare.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class PaintbotUtil {

    public static void parseBoard(BoardSquare[][] scan, int offset) {
        for(int x=offset;x<scan.length-offset;x++) {
            for(int y=offset;y<scan[x].length-offset;y++){
                System.out.print("Board["+x+"]["+y+"]=" + scan[x][y].getSquareType() + "\t");
            }
            System.out.print("\n");
        }
    }

    public static void parseBoard(BoardSquare[][] scan) {
        parseBoard(scan,1);

    }

    public static Map<Surroundings,BoardSquare> getSurroundings(BoardSquare[][] board) {
        Map<Surroundings, BoardSquare> map = new HashMap<Surroundings, BoardSquare>();
        int offset = board.length/2;
        map.put(Surroundings.FRONT,board[offset-1][offset]);
        map.put(Surroundings.BEHIND,board[offset+1][offset]);
        map.put(Surroundings.LEFT,board[offset][offset-1]);
        map.put(Surroundings.RIGHT,board[offset][offset+1]);
        return map;
    }
}
