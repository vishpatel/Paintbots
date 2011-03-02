import paintbots.BoardSquare;
import paintbots.InternalBoardSquare;

import java.awt.*;

public class BoardSquareDO implements BoardSquare{
    private InternalBoardSquare.SquareType squareType;
    private Color color = Color.WHITE;

    public BoardSquareDO(InternalBoardSquare.SquareType squareType) {
        this.squareType = squareType;
    }
    public BoardSquareDO(Color color) {
        this.color = color;
    }
    public Color getSquareColor() {
        return color;
    }

    public boolean redRobotPresent() {
        return false;
    }

    public boolean blueRobotPresent() {
        return false;
    }

    public int robotDirection() {
        return 0;
    }

    public InternalBoardSquare.SquareType getSquareType() {
        return squareType;
    }
}
