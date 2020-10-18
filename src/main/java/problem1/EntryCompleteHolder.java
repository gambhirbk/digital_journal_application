package problem1;


import static problem1.Constants.COMMAND_COMPLETE;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

/**
 * A class representing entry complete holder
 */


public class EntryCompleteHolder extends AbstractDataHolder {

  /**
   * A method processing the arraylist of user input
   *
   * @param userInput the users input as arguments
   * @return a hashmap containing user input for complete as key and distinct entries as values
   * @throws CmdLineExceptions.ArgumentNotFoundException thrown if argument is not found
   */

  @Override
  protected HashMap<String, ArrayList<String>> process(ArrayList<String> userInput)
      throws CmdLineExceptions {
    // remove iteratively
    while (userInput.contains(COMMAND_COMPLETE)) {
      int flag = userInput.indexOf(COMMAND_COMPLETE);
      int argument = flag + 1;
      if (checkIfValid(userInput, argument)) {
        this.toRemove.add(flag);
        this.toRemove.add(argument);
        this.allDetails.add(userInput.get(argument));
      } else {
        throw new CmdLineExceptions.ArgumentNotFoundException(
            "No argument found for " + COMMAND_COMPLETE);
      }
      removeFromArguments(userInput, this.toRemove);
    }
    // output
    ArrayList<String> distinctEntries = this.allDetails.stream().distinct()
        .collect(Collectors.toCollection(ArrayList::new));
    this.currentOutput.put(COMMAND_COMPLETE, distinctEntries);
    return this.currentOutput;
  }

  @Override
  public String toString() {
    return "EntryCompleteHolder{}";
  }

  @Override
  public int hashCode() {
    return EntryCompleteHolder.class.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof EntryCompleteHolder;
  }
}
