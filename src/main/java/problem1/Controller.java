package problem1;

import static problem1.Constants.COMMAND_ADD_ENTRY;
import static problem1.Constants.COMMAND_COMPLETE;
import static problem1.Constants.COMMAND_DISPLAY;
import static problem1.Constants.DISPLAY_BY_DATE;
import static problem1.Constants.DISPLAY_BY_PRIORITY;
import static problem1.Constants.DISPLAY_CATEGORY;
import static problem1.Constants.DISPLAY_INCOMPLETE;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * A class representing a Controller
 */
public class Controller {

  private final Model model;
  private final HashMap<String, ArrayList<String>> tasks;

  /**
   * A constructor for the Controller class
   *
   * @param model the model
   * @param tasks the user input in the HashMap
   */

  public Controller(Model model,
      HashMap<String, ArrayList<String>> tasks) {
    this.model = model;
    this.tasks = tasks;
  }

  /**
   * Getter for a model
   *
   * @return a model
   */

  public Model getModel() {
    return model;
  }

  /**
   * Getter for a Tasks
   *
   * @return a Tasks
   */

  public HashMap<String, ArrayList<String>> getTasks() {
    return tasks;
  }

  /**
   * A void method to execute task to add entry and set complete
   *
   * @throws CmdLineExceptions     thrown if the command does not exist
   * @throws FileNotFoundException thrown if the file does not exist
   */

  public void executeTask() throws CmdLineExceptions, FileNotFoundException {
    for (Map.Entry<String, ArrayList<String>> mapElement : this.tasks.entrySet()) {
      String key = mapElement.getKey();
      ArrayList<String> arguments = mapElement.getValue();
      if (key.equals(COMMAND_ADD_ENTRY)) {
        DigitalEntry newEntry = DigitalEntry.buildEntryFromString(arguments);
        this.model.addEntry(newEntry);
      }
      if (key.equals(COMMAND_COMPLETE)) {
        for (String i : arguments) {
          Integer id = Integer.valueOf(i);
          this.model.setCompletedByID(id);
        }
      }
    }
    this.model.writeToCSV();
  }

  /**
   * A method to return a hashmap with filtered data for display
   *
   * @return a hashmap containing digital entry data
   */

  public Map<Integer, DigitalEntry> display() {
    TreeMap<Integer, DigitalEntry> toDisplay = this.model.getEntries();
    for (Map.Entry<String, ArrayList<String>> mapElement : this.tasks.entrySet()) {
      String key = mapElement.getKey();
      ArrayList<String> arguments = mapElement.getValue();
      if (key.equals(COMMAND_DISPLAY)) {

        if (arguments.contains(DISPLAY_INCOMPLETE)) {
          toDisplay = Model.filterIncomplete(toDisplay);
        }

        if (arguments.contains(DISPLAY_CATEGORY)) {
          toDisplay = Model.filterByCategory(toDisplay, arguments.get(1));
        }

        if (arguments.contains(DISPLAY_BY_DATE)) {
          toDisplay = Model.sortEntriesByDate(toDisplay);
        }

        if (arguments.contains(DISPLAY_BY_PRIORITY)) {
          toDisplay = Model.sortEntriesByPriority(toDisplay);
        }
        return toDisplay;
      }
    }
    return null;
  }

}
