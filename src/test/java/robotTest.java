import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class robotTest {

    Grid  grid = new Grid(5, 3);
    CommandCentre commandCentre = new CommandCentre(grid);
    Position startPosition1;
    Position startPosition2;
    Position startPosition3;
    String instruction1;
    String instruction2;
    String instruction3;
    Position endPosition1;
    Position endPosition2;
    Position endPosition3;
    Robot robot0;
    Robot robot1;
    Robot robot2;


    @Before
    public void setUp(){

        startPosition1 = new Position(1, 1, Cardinal.E);
        startPosition2 = new Position(3, 2, Cardinal.N);
        startPosition3 = new Position(0, 3, Cardinal.W);
        instruction1 = "R F R F R F R F";
        instruction2 = "F R R F L L F F R R F L L";
        instruction3 = "L L F F F L F L F L";
        endPosition1 = new Position(1, 1, Cardinal.E);
        endPosition2 = new Position(3, 3, Cardinal.N);
        endPosition3 = new Position(2, 3, Cardinal.S);
    }

    @Test
    public void commandCentreUploadCommandsTest() {
        commandCentre.upLoadNavInputToCommandLine(instruction1);
        assertEquals("R", commandCentre.commandLine.get(0));
        assertEquals("F", commandCentre.commandLine.get(1));
    }


    @Test
    public void robotTestStartPosition1() {
        robot0 = new Robot(startPosition1);
        commandCentre.upLoadNavInputToCommandLine(instruction1);
        robot0.move(commandCentre);
        robot0.move(commandCentre);
        robot0.move(commandCentre);
        robot0.move(commandCentre);
        assertEquals(Cardinal.W, robot0.currentPosition.getD());
        assertEquals( 1 , robot0.currentPosition.getX(),1);
        assertEquals( 0, robot0.currentPosition.getY(), 1);
        robot0.move(commandCentre);
        robot0.move(commandCentre);
        robot0.move(commandCentre);
        robot0.move(commandCentre);

        assertEquals(endPosition1.getD(), robot0.currentPosition.getD());
        assertEquals(endPosition1.getX(), robot0.currentPosition.getX());
        assertEquals(endPosition1.getY(), robot0.currentPosition.getY());
    }

    @Test
    public void robotTestStartPosition2(){
        robot0 = new Robot(startPosition2);
        commandCentre.upLoadNavInputToCommandLine(instruction2);
        robot0.move(commandCentre);
        robot0.move(commandCentre);
        robot0.move(commandCentre);
        robot0.move(commandCentre);
        robot0.move(commandCentre);
        robot0.move(commandCentre);
        robot0.move(commandCentre);
        robot0.move(commandCentre);
        robot0.move(commandCentre);
        robot0.move(commandCentre);
        robot0.move(commandCentre);
        robot0.move(commandCentre);
        robot0.move(commandCentre);
        assertEquals(true, robot0.lost);



    }

    @Test
    public void robotTestStartPosition3(){
        robot0 = new Robot(startPosition3);
        commandCentre.upLoadNavInputToCommandLine(instruction3);
        robot0.move(commandCentre);
        robot0.move(commandCentre);
        robot0.move(commandCentre);
        robot0.move(commandCentre);
        robot0.move(commandCentre);
        robot0.move(commandCentre);
        robot0.move(commandCentre);
        robot0.move(commandCentre);
        robot0.move(commandCentre);
        robot0.move(commandCentre);
        robot0.move(commandCentre);
        robot0.move(commandCentre);
        assertEquals(true, robot0.lost);


    }

    @Test
    public void robotTestAllPositions(){
        robot0 = new Robot(startPosition1);
        commandCentre.upLoadNavInputToCommandLine(instruction1);
        robot0.move(commandCentre);
        robot0.move(commandCentre);
        robot0.move(commandCentre);
        robot0.move(commandCentre);
        robot0.move(commandCentre);
        robot0.move(commandCentre);
        robot0.move(commandCentre);
        robot0.move(commandCentre);

        robot1 = new Robot(startPosition2);
        commandCentre.upLoadNavInputToCommandLine(instruction2);
        robot1.move(commandCentre);
        robot1.move(commandCentre);
        robot1.move(commandCentre);
        robot1.move(commandCentre);
        robot1.move(commandCentre);
        robot1.move(commandCentre);
        robot1.move(commandCentre);
        robot1.move(commandCentre);
        robot1.move(commandCentre);
        robot1.move(commandCentre);
        robot1.move(commandCentre);
        robot1.move(commandCentre);
        robot1.move(commandCentre);

        assertEquals(true, robot1.lost);

        robot2 = new Robot(startPosition3);
        commandCentre.upLoadNavInputToCommandLine(instruction3);
        robot2.move(commandCentre);
        robot2.move(commandCentre);
        robot2.move(commandCentre);
        robot2.move(commandCentre);
        robot2.move(commandCentre);
        robot2.move(commandCentre);
        robot2.move(commandCentre);
        robot2.move(commandCentre);
        robot2.move(commandCentre);
        robot2.move(commandCentre);
        robot2.move(commandCentre);
        robot2.move(commandCentre);
        robot2.move(commandCentre);
        assertEquals(Cardinal.S, robot2.currentPosition.getD());
        assertEquals(2, robot2.currentPosition.getX(), 0);
        assertEquals(3, robot2.currentPosition.getY(), 0);


    }







}







