import java.util.ArrayList;
import java.util.Arrays;


public class Robot {

    ArrayList<Cardinal> cardinals;
    Position currentPosition;
    Position previousPosition;
    Position lastPositionBeforeLost;
    boolean lost;


    public Robot(Position start) {
        this.cardinals = new ArrayList<>(Arrays.asList(Cardinal.N, Cardinal.E, Cardinal.S, Cardinal.E));
        this.currentPosition = start;
        this.lastPositionBeforeLost = null;
        this.lost = false;
        this.previousPosition = null;
    }


    public void move(CommandCentre commandCentre){
        ascertainCurrentPosition();

        if ((commandCentre.commandLine.size() == 0)||(this.lost)){
           return;
        }
        switch(commandCentre.getNextCommand()) {
            case "R":
                switch(currentPosition.getD()) {
                    case N:
                        currentPosition.setD(Cardinal.E);
                        break;
                    case E:
                        currentPosition.setD(Cardinal.S);
                        break;
                    case S:
                        currentPosition.setD(Cardinal.W);
                        break;
                    case W:
                        currentPosition.setD(Cardinal.N);
                        break;
            }
            break;
            case "L":
                switch(currentPosition.getD()) {
                    case N:
                        currentPosition.setD(Cardinal.W);
                        break;
                    case E:
                        currentPosition.setD(Cardinal.N);
                        break;
                    case S:
                        currentPosition.setD(Cardinal.E);
                        break;
                    case W:
                        currentPosition.setD(Cardinal.S);
                        break;
                }
                break;
            case "F":

                changeGridPoint(currentPosition.getD().seeAxis(), currentPosition.getD().seeChangePosition());
        }

        if (losePrevention(commandCentre)){
            return;
        }

        checkOffGrid(commandCentre);

    }

    public void ascertainCurrentPosition(){
        previousPosition = new Position(currentPosition.getX(), currentPosition.getY(), currentPosition.getD());
    }


    public void changeGridPoint(String xy, Integer change){
        if (xy == "x"){
            this.currentPosition.setX(this.currentPosition.getX() + change);
        }
        else if (xy =="y"){
            this.currentPosition.setY(this.currentPosition.getY() + change);
        }
    }


    public boolean checkOffGrid(Grid grid){
        if ((this.currentPosition.getY() > grid.maxY) || (this.currentPosition.getY() < 0) || (this.currentPosition.getX() > grid.maxX) || (this.currentPosition.getX() < 0)){
         return true;
        }
        else {
        return false;
        }
    }

    public boolean losePrevention(CommandCentre commandCentre){
        if (commandCentre.noGoArea.size() > 0) {
            for (Position item : commandCentre.noGoArea) {
                if ((currentPosition.getX() == item.getX()) && (currentPosition.getY() == item.getY())) {
                 currentPosition = new Position(previousPosition.getX(), previousPosition.getY(), previousPosition.getD());
                    return true;
                }
            }
        }
        return false;
    }

    public void checkOffGrid(CommandCentre commandCentre){
        if (checkOffGrid(commandCentre.getGrid())){
            commandCentre.noGoArea.add(currentPosition);
            this.lost = true;
        }
    }

}





