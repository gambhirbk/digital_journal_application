package problem1;


import static problem1.Constants.COMMAND_ADD_ENTRY;
import static problem1.Constants.COMMAND_COMPLETE;
import static problem1.Constants.COMMAND_DISPLAY;
import static problem1.Constants.CSV_ARG;

/**
 * A class representing data holder factory class
 */

public class DataHolderFactory {

  /**
   * A method to create a new concrete class based on a flag
   *
   * @param flag the flag provided
   * @return the concrete class based on the flag
   */

  public static AbstractDataHolder makeDataHolder(String flag) {
    switch (flag) {
      case CSV_ARG:
        return new EntryCSVHolder();
      case COMMAND_ADD_ENTRY:
        return new EntryCreationHolder();
      case COMMAND_COMPLETE:
        return new EntryCompleteHolder();
      case COMMAND_DISPLAY:
        return new EntryDisplayHolder();
      default:
        return null;
    }

  }

}
