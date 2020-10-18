package problem1;

public class CmdLineExceptions extends RuntimeException {

  private static final String[] flags;
  private static final String[] explanations;
  private static final String usageHelp;

  //Used for USAGE help generation
  static {
    flags = new String[]{
        "--csv-file <path/to/file>",
        "--add-entry",
        "--entry-text <description of entry>",
        "--completed",
        "--date <date>",
        "--priority <1, 2, or 3>",
        "--category <a category name>",
        "--display",
        "--show-incomplete",
        "--show-category <category>",
        "--sort-by-date",
        "--sort-by-priority"

    };
    explanations = new String[]{
        "The CSV file containing the digital entries. This option is required.",
        "Add a new digital entry. If this option is provided, then --entry-text must also be provided.",
        "A description of the digital entry.",
        "(Optional) Sets the completed status of a new digital entry to true.",
        "(Optional) Sets the date of a new digital entry. Format must be MM/dd/yyyy",
        "(Optional) Sets the priority of a new digital entry. The value can be 1, 2, or 3.",
        "(Optional) Sets the category of new digital entry. The value can be any String.  Categories do not need to be pre-defined.",
        "Display digital entry. If none of the following optional arguments are provided, displays all digital entries.",
        "(Optional) If --display is provided, only incomplete digital entries should be displayed.",
        "(Optional) If --display is provided, only digital entries with the given category should be displayed.",
        "(Optional) If --display is provided, sort the list of digital entries by date order (ascending). Cannot be combined with --sort-by-priority.",
        "(Optional) If --display is provided, sort the list of digital entries by priority (ascending). Cannot be combined with --sort-by-date."
    };
  }

  //Used to represent USAGE help report
  static {
    String usageMessage;
    usageMessage = "Usage: \n";
    for (int i = 0; i < flags.length; i++) {
      usageMessage += flags[i] + ' ' + explanations[i] + "\n";
    }
    usageHelp = usageMessage;
  }


  /**
   * This constructor prints the error message on command line and exits successfully.
   *
   * @param msg Error message
   */
  public CmdLineExceptions(String msg) {
    super(msg + "\n" + usageHelp);
  }

  /**
   * Class to handle if argument is not found
   */

  public static class ArgumentNotFoundException extends CmdLineExceptions {

    /**
     * Constructs a new InvalidArgumentsException object and initializes it with the given message.
     *
     * @param message the message to be shown
     */

    public ArgumentNotFoundException(String message) {
      super(message);
    }
  }

  /**
   * Class to handle if argument provided at the command line is unknown
   */

  public static class UnknownArgumentException extends CmdLineExceptions {

    /**
     * Constructs a new InvalidArgumentsException object and initializes it with the given message.
     *
     * @param message the message to be shown
     */

    public UnknownArgumentException(String message) {
      super(message);

    }
  }

  /**
   * Class to handle if id is invalid
   */

  public static class InvalidIDException extends CmdLineExceptions {

    /**
     * Constructs a new InvalidIDException object and initializes it with the given message.
     *
     * @param message the message to be shown
     */

    public InvalidIDException(String message) {
      super(message);
    }
  }

  /**
   * Class to handle if priority is invalid
   */


  public static class InvalidPriorityException extends CmdLineExceptions {

    /**
     * Constructs a new InvalidIDException object and initializes it with the given message.
     *
     * @param message the message to be shown
     */

    public InvalidPriorityException(String message) {
      super(message);
    }

  }


}
