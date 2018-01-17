import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class CommandCentre {

    ArrayList<String> commandLine;
    public String nextCommand;
    ArrayList<Position> noGoArea;
    Grid grid;
    ArrayList<Position> record;


    public CommandCentre(Grid grid) {
        this.grid = grid;
        this.nextCommand = null;
        this.noGoArea = new ArrayList<>();
        this.commandLine = new ArrayList<>();
        this.record = new ArrayList<>();

    }

    public void upLoadNavInputToCommandLine(String navInput){
        commandLine = new ArrayList<>(Arrays.asList(navInput.split(" ")));
        nextCommand = commandLine.get(0);
    }

    public String getNextCommand(){
        this.nextCommand = commandLine.get(0);
        this.commandLine.remove(0);
        return nextCommand;
        }



        public Grid getGrid(){
        return this.grid;
        }
}

