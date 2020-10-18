package problem1;

import static problem1.Constants.CSV_ARG;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * A class representing an entry csv holder
 */

public class EntryCSVHolder extends AbstractDataHolder {

  /**
   * A method to process arguments
   *
   * @param userInput the users input as arguments
   * @return a hashMap containing csv file as key and all details to values
   * @throws CmdLineExceptions.ArgumentNotFoundException thrown if argument is not found
   * @throws CmdLineExceptions.UnknownArgumentException  thrown if argument is unknown
   */

  @Override
  protected HashMap<String, ArrayList<String>> process(ArrayList<String> userInput)
      throws CmdLineExceptions {
    int flag = userInput.indexOf(CSV_ARG);
    int argument = flag + 1;
    if (checkIfValid(userInput, argument)) {
      this.toRemove = new ArrayList<>(Arrays.asList(flag, argument));
      this.allDetails.add(userInput.get(argument));
    } else {
      throw new CmdLineExceptions.ArgumentNotFoundException("No argument found for " + CSV_ARG);
    }
    removeFromArguments(userInput, this.toRemove);
    this.currentOutput.put(CSV_ARG, this.allDetails);
    return this.currentOutput;
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof EntryCSVHolder;
  }

  @Override
  public int hashCode() {
    return EntryCSVHolder.class.hashCode();
  }

  @Override
  public String toString() {
    return "EntryCSVHolder{}";
  }
}
