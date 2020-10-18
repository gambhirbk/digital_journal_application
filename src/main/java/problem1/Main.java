package problem1;

import static problem1.Constants.CSV_ARG;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * A main class to run the program
 */


public class Main {

  protected static final int INPUT_FILE_INDEX = 0;

  /**
   * Construct for the main class
   *
   * @param args the arguments the user entered
   * @throws CmdLineExceptions.ArgumentNotFoundException exception thrown if the argument is not
   *                                                     found
   * @throws CmdLineExceptions.UnknownArgumentException  exception thrown if the argument is
   *                                                     unknown
   * @throws CmdLineExceptions.InvalidIDException        exception thrown if the id is invalid
   * @throws CmdLineExceptions.InvalidPriorityException  exception thrown if priority is invalid
   * @throws FileNotFoundException                       exception throw if file is not found
   */
  public static void main(String[] args)
      throws CmdLineExceptions, FileNotFoundException {
    CommandLineProcessor clp = new CommandLineProcessor(args);
    HashMap<String, ArrayList<String>> allTasks = clp.argumentSeparator(); // package neatly all flags and args into a list of HashMap

    Model digitalEntryDatabase = new Model(allTasks.get(CSV_ARG).get(INPUT_FILE_INDEX)); // create data model
    Controller program = new Controller(digitalEntryDatabase, allTasks); // ingest package

    program.executeTask(); // execute all tasks, modify data model, write to backup CSV
    Map<Integer, DigitalEntry> toDisplay = program.display(); // output final TreeMap, primary key is ID

    View finalView = new View(toDisplay); // Front end focus, still render on errors
    finalView.printAllEntries();
  }
}
