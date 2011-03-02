import paintbots.*;

import java.awt.*;
import java.util.Map;
import static paintbots.MoveRequest.MoveType.*;
import static paintbots.MoveRequest.*;

public class MassDestructionPaintbot extends PaintbotControl {

    private Color myColor;

  public static void main(String[] args) {
     PaintbotControl robot1 = new MassDestructionPaintbot();
     PaintbotControl robot2 = new CS207Paintbot2();
     PaintbotSimulation s = new PaintbotSimulation( robot1, robot2 );
     s.simulateGame( true );
  }

    boolean isOpponentsSquare(BoardSquare square) {
        return !square.getSquareColor().equals(myColor) && square.getSquareType().equals(InternalBoardSquare.SquareType.NORMAL);
    }

    private Color getOpponentsColor() {
        return myColor.equals(Color.RED) ? Color.BLUE : Color.RED;
    }

    boolean beenShot(BoardSquare square) {
        System.out.println("square = " + square.getSquareColor());
        return square.getSquareColor().equals(getOpponentsColor());
    }

    @Override
    public MoveRequest getMove(BoardSquare[][] scan, BoardSquare[][] longrangescan) {
        Map<Surroundings,BoardSquare> map = PaintbotUtil.getSurroundings(scan);
        PaintbotUtil.parseBoard(scan);
        MoveType moveType;
        switch(map.get(Surroundings.FRONT).getSquareType()) {
            case ROCK:
            case FOGROCK:
            case WALL:
                if (isOpponentsSquare(map.get(Surroundings.RIGHT))){
                    moveType = ROTATE_RIGHT;
                }
                else {
                    moveType = ROTATE_LEFT;
                }
                break;
            default:moveType = FORWARD;
        }
        if(beenShot(map.get(Surroundings.BEHIND))) {
            moveType = BACKWARD;
        }
        return new MoveRequest(moveType, true, false);
    }

    @Override
    public String getRobotName() {
        return this.getClass().toString();
    }

    @Override
    public String getStudentLastName() {
        return "Patel";
    }

    @Override
    public String getStudentID() {
        return "007";
    }

    @Override
    public boolean tournamentEntry() {
        return false;
    }

    @Override
    public void reset(Color color) {
        System.out.println("color = " + color);
        myColor = color;
    }
}
