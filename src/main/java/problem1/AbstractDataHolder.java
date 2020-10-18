package problem1;

import static problem1.Constants.FLAG_IDENTIFIER;
import static problem1.Constants.NOT_FOUND;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * An abstract class representing a data holder class
 */


public abstract class AbstractDataHolder {

  HashMap<String, ArrayList<String>> currentOutput;
  ArrayList<String> allDetails;
  List<Integer> toRemove;

  /**
   * A constructor for the AbstractDataHolder
   */

  public AbstractDataHolder() {
    this.currentOutput = new HashMap<>();
    this.allDetails = new ArrayList<>();
    this.toRemove = new ArrayList<>();
  }

  /**
   * Getters of the currentOutput, a HashMap
   *
   * @return currentOutput, a HashMap
   */

  public HashMap<String, ArrayList<String>> getCurrentOutput() {
    return this.currentOutput;
  }

  /**
   * An abstract method to process the user input
   *
   * @param userInput the users input as arguments
   * @return a hashMap
   * @throws CmdLineExceptions.ArgumentNotFoundException when argument is not found
   * @throws CmdLineExceptions.UnknownArgumentException  when unknown argument is found
   */

  protected abstract HashMap<String, ArrayList<String>> process(ArrayList<String> userInput)
      throws CmdLineExceptions;

  /**
   * A helper method to check if the user input is valid
   *
   * @param userInput the list of user input
   * @param argument  the argument, an integer
   * @return boolean, if the argument contains flag identifier, otherwise false
   */

  protected Boolean checkIfValid(ArrayList<String> userInput, int argument) {
    try {
      return !userInput.get(argument).contains(FLAG_IDENTIFIER);
    } catch (IndexOutOfBoundsException e) {
      return false;
    }
  }

  /**
   * A method to check if two arguments are mutually exclusive
   *
   * @param s1,        a string
   * @param s2,        a string
   * @param arguments, a arraylist containing arguments
   * @return a boolean, True if two strings are mutually exclusive, otherwise false
   * @throws CmdLineExceptions.UnknownArgumentException when the argument is unknown
   */

  protected Boolean checkIfMutuallyExclusive(String s1, String s2, ArrayList<String> arguments)
      throws CmdLineExceptions {
    if (arguments.contains(s1)) {
      if (arguments.contains(s2)) {
        throw new CmdLineExceptions.UnknownArgumentException(
            s1 + " and " + s2 + " cannot be used together. ");
      }
    }
    return true;
  }

  /**
   * A method to remove arguments
   *
   * @param providedArgument argument the provided, an arrayList of string
   * @param toRemove         list to remove, an list of integer
   */

  protected void removeFromArguments(ArrayList<String> providedArgument, List<Integer> toRemove) {
    toRemove.sort(Collections.reverseOrder());
    for (Integer i : toRemove) {
      providedArgument.remove((int) i);
    }
  }

  /**
   * A method to add or remove if valid
   *
   * @param userInput   the user input, an Arraylist of string
   * @param toRemove,   the list to remove, a list of integer
   * @param toFind,     a list of string to find
   * @param allDetails, a list of all details
   * @throws CmdLineExceptions.ArgumentNotFoundException when argument is not found
   */

  protected void addRemovalIfValid(ArrayList<String> userInput, List<Integer> toRemove,
      List<String> toFind, List<String> allDetails)
      throws CmdLineExceptions {
    for (String s : toFind) {
      int currentIndex = userInput.indexOf(s);
      if (currentIndex == NOT_FOUND) {
        allDetails.add(null);
      }
      int argumentIndex = currentIndex + 1;
      if (checkIfValid(userInput, argumentIndex)) {
        allDetails.add(userInput.get(argumentIndex));
        toRemove.add(currentIndex);
        toRemove.add(argumentIndex);
      } else {
        throw new CmdLineExceptions.ArgumentNotFoundException(
            "Argument not provided for " + s);
      }
    }
  }
}
