package problem1;

import static problem1.Constants.COMMAND_DISPLAY;
import static problem1.Constants.DISPLAY_BY_DATE;
import static problem1.Constants.DISPLAY_BY_PRIORITY;
import static problem1.Constants.DISPLAY_CATEGORY;
import static problem1.Constants.DISPLAY_INCOMPLETE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * A class representing an entry display holder
 */

public class EntryDisplayHolder extends AbstractDataHolder {

  /**
   * A method to process entry for display
   *
   * @param userInput the users input as arguments
   * @return a hashmap user input as key and details of digital entry as values
   * @throws CmdLineExceptions.ArgumentNotFoundException an exception thrown if argument is not
   *                                                     found
   * @throws CmdLineExceptions.UnknownArgumentException  an exception thrown if argument is unknown
   */

  @Override
  protected HashMap<String, ArrayList<String>> process(ArrayList<String> userInput)
      throws CmdLineExceptions {
    if (checkIfMutuallyExclusive(DISPLAY_BY_DATE, DISPLAY_BY_PRIORITY, userInput)) {
      this.toRemove.add(userInput.indexOf(COMMAND_DISPLAY));
      if (userInput.contains(DISPLAY_CATEGORY)) {
        int flag = userInput.indexOf(DISPLAY_CATEGORY);
        int argument = flag + 1;
        if (checkIfValid(userInput, argument)) {
          this.allDetails.add(DISPLAY_CATEGORY);
          this.allDetails.add(userInput.get(argument));
          this.toRemove.add(flag);
          this.toRemove.add(argument);
        } else {
          throw new CmdLineExceptions.ArgumentNotFoundException(
              "Argument not provided for display by category");
        }
      } else {
        this.allDetails.add(null);
        this.allDetails.add(null);
      }
      List<String> toFind = new ArrayList<>(
          Arrays.asList(DISPLAY_INCOMPLETE, DISPLAY_BY_DATE, DISPLAY_BY_PRIORITY));
      for (String s : toFind) {
        if (userInput.contains(s)) {
          this.allDetails.add(s);
          this.toRemove.add(userInput.indexOf(s));
        } else {
          this.allDetails.add(null);
        }
      }
      removeFromArguments(userInput, this.toRemove);
      HashMap<String, ArrayList<String>> outputDisplay = new HashMap<>();
      outputDisplay.put(COMMAND_DISPLAY, this.allDetails);
      return outputDisplay;
    } else {
      throw new CmdLineExceptions.UnknownArgumentException("Extra argument detected");
    }
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof EntryDisplayHolder;
  }

  @Override
  public int hashCode() {
    return EntryDisplayHolder.class.hashCode();
  }

  @Override
  public String toString() {
    return "DataProcessor{}";
  }
}

