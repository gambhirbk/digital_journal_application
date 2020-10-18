package problem1;

import static problem1.Constants.CSV_ARG;
import static problem1.Constants.PROCESSABLE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * A class processing command lines
 */


public class CommandLineProcessor {

  private final String[] cmdArguments;

  /**
   * A command line process of arguments processing
   *
   * @param cmdArguments the command line arguments to process
   */

  public CommandLineProcessor(String[] cmdArguments) {
    this.cmdArguments = cmdArguments;
  }

  /**
   * A method to separate arguments
   *
   * @return a hashmap of arguments
   * @throws CmdLineExceptions.ArgumentNotFoundException throws argument is not found
   * @throws CmdLineExceptions.UnknownArgumentException  throws argument is unknown
   */

  public HashMap<String, ArrayList<String>> argumentSeparator() {
    HashMap<String, ArrayList<String>> output = new HashMap<>();
    ArrayList<String> providedArgument = new ArrayList<>(Arrays.asList(this.cmdArguments));
    if (providedArgument.contains(CSV_ARG)) {
      for (String commandFlag : PROCESSABLE) {
        processByType(commandFlag, output, providedArgument);
      }

      if (providedArgument.size() > 0) {
        throw new CmdLineExceptions.UnknownArgumentException("Unknown or extra argument detected");
      }

      return output;
    } else {
      throw new CmdLineExceptions.ArgumentNotFoundException("--csv file must be provided");
    }
  }

  /**
   * @param flag             a string representing a flag
   * @param output           a hashmap representing the output
   * @param providedArgument an arraylist of arguments
   * @throws CmdLineExceptions.ArgumentNotFoundException an exception thrown if argument is not
   *                                                     found
   * @throws CmdLineExceptions.UnknownArgumentException  an exception thrown if unknown argument is
   *                                                     found
   */

  protected void processByType(String flag, HashMap<String, ArrayList<String>> output,
      ArrayList<String> providedArgument)
      throws CmdLineExceptions {
    if (providedArgument.contains(flag)) {
      AbstractDataHolder holder = DataHolderFactory.makeDataHolder(flag);
      if (holder != null) {
        output.putAll(holder.process(providedArgument));
      }
    }
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof CommandLineProcessor)) {
      return false;
    }
    CommandLineProcessor that = (CommandLineProcessor) o;
    return
        Arrays.equals(this.cmdArguments, that.cmdArguments);
  }

  @Override
  public int hashCode() {
    return Arrays.hashCode(this.cmdArguments);
  }

  @Override
  public String toString() {
    return "CommandLineProcessor{" +
        "cmdArguments=" + Arrays.toString(this.cmdArguments) +
        '}';
  }

}
