package problem1;

import static problem1.Constants.COMMAND_ADD_ENTRY;
import static problem1.Constants.ENTRY_CATEGORY;
import static problem1.Constants.ENTRY_COMPLETED;
import static problem1.Constants.ENTRY_DATE;
import static problem1.Constants.ENTRY_PRIORITY;
import static problem1.Constants.ENTRY_TEXT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * A class representing an entry creation holder
 */

public class EntryCreationHolder extends AbstractDataHolder {

  /**
   * A method to process the user input to create a holder
   *
   * @param userInput the users input as arguments
   * @return a hashmap, a user input to add entry as key and all the details of digital entry as
   * values
   * @throws CmdLineExceptions.ArgumentNotFoundException throw if argument is not found
   */

  @Override
  protected HashMap<String, ArrayList<String>> process(ArrayList<String> userInput)
      throws CmdLineExceptions {
    if (!userInput.contains(ENTRY_TEXT) || !userInput.contains(ENTRY_DATE)) {
      throw new CmdLineExceptions.ArgumentNotFoundException(
          "Please provide text and date for new entry");
    }
    // remove iteratively
    this.toRemove.add(userInput.indexOf(COMMAND_ADD_ENTRY));
    List<String> toFind = new ArrayList<>(
        Arrays.asList(ENTRY_TEXT, ENTRY_COMPLETED, ENTRY_DATE, ENTRY_PRIORITY, ENTRY_CATEGORY));
    addRemovalIfValid(userInput, this.toRemove, toFind, this.allDetails);
    removeFromArguments(userInput, this.toRemove);
    // output
    this.currentOutput.put(COMMAND_ADD_ENTRY, this.allDetails);
    return currentOutput;
  }

  @Override
  public String toString() {
    return "EntryCreationHolder{}";
  }

  @Override
  public int hashCode() {
    return EntryCreationHolder.class.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof EntryCreationHolder;
  }

}
